package com.bankapp;

import com.google.gson.*;
import java.io.*;
import java.util.concurrent.*;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class FetchData {

    public static Account[] GetAccountsFromJson() {

        String jsonData = FetchJsonData();
        Gson gsonData = new Gson();
        return gsonData.fromJson(jsonData, Account[].class);
    }

    private static String FetchJsonData() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> futureJson = executorService.submit(() -> FetchTask());
        String jsonData = null;

        try {
            jsonData = futureJson.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    private static String FetchTask() {
        String res = "";
        try {
            URL url = new URL(Encryption.getUrl());
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
            BufferedReader is = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = is.readLine()) != null) {
                res += line + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
