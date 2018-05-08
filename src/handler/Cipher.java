package handler;

import java.util.*;

public class Cipher {
    private String binaryKey;
    private String binaryText;

    public Cipher(String binaryKey, String binaryText) {
        this.binaryKey = binaryKey;
        this.binaryText = binaryText;
    }

    public String encrypt() {
        List<String> keySet = Arrays.asList(binaryKey.split("(?<=\\G.)"));
        keySet.forEach(key -> {

            List<String> textSet = Arrays.asList(binaryText.split("(?<=\\G.)"));
            List<String> cache = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            textSet.forEach(text -> {
                cache.add(
                        String.valueOf(
                                Integer.toBinaryString(Integer.parseInt(text,2)^Integer.parseInt(key,2))
                        )
                );
            });

            for (String s : cache) {
                sb.append(s);
            }
            if(key.equals("1")){
                binaryText = addRound(sb.toString());
            } else {
                binaryText = looseRound(sb.toString());
            }

        });
        return binaryText;
    }

    public String decrypt() {
        List<String> keySet = Arrays.asList(binaryKey.split("(?<=\\G.)"));
        Collections.reverse(keySet);
        keySet.forEach(key -> {
            if(key.equals("1")){
                binaryText = looseRound(binaryText);
            } else {
                binaryText = addRound(binaryText);
            }

            List<String> textSet = Arrays.asList(binaryText.split("(?<=\\G.)"));
            List<String> cache = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            textSet.forEach(text -> {
                cache.add(
                        String.valueOf(
                                Integer.toBinaryString(Integer.parseInt(text,2)^Integer.parseInt(key,2))
                        )
                );
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
}
