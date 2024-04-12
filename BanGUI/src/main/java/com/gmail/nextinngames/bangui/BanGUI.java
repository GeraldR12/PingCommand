package com.gmail.nextinngames.bangui;

import com.gmail.nextinngames.bangui.commands.BanGUICommand;
import com.gmail.nextinngames.bangui.listeners.BanInventoryListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BanGUI extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("bangui").setExecutor(new BanGUICommand());

        getServer().getPluginManager().registerEvents(new BanInventoryListener(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
