package me.HALD91.Weaponkit.Gui;

import me.HALD91.Weaponkit.weaponkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Random;

public class Listener implements org.bukkit.event.Listener {
    me.HALD91.Weaponkit.weaponkit weaponkit = JavaPlugin.getPlugin(me.HALD91.Weaponkit.weaponkit.class);

    public String PAXE = weaponkit.getConfig().getString("Weaponkit.Items.PoisonAxeConfig.Name");
    public String NAXE = weaponkit.getConfig().getString("Weaponkit.Items.NauseaAxeConfig.Name");
    public String BAXE = weaponkit.getConfig().getString("Weaponkit.Items.BlindnessAxeConfig.Name");
    public String WAXE = weaponkit.getConfig().getString("Weaponkit.Items.WitherAxeConfig.Name");

    // Sword's names
    public String PSW = weaponkit.getConfig().getString("Weaponkit.Items.PoisonSwordConfig.Name");
    public String NSW = weaponkit.getConfig().getString("Weaponkit.Items.NauseaSwordConfig.Name");
    public String BSW = weaponkit.getConfig().getString("Weaponkit.Items.BlindnessSwordConfig.Name");
    public String WSW = weaponkit.getConfig().getString("Weaponkit.Items.WitherSwordConfig.Name");

    // NetherWart
    public String NW = weaponkit.getConfig().getString("Weaponkit.Items.NetherWartKit.Name");

    // Armor
    public String WH = weaponkit.getConfig().getString("Weaponkit.Items.Armor.WitherHelmet.Name");
    public String WC = weaponkit.getConfig().getString("Weaponkit.Items.Armor.WitherChestPlate.Name");
    public String WL = weaponkit.getConfig().getString("Weaponkit.Items.Armor.WitherLeggings.Name");
    public String WB = weaponkit.getConfig().getString("Weaponkit.Items.Armor.WitherBoots.Name");

    // bug needs fíx here sooo... fix it u dum fuck!
    @EventHandler
    public void ondrop(PlayerDropItemEvent event){
        Player p = event.getPlayer();
        Item i = event.getItemDrop();
        if (!(i.getItemStack().getItemMeta().getLore() == null)) {
            if (!i.getItemStack().getItemMeta().getLore().contains("Soulbound")) {
                event.setCancelled(false);
            } else if (i.getItemStack().getItemMeta().getLore().contains("Soulbound")) {
                event.setCancelled(true);
            }
        }
    }

    public boolean isCustom(ItemStack item) {
        if (item == null) return false;
        if (!item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        if (!meta.hasLore()) return false;
        List<String> lore = meta.getLore();
        return lore.stream().anyMatch((line) -> ChatColor.stripColor(line).equalsIgnoreCase("Soulbound"));
    }

    @EventHandler
    public void playerDie(final PlayerDeathEvent e) {
        List<ItemStack> Inventory = e.getDrops();
        Inventory.removeIf((item) -> this.isCustom(item));
    }

    public boolean onitem(ItemStack I, String Displayname, Material ItemType) {
        return (I != null) && (I.hasItemMeta()) && (I.getItemMeta().getDisplayName().equalsIgnoreCase(Displayname)) && (I.getType() == ItemType);
    }

    @EventHandler
    public void onEntityHit(EntityDamageByEntityEvent e) {
        Random rand = new Random();

        if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
            if (e.isCancelled()) {
                return;
            } else {
                Player P = (Player) e.getEntity();
                Player D = (Player) e.getDamager();
                ItemStack I = D.getItemInHand();

                // Axe's
                if (onitem(I, PAXE + "", Material.DIAMOND_AXE)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                    return;
                }
                if (onitem(I, NAXE + "", Material.DIAMOND_AXE)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                    return;
                }
                if (onitem(I, WAXE + "", Material.DIAMOND_AXE)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                    return;
                }
                if (onitem(I, BAXE + "", Material.DIAMOND_AXE)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                    return;
                }

                // Sword's
                if (onitem(I, PSW + "", Material.DIAMOND_SWORD)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                    return;
                }
                if (onitem(I, NSW + "", Material.DIAMOND_SWORD)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                    return;
                }
                if (onitem(I, WSW + "", Material.DIAMOND_SWORD)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                    return;
                }
                if (onitem(I, BSW + "", Material.DIAMOND_SWORD)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                    return;
                }
            }
        }
    }
}
