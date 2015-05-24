/**
 * Copyright 2015 Okode | www.okode.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.okode.demo.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
