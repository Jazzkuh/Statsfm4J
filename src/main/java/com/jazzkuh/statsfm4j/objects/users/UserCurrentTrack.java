package com.jazzkuh.statsfm4j.objects.users;

import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.Statsfm4J;
import com.jazzkuh.statsfm4j.abstraction.AbstractJsonResult;
import com.jazzkuh.statsfm4j.objects.tracks.Track;
import lombok.Getter;

public class UserCurrentTrack extends AbstractJsonResult {
    private final @Getter String date;
    private final @Getter Boolean isPlaying;
    private final @Getter Long progressMs;
    private final @Getter String deviceName;
    private final @Getter Track track;

    public UserCurrentTrack(JsonObject json) {
        super(json);
        this.date = getString("date");
        this.isPlaying = json.get("isPlaying").getAsBoolean();
        this.progressMs = json.get("progressMs").getAsLong();
        this.deviceName = json.get("deviceName").getAsString();
        this.track = Statsfm4J.getTrack(json.get("track").getAsJsonObject().get("id").getAsString());
    }
}
