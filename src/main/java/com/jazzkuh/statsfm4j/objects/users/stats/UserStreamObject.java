package com.jazzkuh.statsfm4j.objects.users.stats;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.abstraction.AbstractJsonResult;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class UserStreamObject extends AbstractJsonResult {
    private final @Getter String id;
    private final @Getter String userId;
    private final @Getter String endTime;
    private final @Getter Long playedMs;
    private final @Getter Long trackId;
    private final @Getter String trackName;
    private final @Getter Long albumId;
    private final @Getter List<Long> artistIds;

    public UserStreamObject(JsonObject json) {
        super(json);
        this.id = getString("id");
        this.userId = getString("userId");
        this.endTime = getString("endTime");
        this.playedMs = json.get("playedMs").getAsLong();
        this.trackId = json.get("trackId").getAsLong();
        this.trackName = getString("trackName");
        this.albumId = json.get("albumId").getAsLong();

        List<Long> rawArtistIds = new ArrayList<>();
        JsonArray artistIdArray = json.get("artistIds").getAsJsonArray();
        for (int i = 0; i < artistIdArray.size(); i++) {
            rawArtistIds.add(artistIdArray.get(i).getAsLong());
        }
        this.artistIds = rawArtistIds;
    }
}
