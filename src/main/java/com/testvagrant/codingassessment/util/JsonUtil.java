package com.testvagrant.codingassessment.util;

import com.testvagrant.codingassessment.constants.FrameworkConstants;
import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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

    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();

            JSONObject jsonObject = (JSONObject) parser.parse(
                    new FileReader("C:/TestVagrantCodingAssessment/src/test/resources/TeamRCB.json"));//path to the JSON file.

                     JSONParser jsonParser = new JSONParser();
          //Object object = jsonParser.parse(j);

            System.out.println(JsonUtil.getJsonAsString(jsonObject));



        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
