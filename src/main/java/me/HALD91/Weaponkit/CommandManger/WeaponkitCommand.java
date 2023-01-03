package me.HALD91.Weaponkit.CommandManger;

import me.HALD91.Weaponkit.Cooldown.Cooldown;
import me.HALD91.Weaponkit.Gui.WeaponkitGui;
import me.HALD91.Weaponkit.Gui.itemstack;
import me.HALD91.Weaponkit.weaponkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.NetherWarts;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class WeaponkitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Prefix
        weaponkit weaponkit = JavaPlugin.getPlugin(me.HALD91.Weaponkit.weaponkit.class);
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
                if (args.length == 2) {
                    if (!(args[0] == null)) {
                        if (args[1].equalsIgnoreCase("star")) {
                            if (p.hasPermission(ChatColor.translateAlternateColorCodes('&',"" + PermissionNetherWartGive))) {
                                p.getInventory().addItem(new itemstack().Nether_Wart());
                                p.updateInventory();
                            }
                        }
                    }
                }
                if (args.length == 3) {
                    if (p.hasPermission(ChatColor.translateAlternateColorCodes('&', "" + PermissionItemGive))) {
                        if (!(args[0] == null)) {
                            if (args[1].equalsIgnoreCase("help")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&3/WeaponKit <Player> <Star>"));
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&3/WeaponKit <Player> <Sword> <Poison,Blindness,Nausea,Wither>"));
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&3/WeaponKit <Player> <Axe> <Poison,Blindness,Nausea,Wither>"));
                            }
                            if (args[1].equalsIgnoreCase("Sword")) {
                                if (args[2].equalsIgnoreCase("Poison")) {
                                    p.getInventory().addItem(new itemstack().Poison_Sword());
                                    p.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Blindness")) {
                                    p.getInventory().addItem(new itemstack().Blindness_Sword());
                                    p.updateInventory();
                                }
                                 if (args[2].equalsIgnoreCase("Nausea")) {
                                    p.getInventory().addItem(new itemstack().Nausea_Sword());
                                    p.updateInventory();
                                }
                                 if (args[2].equalsIgnoreCase("Wither")) {
                                    p.getInventory().addItem(new itemstack().Wither_Sword());
                                    p.updateInventory();
                                }
                            }
                            if (args[1].equalsIgnoreCase("Axe")) {
                                if (args[2].equalsIgnoreCase("Poison")) {
                                    p.getInventory().addItem(new itemstack().Poison_Axe());
                                    p.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Blindness")) {
                                    p.getInventory().addItem(new itemstack().Blindness_Axe());
                                    p.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Nausea")) {
                                    p.getInventory().addItem(new itemstack().Nausea_Axe());
                                    p.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Wither")) {
                                    p.getInventory().addItem(new itemstack().Wither_Axe());
                                    p.updateInventory();
                                }
                            }
                            if (args[1].equalsIgnoreCase("Wither")) {
                                if (args[2].equalsIgnoreCase("Kit")) {
                                    if (Cooldown.tryCooldown(p, "Kit", 86400000L)) {
                                        p.getInventory().addItem(new itemstack().Wither_Sword());
                                        p.getInventory().addItem(new itemstack().Nether_Wart());
                                        p.getInventory().addItem(new itemstack().Nether_Wart_Helmet());
                                        p.getInventory().addItem(new itemstack().Nether_Wart_Chestplate());
                                        p.getInventory().addItem(new itemstack().Nether_Wart_Leggins());
                                        p.getInventory().addItem(new itemstack().Nether_Wart_Boots());
                                        p.updateInventory();
                                    } else {
                                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + " " + weaponkit.getConfig().getString("Weaponkit.CoolDown.WaitMessage")));
                                    }
                                }
                                if (args[2].equalsIgnoreCase("Star")) {
                                    p.getInventory().addItem(new itemstack().Nether_Wart());
                                    p.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Helmet")) {
                                    p.getInventory().addItem(new itemstack().Nether_Wart_Helmet());
                                    p.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("ChestPlate")) {
                                    p.getInventory().addItem(new itemstack().Nether_Wart_Chestplate());
                                    p.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Leggins")) {
                                    p.getInventory().addItem(new itemstack().Nether_Wart_Leggins());
                                    p.updateInventory();
                                }
                                if (args[2].equalsIgnoreCase("Boots")) {
                                    p.getInventory().addItem(new itemstack().Nether_Wart_Boots());
                                    p.updateInventory();
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
