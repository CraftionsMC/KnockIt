/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.knockit.commands;

import net.craftions.knockit.KnockIt;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            KnockIt.config.set("spawn", ((Player) sender).getLocation());
            KnockIt.config.reload(true);
            sender.sendMessage(KnockIt.prefix + "§7The spawn was §asuccessfully §7set.");
        }else {
            sender.sendMessage(KnockIt.prefix + "§cYou need to be a player in order to run this command.");
        }
        return true;
    }
}
