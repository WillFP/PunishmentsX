package me.imaginedev.punishmentsx.punishment;

import lombok.Getter;
import me.imaginedev.galaxylib.util.MessageUtil;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import me.imaginedev.punishmentsx.api.PunishmentsXAPI;
import org.bukkit.BanList;
import org.bukkit.Bukkit;

import java.time.Instant;
import java.util.Date;
import java.util.stream.Collectors;

public class BanPunishment extends TemporaryPunishment {
    private @Getter final String banList = PunishmentsXAPI.getInstance().getMessages().getBannedMessage().stream()
            .map(MessageUtil::color)
            .collect(Collectors.joining(System.lineSeparator()));

    private final BanList.Type type;
    private final String enforcer;
    private final Instant expires;

    public BanPunishment(@Nullable Instant expires, String enforcer) {
        this(BanList.Type.NAME, expires, enforcer);
    }

    public BanPunishment(BanList.Type type, @Nullable Instant expires, String enforcer) {
        super(enforcer, expires);

        this.type = type;
        this.expires = expires;
        this.enforcer = enforcer;
    }

    @Override
    public PunishmentType getType() {
        return PunishmentType.BAN;
    }

    @Override
    public void applyPunishment(Player player, String reason) {
        Bukkit.getBanList(type).addBan(
            player.getName(), reason, expires == null ? null : Date.from(expires), enforcer
        );
    }
}