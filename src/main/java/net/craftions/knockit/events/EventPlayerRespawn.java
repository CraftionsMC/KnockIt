/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.knockit.events;

import net.craftions.knockit.KnockIt;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class EventPlayerRespawn implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        e.getPlayer().getInventory().setContents(KnockIt.getDefaultInventory().getContents());
        if(KnockIt.config.get("spawn") != null){
            e.setRespawnLocation((Location) KnockIt.config.get("spawn"));
        }else {
            e.getPlayer().sendMessage(KnockIt.prefix + "§7The spawn was §cnot §7set yet. Set it using §a/setspawn");
        }
    }
}
