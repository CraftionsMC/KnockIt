/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.knockit.events;

import net.craftions.knockit.KnockIt;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventPlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(KnockIt.config.get("spawn") != null){

        }
    }
}
