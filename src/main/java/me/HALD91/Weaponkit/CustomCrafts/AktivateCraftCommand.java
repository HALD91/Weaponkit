package me.HALD91.Weaponkit.CustomCrafts;

import me.HALD91.Weaponkit.Main.weaponkit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class AktivateCraftCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        weaponkit weaponkit = JavaPlugin.getPlugin(me.HALD91.Weaponkit.Main.weaponkit.class);

        // Permissions
        String PermissionCraftUse = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&',"Weaponkit.Permissions.ActivateCraft"));

        // Prefix
        String prefix = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "Weaponkit.Prefix"));

        // Messages
        List<String> HelpMessage = weaponkit.getConfig().getStringList(ChatColor.translateAlternateColorCodes('&',"Weaponkit.Messages.HelpMessage"));
        String PermMessage = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "Weaponkit.Messages.PermissionMessage"));
        String ActivateCraftOnMessage = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "Weaponkit.Messages.ActivateCraftOnMessage"));
        String ActivateCraftOffMessage = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "Weaponkit.Messages.ActivateCraftOffMessage"));

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }

        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("ActivateCraft")) {
            if (player.hasPermission(PermissionCraftUse + "")) {
                if (args.length == 2) {
                    Player d = Bukkit.getServer().getPlayer(args[0]);
                    if (!(args[0] == null)) {
                        if (d != null) {
                            if (args[1].equalsIgnoreCase("on")) {
                                weaponkit.allowedCrafters.add(d.getName());
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + " " + d.getName()+ " " + ActivateCraftOnMessage));
                            } else if (args[1].equalsIgnoreCase("off")) {
                                weaponkit.allowedCrafters.remove(d.getName());
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + " " + d.getName() + " " + ActivateCraftOffMessage));
                            } else {
                                for (String m : HelpMessage) {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', m));
                                }
                            }
                        }
                    }
                } else {
                    for (String m : HelpMessage) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', m));
                    }

                }
            }
        } else {
            player.sendMessage( prefix + " " + PermMessage);
        }

        return false;
    }
}
