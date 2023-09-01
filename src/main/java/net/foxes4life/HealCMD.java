package net.foxes4life;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.foxes4life.utils.Utils;

public class HealCMD implements CommandExecutor {

    private final Main plugin;

    public HealCMD(Main plugin) {
        this.plugin = plugin;

        plugin.getCommand("heal").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("no_console")));
            return true;

        }

        Player p = (Player) sender;

        if (p.hasPermission("whatever.heal")) {

            if (p.getHealth() < 20) {
                p.setHealth(20);
                p.sendMessage(Utils.chat(plugin.getConfig().getString("heal_filled")));
            } else {
                p.sendMessage(Utils.chat(plugin.getConfig().getString("heal_full")));
            }
            return true;
        } else {
            p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm")));
        }
        return false;
    }

}
