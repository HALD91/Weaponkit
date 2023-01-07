package me.HALD91.Weaponkit.Bow;

import me.HALD91.Weaponkit.Gui.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.Objects;

public class MultiBow extends Listener {
    me.HALD91.Weaponkit.weaponkit weaponkit = JavaPlugin.getPlugin(me.HALD91.Weaponkit.weaponkit.class);
    public String MulBow = weaponkit.getConfig().getString("Weaponkit.Items.Bow.Multi.Name");

    public boolean onitem(ItemStack I, String Displayname, Material ItemType) {
        return (I != null) && (I.hasItemMeta()) && (I.getItemMeta().getDisplayName().equalsIgnoreCase(Displayname)) && (I.getType() == ItemType);
    }

    public Vector rotateVector(Vector vector, double whatAngle) {
        double sin = Math.sin(whatAngle);
        double cos = Math.cos(whatAngle);
        double x = vector.getX() * cos + vector.getZ() * sin;
        double z = vector.getX() * -sin + vector.getZ() * cos;
        return vector.setX(x).setZ(z);
    }
    @EventHandler
    public void multibow(EntityShootBowEvent e) {
        Player p = (Player) e.getEntity();
        ItemStack b = p.getItemInHand();

        //if (Objects.equals(b.getItemMeta().getDisplayName(), ChatColor.translateAlternateColorCodes('&', MulBow + ""))) {
        if (onitem(b, ChatColor.translateAlternateColorCodes('&', MulBow + ""), Material.BOW)) {
            e.setCancelled(true);
            e.getEntity().getWorld().spawnArrow(e.getEntity().getLocation().clone().add(0, 2.5, 0), rotateVector(e.getProjectile().getVelocity(), 0), e.getForce() * 2, 0f);
            Bukkit.getScheduler().runTaskLater(weaponkit, () -> {
                e.getEntity().getWorld().spawnArrow(e.getEntity().getLocation().clone().add(0, 2.5, 0), rotateVector(e.getProjectile().getVelocity(), 0), e.getForce() * 2, 0f);
            },5L);
        }
    }
}
