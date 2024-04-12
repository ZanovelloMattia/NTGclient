package ZANOMATT.modules.movement;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;
import org.lwjgl.input.Keyboard;

public class AutoWalk extends Module {
    public AutoWalk() {
        super("AutoWalk", Keyboard.KEY_P, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()){
            mc.gameSettings.keyBindForward.pressed = true;
        }
    }

    @Override
    public void onDisable() {
        mc.gameSettings.keyBindForward.pressed = false;
        super.onDisable();
    }
}
