package com.jazzkuh.statsfm4j.abstraction;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Getter;

public abstract class AbstractJsonResult {
    private final @Getter JsonObject json;

    public AbstractJsonResult(JsonObject json) {
        this.json = json;
    }

    public String getString(String key) {
        JsonElement element = json.get(key);
        return element.isJsonNull() ? null : element.getAsString();
    }

    public String toString() {
        return json.toString();
    }
}
