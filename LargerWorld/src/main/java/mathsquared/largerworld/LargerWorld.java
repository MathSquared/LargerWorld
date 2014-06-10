/**
 * 
 */
package mathsquared.largerworld;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author MathSquared
 * 
 */
public class LargerWorld extends JavaPlugin implements Listener {
    private static Plugin instance;

    @Override
    public void onEnable () {
        instance = this;
        CommandExecutor executor = new LargerWorldCommandExecutor();
        getCommand("basic").setExecutor(executor);
        getCommand("basic2").setExecutor(executor);
        getCommand("vengeance").setExecutor(executor);
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("onEnable has been invoked!");
    }

    @Override
    public void onDisable () {
        getLogger().info("onDisable has been invoked!");
    }

    @EventHandler
    public void onPlayerMove (PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        loc.setY(loc.getY() + 5);
        Block block = loc.getBlock();
        block.setType(Material.STONE);
    }

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PlayerInventory inv = player.getInventory();
        ItemStack diamonds = new ItemStack(Material.DIAMOND, 64);

        if (inv.contains(diamonds)) {
            inv.addItem(diamonds);
            player.sendMessage("May the rich be ever richer.");
        }
    }

    public static Plugin getInstance () {
        return instance;
    }
}
