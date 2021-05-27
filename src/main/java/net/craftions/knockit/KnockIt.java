package net.craftions.knockit;

import org.bukkit.plugin.java.JavaPlugin;

public final class KnockIt extends JavaPlugin {

    public static String prefix = "§7[§cKnock§9It§7] §r";

    @Override
    public void onEnable() {
        System.out.println(prefix + "Loading KnockIt v" + this.getDescription().getVersion() + "...");

    }

    @Override
    public void onDisable() {
    }
}
