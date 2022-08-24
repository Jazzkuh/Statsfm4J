package com.jazzkuh.statsfm4j.objects.users;

import com.google.gson.JsonObject;
import lombok.Getter;

public class UserProfile {
    private final @Getter JsonObject json;

    private final @Getter String bio;
    private final @Getter String pronouns;

    public UserProfile(JsonObject json) {
        this.json = json;
        this.bio = json.get("bio").getAsString();
        this.pronouns = json.get("pronouns").getAsString();
    }

    public String toString() {
        return json.toString();
    }
}
