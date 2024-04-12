package ZANOMATT.modules.movement;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;
import ZANOMATT.utils.Invoker;
import org.lwjgl.input.Keyboard;

public class Spider extends Module {
    public Spider() {
        super("Spider", Keyboard.KEY_K, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {

        if(this.isToggled()){
            if(Invoker.isCollidedHorizontally()){
                Invoker.setMotionY(0.2);

                float var6 = 0.015f;

                if(Invoker.getMotionX() < (double) -var6){
                    Invoker.setMotionX(-var6);
                }
                if(Invoker.getMotionX() > (double) -var6){
                    Invoker.setMotionX(-var6);
                }

                if(Invoker.getMotionZ() < (double) -var6){
                    Invoker.setMotionZ(-var6);
                }
                if(Invoker.getMotionZ() > (double) -var6){
                    Invoker.setMotionZ(-var6);
                }

                Invoker.setFallDistance(0);

                if(Invoker.getMotionY() < 0.15D){
                    Invoker.setMotionY(-0.15D);
                }
            }
        }
        super.onUpdate();
    }
}
