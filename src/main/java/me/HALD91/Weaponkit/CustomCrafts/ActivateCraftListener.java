package me.HALD91.Weaponkit.CustomCrafts;

import me.HALD91.Weaponkit.Main.weaponkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ActivateCraftListener implements Listener {
    private Plugin plugin;

    public ActivateCraftListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCraftItem(CraftItemEvent e) {
        weaponkit weaponkit = JavaPlugin.getPlugin(me.HALD91.Weaponkit.Main.weaponkit.class);
        String ActivateCraftOffMessage = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "Weaponkit.Messages.ActivateCraftIsOffMessage"));
        String prefix = weaponkit.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "Weaponkit.Prefix"));

        // get who clicked and get result of crafting
        Player player = (Player) e.getWhoClicked();
        ItemStack result = e.getInventory().getResult();

        // check if player is allowed to craft this recipe
        CraftWitherBow craftWitherBow = new CraftWitherBow(plugin);
        CraftMultiBow craftMultiBow = new CraftMultiBow(plugin);
        if (craftMultiBow.isCustomRecipe(result) && !craftMultiBow.canCraft(player) || craftWitherBow.isCustomRecipe(result) && !craftWitherBow.canCraft(player)) {
            e.setResult(Event.Result.DENY); // Cancel the crafting event
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " " + ActivateCraftOffMessage));
        }
    }
}
