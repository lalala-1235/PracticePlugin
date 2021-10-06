package main;

import commands.OpenCosmeticGUI;
import listener.CustomDamage;
import listener.Inventories;
import listener.OnRightClickAir;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("RPGPlugin Enabled");

        getServer().getPluginManager().registerEvents(new CustomDamage(), this);
        getServer().getPluginManager().registerEvents(new OnRightClickAir(), this);
        getServer().getPluginManager().registerEvents(new Inventories(), this);
        System.out.println("event registered.");

        getCommand("cosmetic").setExecutor(new OpenCosmeticGUI());
        System.out.println("command registered.");
    }

    @Override
    public void onDisable() {
        System.out.println("RPGPlugin Disabled");
    }

}
