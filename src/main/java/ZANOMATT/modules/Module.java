package ZANOMATT.modules;

import net.minecraft.client.Minecraft;

public abstract class Module {
    protected Minecraft mc = Minecraft.getMinecraft();

    public String name;
    public boolean toggled;
    public int key;
    public Category category;

    public Module(String name, int key, Category c){
        this.name = name;
        this.key = key;
        this.category = c;
        toggled = false;
    }

    public void toggle(){
        toggled = !toggled;
        if(toggled){
            onEnable();
        }else {
            onDisable();
        }
    }

    public void onEnable(){

    }

    public void onDisable(){

    }

    public void onUpdate(){

    }

    public void onRender(){

    }

    public Minecraft getMc() {
        return mc;
    }

    public void setMc(Minecraft mc) {
        this.mc = mc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
