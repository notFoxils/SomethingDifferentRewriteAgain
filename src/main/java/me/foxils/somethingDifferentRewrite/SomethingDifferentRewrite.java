package me.foxils.somethingDifferentRewrite;

import me.foxils.foxutils.registry.ItemRegistry;
import me.foxils.foxutils.utilities.ActionType;
import me.foxils.foxutils.utilities.ItemAbility;
import me.foxils.somethingDifferentRewrite.items.EnchantedChorusFruit;
import me.foxils.somethingDifferentRewrite.items.EnchantedEnderPearl;
import me.foxils.somethingDifferentRewrite.items.VoidBow;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public final class SomethingDifferentRewrite extends JavaPlugin {

    @Override
    public void onEnable() {
        registerItems();
    }

    private void registerItems() {
        EnchantedChorusFruit enchantedChorusFruit = new EnchantedChorusFruit(Material.CHORUS_FRUIT, ChatColor.DARK_PURPLE + "Enchanted Chorus Fruit", this,
                List.of(
                        new ItemAbility("Enchanted", Arrays.asList(
                                "Compacted item made up",
                                "of its non-enchanted form"
                        ), ActionType.CRAFT)
                ),
                Arrays.asList(
                        new ItemStack(Material.AIR), new ItemStack(Material.CHORUS_FRUIT, 32), new ItemStack(Material.AIR),
                        new ItemStack(Material.CHORUS_FRUIT, 32), new ItemStack(Material.CHORUS_FRUIT, 32), new ItemStack(Material.CHORUS_FRUIT, 32),
                        new ItemStack(Material.AIR), new ItemStack(Material.CHORUS_FRUIT, 32), new ItemStack(Material.AIR)
                ), false);
        EnchantedEnderPearl enchantedEnderPearl = new EnchantedEnderPearl(Material.ENDER_PEARL, ChatColor.LIGHT_PURPLE + "Enchanted Ender Pearl", this,
                List.of(
                        new ItemAbility("Enchanted", Arrays.asList(
                                "Compacted item made up",
                                "of its non-enchanted form"
                        ), ActionType.CRAFT)
                ),
                Arrays.asList(
                        new ItemStack(Material.AIR), new ItemStack(Material.ENDER_PEARL, 16), new ItemStack(Material.AIR),
                        new ItemStack(Material.ENDER_PEARL, 16), new ItemStack(Material.ENDER_PEARL, 16), new ItemStack(Material.ENDER_PEARL, 16),
                        new ItemStack(Material.AIR), new ItemStack(Material.ENDER_PEARL, 16), new ItemStack(Material.AIR)
                ), false);

        ItemRegistry.registerItem(enchantedChorusFruit);
        ItemRegistry.registerItem(enchantedEnderPearl);

        ItemRegistry.registerItem(new VoidBow(Material.BOW, 10, "" + ChatColor.of("#9b01e8") + ChatColor.BOLD + ChatColor.MAGIC + "[" + ChatColor.RESET + ChatColor.of("#9b01e8") + ChatColor.BOLD + "[" + ChatColor.of("#9b01e8") + ChatColor.BOLD + "V" + ChatColor.of("#8801d2") + ChatColor.BOLD + "o" + ChatColor.of("#7602bb") + ChatColor.BOLD + "i" + ChatColor.of("#6302a4") + ChatColor.BOLD + "d " + ChatColor.of("#50038e") + ChatColor.BOLD + "B" + ChatColor.of("#3d0377") + ChatColor.BOLD + "o" + ChatColor.of("#2b0460") + ChatColor.BOLD + "w]" + ChatColor.MAGIC + "]", this,
                Arrays.asList(
                        new ItemAbility("Chain Of The Void", Arrays.asList(
                                "Teleports your last shot player to your location.",
                                "Must be activated within 1m of your last shot."
                        ), ActionType.LEFT_CLICK),
                        new ItemAbility("Void Teleport", Arrays.asList(
                                "Allows you to teleport to your last shot arrow.",
                                "Can only be used if last shot did not hit a player.",
                                "Must be activated within 30s of your last shot."
                        ), ActionType.LEFT_CLICK)
                ),
                Arrays.asList(
                        new ItemStack(Material.AIR), enchantedChorusFruit.createItem(32), new ItemStack(Material.BOW),
                        enchantedEnderPearl.createItem(16), new ItemStack(Material.PLAYER_HEAD), new ItemStack(Material.BOW),
                        new ItemStack(Material.AIR), enchantedChorusFruit.createItem(32), new ItemStack(Material.BOW)
                ), true));
    }

}
