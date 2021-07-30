package me.imaginedev.punishmentsx.command;

import lombok.RequiredArgsConstructor;
import me.imaginedev.galaxylib.util.MessageUtil;
import me.imaginedev.punishmentsx.config.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;

@RequiredArgsConstructor
public abstract class PunishmentCommand implements CommandExecutor {
    public abstract void punishPlayer(String sender, Player player, String reason, Instant until);
    public abstract String getPermission();

    private final Messages messages;

    @RequiredArgsConstructor
    private enum DateTime {
        MIN(60),
        DAY(86400),
        MONTH(2592000);

        private final int duration;

        public static DateTime of(String msg) {
            String upperCase = msg.toUpperCase();

            for (DateTime time : values()) {
                String name = time.name();

                if (name.equals(upperCase) || (name + 's').equals(upperCase)) {
                    return time;
                }
            }
            return null;
        }
    }

    private Instant getInstant(String[] args) {
        if (args.length == 4) {
            try {
                DateTime dt = DateTime.of(args[3]);
                if (dt == null) return null;

                int type = dt.duration;
                return Instant.now().plusSeconds((long) Integer.parseInt(args[2]) * type);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(MessageUtil.color(messages.getNoPermission()));
        }

        if (args.length < 2 || args.length == 3) {
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage(MessageUtil.color(messages.getNotAPlayer()));
            return true;
        }

        Instant until = null;

        if (args.length == 4) {
            until = getInstant(args);
            if (until == null) return false;
        }

        punishPlayer(sender.getName(), target, args[1], until);
        return true;
    }
}