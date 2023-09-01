package net.foxes4life.listeners;

import net.foxes4life.Main;
import net.foxes4life.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class JoinListener implements Listener {

    public JoinListener(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e, Plugin plugin) {
        // What to do when the player joins?

        Bukkit.getPluginManager().registerEvents(this, plugin);

        Player p = e.getPlayer();

        if (!p.hasPlayedBefore()) {
            Bukkit.broadcastMessage (
                    Utils.chat(Objects.requireNonNull(plugin.getConfig().getString("First_JoinMessage")).replace("<player>", p.getName())));
        } else {
            Bukkit.broadcastMessage (
                    Utils.chat(Objects.requireNonNull(plugin.getConfig().getString("JoinMessage")).replace("<player>", p.getName())));
        }
    }
}
