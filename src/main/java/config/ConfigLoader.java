package config;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class ConfigLoader {
    public static void load() {
        Gson gson = new Gson();
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(ClassLoader.getSystemResource("config.json").getPath()));
            Config.config = gson.fromJson(jsonReader, Config.class);
        } catch (java.lang.Exception e) {
            System.out.println("Error loading config");
            e.printStackTrace();
        }
    }
}
