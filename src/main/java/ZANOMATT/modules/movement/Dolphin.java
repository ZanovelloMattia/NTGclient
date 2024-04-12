package ZANOMATT.modules.movement;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;

public class Dolphin extends Module {
    public Dolphin() {
        super("Dolphin", 0, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()){
            if(mc.thePlayer.isInWater()){
                mc.thePlayer.motionY += 0.04;
            }
        }
    }
}
