package com.github.unchama.buildassist.wand;

import com.github.unchama.buildassist.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;

/**
 * Created by karayuu on 2019/02/26
 */
public class SpoitActionListener implements Listener {
    @EventHandler
    public void spoit(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() != Action.LEFT_CLICK_AIR || event.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }

        if (!event.getItem().equals(BuildersWand.wand)) {
            return;
        }

        Material spoit_material = event.getClickedBlock().getType();

        BuildAssist.playermap.get(player.getUniqueId()).spoit_Material = spoit_material;
        player.sendMessage(ChatColor.AQUA + "[ビルダーズワンド] " + ChatColor.YELLOW + spoit_material.name() + "を選択しました.");
    }
}
