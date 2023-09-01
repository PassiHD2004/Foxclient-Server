package net.foxes4life.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import net.foxes4life.Main;
import net.foxes4life.utils.Utils;

public class QuitListener implements Listener {

    private static Main plugin;

    public QuitListener(Main plugin) {
        QuitListener.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent f) {
        Player p = f.getPlayer();

        {

            Bukkit.broadcastMessage(
                    Utils.chat(plugin.getConfig().getString("QuitMessage").replace("<player>", p.getName())));
        }
    }
}