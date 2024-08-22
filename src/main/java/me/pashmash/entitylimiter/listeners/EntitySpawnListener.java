package me.pashmash.entitylimiter.listeners;

import me.pashmash.entitylimiter.EntityLimiter;
import org.bukkit.Chunk;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Arrays;

public class EntitySpawnListener implements Listener {
    @EventHandler
    public void onEntitySpawn(CreatureSpawnEvent event) {
        EntityType type = event.getEntityType();
        Chunk chunk = event.getLocation().getChunk();
        int limit = EntityLimiter.getInstance().getConfig().getInt("entity-limits." + type.name(), 10);

        long entityCount = Arrays.stream(chunk.getEntities())
                .filter(entity -> entity.getType().equals(type))
                .count();

        if (entityCount >= limit) {
            event.setCancelled(true);
        }
    }
}
