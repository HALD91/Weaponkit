package me.HALD91.Weaponkit.CustomCrafts;

import me.HALD91.Weaponkit.Gui.itemstack;
import me.HALD91.Weaponkit.Main.weaponkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;


public class CraftMultiBow {
    private final Plugin plugin;

    public CraftMultiBow(Plugin plugin) {
        this.plugin = plugin;
    }
    public ShapedRecipe getRecipe() {
        ShapedRecipe multibowrecipe = new ShapedRecipe(new itemstack().Multi_Bow());
        multibowrecipe.shape(" B ","BAB"," B ");
        multibowrecipe.setIngredient('B', Material.BOW);
        multibowrecipe.setIngredient('A', Material.ARROW);
        return multibowrecipe;
    }
    public boolean canCraft(Player player) {
        // Check if the player's name is in the allowedCrafters ArrayList
        return weaponkit.allowedCrafters.contains(player.getName());
    }
    public boolean isCustomRecipe(ItemStack itemStack) {
        // Check if the itemStack is the result of the custom recipe
        return itemStack.isSimilar(new itemstack().Multi_Bow());
    }
}
