package me.imaginedev.punishmentsx.punishment;

import org.bukkit.BanList;

import java.time.Instant;

public class IPBanPunishment extends BanPunishment {
    public IPBanPunishment(Instant expires, String enforcer) {
        super(BanList.Type.IP, expires, enforcer);
    }

    @Override
    public PunishmentType getType() {
        return PunishmentType.IP_BAN;
    }
}