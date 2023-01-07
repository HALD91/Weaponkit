package me.HALD91.Weaponkit.CommandManger;

import me.HALD91.Weaponkit.Cooldown.Cooldown;
import me.HALD91.Weaponkit.Gui.itemstack;
import me.HALD91.Weaponkit.weaponkit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ConsoleWeaponkitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        weaponkit weaponkit = JavaPlugin.getPlugin(me.HALD91.Weaponkit.weaponkit.class);
        // Prefix
        String prefix = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "Weaponkit.Prefix"));
        String NotAPlayerCommand = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&',"Weaponkit.ConsoleCommand.NotAPlayerCommand"));

        if (command.getName().equalsIgnoreCase("ConsoleWeaponkit")) {
            if (sender instanceof Player) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + " " + NotAPlayerCommand));
                return true;
            } else if (sender instanceof ConsoleCommandSender) {
                if (!(args[0] == null)) {
                    Player p = null;
                    p = Bukkit.getServer().getPlayer(args[0]);
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
                                p.getInventory().addItem(new itemstack().Wither_Tear());
                                p.getInventory().addItem(new itemstack().Nether_Wart_Helmet());
                                p.getInventory().addItem(new itemstack().Nether_Wart_Chestplate());
                                p.getInventory().addItem(new itemstack().Nether_Wart_Leggins());
                                p.getInventory().addItem(new itemstack().Nether_Wart_Boots());
                                p.updateInventory();
                            }else {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + " " + weaponkit.getConfig().getString("Weaponkit.CoolDown.WaitMessage")));
                            }
                        }
                        if (args[2].equalsIgnoreCase("Tear")) {
                            p.getInventory().addItem(new itemstack().Wither_Tear());
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
                    if (args[1].equalsIgnoreCase("Bow")) {
                        if (args[2].equalsIgnoreCase("Multi")) {
                            p.getInventory().addItem(new itemstack().Multi_Bow());
                            p.updateInventory();
                        }
                        if (args[2].equalsIgnoreCase("Wither")) {
                            p.getInventory().addItem(new itemstack().Wither_Bow());
                            p.updateInventory();
                        }
                    }
                }

            }
        }
        return false;
    }
}
