package me.HALD91.Weaponkit.Gui;

import me.HALD91.Weaponkit.weaponkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Random;

public class Listener implements org.bukkit.event.Listener {
    me.HALD91.Weaponkit.weaponkit weaponkit = JavaPlugin.getPlugin(me.HALD91.Weaponkit.weaponkit.class);

    public String PAXE = weaponkit.getConfig().getString("Weaponkit.Items.Axe.PoisonAxeConfig.Name");
    public String NAXE = weaponkit.getConfig().getString("Weaponkit.Items.Axe.NauseaAxeConfig.Name");
    public String BAXE = weaponkit.getConfig().getString("Weaponkit.Items.Axe.BlindnessAxeConfig.Name");
    public String WAXE = weaponkit.getConfig().getString("Weaponkit.Items.Axe.WitherAxeConfig.Name");

    // Sword's names
    public String PSW = weaponkit.getConfig().getString("Weaponkit.Items.Sword.PoisonSwordConfig.Name");
    public String NSW = weaponkit.getConfig().getString("Weaponkit.Items.Sword.NauseaSwordConfig.Name");
    public String BSW = weaponkit.getConfig().getString("Weaponkit.Items.Sword.BlindnessSwordConfig.Name");
    public String WSW = weaponkit.getConfig().getString("Weaponkit.Items.Sword.WitherSwordConfig.Name");

    // Wither Tear
    public String NW = weaponkit.getConfig().getString("Weaponkit.Items.WitherTear.Name");

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
        if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
            /*if (e.isCancelled()) {
                return;
            } else {*/
                Player P = (Player) e.getEntity();
                Player D = (Player) e.getDamager();
                ItemStack I = D.getItemInHand();

                // Axe's
                if (onitem(I, ChatColor.translateAlternateColorCodes('&',PAXE + ""), Material.DIAMOND_AXE)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                }
                if (onitem(I, ChatColor.translateAlternateColorCodes('&',NAXE + ""), Material.DIAMOND_AXE)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                }
                if (onitem(I, ChatColor.translateAlternateColorCodes('&',WAXE + ""), Material.DIAMOND_AXE)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                }
                if (onitem(I, ChatColor.translateAlternateColorCodes('&',BAXE + ""), Material.DIAMOND_AXE)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                }

                // Sword's
                if (onitem(I, ChatColor.translateAlternateColorCodes('&',PSW + ""), Material.DIAMOND_SWORD)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                }
                if (onitem(I, ChatColor.translateAlternateColorCodes('&',NSW + ""), Material.DIAMOND_SWORD)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                }
                if (onitem(I, ChatColor.translateAlternateColorCodes('&',WSW + ""), Material.DIAMOND_SWORD)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                }
                if (onitem(I, ChatColor.translateAlternateColorCodes('&',BSW + ""), Material.DIAMOND_SWORD)) {
                    P.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
                    P.getWorld().playEffect(P.getLocation(), Effect.POTION_BREAK, 0);
                }
            }
        }

        @EventHandler
        public void RightClick(PlayerInteractEvent e) {
            Player P = (Player) e.getPlayer();
            ItemStack I = P.getItemInHand();
            // Wither Tear
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (onitem(I, ChatColor.translateAlternateColorCodes('&', NW + ""), Material.GHAST_TEAR)) {
                    for (PotionEffect effect : P.getActivePotionEffects()) {
                        if (effect.getType().equals(PotionEffectType.WITHER) || effect.getType().equals(PotionEffectType.POISON) || effect.getType().equals(PotionEffectType.BLINDNESS) || effect.getType().equals(PotionEffectType.CONFUSION)) {
                            P.removePotionEffect(effect.getType());
                        }
                    }
                }
            }
        }

    }
/*}*/
