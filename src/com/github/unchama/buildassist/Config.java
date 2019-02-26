package com.github.unchama.buildassist;

import org.bukkit.configuration.file.FileConfiguration;

import com.github.unchama.seichiassist.util.Util;
import org.bukkit.inventory.ItemStack;

public class Config{
	private static FileConfiguration config;
	private BuildAssist plugin;

	//コンストラクタ
	Config(BuildAssist _plugin){
		plugin = _plugin;
		saveDefaultConfig();
	}

	//コンフィグのロード
	public void loadConfig(){
		config = getConfig();
	}

	//コンフィグのリロード
	public void reloadConfig(){
		plugin.reloadConfig();
		config = getConfig();
	}

	//コンフィグのセーブ
	public void saveConfig(){
		plugin.saveConfig();
	}

	//plugin.ymlがない時にDefaultのファイルを生成
	public void saveDefaultConfig(){
		plugin.saveDefaultConfig();
	}

	//plugin.ymlファイルからの読み込み
	public FileConfiguration getConfig(){
		return plugin.getConfig();
	}


	public int getFlyExp() {
		return Util.toInt(config.getString("flyexp"));
	}
/*
	public String getURL(){
		String url = "jdbc:mysql://";
		url += config.getString("host");
		if(!config.getString("port").isEmpty()){
			url += ":" + config.getString("port");
		}
		return url;
	}

	public String getLvMessage(int i) {
		return config.getString("lv" + i + "message","");
	}
*/

//ブロックを並べるスキル開放LV
	public int getblocklineuplevel() {
		return Util.toInt(config.getString("blocklineup.level"));
	}
//ブロックを並べるスキルのマナ消費倍率
	public double getblocklineupmana_mag() {
		return Util.toDouble(config.getString("blocklineup.mana_mag"));
	}
//ブロックを並べるスキルマインスタック優先開放LV
	public int getblocklineupMinestacklevel() {
		return Util.toInt(config.getString("blocklineup.minestack_level"));
	}

	public int getZoneSetSkillLevel(){
		return Util.toInt(config.getString("ZoneSetSkill.level"));
	}

//スキルを使って並べた時のブロックカウント倍率
	public double getBlockCountMag(){
		return Util.toDouble(config.getString("BlockCountMag"));
	}
	
	//MineStackブロック一括クラフト開放LV
	public int getMinestackBlockCraftlevel(int lv) {
		return Util.toInt(config.getString("minestack_BlockCraft.level" + lv ));
	}
	
	//ブロック設置カウントの1分上限
	public int getBuildNum1minLimit() {
		return Util.toInt(config.getString("BuildNum1minLimit" ));
	}
	
	//ブロック範囲設置スキルのマインスタック優先解放レベル
	public int getZoneskillMinestacklevel(){
		return Util.toInt(config.getString("ZoneSetSkill.minestack"));
	}

    /**
     * ワンドとして使用するアイテムを取得します.
     */
	public static ItemStack getWand() {
	    return config.getItemStack("Wand.itemstack");
    }

    /**
     * ワンドとして使用するアイテムを書き込みます.
     */
    public static void setWand(ItemStack wand) {
        config.set("Wand.itemstack", wand);
    }

}