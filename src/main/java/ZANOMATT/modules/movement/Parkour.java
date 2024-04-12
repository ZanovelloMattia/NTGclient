package ZANOMATT.modules.movement;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;
import net.minecraft.entity.Entity;
import org.lwjgl.input.Keyboard;

public class Parkour extends Module {
    public Parkour() {
        super("Parkour", Keyboard.KEY_Z, Category.MOVEMENT);
    }

    @Override
    public void onUpdate() {
        if(this.isToggled()){
            if(mc.thePlayer.onGround && !mc.thePlayer.isSneaking()
                    && !this.mc.gameSettings.keyBindSneak.pressed
                    && this.mc.theWorld.getCollidingBoundingBoxes((Entity) mc.thePlayer,
                        mc.thePlayer.getEntityBoundingBox().offset(0.0D, -0.5D, 0.0D).expand(-0.001D, 0, 0.001D)).isEmpty()) {
                mc.thePlayer.jump();
            }
        }
    }
}
