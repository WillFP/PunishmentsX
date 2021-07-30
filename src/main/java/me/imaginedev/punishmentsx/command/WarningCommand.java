package me.imaginedev.punishmentsx.command;

import me.imaginedev.punishmentsx.config.Messages;
import me.imaginedev.punishmentsx.punishment.WarningPunishment;
import me.imaginedev.punishmentsx.sql.SQLManager;
import org.bukkit.entity.Player;

import java.time.Instant;

public class WarningCommand extends PunishmentCommand {
    private final SQLManager manager;

    public WarningCommand(Messages messages, SQLManager manager) {
        super(messages);
        this.manager = manager;
    }

    @Override
    public String getPermission() {
        return "permissionsx.warn";
    }

    @Override
    public void punishPlayer(String sender, Player player, String reason, Instant until) {
        WarningPunishment punishment = new WarningPunishment(sender);
        punishment.applyPunishment(player, reason);

        manager.addPunishment(player, punishment);
    }
}