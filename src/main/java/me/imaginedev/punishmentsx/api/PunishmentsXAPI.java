package me.imaginedev.punishmentsx.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.imaginedev.punishmentsx.config.Messages;
import me.imaginedev.punishmentsx.sql.SQLManager;

/**
 * API singleton for PunishmentsXAPI.
 */
@Getter
@RequiredArgsConstructor
public class PunishmentsXAPI {
    private final Messages messages;
    private final SQLManager manager;

    private @Getter static PunishmentsXAPI instance;

    {
        instance = this;
    }
}