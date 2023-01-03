package me.HALD91.Weaponkit.Gui;

import me.HALD91.Weaponkit.weaponkit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.NetherWarts;
import org.bukkit.plugin.java.JavaPlugin;

public class WeaponkitGui implements Listener {
    // Prefix
    weaponkit weaponkit = JavaPlugin.getPlugin(me.HALD91.Weaponkit.weaponkit.class);
    String prefix = weaponkit.getConfig().getString("Weaponkit.Prefix");
    // Permissions
    String PermissionGuiUse = weaponkit.getConfig().getString("Weaponkit.Permissions.PermissionGuiUse");
    String PermissionCommandUse = weaponkit.getConfig().getString("Weaponkit.Permissions.PermissionCommandUse");

    //Gui
    String WeaponkitGuiName = weaponkit.getConfig().getString("Weaponkit.WeaponkitGui.Name");
    int WeaponkitGuiSize = weaponkit.getConfig().getInt("Weaponkit.WeaponkitGui.Size");

    // Axe's names
    public String PAXE = weaponkit.getConfig().getString("Weaponkit.Items.Axe.PoisonAxeConfig.Name");
    public String NAXE = weaponkit.getConfig().getString("Weaponkit.Items.Axe.NauseaAxeConfig.Name");
    public String BAXE = weaponkit.getConfig().getString("Weaponkit.Items.Axe.BlindnessAxeConfig.Name");
    public String WAXE = weaponkit.getConfig().getString("Weaponkit.Items.Axe.WitherAxeConfig.Name");

    // Sword's names
    public String PSW = weaponkit.getConfig().getString("Weaponkit.Items.Sword.PoisonSwordConfig.Name");
    public String NSW = weaponkit.getConfig().getString("Weaponkit.Items.Sword.NauseaSwordConfig.Name");
    public String BSW = weaponkit.getConfig().getString("Weaponkit.Items.Sword.BlindnessSwordConfig.Name");
    public String WSW = weaponkit.getConfig().getString("Weaponkit.Items.Sword.WitherSwordConfig.Name");

    // NetherWart
    public String NW = weaponkit.getConfig().getString("Weaponkit.Items.WitherKit.Name");

    // Armor
    public String WH = weaponkit.getConfig().getString("Weaponkit.Items.Armor.WitherHelmet.Name");
    public String WC = weaponkit.getConfig().getString("Weaponkit.Items.Armor.WitherChestPlate.Name");
    public String WL = weaponkit.getConfig().getString("Weaponkit.Items.Armor.WitherLeggings.Name");
    public String WB = weaponkit.getConfig().getString("Weaponkit.Items.Armor.WitherBoots.Name");

    private final Inventory inv;

    public WeaponkitGui(){
        inv = Bukkit.createInventory(null, weaponkit.getConfig().getInt("Weaponkit.WeaponkitGui.Size"), ChatColor.translateAlternateColorCodes('&',WeaponkitGuiName));
        initializeItems();
    }

    private void initializeItems() {
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.WitherKit.DisplayItemInGui")) {
            int wwart = weaponkit.getConfig().getInt("Weaponkit.Items.WitherKit.SlotNumber");
            inv.setItem(wwart, new itemstack().Nether_Wart());
        }
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Armor.WitherHelmet.DisplayItemInGui")) {
            int wboots = weaponkit.getConfig().getInt("Weaponkit.Items.Armor.WitherHelmet.SlotNumber");
            inv.setItem(wboots, new itemstack().Nether_Wart_Helmet());
        }
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Armor.WitherChestPlate.DisplayItemInGui")) {
            int wboots = weaponkit.getConfig().getInt("Weaponkit.Items.Armor.WitherChestPlate.SlotNumber");
            inv.setItem(wboots, new itemstack().Nether_Wart_Chestplate());
        }
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Armor.WitherLeggings.DisplayItemInGui")) {
            int wboots = weaponkit.getConfig().getInt("Weaponkit.Items.Armor.WitherLeggings.SlotNumber");
            inv.setItem(wboots, new itemstack().Nether_Wart_Leggins());
        }
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Armor.WitherBoots.DisplayItemInGui")) {
            int wboots = weaponkit.getConfig().getInt("Weaponkit.Items.Armor.WitherBoots.SlotNumber");
            inv.setItem(wboots, new itemstack().Nether_Wart_Boots());
        }
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.PoisonAxeConfig.DisplayItemInGui")) {
            int wboots = weaponkit.getConfig().getInt("Weaponkit.Items.Axe.PoisonAxeConfig.SlotNumber");
            inv.setItem(wboots, new itemstack().Poison_Axe());
        }
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.NauseaAxeConfig.DisplayItemInGui")) {
            int wboots = weaponkit.getConfig().getInt("Weaponkit.Items.Axe.NauseaAxeConfig.SlotNumber");
            inv.setItem(wboots, new itemstack().Nausea_Axe());
        }
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.BlindnessAxeConfig.DisplayItemInGui")) {
            int wboots = weaponkit.getConfig().getInt("Weaponkit.Items.Axe.BlindnessAxeConfig.SlotNumber");
            inv.setItem(wboots, new itemstack().Blindness_Axe());
        }
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.WitherAxeConfig.DisplayItemInGui")) {
            int wboots = weaponkit.getConfig().getInt("Weaponkit.Items.Axe.WitherAxeConfig.SlotNumber");
            inv.setItem(wboots, new itemstack().Wither_Axe());
        }
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Sword.PoisonSwordConfig.DisplayItemInGui")) {
            int wboots = weaponkit.getConfig().getInt("Weaponkit.Items.Sword.PoisonSwordConfig.SlotNumber");
            inv.setItem(wboots, new itemstack().Poison_Sword());
        }
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Sword.NauseaSwordConfig.DisplayItemInGui")) {
            int wboots = weaponkit.getConfig().getInt("Weaponkit.Items.Sword.NauseaSwordConfig.SlotNumber");
            inv.setItem(wboots, new itemstack().Nausea_Sword());
        }
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Sword.BlindnessSwordConfig.DisplayItemInGui")) {
            int wboots = weaponkit.getConfig().getInt("Weaponkit.Items.Sword.BlindnessSwordConfig.SlotNumber");
            inv.setItem(wboots, new itemstack().Blindness_Sword());
        }
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Sword.WitherSwordConfig.DisplayItemInGui")) {
            int wboots = weaponkit.getConfig().getInt("Weaponkit.Items.Sword.WitherSwordConfig.SlotNumber");
            inv.setItem(wboots, new itemstack().Wither_Sword());
        }

    }

    // You can open the inventory with this
    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }


    @EventHandler
    public void onCdlick(InventoryClickEvent e) {
        Inventory INV = e.getInventory();
        if (INV.getTitle().contains(ChatColor.translateAlternateColorCodes('&', WeaponkitGuiName))) {
            final org.bukkit.inventory.ItemStack clickedItem = e.getCurrentItem();
            final Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);

            // verify current item is not null
            if (clickedItem == null || clickedItem.getType().equals(Material.AIR)) return;


            // Using slots click is a best option for your inventory click's
            if (weaponkit.getConfig().getBoolean("Weaponkit.WeaponkitGui.GetSlotNrOnItemClick")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&aYou clicked at slot &3" + e.getRawSlot()));
            }

            // Gets click item and make an action event.
            //Axe
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',PAXE))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Axe Poison");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',NAXE))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Axe Nausea");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',BAXE))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Axe Blindness");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',WAXE))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Axe Wither");
            }

            //Sword
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',PSW))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Sword Poison");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',NSW))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Sword Nausea");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',BSW))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Sword Blindness");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',WSW))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Sword Wither");
            }

            // Wither
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',NW))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Wither Kit");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',WH))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Wither Helmet");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',WC))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Wither ChestPlate");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',WL))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Wither Leggins");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',WB))) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ConsoleWeaponkit" + " " + p.getName() + " " + "Wither Boots");
            }


        } else {
            e.setCancelled(false);
        }
    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        Inventory INV = e.getInventory();
        if (INV.getTitle().contains(ChatColor.translateAlternateColorCodes('&', WeaponkitGuiName))) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

}
