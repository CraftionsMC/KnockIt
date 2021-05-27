/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.knockit.events;

import net.craftions.knockit.KnockIt;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class EventBlockPlace implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
            Bukkit.getScheduler().scheduleSyncDelayedTask(KnockIt.getInstance(), new Runnable() {
                @Override
                public void run() {
                    e.getBlock().setType(Material.AIR);
                }
            }, 10*20);
        }
    }
}
