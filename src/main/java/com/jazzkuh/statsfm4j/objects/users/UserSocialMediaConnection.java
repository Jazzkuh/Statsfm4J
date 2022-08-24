package com.jazzkuh.statsfm4j.objects.users;

import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.abstraction.AbstractJsonResult;
import lombok.Getter;

public class UserSocialMediaConnection extends AbstractJsonResult {
    private final @Getter Integer id;
    private final @Getter boolean verified;
    private final @Getter String platformUserId;
    private final @Getter String platformUsername;
    private final @Getter String platformUserImage;
    private final @Getter UserSocialMediaPlatform platform;

    public UserSocialMediaConnection(JsonObject json) {
        super(json);

        this.id = json.get("id").getAsInt();
        this.verified = json.get("verified").getAsBoolean();
        this.platformUserId = getString("platformUserId");
        this.platformUsername = getString("platformUsername");
        this.platformUserImage = getString("platformUserImage");
        this.platform = new UserSocialMediaPlatform(json.get("platform").getAsJsonObject());
    }
}
