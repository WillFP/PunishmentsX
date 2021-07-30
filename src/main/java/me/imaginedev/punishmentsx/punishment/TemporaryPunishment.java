package me.imaginedev.punishmentsx.punishment;

import java.time.Instant;

public abstract class TemporaryPunishment extends Punishment {
    private final Instant date;

    public TemporaryPunishment(String enforcer, Instant until) {
        super(enforcer);
        this.date = until;
    }

    public boolean isActive() {
        return date == null || Instant.now().isBefore(date);
    }
}