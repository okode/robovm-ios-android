package com.okode.demo.common;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGetHC4;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class Common {

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static String getValueFromJson(String json, String key) {
        String value = "null";
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map values = mapper.readValue(json, Map.class);
            if (values.containsKey(key)) {
                value = values.get(key).toString();
            }
        } catch (IOException e) {
            System.out.println("Could not parse json: " + json);
        }
        return value;
    }

    public static String getValueFromURL(String url, String key) {
        String json = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGetHC4 httpGet = new HttpGetHC4("http://targethost/homepage");
        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);
            InputStream in = response.getEntity().getContent();
            InputStreamReader is = new InputStreamReader(in);
            StringBuilder sb=new StringBuilder();
            BufferedReader br = new BufferedReader(is);
            String read = br.readLine();
            while(read != null) {
                sb.append(read);
                read =br.readLine();
            }
            json = sb.toString();
        } catch (IOException e) {
            System.out.println("Could not get content from URL '" + url + "': " + e.getMessage());
        }
        return getValueFromJson(json, key);
    }
}
