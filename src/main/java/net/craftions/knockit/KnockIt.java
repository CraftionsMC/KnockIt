package net.craftions.knockit;

import net.craftions.knockit.commands.CommandSetSpawn;
import net.craftions.knockit.config.Config;
import net.craftions.knockit.events.*;
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
    protected static KnockIt instance;

    @Override
    public void onEnable() {
        instance = this;
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
        Bukkit.getPluginManager().registerEvents(new EventPlayerRespawn(), this);
        Bukkit.getPluginManager().registerEvents(new EventBlockPlace(), this);
        Bukkit.getPluginManager().registerEvents(new EventInventoryClick(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerDeath(), this);
        Bukkit.getPluginManager().registerEvents(new EventItemDrop(), this);
        // finish
        System.out.println(prefix + "Successfully loaded KnockIt!");
    }

    public static Inventory getDefaultInventory(){
        Inventory inv = Bukkit.createInventory(null, InventoryType.PLAYER);
        ItemStack stick = new ItemStack(Material.STICK);
        ItemStack blocks = new ItemStack(Material.SANDSTONE, 64);
        ItemStack sword = new ItemStack(Material.WOODEN_SWORD);
        stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
        sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
        inv.setItem(39, new ItemStack(Material.LEATHER_HELMET));
        inv.setItem(38, new ItemStack(Material.LEATHER_CHESTPLATE));
        inv.setItem(37, new ItemStack(Material.LEATHER_LEGGINGS));
        inv.setItem(36, new ItemStack(Material.LEATHER_BOOTS));
        inv.setItem(0, sword);
        inv.setItem(1, stick);
        inv.setItem(2, blocks);
        return inv;
    }

    public static KnockIt getInstance(){
        return instance;
    }
}