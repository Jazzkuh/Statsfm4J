package com.jazzkuh.statsfm4j.objects.users;

import com.google.gson.JsonObject;
import lombok.Getter;

public class UserSocialMediaPlatform {
    private final @Getter JsonObject json;

    private final @Getter String name;
    private final @Getter String icon;

    public UserSocialMediaPlatform(JsonObject json) {
        this.json = json;
        this.name = json.get("name").getAsString();
        this.icon = json.get("icon").getAsString();
    }

    public String toString() {
        return json.toString();
    }
}
