package key.maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranslationMap {
    private static Map<String, Map<String, String>> translationMap = new HashMap<>();
    private static String[] subBitKey = {"01", "00", "11", "10"};

    public static Map<String, Map<String, String>> getTranslationMap(String binaryKey) {
        List<String> keySet = Arrays.asList(binaryKey.split("(?<=\\G..)"));
        Map<String, String> substitutionMap = new HashMap<>();
        int count = 0;
        int mapCount = 0;
        for(String bitPair : keySet) {

            if (!substitutionMap.containsValue(bitPair)) {
                substitutionMap.put(subBitKey[count], bitPair);
                count++;
            }

            if (count > 3) {
                translationMap.put(subBitKey[mapCount], substitutionMap);
                mapCount++;
                substitutionMap.clear();
                count = 0;
            }

            if(mapCount > 3){
                break;
            }
        };

        return translationMap;
    }

    public static void olde() {

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
    }
}
