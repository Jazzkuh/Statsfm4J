package com.jazzkuh.statsfm4j;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.jazzkuh.statsfm4j.objects.UserPublic;
import lombok.Getter;
import lombok.Setter;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Statsfm4J {
    public static @Getter @Setter String baseUrl = "https://api.stats.fm/api/v1";

    public static UserPublic getUserPublic(String userId) {
        String url = baseUrl + "/users/" + userId;
        JsonObject json = getJsonObject(url);
        if (json == null) return null;
        System.out.println(json);
        return new UserPublic(json.getAsJsonObject("item"));
    }

    private static JsonObject getJsonObject(String url) {
        try {
            HttpURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();

            return new JsonParser().parse(new InputStreamReader((InputStream) connection.getContent()))
                    .getAsJsonObject();
        } catch (IOException ignored) {
        }

        return null;
    }

    public static void main(String[] args) {
        UserPublic userPublic = getUserPublic("jazzkuh");
        if (userPublic == null) {
            System.out.println("User not found");
            return;
        }
        System.out.println(userPublic.toString());
    }
}
