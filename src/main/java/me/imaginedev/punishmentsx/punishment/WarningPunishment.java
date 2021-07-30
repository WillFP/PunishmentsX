package me.imaginedev.punishmentsx.punishment;

import me.imaginedev.galaxyapi.util.MessageUtil;
import me.imaginedev.punishmentsx.api.PunishmentsXAPI;
import org.bukkit.entity.Player;

public class WarningPunishment extends Punishment {
    private final String warnMessage = MessageUtil.color(PunishmentsXAPI.getInstance().getMessages().getWarnedMessage());

    @Override
    public boolean blocksJoin() {
        return false;
    }

    @Override
    public void apply(Player player, String reason) {
        player.sendMessage(warnMessage.replace("%reason%", reason));
    }
}