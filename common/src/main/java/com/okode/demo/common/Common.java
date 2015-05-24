package com.okode.demo.common;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Common {

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static String getValueFromJson(String json, String key) {
        String value = "null";
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> values = mapper.readValue(json, new TypeReference<Map<String, String>>() {});
            if (values.containsKey(key)) {
                value = values.get(key).toString();            	
            }
        } catch (IOException e) {
            System.out.println("Could not parse json: " + json);
        }
        return value;
    }

}
