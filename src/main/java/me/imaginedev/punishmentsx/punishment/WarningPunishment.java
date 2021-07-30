package me.imaginedev.punishmentsx.punishment;

import me.imaginedev.galaxylib.util.MessageUtil;
import me.imaginedev.punishmentsx.api.PunishmentsXAPI;
import org.bukkit.entity.Player;

public class WarningPunishment extends Punishment {
    private final String warnMessage = MessageUtil.color(PunishmentsXAPI.getInstance().getMessages().getWarnedMessage());

    public WarningPunishment(String enforcer) {
        super(enforcer);
    }

    @Override
    public PunishmentType getType() {
        return PunishmentType.WARNING;
    }

    @Override
    public void applyPunishment(Player player, String reason) {
        player.sendMessage(warnMessage.replace("%reason%", reason));
    }
}