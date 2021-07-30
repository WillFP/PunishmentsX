package me.imaginedev.punishmentsx.punishment;

import me.imaginedev.galaxylib.util.MessageUtil;
import me.imaginedev.punishmentsx.api.PunishmentsXAPI;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;

public class MutePunishment extends TemporaryPunishment {
    private final String muted = MessageUtil.color(PunishmentsXAPI.getInstance().getMessages().getMutedMessage());

    public MutePunishment(String enforcer, @Nullable Instant until) {
        super(enforcer, until);
    }

    @Override
    public PunishmentType getType() {
        return PunishmentType.MUTE;
    }

    @Override
    public void applyPunishment(Player player, String reason) {
        player.sendMessage(muted.replace("%reason%", reason));
    }
}