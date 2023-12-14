package com.example.barhome.util;

import com.example.barhome.controllers.ListOfDevicesController;
import com.example.barhome.database.OutputInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class TurnOn {
    public static String api;
    public static void on(String URLOn) {
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
            URL url = new URL(URLOn);
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
                assert outputStreamWriter != null;
                outputStreamWriter.close();
                assert inputStreamReader != null;
                inputStreamReader.close();
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}