package ZANOMATT.modules.render;

import ZANOMATT.modules.Category;
import ZANOMATT.modules.Module;
import ZANOMATT.ui.modern.ModernClickGui;
import org.lwjgl.input.Keyboard;

public class ClickGuiMod extends Module {

    public static final ModernClickGui modernClickGui = new ModernClickGui();

    public ClickGuiMod() {
        super("ClickGui", Keyboard.KEY_RSHIFT, Category.RENDER);
    }

    @Override
    public void onEnable() {
        mc.displayGuiScreen(modernClickGui);
        super.onEnable();
    }
}
