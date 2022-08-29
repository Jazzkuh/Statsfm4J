package com.jazzkuh.statsfm4j.objects.tracks;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.abstraction.AbstractJsonResult;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Artist extends AbstractJsonResult {
    private final @Getter String name;
    private final @Getter Long followers;
    private final @Getter List<String> genres;
    private final @Getter Long id;
    private final @Getter String image;
    private final @Getter Long spotifyPopularity;

    public Artist(JsonObject json) {
        super(json);
        this.name = getString("name");
        this.followers = json.get("followers").getAsLong();

        List<String> rawGenres = new ArrayList<>();
        JsonArray genreArray = json.get("genres").getAsJsonArray();
        for (int i = 0; i < genreArray.size(); i++) {
            rawGenres.add(genreArray.get(i).getAsString());
        }
        this.genres = rawGenres;
        this.id = json.get("id").getAsLong();
        this.image = getString("image");
        this.spotifyPopularity = json.get("spotifyPopularity").getAsLong();
    }
}
