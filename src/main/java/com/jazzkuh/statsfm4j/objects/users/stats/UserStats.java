package com.jazzkuh.statsfm4j.objects.users.stats;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.abstraction.AbstractJsonResult;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class UserStats extends AbstractJsonResult {
    private final @Getter Long durationMs;
    private final @Getter Long count;
    private final @Getter Percentiles playedMs;
    private final @Getter Long playedMsCount;
    private final @Getter Long playedMsMin;
    private final @Getter Long playedMsMax;
    private final @Getter Double playedMsAvg;
    private final @Getter Long playedMsSum;
    private final @Getter Cardinality cardinality;

    public UserStats(JsonObject json) {
        super(json);

        this.durationMs = json.get("durationMs").getAsLong();
        this.count = json.get("count").getAsLong();
        this.playedMs = new Percentiles(json.get("playedMs").getAsJsonObject().get("percentiles").getAsJsonObject());
        this.playedMsCount = json.get("playedMs").getAsJsonObject().get("count").getAsLong();
        this.playedMsMin = json.get("playedMs").getAsJsonObject().get("min").getAsLong();
        this.playedMsMax = json.get("playedMs").getAsJsonObject().get("max").getAsLong();
        this.playedMsAvg = json.get("playedMs").getAsJsonObject().get("avg").getAsDouble();
        this.playedMsSum = json.get("playedMs").getAsJsonObject().get("sum").getAsLong();
        this.cardinality = new Cardinality(json.get("cardinality").getAsJsonObject());
    }
}
