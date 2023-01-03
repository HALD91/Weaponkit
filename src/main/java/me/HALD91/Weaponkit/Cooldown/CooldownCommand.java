package me.HALD91.Weaponkit.Cooldown;

import me.HALD91.Weaponkit.weaponkit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CooldownCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        weaponkit weaponkit = JavaPlugin.getPlugin(me.HALD91.Weaponkit.weaponkit.class);
        String prefix = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "Weaponkit.Prefix"));
        String CooldownReset = weaponkit.getConfig().getString("Weaponkit.Permissions.CooldownReset");
        String CooldownMessage = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&',"Weaponkit.CoolDown.ResetMessage"));

        if (command.getName().equalsIgnoreCase("CooldownReset")) {
            if (sender.hasPermission("" + CooldownReset)) {
                Player p = (Player) sender;
                Cooldown.setCooldown(p, "Kit", 0L);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + " " + CooldownMessage));
            }
        }
        return false;
    }
}
