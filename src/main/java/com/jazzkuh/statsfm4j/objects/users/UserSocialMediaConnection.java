package com.jazzkuh.statsfm4j.objects.users;

import com.google.gson.JsonObject;
import lombok.Getter;

public class UserSocialMediaConnection {
    /*
    {
"id": 2229,
"verified": true,
"platformUserId": "254207576214994944",
"platformUsername": "Jazzkuh#0001",
"platformUserImage": "https://cdn.discordapp.com/avatars/254207576214994944/a_0bbb666985ee35ee0b21f2f0ae1c61fd.png",
"platform": {
"name": "Discord",
"icon": "https://cdn.stats.fm/file/statsfm/images/brands/discord/color.png"
}
}
     */
    private final @Getter JsonObject json;

    private final @Getter Integer id;
    private final @Getter boolean verified;
    private final @Getter String platformUserId;
    private final @Getter String platformUsername;
    private final @Getter String platformUserImage;
    private final @Getter UserSocialMediaPlatform platform;

    public UserSocialMediaConnection(JsonObject json) {
        this.json = json;
        this.id = json.get("id").getAsInt();
        this.verified = json.get("verified").getAsBoolean();
        this.platformUserId = json.get("platformUserId").getAsString();
        this.platformUsername = json.get("platformUsername").getAsString();
        this.platformUserImage = json.get("platformUserImage").getAsString();
        this.platform = new UserSocialMediaPlatform(json.get("platform").getAsJsonObject());
    }

    public String toString() {
        return json.toString();
    }
}
