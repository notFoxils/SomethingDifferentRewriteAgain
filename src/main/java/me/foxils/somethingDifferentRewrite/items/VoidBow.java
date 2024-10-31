package me.foxils.somethingDifferentRewrite.items;

import me.foxils.foxutils.Item;
import me.foxils.foxutils.itemactions.ClickActions;
import me.foxils.foxutils.itemactions.ShootAction;
import me.foxils.foxutils.utilities.ItemAbility;
import me.foxils.foxutils.utilities.ItemUtils;
import org.bukkit.*;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoidBow extends Item implements ClickActions, ShootAction {

    private final NamespacedKey VOID_ARROW_BOOLEAN = new NamespacedKey(plugin, "void_arrow");

    private static final Map<ItemStack, Arrow> itemArrowMap = new HashMap<>();

    public VoidBow(Material material, int customModelData, String name, Plugin plugin, List<ItemAbility> abilityList, List<ItemStack> itemsForRecipe, boolean shapedRecipe) {
        super(material, customModelData, name, plugin, abilityList, itemsForRecipe, shapedRecipe);
    }

    @Override
    public void leftClickAir(PlayerInteractEvent event, ItemStack itemInteracted) {
        teleportToArrow(event, itemInteracted);
    }

    @Override
    public void leftClickBlock(PlayerInteractEvent event, ItemStack itemInteracted) {
        teleportToArrow(event, itemInteracted);
    }

    private void teleportToArrow(PlayerInteractEvent event, ItemStack itemInteracted) {
        Player player = event.getPlayer();

        if (itemInteracted.getType() != Material.PAPER) {
            player.sendMessage(ChatColor.RED + "Cannot Use Void Teleport: Out Of Time");
            return;
        }

        Arrow voidArrow = itemArrowMap.get(itemInteracted);

        if (voidArrow == null) {
            player.sendMessage("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "No Void Arrow To Teleport To");
            return;
        }

        player.teleport(voidArrow);
    }

    @Override
    public void onShootProjectile(ProjectileLaunchEvent projectileLaunchEvent, Projectile projectile, ItemStack itemStack) {
        addVoidArrowTag(projectileLaunchEvent, projectile, itemStack);
    }

    private void addVoidArrowTag(ProjectileLaunchEvent projectileLaunchEvent, Projectile projectile, ItemStack itemStack) {
        if (!(projectile instanceof Arrow arrow)) return;

        arrow.setColor(Color.PURPLE);

        itemStack.setType(Material.PAPER);

        itemArrowMap.put(itemStack, arrow);

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            itemArrowMap.remove(itemStack);
            arrow.remove();

            ((Player) projectileLaunchEvent.getEntity().getShooter()).sendTitle("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Void Arrow Removed", null, 5, 30, 5);

            itemStack.setType(Material.BOW);
        }, 1200);
    }

    private class removeVoidArrowTask extends BukkitRunnable {

        @Override
        public void run() {

        }
    }
}
