package net.foxes4life;

import org.bukkit.plugin.java.JavaPlugin;
import net.foxes4life.listeners.JoinListener;
import net.foxes4life.listeners.QuitListener;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new JoinListener(this);
        new QuitListener(this);
        new FoxclientCMD(this);
    }

    public void onDisable() {
        // Plugin shutdown logic
    }
}
