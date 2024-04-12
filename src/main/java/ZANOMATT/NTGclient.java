package ZANOMATT;


import ZANOMATT.modules.ModuleManager;
import org.lwjgl.opengl.Display;

public class NTGclient {

    public static NTGclient INSTANCE = new NTGclient();

    public static String name = "NTGclient", version = "1.0.0", creator = "ZANOMATT";
    public static ModuleManager moduleManager;

    public static void startup(){

        moduleManager = new ModuleManager();


        System.out.println("Starting " + name + " at version: " + version + " by " + creator);
        Display.setTitle(name + " " + version + " by " + creator);
    }
}
