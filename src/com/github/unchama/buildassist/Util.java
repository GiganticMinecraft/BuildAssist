/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
package com.github.unchama.buildassist;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.github.unchama.seichiassist.SeichiAssist;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import java.math.BigDecimal;

public class Util {
	public Util() {
	}

	public static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static String getName(Player p) {
		return p.getName().toLowerCase();
	}

	public static String getName(String name) {
		return name.toLowerCase();
	}
	/*
//現在の建築量順位を表示する
public static int calcPlayerRank(Player p){
	//ランク用関数
	int i = 0;
	int t = BuildBlock.calcBuildBlock(p);
	//ランクが上がらなくなるまで処理
	while(BuildAssist.ranklist.get(i).intValue() > t){
		i++;
	}
	return i+1;
}
*/
//ワールドガードAPIを返す
public static WorldGuardPlugin getWorldGuard() {
	Plugin plugin = BuildAssist.plugin.getServer().getPluginManager().getPlugin("WorldGuard");

    // WorldGuard may not be loaded
    if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
        return null; // Maybe you want throw an exception instead
    }

    return (WorldGuardPlugin) plugin;
}

//スキルの発動可否の処理(発動可能ならtrue、発動不可ならfalse)
public static boolean isSkillEnable(Player player){
	//デバッグモード時は全ワールドでスキル使用を許可する(DEBUGWORLDNAME = worldの場合)
	String worldname = SeichiAssist.SEICHIWORLDNAME;
	if(SeichiAssist.DEBUG){
		worldname = SeichiAssist.DEBUGWORLDNAME;
	}
	//プレイヤーの場所が各種整地ワールド(world_SWで始まるワールド)または各種メインワールド(world)または各種TTワールドにいる場合
	if(player.getWorld().getName().toLowerCase().startsWith(worldname)
			|| player.getWorld().getName().equalsIgnoreCase("world")
			|| player.getWorld().getName().equalsIgnoreCase("world_nether")
			|| player.getWorld().getName().equalsIgnoreCase("world_the_end")
			|| player.getWorld().getName().equalsIgnoreCase("world_TT")
			|| player.getWorld().getName().equalsIgnoreCase("world_nether_TT")
			|| player.getWorld().getName().equalsIgnoreCase("world_the_end_TT")
			){
		return true;
	}
	//それ以外のワールドの場合
	return false;
}


	//設置ブロックカウント対象ワールドかを確認(対象ならtrue、対象外ならfalse)
	public static boolean isBlockCount(Player player){
		//デバッグモード時は全ワールドでスキル使用を許可する(DEBUGWORLDNAME = worldの場合)
		if(SeichiAssist.DEBUG){
			return true;
		}
		//プレイヤーの場所がメインワールド(world)または各種整地ワールド(world_SW)にいる場合
		if(player.getWorld().getName().toLowerCase().startsWith(SeichiAssist.SEICHIWORLDNAME)
			|| player.getWorld().getName().equalsIgnoreCase("world")
			|| player.getWorld().getName().equalsIgnoreCase("world_nether")
			|| player.getWorld().getName().equalsIgnoreCase("world_the_end")
		){
			return true;
		}
		//それ以外のワールドの場合
		return false;
	}

	//指定した名前のマインスタックの番号を返す		見つからなかった場合は-1
	//名前はSeichiAssist.javaのminestacklistに定義されてる英語名
	public static int MineStackobjname_indexOf(String s){
		int id = -1;
		for(int x = 0 ; x < SeichiAssist.minestacklist.size() ; x++){
			if( s.equals( SeichiAssist.minestacklist.get(x).getMineStackObjName() ) ){
				id = x;
				break;
			}
		}
		return id;
	}

	/**
	 * 1分間の設置料を指定量増加させます。
	 * ワールドによって倍率も加味されます。
	 *
	 * @param player 増加させるプレイヤー
	 * @param amount 増加量
	 */
	public static void addBuild1MinAmount(Player player, BigDecimal amount) {
		//プレイヤーデータ取得
		PlayerData playerData = BuildAssist.playermap.get(player.getUniqueId());
		//player.sendMessage("足す数:" + amount.doubleValue() + ",かけた後:" + amount.multiply(new BigDecimal("0.1")).doubleValue());
		//ワールドによって倍率変化
		if (player.getWorld().getName().toLowerCase().startsWith(SeichiAssist.SEICHIWORLDNAME)) {
			playerData.build_num_1min = playerData.build_num_1min.add(amount.multiply(new BigDecimal("0.1")));
		} else {
			playerData.build_num_1min= playerData.build_num_1min.add(amount);
		}
	}
}
