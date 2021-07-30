package me.imaginedev.punishmentsx.command;

import me.imaginedev.punishmentsx.config.Messages;
import me.imaginedev.punishmentsx.punishment.BanPunishment;
import me.imaginedev.punishmentsx.punishment.Punishment;
import me.imaginedev.punishmentsx.sql.SQLManager;
import org.bukkit.BanList;
import org.bukkit.entity.Player;

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
    public void punishPlayer(String sender, Player player, String reason) {
        Punishment punishment = manager.addOrGet(player, new BanPunishment(BanList.Type.NAME, sender));
        punishment.applyPunishment(player, reason);
    }
}