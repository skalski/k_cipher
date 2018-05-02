package handler;

import maps.TranslationMap;

import java.util.*;

public class Cipher {
    private String binaryKey;
    private String binaryText;

    private Map<String, Map<String, String>> translationMap;

    public Cipher(String binaryKey, String binaryText) {
        this.binaryKey = binaryKey;
        this.binaryText = binaryText;
        this.translationMap = TranslationMap.getTranslationMap();
    }

    public String encrypt() {
        List<String> keySet = Arrays.asList(binaryKey.split("(?<=\\G..)"));
        keySet.forEach(key -> {

            List<String> textSet = Arrays.asList(binaryText.split("(?<=\\G..)"));
            List<String> cache = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            textSet.forEach(text -> {
                Map<String, String> translation = translationMap.get(key);
                cache.add(translation.get(text));
            });

            for (String s : cache) {
                sb.append(s);
            }
            if(isEven(key)){
                binaryText = addRound(sb.toString());
            } else {
                binaryText = looseRound(sb.toString());
            }

        });
        return binaryText;
    }

    public String decrypt() {
        List<String> keySet = Arrays.asList(binaryKey.split("(?<=\\G..)"));
        Collections.reverse(keySet);
        keySet.forEach(key -> {
            if(isEven(key)){
                binaryText = looseRound(binaryText);
            } else {
                binaryText = addRound(binaryText);
            }

            List<String> textSet = Arrays.asList(binaryText.split("(?<=\\G..)"));
            List<String> cache = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            textSet.forEach(text -> {
                Map<String, String> translation = translationMap.get(key);
                cache.add(getKeyFromValue(translation, text).toString());
            });

            for (String s : cache) {
                sb.append(s);
            }
            binaryText = sb.toString();
        });
        return binaryText;
    }

    private String addRound(String cache) {
        return cache.substring(1) + cache.charAt(0);
    }

    private String looseRound(String cache) {
        char last = cache.charAt(cache.length() - 1);
        return last + cache.substring(0, cache.length() - 1);
    }

    private Boolean isEven(String binaryString){
        return (Integer.parseInt(binaryString, 2)& 1) == 0;
    }

    private Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

}
