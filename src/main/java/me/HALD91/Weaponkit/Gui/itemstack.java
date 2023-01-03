package me.HALD91.Weaponkit.Gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class itemstack implements Listener {
me.HALD91.Weaponkit.weaponkit weaponkit = JavaPlugin.getPlugin(me.HALD91.Weaponkit.weaponkit.class);

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

// Helmet
public org.bukkit.inventory.ItemStack Poison_Axe() {
    org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.DIAMOND_AXE, 1);
    ItemMeta Im = I.getItemMeta();
    if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.PoisonAxeConfig.Enchantments")) {
        Im.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
        Im.addEnchant(Enchantment.DURABILITY, 3, true);
    }
    Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', PAXE));
    if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.PoisonAxeConfig.Soulbound")) {
        ArrayList Nau = new ArrayList();
        Nau.add("Soulbound");
        Im.setLore(Nau);
    }
    I.setItemMeta(Im);
    return I;
}

    public org.bukkit.inventory.ItemStack Nausea_Axe() {
        org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta Im = I.getItemMeta();
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.NauseaAxeConfig.Enchantments")) {
            Im.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            Im.addEnchant(Enchantment.DURABILITY, 3, true);
        }
        Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', NAXE));
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.NauseaAxeConfig.Soulbound")) {
            ArrayList Nau = new ArrayList();
            Nau.add("Soulbound");
            Im.setLore(Nau);
        }
        I.setItemMeta(Im);
        return I;
    }

    public org.bukkit.inventory.ItemStack Blindness_Axe() {
        org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta Im = I.getItemMeta();
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.BlindnessAxeConfig.Enchantments")) {
            Im.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            Im.addEnchant(Enchantment.DURABILITY, 3, true);
        }
        Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', BAXE));
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.BlindnessAxeConfig.Soulbound")) {
            ArrayList Nau = new ArrayList();
            Nau.add("Soulbound");
            Im.setLore(Nau);
        }
        I.setItemMeta(Im);
        return I;
    }

    public org.bukkit.inventory.ItemStack Wither_Axe() {
        org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta Im = I.getItemMeta();
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.WitherAxeConfig.Enchantments")) {
            Im.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            Im.addEnchant(Enchantment.DURABILITY, 3, true);
        }
        Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', WAXE));
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.WitherAxeConfig.Soulbound")) {
            ArrayList Nau = new ArrayList();
            Nau.add("Soulbound");
            Im.setLore(Nau);
        }
        I.setItemMeta(Im);
        return I;
    }

    // Sword's
    public org.bukkit.inventory.ItemStack Poison_Sword() {
        org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta Im = I.getItemMeta();
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.PoisonAxeConfig.Enchantments")) {
            Im.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            Im.addEnchant(Enchantment.DURABILITY, 3, true);
        }
        Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', PSW));
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Axe.PoisonAxeConfig.Soulbound")) {
            ArrayList Nau = new ArrayList();
            Nau.add("Soulbound");
            Im.setLore(Nau);
        }
        I.setItemMeta(Im);
        return I;
    }

    public org.bukkit.inventory.ItemStack Nausea_Sword() {
        org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta Im = I.getItemMeta();
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Sword.NauseaSwordConfig.Enchantments")) {
            Im.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            Im.addEnchant(Enchantment.DURABILITY, 3, true);
        }
        Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', NSW));
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Sword.NauseaSwordConfig.Soulbound")) {
            ArrayList Nau = new ArrayList();
            Nau.add("Soulbound");
            Im.setLore(Nau);
        }
        I.setItemMeta(Im);
        return I;
    }

    public org.bukkit.inventory.ItemStack Blindness_Sword() {
        org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta Im = I.getItemMeta();
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Sword.BlindnessSwordConfig.Enchantments")) {
            Im.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            Im.addEnchant(Enchantment.DURABILITY, 3, true);
        }
        Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', BSW));
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Sword.BlindnessSwordConfig.Soulbound")) {
            ArrayList Nau = new ArrayList();
            Nau.add("Soulbound");
            Im.setLore(Nau);
        }
        I.setItemMeta(Im);
        return I;
    }

    public org.bukkit.inventory.ItemStack Wither_Sword() {
        org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta Im = I.getItemMeta();
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Sword.WitherSwordConfig.Enchantments")) {
            Im.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            Im.addEnchant(Enchantment.DURABILITY, 3, true);
        }
        Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', WSW));
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Sword.WitherSwordConfig.Soulbound")) {
            ArrayList Nau = new ArrayList();
            Nau.add("Soulbound");
            Im.setLore(Nau);
        }
        I.setItemMeta(Im);
        return I;
    }
    public org.bukkit.inventory.ItemStack Nether_Wart() {
        org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.NETHER_STAR, 1);
        ItemMeta Im = I.getItemMeta();
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Sword.NetherWartKit.Enchantments")) {
            Im.addEnchant(Enchantment.DURABILITY, 3, true);
        }
        Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', NW));
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Sword.NetherWartKit.Soulbound")) {
            ArrayList Nau = new ArrayList();
            Nau.add("Soulbound");
            Im.setLore(Nau);
        }
        I.setItemMeta(Im);
        return I;
    }

    public org.bukkit.inventory.ItemStack Nether_Wart_Helmet() {
        org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.DIAMOND_HELMET, 1);
        ItemMeta Im = I.getItemMeta();
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Armor.WitherHelmet.Enchantments")) {
            Im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            Im.addEnchant(Enchantment.DURABILITY, 3, true);
        }
        Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', WH));
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Armor.WitherHelmet.Soulbound")) {
            ArrayList Nau = new ArrayList();
            Nau.add("Soulbound");
            Im.setLore(Nau);
        }
        I.setItemMeta(Im);
        return I;
    }
    public org.bukkit.inventory.ItemStack Nether_Wart_Chestplate() {
        org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta Im = I.getItemMeta();
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Armor.WitherChestPlate.Enchantments")) {
            Im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            Im.addEnchant(Enchantment.DURABILITY, 3, true);
        }
        Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', WC));
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Armor.WitherChestPlate.Soulbound")) {
            ArrayList Nau = new ArrayList();
            Nau.add("Soulbound");
            Im.setLore(Nau);
        }
        I.setItemMeta(Im);
        return I;
    }
    public org.bukkit.inventory.ItemStack Nether_Wart_Leggins() {
        org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemMeta Im = I.getItemMeta();
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Armor.WitherLeggings.Enchantments")) {
            Im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            Im.addEnchant(Enchantment.DURABILITY, 3, true);
        }
        Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', WL));
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Armor.WitherLeggings.Soulbound")) {
            ArrayList Nau = new ArrayList();
            Nau.add("Soulbound");
            Im.setLore(Nau);
        }
        I.setItemMeta(Im);
        return I;
    }
    public org.bukkit.inventory.ItemStack Nether_Wart_Boots() {
        org.bukkit.inventory.ItemStack I = new org.bukkit.inventory.ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta Im = I.getItemMeta();
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Armor.WitherBoots.Enchantments")) {
            Im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            Im.addEnchant(Enchantment.DURABILITY, 3, true);
        }
        Im.setDisplayName(ChatColor.translateAlternateColorCodes('&', WB));
        if (weaponkit.getConfig().getBoolean("Weaponkit.Items.Armor.WitherBoots.Soulbound")) {
            ArrayList Nau = new ArrayList();
            Nau.add("Soulbound");
            Im.setLore(Nau);
        }
        I.setItemMeta(Im);
        return I;
    }

}
