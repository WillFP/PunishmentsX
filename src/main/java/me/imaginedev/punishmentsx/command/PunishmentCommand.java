package me.imaginedev.punishmentsx.command;

import lombok.RequiredArgsConstructor;
import me.imaginedev.galaxyapi.util.MessageUtil;
import me.imaginedev.punishmentsx.config.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public abstract class PunishmentCommand implements CommandExecutor {
    public abstract void punishPlayer(String sender, Player player, String reason);
    public abstract String getPermission();

    private final Messages messages;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(MessageUtil.color(messages.getNoPermission()));
        }

        if (args.length < 2) {
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(MessageUtil.color(messages.getNotAPlayer()));
            return true;
        }

        punishPlayer(sender.getName(), target, args[1]);
        return true;
    }
}