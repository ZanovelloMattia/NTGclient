package ZANOMATT.modules;

import ZANOMATT.modules.combat.*;
import ZANOMATT.modules.movement.*;
import ZANOMATT.modules.render.ClickGuiMod;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

public class ModuleManager {

    private static List<Module> mods;
    public ModuleManager(){
        mods = new ArrayList<>();

        //COMBAT
        newMod(new KillAura());
        newMod(new FastBow());

        //MOVEMENT
        newMod(new AutoSprint());
        newMod(new AutoWalk());
        newMod(new Dolphin());
        newMod(new Flight());
        newMod(new NoFall());
        newMod(new Glide());
        newMod(new JetPack());
        newMod(new Parkour());
        newMod(new ToggledSneak());
        newMod(new Speed());
        newMod(new Spider());
        newMod(new Step());

        //PLAYER

        //RENDER
        newMod(new ClickGuiMod());
        //MISC
    }

    public static void newMod(Module m){
        mods.add(m);
    }

    public static List<Module> getModules(){
        return mods;
    }

    public static void onUpdate(){
        for (Module m : mods){
            m.onUpdate();
        }
    }

    public static void onRender(){
        for(Module m : mods){
            m.onRender();
        }
    }

    public static void onKey(int k){
        for(Module m : mods){
            if(m.getKey() == k){
                m.toggle();
            }
        }
    }

}
