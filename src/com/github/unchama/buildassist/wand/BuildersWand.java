package com.github.unchama.buildassist.wand;

import com.github.unchama.buildassist.BuildAssist;
import com.github.unchama.buildassist.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


/**
 * @author karayuu
 */
public class BuildersWand {
    private ItemStack wand = Config.getWand();

    @EventHandler
    public void spoit(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        
        if (event.getAction() != Action.LEFT_CLICK_AIR || event.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }

        if (!event.getItem().equals(wand)) {
            return;
        }
        
        Material spoit_material = event.getClickedBlock().getType();

        BuildAssist.playermap.get(player.getUniqueId()).spoit_Material = spoit_material;
        player.sendMessage(ChatColor.AQUA + "[ビルダーズワンド] " + ChatColor.YELLOW + spoit_material.name() + "を選択しました.");
    }

    private Inventory spoitMenu(Player player) {
        /*PlayerData data = BuildAssist.playermap.get(player.getUniqueId());*/
        Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER,
                ChatColor.YELLOW + "設置したいブロックを入れてください");

        /* 空白用ステンドガラスのItemStack */
        ItemStack blank = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta meta = Bukkit.getItemFactory().getItemMeta(Material.STAINED_GLASS_PANE);
        meta.setDisplayName("");
        
        inv.setItem(0, blank);
        inv.setItem(1, blank);
        inv.setItem(3, blank);
        inv.setItem(4, blank);
        
        return inv;
    }
}
