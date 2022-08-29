package com.jazzkuh.statsfm4j.objects.users.stats;

import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.abstraction.AbstractJsonResult;
import lombok.Getter;

public class Cardinality extends AbstractJsonResult {
    private final @Getter Long tracks;
    private final @Getter Long artists;
    private final @Getter Long albums;

    public Cardinality(JsonObject json) {
        super(json);

        this.tracks = json.get("tracks").getAsLong();
        this.artists = json.get("artists").getAsLong();
        this.albums = json.get("albums").getAsLong();
    }
}
