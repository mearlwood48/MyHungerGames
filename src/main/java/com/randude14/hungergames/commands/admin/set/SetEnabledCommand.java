package com.randude14.hungergames.commands.admin.set;

import com.randude14.hungergames.Defaults.Commands;
import com.randude14.hungergames.GameManager;
import com.randude14.hungergames.HungerGames;
import com.randude14.hungergames.Lang;
import com.randude14.hungergames.commands.Command;
import com.randude14.hungergames.utils.ChatUtils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetEnabledCommand extends Command {

    public SetEnabledCommand() {
	    super(Commands.ADMIN_SET_ENABLED, Commands.ADMIN_SET_HELP.getCommand(), "enabled");
    }

    @Override
    public boolean handle(CommandSender cs, String cmd, String[] args) {
	    Player player = (Player) cs;
	    if (args.length < 1) {
		    ChatUtils.helpCommand(player, getUsage(), HungerGames.CMD_ADMIN);
		    return true;
	    }
	    game = GameManager.INSTANCE.getGame(args[0]);
	    if (game == null) {
		    ChatUtils.error(player, Lang.getNotExist().replace("<item>", args[0]));
		    return true;
	    }
	    
	    boolean flag;
	    if (args.length == 1) {
		    flag = true;
	    } else {
		    flag = Boolean.valueOf(args[1]);
	    }
	    game.setEnabled(flag);
	    if (flag) {
		    ChatUtils.send(player, "%s has been enabled.", game.getName());
	    } else {
		    ChatUtils.send(player, "%s has been disabled and stopped if it was running.", game.getName());
	    }
	    return true;
    }

	@Override
	public String getInfo() {
		return "enable or disable a game";
	}

	@Override
	public String getUsage() {
		return "/%s set enabled <game name> <true/false>";
	}
    
}
