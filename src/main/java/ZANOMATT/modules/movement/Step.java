package ZANOMATT.modules.movement;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.lwjgl.input.Keyboard;

public class Step extends Module {
    public Step() {
        super("Step", Keyboard.KEY_J, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {

        if(this.isToggled()){
            if(mc.thePlayer.isCollidedHorizontally && mc.thePlayer.onGround){
                mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.42, mc.thePlayer.posZ, mc.thePlayer.onGround));
                mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.72, mc.thePlayer.posZ, mc.thePlayer.onGround));
                mc.thePlayer.stepHeight = 1.0f;
            }
        }else{
            mc.thePlayer.stepHeight = 0.5f;
        }
        super.onUpdate();
    }
}
