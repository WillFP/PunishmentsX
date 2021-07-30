package me.imaginedev.punishmentsx.punishment;

import me.imaginedev.galaxylib.util.MessageUtil;
import me.imaginedev.punishmentsx.api.PunishmentsXAPI;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.stream.Collectors;

public class KickPunishment extends Punishment {
    private final String kickMessage = PunishmentsXAPI.getInstance().getMessages().getKickedMessage().stream()
            .map(MessageUtil::color)
            .collect(Collectors.joining(System.lineSeparator()));

    public KickPunishment(String enforcer) {
        super(enforcer);
    }

    @Override
    public PunishmentType getType() {
        return PunishmentType.KICK;
    }

    @Override
    public void applyPunishment(Player player, String reason) {
        player.kickPlayer(this.kickMessage.replace("%reason%", Optional.ofNullable(reason).orElse("Unspecified")));
    }
}