package net.foxes4life.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.foxes4life.Main;
import net.foxes4life.utils.Utils;

import java.util.Objects;

public class JoinListener implements Listener {

    private static Main plugin;

    public JoinListener(Main plugin) {
        JoinListener.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
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