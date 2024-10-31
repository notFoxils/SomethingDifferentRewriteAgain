package me.foxils.somethingDifferentRewrite.items;

import me.foxils.foxutils.Item;
import me.foxils.foxutils.utilities.ItemAbility;
import me.foxils.foxutils.utilities.ItemUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class EnchantedEnderPearl extends Item {

    public EnchantedEnderPearl(Material material, String name, Plugin plugin, List<ItemAbility> abilityList, List<ItemStack> itemsForRecipe, boolean shapedRecipe) {
        super(material, name, plugin, abilityList, itemsForRecipe, shapedRecipe);
    }

    @Override
    public ItemStack createItem(int amount) {
        ItemStack newItem = super.createItem(amount);

        ItemUtils.addEnchantGlint(newItem);

        return newItem;
    }
}
