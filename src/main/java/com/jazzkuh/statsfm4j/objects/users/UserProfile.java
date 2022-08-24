package com.jazzkuh.statsfm4j.objects.users;

import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.abstraction.AbstractJsonResult;
import lombok.Getter;

public class UserProfile extends AbstractJsonResult {
    private final @Getter String bio;
    private final @Getter String pronouns;

    public UserProfile(JsonObject json) {
        super(json);
        this.bio = getString("bio");
        this.pronouns = getString("pronouns");
    }
}
