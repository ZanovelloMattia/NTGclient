package ZANOMATT.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.util.MathHelper;

import java.sql.ClientInfoStatus;

public class KillAuraUtil {

    public static Minecraft mc = Minecraft.getMinecraft();

    public static void attack(EntityLivingBase target){
        rotatePlayer(calculateYawPitch(target));

        mc.playerController.attackEntity(mc.thePlayer, target);
        mc.thePlayer.swingItem();
    }

    public static void rotatePlayer(float[] yawPitch){
        C03PacketPlayer.C05PacketPlayerLook packet = new C03PacketPlayer.C05PacketPlayerLook(yawPitch[0],yawPitch[1], mc.thePlayer.onGround);
        mc.getNetHandler().addToSendQueue(packet);
        mc.thePlayer.setRotationYawHead(yawPitch[0]);
        mc.thePlayer.renderYawOffset = yawPitch[0];
        mc.thePlayer.rotationPitchHead = yawPitch[1];
    }

    public static boolean shouldAttack(EntityLivingBase entity, float range){
        if(entity instanceof EntityPlayerSP) return false;
        if(mc.thePlayer.getDistanceToEntity(entity) <= 3f){ //6.2173613f
            if(entity.isEntityAlive() && !entity.isInvisible()){
                return true;
            }
        }
        return false;
    }

    public static float[] calculateYawPitch(EntityLivingBase target){
        double dX = target.posX - mc.thePlayer.posX ;
        double dY = target.posY - mc.thePlayer.posY ;
        double dZ = target.posZ - mc.thePlayer.posZ;
        double d3 = MathHelper.sqrt_double(dX * dX + dZ * dZ);
        float f = (float)(MathHelper.func_181159_b(dZ, dX) * 180.0D / Math.PI) - 90.0F;
        float f1 = (float)(-(MathHelper.func_181159_b(dY, d3) * 180.0D / Math.PI));
        float[] yawPitch= {f, f1};
        return yawPitch;
    }

}
