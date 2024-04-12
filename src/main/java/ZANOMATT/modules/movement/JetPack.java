package ZANOMATT.modules.movement;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;

public class JetPack extends Module {
    public JetPack() {
        super("JetPack", 0, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()){
            if(mc.gameSettings.keyBindJump.pressed){
                mc.thePlayer.jump();
            }
        }
    }
}
