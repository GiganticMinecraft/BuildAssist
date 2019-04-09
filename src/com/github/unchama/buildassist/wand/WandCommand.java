package com.github.unchama.buildassist.wand;

import com.github.unchama.buildassist.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

import java.util.*;

/**
 * Created by karayuu on 2019/02/26
 */
public class WandCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "このコマンドはプレイヤーから送信してください.");
            return false;
        }

        Player p = (Player) sender;

        if (strings.length != 1) {
            p.sendMessage("存在しないコマンドです.");
            return false;
        }

        switch (strings[0]) {
            case "set": {
                if (!p.isOp()) {
                    p.sendMessage(ChatColor.RED + "このコマンドは権限者のみが利用できます.");
                    return false;
                }
                ItemStack wand = p.getInventory().getItemInMainHand();
                BuildersWand.wand = wand;
                Config.setWand(wand);

                p.sendMessage(ChatColor.GREEN + "ビルダースワンドを設定しました.");
                break;
            }

            case "help": {
                p.sendMessage(ChatColor.AQUA + "[ビルダーズワンド] コマンド使用方法");
                if (p.isOp()) {
                    p.sendMessage(ChatColor.AQUA + "/wand set  手に持っているアイテムをビルダースワンドとして登録します.");
                    p.sendMessage(ChatColor.RED + "(権限者のみが実行可能です.)");
                }
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if (!command.getName().equalsIgnoreCase("wand")) {
            return null;
        }

        if (args.length == 0) {
            return Arrays.asList("set", "help");
        }

        return null;
    }
}
