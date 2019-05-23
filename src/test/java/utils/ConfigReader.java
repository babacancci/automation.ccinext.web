package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public final class ConfigReader {

    private static ConfigReader configReader;

    private JSONObject configJson;

    private ConfigReader() {
        configJson = getDataFile("config.json");
    }

    protected JSONObject getDataFile(String dataFileName) {
        String dataFilePath = "src/test/java/resources/";
        JSONObject testObject = null;

        try {
            FileReader reader = new FileReader(dataFilePath + dataFileName);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            testObject = (JSONObject) jsonObject;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return testObject;
    }


    public static ConfigReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    private String readValue(String key) {
        return (String) configJson.get(key);//.getString(key);
    }

    public static String getValue(String key) {
        String value = System.getProperty(key);

        if (value == null) {
            value = getInstance().readValue(key);
        }

        return value;
    }

    public static String getPlatform() {
        return getValue("platform");
    }

    public static String getHost() {
        return getValue("host");
    }

}
