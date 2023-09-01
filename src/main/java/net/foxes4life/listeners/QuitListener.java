package net.foxes4life.listeners;

import net.foxes4life.Main;
import net.foxes4life.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class QuitListener implements Listener {

    public QuitListener(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e, Plugin plugin) {
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
