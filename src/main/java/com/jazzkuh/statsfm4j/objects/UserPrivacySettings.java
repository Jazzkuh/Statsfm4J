package com.jazzkuh.statsfm4j.objects;

import com.google.gson.JsonObject;
import lombok.Getter;

public class UserPublic {
    private final @Getter JsonObject json;

    private final @Getter String id;
    private final @Getter String customId;
    private final @Getter String displayName;
    private final @Getter String image;
    private final @Getter boolean isPlus;
    private final @Getter boolean hasImported;
    private final @Getter boolean syncEnabled;
    private final @Getter String orderBy;
    private @Getter JsonObject privacySettings;
    private @Getter JsonObject profile;
    private @Getter JsonObject socialMediaConnections;

    public UserPublic(JsonObject json) {
        this.json = json;
        this.id = json.get("id").getAsString();
        this.customId = json.get("customId").getAsString();
        this.displayName = json.get("displayName").getAsString();
        this.image = json.get("image").getAsString();
        this.isPlus = json.get("isPlus").getAsBoolean();
        this.hasImported = json.get("hasImported").getAsBoolean();
        this.syncEnabled = json.get("syncEnabled").getAsBoolean();
        this.orderBy = json.get("orderBy").getAsString();
    }

    public String toString() {
        return json.toString();
    }
}
