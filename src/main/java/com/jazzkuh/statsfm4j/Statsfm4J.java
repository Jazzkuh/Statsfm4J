package com.jazzkuh.statsfm4j;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
    public @Getter @Setter String baseUrl = "https://stats.fm/api/v1";

    public UserPublic getUserPublic(String userId) {
        String url = baseUrl + "/user/" + userId;
        JsonObject json = this.getJsonObject(url, "GET");
        return new UserPublic(json);
    }

    private JsonObject getJsonObject(String url, String method) {
        try {
            HttpURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(5000);
            connection.setRequestMethod(method);
            connection.connect();

            return new JsonParser().parse(new InputStreamReader((InputStream) connection.getContent()))
                    .getAsJsonObject();
        } catch (IOException ignored) {
        }

        return null;
    }
}
