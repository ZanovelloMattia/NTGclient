package ZANOMATT.modules.movement;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.lwjgl.input.Keyboard;

public class NoFall extends Module {

    public NoFall() {
        super("NoFall", Keyboard.KEY_N, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()){
            if(mc.thePlayer.fallDistance > 2f){
                mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
            }
            super.onUpdate();
        }
    }
}
