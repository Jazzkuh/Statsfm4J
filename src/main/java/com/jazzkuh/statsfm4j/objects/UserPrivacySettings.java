package com.jazzkuh.statsfm4j.objects;

import com.google.gson.JsonObject;
import lombok.Getter;

public class UserPrivacySettings {
    private final @Getter JsonObject json;

    private final @Getter boolean profile;
    private final @Getter boolean currentlyPlaying;
    private final @Getter boolean recentlyPlayed;
    private final @Getter boolean topTracks;
    private final @Getter boolean topArtists;
    private final @Getter boolean topAlbums;
    private final @Getter boolean topGenres;
    private final @Getter boolean streams;
    private final @Getter boolean streamStats;
    private final @Getter boolean leaderboards;

    public UserPrivacySettings(JsonObject json) {
        this.json = json;
        this.profile = json.get("profile").getAsBoolean();
        this.currentlyPlaying = json.get("currentlyPlaying").getAsBoolean();
        this.recentlyPlayed = json.get("recentlyPlayed").getAsBoolean();
        this.topTracks = json.get("topTracks").getAsBoolean();
        this.topArtists = json.get("topArtists").getAsBoolean();
        this.topAlbums = json.get("topAlbums").getAsBoolean();
        this.topGenres = json.get("topGenres").getAsBoolean();
        this.streams = json.get("streams").getAsBoolean();
        this.streamStats = json.get("streamStats").getAsBoolean();
        this.leaderboards = json.get("leaderboards").getAsBoolean();
    }

    public String toString() {
        return json.toString();
    }
}
