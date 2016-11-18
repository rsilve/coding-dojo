package net.silve.dojo;


import java.text.Normalizer;
import java.util.Arrays;

public class Anagram {

    public boolean validate(String a, String b) {
        char[] sortedA = prepare(a).toCharArray();
        Arrays.sort(sortedA);
        char[] sortedB = prepare(b).toCharArray();
        Arrays.sort(sortedB);

        return Arrays.equals(sortedA, sortedB);
    }

    private String prepare(String s) {
        return Normalizer.normalize(s, Normalizer.Form.NFKD)
                .toLowerCase()
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
                .replaceAll("\\W", "");
    }

}
