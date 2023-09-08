package me.HALD91.Weaponkit.Main;

import me.HALD91.Weaponkit.Bow.MultiBow;
import me.HALD91.Weaponkit.Bow.WitherBow;
import me.HALD91.Weaponkit.CommandManger.ConsoleWeaponkitCommand;
import me.HALD91.Weaponkit.CommandManger.WeaponkitCommand;
import me.HALD91.Weaponkit.Cooldown.CooldownCommand;
import me.HALD91.Weaponkit.CustomCrafts.ActivateCraftListener;
import me.HALD91.Weaponkit.CustomCrafts.AktivateCraftCommand;
import me.HALD91.Weaponkit.CustomCrafts.CraftMultiBow;
import me.HALD91.Weaponkit.CustomCrafts.CraftWitherBow;
import me.HALD91.Weaponkit.Gui.itemstack;
import me.HALD91.Weaponkit.Gui.WeaponkitGui;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class weaponkit extends JavaPlugin {
    public static ArrayList<String> allowedCrafters = new ArrayList<>();
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new itemstack(), (Plugin)this);
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new WeaponkitGui(), (Plugin)this);
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new me.HALD91.Weaponkit.Gui.Listener(), (Plugin)this);
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new MultiBow(), (Plugin)this);
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new WitherBow(), (Plugin)this);
        getServer().getPluginManager().registerEvents(new ActivateCraftListener(this), this);
        getCommand("Weaponkit").setExecutor((CommandExecutor)new WeaponkitCommand());
        getCommand("ConsoleWeaponkit").setExecutor((CommandExecutor)new ConsoleWeaponkitCommand());
        getCommand("CooldownReset").setExecutor((CommandExecutor)new CooldownCommand());
        getCommand("ActivateCraft").setExecutor((CommandExecutor)new AktivateCraftCommand());

        // get custom Craft Recipes:
        CraftMultiBow craftMultiBow = new CraftMultiBow(this);
        Bukkit.getServer().addRecipe(craftMultiBow.getRecipe());
        CraftWitherBow craftwitherbow = new CraftWitherBow(this);
        Bukkit.getServer().addRecipe(craftwitherbow.getRecipe());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
