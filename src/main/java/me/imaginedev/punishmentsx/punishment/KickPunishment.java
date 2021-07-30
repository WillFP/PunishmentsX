package me.imaginedev.punishmentsx.punishment;

import me.imaginedev.galaxyapi.util.MessageUtil;
import me.imaginedev.punishmentsx.api.PunishmentsXAPI;
import org.bukkit.entity.Player;

import java.util.stream.Collectors;

public class KickPunishment extends Punishment {
    private final String kickMessage = PunishmentsXAPI.getInstance().getMessages().getKickedMessage().stream()
            .map(MessageUtil::color)
            .collect(Collectors.joining(System.lineSeparator()));

    public KickPunishment(String enforcer) {
        super(enforcer);
    }

    @Override
    public String getDefaultReason() {
        return "";
    }

    @Override
    public boolean blocksJoin() {
        return false;
    }

    @Override
    protected void apply(Player player, String reason) {
        player.kickPlayer(this.kickMessage.replace("%reason%", reason));
    }
}