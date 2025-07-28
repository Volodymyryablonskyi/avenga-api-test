package com.avenga.yablonskyi.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

    private final ObjectMapper mapper = new ObjectMapper();

    public JsonNode getField(String jsonBody, String fieldPath) {
        try {
            JsonNode root = mapper.readTree(jsonBody);
            String[] parts = fieldPath.split("\\.");
            for (String part : parts) {
                if (root == null) return null;
                root = root.get(part);
            }
            return root;
        } catch (Exception e) {
            throw new RuntimeException("Could not read JSON filed: " + fieldPath, e);
        }
    }

}
