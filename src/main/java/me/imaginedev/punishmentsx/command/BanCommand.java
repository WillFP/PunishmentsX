package me.imaginedev.punishmentsx.command;

import me.imaginedev.punishmentsx.config.Messages;
import me.imaginedev.punishmentsx.punishment.BanPunishment;
import me.imaginedev.punishmentsx.sql.SQLManager;
import org.bukkit.entity.Player;

import java.time.Instant;

public class BanCommand extends PunishmentCommand {
    private final SQLManager manager;

    public BanCommand(Messages messages, SQLManager manager) {
        super(messages);
        this.manager = manager;
    }

    @Override
    public String getPermission() {
        return "punishmentsx.ban";
    }

    @Override
    public void punishPlayer(String sender, Player player, String reason, Instant until) {
        BanPunishment punishment = new BanPunishment(until, sender);
        punishment.applyPunishment(player, reason);

        manager.addPunishment(player, punishment);
    }
}