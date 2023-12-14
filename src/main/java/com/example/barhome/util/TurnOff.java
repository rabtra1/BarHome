package com.example.barhome.util;



import com.example.barhome.controllers.ListOfDevicesController;
import com.example.barhome.database.OutputInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class TurnOff {
    public static String api;
    public static void off(String URLOff) {
        StringBuilder stringBuilder = new StringBuilder();
        OutputStreamWriter outputStreamWriter = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            api = String.format("Bearer %s", OutputInfo.getApiToken(ListOfDevicesController.getLogin()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            URL url = new URL(URLOff);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.addRequestProperty("Authorization", api);
            httpURLConnection.connect();

            try {
                outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
                outputStreamWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()) {
                inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                for (;(line = bufferedReader.readLine()) != null;) {
                    stringBuilder.append(line);
                }
            }
            System.out.println(stringBuilder);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.close();
                inputStreamReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
