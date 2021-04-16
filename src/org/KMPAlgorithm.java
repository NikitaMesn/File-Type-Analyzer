package org;

import java.util.*;

public class KMPAlgorithm implements  SearchPattern {
    final private byte[] fileAllBytes;
    final private byte[] pattern;
    final private String type;

    public KMPAlgorithm(ArgsHandler args) {
        this.fileAllBytes = args.getFileAllBytes();
        this.pattern = args.getPatternBytes();
        this.type = args.getType();
    }

    @Override
    public void getResult() {
        long startTime = System.nanoTime();
        boolean isFound = KMPSearch();
        long elapsedNanos = System.nanoTime() - startTime;
        double second = (double) elapsedNanos / 1_000_000_000;

        if (!isFound) {
            System.out.println("Unknown file type");
        } else {
            System.out.println(type);
        }

        System.out.printf("It took s% seconds", second);

    }

    private  boolean KMPSearch() {
        int[] prefixFunc = prefixFunction();
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


    private int[] prefixFunction() {
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
