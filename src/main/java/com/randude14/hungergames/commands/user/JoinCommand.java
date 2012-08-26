package com.randude14.hungergames.commands.user;

import com.randude14.hungergames.Config;
import com.randude14.hungergames.Defaults.Commands;
import com.randude14.hungergames.GameManager;
import com.randude14.hungergames.HungerGames;
import com.randude14.hungergames.Lang;
import com.randude14.hungergames.commands.Command;
import com.randude14.hungergames.utils.ChatUtils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinCommand extends Command {

	public JoinCommand() {
		super(Commands.USER_JOIN, "join", ADMIN_COMMAND);
	}

	@Override
	public boolean handle(CommandSender cs, String cmd, String[] args) {
		Player player = (Player) cs;

		String name = (args.length < 1) ? Config.getDefaultGame() : args[0];
		if (name == null) {
			ChatUtils.helpCommand(player, getUsage(), HungerGames.CMD_USER);
			return true;
		}

		game = GameManager.INSTANCE.getGame(name);
		if (game == null) {
			ChatUtils.error(player, Lang.getNotExist().replace("<item>", name));
			return true;
		}

		game.join(player);
		return true;
	}

	@Override
	public String getInfo() {
		return "join a game";
	}

	@Override
	public String getUsage() {
		return "/%s join [game name]";
	}
}
