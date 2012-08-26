package com.randude14.hungergames.commands.user;

import com.randude14.hungergames.Defaults.Commands;
import com.randude14.hungergames.GameManager;
import com.randude14.hungergames.commands.Command;
import com.randude14.hungergames.utils.ChatUtils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuitCommand extends Command {

	public QuitCommand() {
		super(Commands.USER_QUIT, "quit", USER_COMMAND);
	}

	@Override
	public boolean handle(CommandSender cs, String cmd, String[] args) {
		Player player = (Player) cs;

		game = GameManager.INSTANCE.getSession(player);
		if (game == null) {
			ChatUtils.error(player, "You are currently not in a game.");
			return true;
		}

		game.quit(player, true);
		return true;
	}

	@Override
	public String getInfo() {
		return "quit the current game indefinitely";
	}

	@Override
	public String getUsage() {
		return "/%s quit";
	}
    
}
