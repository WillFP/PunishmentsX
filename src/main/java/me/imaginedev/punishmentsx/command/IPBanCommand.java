package me.imaginedev.punishmentsx.command;

import me.imaginedev.punishmentsx.config.Messages;
import me.imaginedev.punishmentsx.punishment.IPBanPunishment;
import me.imaginedev.punishmentsx.sql.SQLManager;
import org.bukkit.entity.Player;

import java.time.Instant;

public class IPBanCommand extends PunishmentCommand {
    private final SQLManager manager;

    public IPBanCommand(Messages messages, SQLManager manager) {
        super(messages);
        this.manager = manager;
    }

    @Override
    public String getPermission() {
        return "punishmentsx.ipban";
    }

    @Override
    public void punishPlayer(String sender, Player player, String reason, Instant until) {
        IPBanPunishment punishment = new IPBanPunishment(until, sender);
        punishment.applyPunishment(player, reason);

        manager.addPunishment(player, punishment);
    }
}