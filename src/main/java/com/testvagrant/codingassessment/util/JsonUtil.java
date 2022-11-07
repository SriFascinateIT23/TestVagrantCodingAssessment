package com.testvagrant.codingassessment.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtil {

    public static JSONObject getJsonFileContent(String jsonFilePath,String jsonFileName) {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONParser parser = new JSONParser();

            jsonObject = (JSONObject) parser.parse(
                    new FileReader(jsonFilePath+jsonFileName));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public static JSONArray getJsonArray(JSONObject jsonObject, String jsonArrayName) {
        JSONArray jsonArray = (JSONArray) jsonObject.get(jsonArrayName);
        return jsonArray;
    }

    public static String getJsonAsString(JSONObject jsonObject) {
        return jsonObject.toJSONString();
    }

}
