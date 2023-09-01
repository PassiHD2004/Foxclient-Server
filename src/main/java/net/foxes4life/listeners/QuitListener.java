package net.foxes4life.listeners;

import net.foxes4life.Main;
import net.foxes4life.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class QuitListener implements Listener {

    private static Main plugin;

    public QuitListener(Main plugin) {
        QuitListener.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        e.setQuitMessage("");
        {
            Bukkit.broadcastMessage(
                    Utils.chat(Objects.requireNonNull(plugin.getConfig().getString("QuitMessage")).replace("<player>", p.getName())));
        }
    }
}