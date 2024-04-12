package ZANOMATT.modules.movement;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;
import org.lwjgl.input.Keyboard;

public class AutoSprint extends Module {

    public AutoSprint() {
        super("AutoSprint", Keyboard.KEY_F, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()) {
            if(mc.thePlayer.moveForward > 0 && !mc.thePlayer.isUsingItem() && !mc.thePlayer.isSneaking()) {
                mc.thePlayer.setSprinting(true);
                super.onEnable();
            }
        }
    }


    @Override
    public void onDisable() {
        mc.thePlayer.setSprinting(mc.gameSettings.keyBindSprint.isPressed());
        super.onDisable();
    }
}
