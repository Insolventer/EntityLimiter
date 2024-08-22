package me.pashmash.entitylimiter;

import me.pashmash.entitylimiter.listeners.EntitySpawnListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

public class EntityLimiter extends JavaPlugin implements Listener {

    private static EntityLimiter instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new EntitySpawnListener(), this);
        saveDefaultConfig();
    }


    public static EntityLimiter getInstance() {
        return instance;
    }
}

