package com.jazzkuh.statsfm4j.objects.users.stats;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.abstraction.AbstractJsonResult;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class UserStreams extends AbstractJsonResult {
    private final @Getter List<UserStreamObject> streams;

    public UserStreams(JsonObject json) {
        super(json);
        List<UserStreamObject> streamList = new ArrayList<>();
        JsonArray userStreams = json.get("items").getAsJsonArray();
        for (int i = 0; i < userStreams.getAsJsonArray().size(); i++) {
            streamList.add(new UserStreamObject(userStreams.get(i).getAsJsonObject()));
        }
        this.streams = streamList;
    }
}
