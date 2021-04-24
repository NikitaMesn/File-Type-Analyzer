package org;

public class KMPAlgorithm implements PatternSearcher {


    @Override
    public boolean isFound(byte[] fileAllBytes, byte[] pattern) {

        return KMPSearch(fileAllBytes, pattern);
    }

    private  boolean KMPSearch(byte[] fileAllBytes, byte[] pattern) {
        int[] prefixFunc = prefixFunction(pattern);
        int j = 0;

        for (int i = 0; i < fileAllBytes.length; i++) {

            while (j > 0 && fileAllBytes[i] != pattern[j]) {
                j = prefixFunc[j - 1];
            }

            if (fileAllBytes[i] == pattern[j]) {
                j += 1;
            }

            if (j == pattern.length) {
                return true;
            }
        }
        return false;
    }

    private int[] prefixFunction(byte[] pattern) {
        int[] prefixFunc = new int[pattern.length];

        for (int i = 1; i < pattern.length; i++) {
            int j = prefixFunc[i - 1];

            while (j > 0 && pattern[i] != pattern[j]) {
                j = prefixFunc[j - 1];
            }

            if (pattern[i] == pattern[j]) {
                j += 1;
            }
            prefixFunc[i] = j;
        }
        return prefixFunc;
    }
}
