package org;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class NaiveAlgorithm implements SearchPattern{

    final private byte[] fileAllBytes;
    final private byte[] pattern;
    final private String type;


    public NaiveAlgorithm(ArgsHandler args) {
        this.fileAllBytes = args.getFileAllBytes();
        this.pattern = args.getPatternBytes();
        this.type = args.getType();
    }

    @Override
    public void getResult() {
        long startTime = System.nanoTime();
        boolean isFound = checkByte();
        long elapsedNanos = System.nanoTime() - startTime;
        double second = (double) elapsedNanos / 1_000_000_000;

        if (!isFound) {
            System.out.println("Unknown file type");
        } else {
            System.out.println(type);
        }

        System.out.println("It took " + second +" seconds");
    }


    private boolean checkByte() {
        boolean isFound = false;

        for (int i = 0; i < fileAllBytes.length && !isFound; i++) {
            if (fileAllBytes[i] == pattern[0] && (fileAllBytes.length - i) >= pattern.length) {
                for (int j = 1; j < pattern.length && !isFound; j++) {
                    if (fileAllBytes[i + j] == pattern[j]) {
                        return true;
                    }
                }
            }
        }

        return  false;
    }
}
