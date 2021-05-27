package net.craftions.knockit;

import net.craftions.knockit.commands.CommandSetSpawn;
import net.craftions.knockit.config.Config;
import net.craftions.knockit.events.EventBlockPlace;
import net.craftions.knockit.events.EventInventoryClick;
import net.craftions.knockit.events.EventPlayerDeath;
import net.craftions.knockit.events.EventPlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class KnockIt extends JavaPlugin {

    public static String prefix = "§7[§cKnock§9It§7] §r";
    public static Config config = null;

    @Override
    public void onEnable() {
        System.out.println(prefix + "Loading KnockIt v" + this.getDescription().getVersion() + "...");
        // prepare configuration
        File rootDir = new File("plugins/KnockIt");
        if (!rootDir.isDirectory()) {
            rootDir.mkdirs();
        }
        File configFile = new File("plugins/KnockIt/config.yml");
        if(!configFile.exists()){
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = new Config(configFile, "conf");
        // register commands
        getCommand("setspawn").setExecutor(new CommandSetSpawn());
        // register events
        Bukkit.getPluginManager().registerEvents(new EventPlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerDeath(), this);
        Bukkit.getPluginManager().registerEvents(new EventBlockPlace(), this);
        Bukkit.getPluginManager().registerEvents(new EventInventoryClick(), this);
        // finish
        System.out.println(prefix + "Successfully loaded KnockIt!");
    }

    @Override
    public void onDisable() {
    }

    public static Inventory getDefaultInventory(){
        Inventory inv = Bukkit.createInventory(null, InventoryType.PLAYER);
        ItemStack stick = new ItemStack(Material.STICK);
        stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        inv.setItem(0, stick);
        return null;
    }
}