package ZANOMATT.modules.movement;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;
import org.lwjgl.input.Keyboard;

public class Speed extends Module {
    public Speed() {
        super("Speed", Keyboard.KEY_L, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()){
            if(mc.thePlayer.onGround && mc.gameSettings.keyBindForward.isPressed()){
                mc.thePlayer.motionX *= 2.0f;
                mc.thePlayer.motionZ *= 2.0f;
            }
        }
    }
}
