package com.jazzkuh.statsfm4j;

import com.google.gson.JsonObject;
import com.jazzkuh.statsfm4j.objects.exception.ForbiddenResourceException;
import com.jazzkuh.statsfm4j.objects.tracks.Album;
import com.jazzkuh.statsfm4j.objects.tracks.Artist;
import com.jazzkuh.statsfm4j.objects.tracks.Track;
import com.jazzkuh.statsfm4j.objects.users.UserCurrentTrack;
import com.jazzkuh.statsfm4j.objects.users.PublicUser;
import com.jazzkuh.statsfm4j.objects.users.stats.UserStats;
import com.jazzkuh.statsfm4j.objects.users.stats.UserStreams;
import lombok.Getter;
import lombok.Setter;

public class Statsfm4J {
    public static @Getter @Setter String baseUrl = "https://api.stats.fm/api/v1";

    public static PublicUser getPublicUser(String userId) {
        String url = baseUrl + "/users/" + userId;
        JsonObject json = JsonUtils.getJsonObject(url);
        if (json == null) return null;
        return new PublicUser(json.getAsJsonObject("item"));
    }

    public static UserStreams getUserStreams(String userId) {
        String url = baseUrl + "/users/" + userId + "/streams";
        JsonObject json = JsonUtils.getJsonObject(url);
        if (json == null) return null;
        return new UserStreams(json);
    }

    public static UserStats getUserStats(String userId) {
        String url = baseUrl + "/users/" + userId + "/streams/stats";
        JsonObject json = JsonUtils.getJsonObject(url);
        if (json == null) return null;
        return new UserStats(json.getAsJsonObject("items"));
    }

    public static UserCurrentTrack getUserCurrentTrack(String userId) throws ForbiddenResourceException {
        String url = baseUrl + "/users/" + userId + "/streams/current";
        JsonObject json = JsonUtils.getJsonObject(url);
        if (json == null) return null;
        if (json.get("item") == null) throw new ForbiddenResourceException();
        return new UserCurrentTrack(json.getAsJsonObject("item"));
    }

    public static Artist getArtist(String artistId) {
        String url = baseUrl + "/artists/" + artistId;
        JsonObject json = JsonUtils.getJsonObject(url);
        if (json == null) return null;
        return new Artist(json.getAsJsonObject("item"));
    }

    public static Album getAlbum(String albumId) {
        String url = baseUrl + "/albums/" + albumId;
        JsonObject json = JsonUtils.getJsonObject(url);
        if (json == null) return null;
        return new Album(json.getAsJsonObject("item"));
    }

    public static Track getTrack(String trackId) {
        String url = baseUrl + "/tracks/" + trackId;
        JsonObject json = JsonUtils.getJsonObject(url);
        if (json == null) return null;
        return new Track(json.getAsJsonObject("item"));
    }

    public static void main(String[] args) {
        PublicUser publicUser = getPublicUser("jazzkuh");
        if (publicUser == null) {
            System.out.println("User not found");
            return;
        }
        System.out.println(getUserStats("wouter"));
        System.out.println(getTrack("10899778"));
        System.out.println(publicUser.getCurrentTrack());
    }
}
