package ZANOMATT.modules.movement;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;

public class ToggledSneak extends Module {
    public ToggledSneak() {
        super("ToggleSneak", 0, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()){
            mc.gameSettings.keyBindSneak.pressed = true;
        }
    }

    @Override
    public void onDisable() {
        mc.gameSettings.keyBindSneak.pressed = false;
        super.onDisable();
    }
}
