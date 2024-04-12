package ZANOMATT.modules.combat;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;
import ZANOMATT.utils.KillAuraUtil;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.input.Keyboard;

import java.util.Iterator;

public class KillAura extends Module {
    public KillAura() {
        super("KillAura", Keyboard.KEY_V, Category.COMBAT);
    }

    public float range = 3;

    @Override
    public void onUpdate() {
        if(!this.isToggled())
            return;

        for(Iterator<Entity> entities = mc.theWorld.loadedEntityList.iterator(); entities.hasNext();){
            Object theObject = entities.next();
            if(theObject instanceof EntityLivingBase) {
                EntityLivingBase entity = (EntityLivingBase) theObject;
                if (KillAuraUtil.shouldAttack(entity, range)) {
                    KillAuraUtil.attack(entity);
                    continue;
                }
            }
            if(theObject instanceof EntityLivingBase){
                EntityLivingBase entity = (EntityLivingBase) theObject;
                if(entity instanceof EntityPlayerSP) continue;
                if(mc.thePlayer.getDistanceToEntity(entity) <= 3f){ //6.2173613f
                    //if(entity.isEntityAlive() && !entity.isDead && !entity.isInvisible()){
                        KillAuraUtil.attack(entity);
                        continue;
                    //}
                }
            }
        }
        super.onUpdate();
    }

}
