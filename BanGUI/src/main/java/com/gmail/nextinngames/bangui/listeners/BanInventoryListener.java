package com.gmail.nextinngames.bangui.listeners;

import com.gmail.nextinngames.bangui.utils.BanMenuUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BanInventoryListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Player List")){

            if(e.getCurrentItem().getType() == Material.PLAYER_HEAD){

                Player whoToBan = p.getServer().getPlayerExact(ChatColor.stripColor (e.getCurrentItem().getItemMeta().getDisplayName()));

               BanMenuUtils.openConfirmBanMenu(p, whoToBan);
            }else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Ban this Player")){

                if (e.getCurrentItem().getType() == Material.BARRIER){
                    BanMenuUtils.openBanMenu(p);
                } else if (e.getCurrentItem().getType() == Material.WOODEN_AXE){
                    String name = ChatColor.stripColor (e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                    p.getServer().getBanList(BanList.Type.NAME).addBan(name, " ",  null, null);
                    p.sendMessage(ChatColor.GREEN + "Banned Player.");
                }
            }

            e.setCancelled(true);
        }
    }
}
