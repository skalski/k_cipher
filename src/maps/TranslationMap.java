package maps;

import java.util.HashMap;
import java.util.Map;

public class TranslationMap {
    private static Map<String, Map<String, String>> translationMap = new HashMap<>();

    public static Map<String, Map<String, String>> getTranslationMap() {
        Map<String, String> translationMap01 = new HashMap<>();
        translationMap01.put("00", "11");
        translationMap01.put("01", "10");
        translationMap01.put("10", "00");
        translationMap01.put("11", "01");

        Map<String, String> translationMap11 = new HashMap<>();
        translationMap11.put("00", "11");
        translationMap11.put("01", "10");
        translationMap11.put("10", "00");
        translationMap11.put("11", "01");

        Map<String, String> translationMap00 = new HashMap<>();
        translationMap00.put("00", "11");
        translationMap00.put("01", "10");
        translationMap00.put("10", "00");
        translationMap00.put("11", "01");

        Map<String, String> translationMap10 = new HashMap<>();
        translationMap10.put("00", "11");
        translationMap10.put("01", "10");
        translationMap10.put("10", "00");
        translationMap10.put("11", "01");

        translationMap.put("01", translationMap01);
        translationMap.put("00", translationMap00);
        translationMap.put("10", translationMap10);
        translationMap.put("11", translationMap11);

        return translationMap;
    }
}
