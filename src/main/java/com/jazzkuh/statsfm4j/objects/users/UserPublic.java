package com.jazzkuh.statsfm4j.objects.users;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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
    private final @Getter UserPrivacySettings privacySettings;
    private final @Getter UserProfile profile;
    private final @Getter List<UserSocialMediaConnection> socialMediaConnections;

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
        this.privacySettings = new UserPrivacySettings(json.get("privacySettings").getAsJsonObject());
        this.profile = new UserProfile(json.get("profile").getAsJsonObject());

        List<UserSocialMediaConnection> connectionList = new ArrayList<>();
        JsonArray mediaConnections = json.get("socialMediaConnections").getAsJsonArray();
        for (int i = 0; i < mediaConnections.getAsJsonArray().size(); i++) {
            connectionList.add(new UserSocialMediaConnection(mediaConnections.get(i).getAsJsonObject()));
        }
        this.socialMediaConnections = connectionList;
    }

    public String toString() {
        return json.toString();
    }
}
