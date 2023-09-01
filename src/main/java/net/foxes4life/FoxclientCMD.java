package net.foxes4life;

import net.foxes4life.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class FoxclientCMD implements CommandExecutor {

    private final Main plugin;

    public FoxclientCMD(Main plugin) {
        this.plugin = plugin;
        Objects.requireNonNull(plugin.getCommand("foxclient")).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("no_console")));
            return true;

        }
        Player p = (Player) sender;

        if (p.hasPermission(Objects.requireNonNull(plugin.getConfig().getString("common")))) {
            p.sendMessage(Utils.chat(plugin.getConfig().getString("foxclient_message")));

            return true;
        } else {
            p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm")));
        }
        return false;
    }
}

