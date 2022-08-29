package com.jazzkuh.statsfm4j;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonUtils {
    public static JsonObject getJsonObject(String url) {
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
}
