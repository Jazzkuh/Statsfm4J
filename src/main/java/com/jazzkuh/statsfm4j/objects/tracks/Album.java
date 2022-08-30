package com.jazzkuh.statsfm4j.objects.tracks;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.Statsfm4J;
import com.jazzkuh.statsfm4j.abstraction.AbstractJsonResult;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Album extends AbstractJsonResult {
    private final @Getter String name;
    private final @Getter String image;
    private final @Getter String label;
    private final @Getter Long spotifyPopularity;
    private final @Getter Long totalTracks;
    private final @Getter Long releaseDate;
    private final @Getter List<String> genres;
    private final @Getter List<Artist> artists;
    private final @Getter Long id;
    private final @Getter String type;
    private final @Getter List<String> spotifyIds;

    public Album(JsonObject json) {
        super(json);
        this.name = getString("name");
        this.image = getString("image");
        this.label = getString("label");
        this.spotifyPopularity = json.get("spotifyPopularity").getAsLong();
        this.totalTracks = json.get("totalTracks").getAsLong();
        this.releaseDate = json.get("releaseDate").getAsLong();

        List<String> rawGenres = new ArrayList<>();
        JsonArray genreArray = json.get("genres").getAsJsonArray();
        for (int i = 0; i < genreArray.size(); i++) {
            rawGenres.add(genreArray.get(i).getAsString());
        }
        this.genres = rawGenres;

        List<Artist> rawArtists = new ArrayList<>();
        JsonArray artistArray = json.get("artists").getAsJsonArray();
        for (int i = 0; i < artistArray.size(); i++) {
            Long artistId = artistArray.get(i).getAsJsonObject().get("id").getAsLong();
            Artist artist = Statsfm4J.getArtist(String.valueOf(artistId));
            rawArtists.add(artist);
        }
        this.artists = rawArtists;
        this.id = json.get("id").getAsLong();
        this.type = getString("type");

        List<String> rawSpotifyIds = new ArrayList<>();
        JsonArray spotifyIdArray = json.get("externalIds").getAsJsonObject().get("spotify").getAsJsonArray();
        for (int i = 0; i < spotifyIdArray.size(); i++) {
            rawSpotifyIds.add(spotifyIdArray.get(i).getAsString());
        }
        this.spotifyIds = rawSpotifyIds;
    }
}
