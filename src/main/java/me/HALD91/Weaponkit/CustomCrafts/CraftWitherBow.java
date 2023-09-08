package me.HALD91.Weaponkit.CustomCrafts;

import me.HALD91.Weaponkit.Gui.itemstack;
import me.HALD91.Weaponkit.Main.weaponkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public class CraftWitherBow {
    private final Plugin plugin;


    public CraftWitherBow(Plugin plugin) {
        this.plugin = plugin;
    }

    public static ItemStack getItemWithCustomData(int itemId, int dataValue, int amount) {
        Material material = Material.getMaterial(itemId);
        if (material != null) {
            ItemStack itemStack = new ItemStack(material, amount);
            itemStack.setDurability((short) dataValue);
            return itemStack;
        } else {
            return null; // Item ID is not valid
        }
    }
    public ShapedRecipe getRecipe() {
        ShapedRecipe witherbowrecipe = new ShapedRecipe(new itemstack().Wither_Bow());

        //ItemStack skull = new ItemStack(Material.SKULL, 1, (short) 397);
        witherbowrecipe.shape(" B ","BAB"," B ");
        witherbowrecipe.setIngredient('B', Material.BOW);
        witherbowrecipe.setIngredient('A', getItemWithCustomData(397,1,1).getData());
        return witherbowrecipe;
    }
    public boolean canCraft(Player player) {
        // Check if the player's name is in the allowedCrafters ArrayList
        return weaponkit.allowedCrafters.contains(player.getName());
    }
    public boolean isCustomRecipe(ItemStack itemStack) {
        // Check if the itemStack is the result of the custom recipe
        return itemStack.isSimilar(new itemstack().Wither_Bow());
    }
}
