package me.imaginedev.punishmentsx.command;

import me.imaginedev.punishmentsx.config.Messages;
import me.imaginedev.punishmentsx.punishment.MutePunishment;
import me.imaginedev.punishmentsx.sql.SQLManager;
import org.bukkit.entity.Player;

import java.time.Instant;

public class MuteCommand extends PunishmentCommand {
    private final SQLManager manager;

    public MuteCommand(Messages messages, SQLManager manager) {
        super(messages);
        this.manager = manager;
    }

    @Override
    public String getPermission() {
        return "permissionsx.mute";
    }

    @Override
    public void punishPlayer(String sender, Player player, String reason, Instant until) {
        MutePunishment punishment = new MutePunishment(sender, until);
        punishment.applyPunishment(player, reason);

        manager.addPunishment(player, punishment);
    }
}