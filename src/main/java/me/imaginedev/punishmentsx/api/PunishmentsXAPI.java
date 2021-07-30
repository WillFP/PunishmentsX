package me.imaginedev.punishmentsx.api;

import lombok.Getter;
import me.imaginedev.punishmentsx.config.Messages;

/**
 * API singleton for PunishmentsXAPI.
 */
@Getter
public class PunishmentsXAPI {
    private final Messages messages;

    private @Getter static PunishmentsXAPI instance;

    public PunishmentsXAPI(Messages messages) {
        this.messages = messages;
        PunishmentsXAPI.instance = this;
    }
}