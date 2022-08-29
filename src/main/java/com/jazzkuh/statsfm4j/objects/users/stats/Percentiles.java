package com.jazzkuh.statsfm4j.objects.users.stats;

import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.abstraction.AbstractJsonResult;
import lombok.Getter;

public class Percentiles extends AbstractJsonResult {
    private final @Getter Double percentiles1;
    private final @Getter Double percentiles5;
    private final @Getter Double percentiles25;
    private final @Getter Double percentiles50;
    private final @Getter Double percentiles75;
    private final @Getter Double percentiles95;
    private final @Getter Double percentiles99;

    public Percentiles(JsonObject json) {
        super(json);

        this.percentiles1 = json.get("values").getAsJsonObject().get("1.0").getAsDouble();
        this.percentiles5 = json.get("values").getAsJsonObject().get("5.0").getAsDouble();
        this.percentiles25 = json.get("values").getAsJsonObject().get("25.0").getAsDouble();
        this.percentiles50 = json.get("values").getAsJsonObject().get("50.0").getAsDouble();
        this.percentiles75 = json.get("values").getAsJsonObject().get("75.0").getAsDouble();
        this.percentiles95 = json.get("values").getAsJsonObject().get("95.0").getAsDouble();
        this.percentiles99 = json.get("values").getAsJsonObject().get("99.0").getAsDouble();
    }
}
