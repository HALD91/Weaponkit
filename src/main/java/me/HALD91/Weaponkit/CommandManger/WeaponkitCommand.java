package me.HALD91.Weaponkit.CommandManger;

import me.HALD91.Weaponkit.Cooldown.Cooldown;
import me.HALD91.Weaponkit.Gui.WeaponkitGui;
import me.HALD91.Weaponkit.Gui.itemstack;
import me.HALD91.Weaponkit.Main.weaponkit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WeaponkitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Prefix
        weaponkit weaponkit = JavaPlugin.getPlugin(me.HALD91.Weaponkit.Main.weaponkit.class);
        String prefix = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "Weaponkit.Prefix"));

        // Permissions
        String PermissionGuiUse = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&',"Weaponkit.Permissions.PermissionGuiUse"));
        String PermissionCommandUse = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&',"Weaponkit.Permissions.PermissionCommandUse"));
        String PermissionNetherWartGive = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&',"Weaponkit.Permissions.NetherWartGive"));
        String PermissionItemGive = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&',"Weaponkit.Permissions.ItemGive"));

        //Messages
        String PermMessage = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "Weaponkit.Messages.PermissionMessage"));
        List<String> HelpMessage = weaponkit.getConfig().getStringList(ChatColor.translateAlternateColorCodes('&',"Weaponkit.Messages.HelpMessage"));
        List<String> ListAvailableItem = weaponkit.getConfig().getStringList(ChatColor.translateAlternateColorCodes('&',"Weaponkit.Items.ListItemsCommand"));


        if (command.getName().equalsIgnoreCase("Weaponkit")) {
        Player p = (Player)sender;
        if (sender.hasPermission("" + PermissionCommandUse)) {
            if (args.length == 0) {
                if (sender.hasPermission("" + PermissionGuiUse)) {
                    new WeaponkitGui().openInventory((HumanEntity) sender);
                } else if (!sender.hasPermission("" + PermissionGuiUse)) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " " + "&3/Weaponkit Help &7- to get help on how to use this command."));
                }
                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("help")) {
                        for (String m : HelpMessage) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', m));
                        }
                        return true;
                    }
                    if (sender.hasPermission("" + PermissionCommandUse)) {
                        if (args[0].equalsIgnoreCase("list")) {
                            for (String l : ListAvailableItem) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', l));
                            }
                            return true;
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " " + PermMessage));
                    }
                }
                if (args.length == 3) {
                    Player d = Bukkit.getServer().getPlayer(args[0]);
                    if (p.hasPermission(ChatColor.translateAlternateColorCodes('&', "" + PermissionItemGive))) {
                        if (!(args[0] == null)) {
                            if (args[1].equalsIgnoreCase("help")) {
                                for (String m : HelpMessage) {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', m));
                                }
                            }
                            if (args[1].equalsIgnoreCase("Sword")) {
                                if (args[2].equalsIgnoreCase("Poison")) {
                                    d.getInventory().addItem(new itemstack().Poison_Sword());
                                    d.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Blindness")) {
                                    d.getInventory().addItem(new itemstack().Blindness_Sword());
                                    d.updateInventory();
                                }
                                 if (args[2].equalsIgnoreCase("Nausea")) {
                                    d.getInventory().addItem(new itemstack().Nausea_Sword());
                                    d.updateInventory();
                                }
                                 if (args[2].equalsIgnoreCase("Wither")) {
                                    d.getInventory().addItem(new itemstack().Wither_Sword());
                                    d.updateInventory();
                                }
                            }
                            if (args[1].equalsIgnoreCase("Axe")) {
                                if (args[2].equalsIgnoreCase("Poison")) {
                                    d.getInventory().addItem(new itemstack().Poison_Axe());
                                    d.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Blindness")) {
                                    d.getInventory().addItem(new itemstack().Blindness_Axe());
                                    d.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Nausea")) {
                                    d.getInventory().addItem(new itemstack().Nausea_Axe());
                                    d.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Wither")) {
                                    d.getInventory().addItem(new itemstack().Wither_Axe());
                                    d.updateInventory();
                                }
                            }
                            if (args[1].equalsIgnoreCase("Wither")) {
                                if (args[2].equalsIgnoreCase("Kit")) {
                                    if (Cooldown.tryCooldown(d, "Kit", 3600000L)) { // 3600000L = 60 hour 60000L = 60 Seconds
                                        d.getInventory().addItem(new itemstack().Wither_Sword());
                                        d.getInventory().addItem(new itemstack().Wither_Tear());
                                        d.getInventory().addItem(new itemstack().Nether_Wart_Helmet());
                                        d.getInventory().addItem(new itemstack().Nether_Wart_Chestplate());
                                        d.getInventory().addItem(new itemstack().Nether_Wart_Leggins());
                                        d.getInventory().addItem(new itemstack().Nether_Wart_Boots());
                                        d.updateInventory();
                                    } else {
                                        d.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " " + weaponkit.getConfig().getString("Weaponkit.CoolDown.WaitMessage") + " " + Cooldown.getCooldown(d, "Kit") + " " + "Minutes")); // + " " + Cooldown.getCooldown(d, "Kit")
                                    }
                                }
                                if (args[2].equalsIgnoreCase("Tear")) {
                                    d.getInventory().addItem(new itemstack().Wither_Tear());
                                    d.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Helmet")) {
                                    d.getInventory().addItem(new itemstack().Nether_Wart_Helmet());
                                    d.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("ChestPlate")) {
                                    d.getInventory().addItem(new itemstack().Nether_Wart_Chestplate());
                                    d.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Leggins")) {
                                    d.getInventory().addItem(new itemstack().Nether_Wart_Leggins());
                                    d.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Boots")) {
                                    d.getInventory().addItem(new itemstack().Nether_Wart_Boots());
                                    d.updateInventory();
                                }
                            }
                            if (args[1].equalsIgnoreCase("Bow")) {
                                if (args[2].equalsIgnoreCase("Multi")) {
                                    d.getInventory().addItem(new itemstack().Multi_Bow());
                                    d.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Wither")) {
                                    d.getInventory().addItem(new itemstack().Wither_Bow());
                                    d.updateInventory();
                                }
                            }
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " " + PermMessage));
                        return true;
                    }
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " " + PermMessage));
                return true;
            }
        }
        return false;
    }
}
