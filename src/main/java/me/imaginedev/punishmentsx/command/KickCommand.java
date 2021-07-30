package me.imaginedev.punishmentsx.command;

import me.imaginedev.punishmentsx.config.Messages;
import me.imaginedev.punishmentsx.punishment.KickPunishment;
import me.imaginedev.punishmentsx.punishment.Punishment;
import me.imaginedev.punishmentsx.sql.SQLManager;
import org.bukkit.entity.Player;

public class KickCommand extends PunishmentCommand {
    private final SQLManager manager;

    public KickCommand(Messages messages, SQLManager manager) {
        super(messages);
        this.manager = manager;
    }

    @Override
    public String getPermission() {
        return "punishmentsx.kick";
    }

    @Override
    public void punishPlayer(String sender, Player player, String reason) {
        Punishment punishment = manager.addOrGet(player, new KickPunishment(sender));
        punishment.applyPunishment(player, reason);
    }
}