package com.nuna.utility;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;


public class ConfigReader {

    static JSONObject obj;
    private static JSONParser jsonParser = new JSONParser();

    static {
        try {
            FileReader in = new FileReader("data.json");
             obj = (JSONObject) jsonParser.parse(in);
            in.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

        public static String read(String key){
        return (String) obj.get(key) ;
    }

}
