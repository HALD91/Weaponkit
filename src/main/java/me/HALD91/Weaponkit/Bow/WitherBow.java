package me.HALD91.Weaponkit.Bow;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WitherBow implements Listener {
    //Main File
    me.HALD91.Weaponkit.weaponkit weaponkit = JavaPlugin.getPlugin(me.HALD91.Weaponkit.weaponkit.class);

    //WitherBow Name
    public String WitBow = weaponkit.getConfig().getString("Weaponkit.Items.Bow.Wither.Name");

    public boolean onitem(ItemStack I, String Displayname, Material ItemType) {
        return (I != null) && (I.hasItemMeta()) && (I.getItemMeta().getDisplayName().equalsIgnoreCase(Displayname)) && (I.getType() == ItemType);
    }

    @EventHandler
    public void onEntityHit(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Arrow) {
            Arrow f = (Arrow) e.getDamager();
            Player shootedplayer = (Player) e.getEntity();
            if (f.getShooter() instanceof Player) {
                Player shooter = (Player) f.getShooter();
                if (e.getEntity() instanceof Player) {
                    ItemStack I =  shooter.getItemInHand();
                    if (onitem(I, ChatColor.translateAlternateColorCodes('&',WitBow + ""), Material.BOW)) {
                        shootedplayer.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1));
                        shootedplayer.getWorld().playEffect(shootedplayer.getLocation(), Effect.POTION_BREAK, 0);
                    }
                }
            }
        }
    }
}
