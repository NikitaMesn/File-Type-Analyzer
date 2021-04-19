package org;

public class KMPAlgorithm implements  SearchPattern {
    final private byte[] fileAllBytes;
    final private byte[] pattern;
    final private String type;
    final String fileName;

    public KMPAlgorithm(ArgsHandler args) {
        this.fileAllBytes = args.getFileAllBytes();
        this.pattern = args.getPatternBytes();
        this.type = args.getType();
        this.fileName = args.getFileName();
    }

    @Override
    public String getResult() {
        boolean isFound = KMPSearch();

        if (!isFound) {
            return fileName+ ": " + "Unknown file type";
        } else {
            return fileName + ": " + type;
        }
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
