/**
 * 
 */
package mathsquared.largerworld;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author MathSquared
 * 
 */
public class LargerWorldCommandExecutor implements CommandExecutor {

    /**
     * @see org.bukkit.command.CommandExecutor#onCommand(org.bukkit.command.CommandSender, org.bukkit.command.Command, java.lang.String, java.lang.String[])
     */
    @Override
    public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("basic")) {
            sender.sendMessage("Hello, world!");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("basic2")) {
            if (sender instanceof Player) {
                sender.sendMessage("Hello, " + sender.getName() + "!");
                return true;
            } else {
                sender.sendMessage("You must be a player!");
                return false;
            }
        }
        if (cmd.getName().equalsIgnoreCase("vengeance")) {
            if (sender instanceof Player) {
                ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);

                // Enchant with Fire Aspect II
                Enchantment fireAspect = new EnchantmentWrapper(20); // Fire Aspect
                sword.addEnchantment(fireAspect, 2);

                // Give a BOSS display name
                ItemMeta meta = sword.getItemMeta();
                meta.setDisplayName(ChatColor.RED.toString() + ChatColor.BOLD + "Sword of Vengeance");
                sword.setItemMeta(meta);

                // Give the item
                sender.sendMessage(ChatColor.RED.toString() + ChatColor.BOLD + "VENGEANCE SHALL BE HAD!");
                ((Player) sender).getInventory().addItem(sword);

                return true;
            } else {
                sender.sendMessage("Only players may use the Sword of Vengeance.");
                return false;
            }
        }

        return false;
    }

}
