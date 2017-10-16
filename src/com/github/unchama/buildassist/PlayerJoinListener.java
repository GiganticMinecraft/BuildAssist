/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.github.unchama.buildassist;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
	private BuildAssist plugin = BuildAssist.plugin;
	public PlayerJoinListener() {
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onplayerJoinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		//DBからデータを読み込むのを待ってから初期化
		new LoadPlayerDataTaskRunnable(player).runTaskTimerAsynchronously(plugin, 0, 20);

	}
}
