package me.HALD91.Weaponkit;

import me.HALD91.Weaponkit.CommandManger.ConsoleWeaponkitCommand;
import me.HALD91.Weaponkit.CommandManger.WeaponkitCommand;
import me.HALD91.Weaponkit.Cooldown.CooldownCommand;
import me.HALD91.Weaponkit.Gui.itemstack;
import me.HALD91.Weaponkit.Gui.WeaponkitGui;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class weaponkit extends JavaPlugin {
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new itemstack(), (Plugin)this);
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new WeaponkitGui(), (Plugin)this);
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new me.HALD91.Weaponkit.Gui.Listener(), (Plugin)this);
        getCommand("Weaponkit").setExecutor((CommandExecutor)new WeaponkitCommand());
        getCommand("ConsoleWeaponkit").setExecutor((CommandExecutor)new ConsoleWeaponkitCommand());
        getCommand("CooldownReset").setExecutor((CommandExecutor)new CooldownCommand());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
