package ZANOMATT.modules.movement;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;
import org.lwjgl.input.Keyboard;

public class Flight extends Module {

    public static float flyHackSpeed = 0.1f;

    public Flight() {
        super("Flight", Keyboard.KEY_G, Category.MOVEMENT);
    }

    @Override
    public void onDisable() {
        mc.thePlayer.capabilities.isFlying = false;
        super.onDisable();
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()){
            mc.thePlayer.capabilities.isFlying = true;

            if(mc.gameSettings.keyBindJump.isPressed()){
                mc.thePlayer.motionY += 0.2f;
            }

            if(mc.gameSettings.keyBindSneak.isPressed()){
                mc.thePlayer.motionY -= 0.2f;
            }

            if(mc.gameSettings.keyBindForward.isPressed()){
                mc.thePlayer.capabilities.setFlySpeed(flyHackSpeed);
            }

            super.onDisable();

        }
    }
}
