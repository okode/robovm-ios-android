package com.okode.demo.common;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.fluent.Request;

import java.io.IOException;
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
        try {
            json = Request.Get(url).execute().returnContent().asString();
        } catch (IOException e) {
            System.out.println("Could not retrieve contents from URL: " + url);
        }
        return getValueFromJson(json, key);
    }
}
