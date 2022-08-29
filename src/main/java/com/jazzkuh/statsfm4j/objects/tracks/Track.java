package com.jazzkuh.statsfm4j.objects.tracks;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.Statsfm4J;
import com.jazzkuh.statsfm4j.abstraction.AbstractJsonResult;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Track extends AbstractJsonResult {
    private final @Getter String name;
    private final @Getter Boolean explicit;
    private final @Getter Long durationMs;
    private final @Getter Long spotifyPopularity;
    private final @Getter List<Album> albums;
    private final @Getter List<Artist> artists;
    private final @Getter Long id;
    private final @Getter List<String> spotifyIds;

    public Track(JsonObject json) {
        super(json);
        this.name = getString("name");
        this.explicit = json.get("explicit").getAsBoolean();
        this.durationMs = json.get("durationMs").getAsLong();
        this.spotifyPopularity = json.get("spotifyPopularity").getAsLong();
        List<Album> rawAlbums = new ArrayList<>();
        JsonArray albumArray = json.get("albums").getAsJsonArray();
        for (int i = 0; i < albumArray.size(); i++) {
            Long albumId = albumArray.get(i).getAsJsonObject().get("id").getAsLong();
            Album album = Statsfm4J.getAlbum(String.valueOf(albumId));
            rawAlbums.add(album);
        }
        this.albums = rawAlbums;

        List<Artist> rawArtists = new ArrayList<>();
        JsonArray artistArray = json.get("artists").getAsJsonArray();
        for (int i = 0; i < artistArray.size(); i++) {
            Long artistId = artistArray.get(i).getAsJsonObject().get("id").getAsLong();
            Artist artist = Statsfm4J.getArtist(String.valueOf(artistId));
            rawArtists.add(artist);
        }
        this.artists = rawArtists;
        this.id = json.get("id").getAsLong();

        List<String> rawSpotifyIds = new ArrayList<>();
        JsonArray spotifyIdArray = json.get("externalIds").getAsJsonObject().get("spotify").getAsJsonArray();
        for (int i = 0; i < spotifyIdArray.size(); i++) {
            rawSpotifyIds.add(spotifyIdArray.get(i).getAsString());
        }
        this.spotifyIds = rawSpotifyIds;
    }
}
