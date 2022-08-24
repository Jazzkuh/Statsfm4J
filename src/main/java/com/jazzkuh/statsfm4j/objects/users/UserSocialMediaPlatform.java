package com.jazzkuh.statsfm4j.objects.users;

import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.abstraction.AbstractJsonResult;
import lombok.Getter;

public class UserSocialMediaPlatform extends AbstractJsonResult {
    private final @Getter String name;
    private final @Getter String icon;

    public UserSocialMediaPlatform(JsonObject json) {
        super(json);

        this.name = getString("name");
        this.icon = getString("icon");
    }
}
