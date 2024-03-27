package com.gmail.nextinngames.ping;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class PingClass extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("ping").setExecutor(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ping")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can use this command.");
                return true;
            }

            Player player = (Player) sender;
            int ping = getPing(player);
            player.sendMessage("Your ping: " + ping + "ms");
            return true;
        }
        return false;
    }

    public int getPing(Player player) {
        return player.getPing();
    }
}
