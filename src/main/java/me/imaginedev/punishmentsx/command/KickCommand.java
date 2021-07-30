package me.imaginedev.punishmentsx.command;

import me.imaginedev.punishmentsx.config.Messages;
import me.imaginedev.punishmentsx.punishment.KickPunishment;
import org.bukkit.entity.Player;

import java.time.Instant;

public class KickCommand extends PunishmentCommand {
    public KickCommand(Messages messages) {
        super(messages);
    }

    @Override
    public String getPermission() {
        return "punishmentsx.kick";
    }

    @Override
    public void punishPlayer(String sender, Player player, String reason, Instant until) {
        KickPunishment kickPunishment = new KickPunishment(sender);
        kickPunishment.applyPunishment(player, reason);
    }
}