/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.knockit.events;

import net.craftions.knockit.KnockIt;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventPlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.getPlayer().getInventory().setContents(KnockIt.getDefaultInventory().getContents());
        e.setJoinMessage(KnockIt.prefix + "§c" + e.getPlayer().getName() + " §7joined the game.");
        if(KnockIt.config.get("spawn") != null){
            e.getPlayer().teleport((Location) KnockIt.config.get("spawn"));
        }else {
            e.getPlayer().sendMessage(KnockIt.prefix + "§7The spawn was §cnot §7set yet. Set it using §a/setspawn");
        }
    }
}
