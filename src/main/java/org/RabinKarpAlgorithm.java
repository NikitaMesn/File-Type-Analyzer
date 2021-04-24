package org;


import java.nio.charset.StandardCharsets;
import java.util.*;

public class RabinKarpAlgorithm implements PatternSearcher{

    @Override
    public boolean isFound(byte[] fileAllBytes, byte[] pattern) {

        return RabinKarp(fileAllBytes, pattern);
    }
    
    private  boolean RabinKarp(byte[] text, byte[] pattern) {
        int a = 53;
        long m = 1_000_000_000 + 9;

        if (text.length < pattern.length) {
            return false;
        }

        long patternHash = 0;
        long currSubstrHash = 0;
        long pow = 1;

        for (int i = 0; i < pattern.length; i++) {
            patternHash += pattern[i] * pow;
            patternHash %= m;

            currSubstrHash += text[(text.length - pattern.length + i)] * pow;
            currSubstrHash %= m;

            if (i != pattern.length - 1) {
                pow = pow * a % m;
            }
        }

        for (int i = text.length; i >= pattern.length; i--) {
            if (patternHash == currSubstrHash) {
                boolean patternIsFound = true;

                for (int j = 0; j < pattern.length; j++) {
                    if (text[i - pattern.length + j] != pattern[j]) {
                        patternIsFound = false;
                        break;
                    }
                }
                if (patternIsFound) {
                    return true;
                }
            }

            if (i > pattern.length) {

                currSubstrHash = (currSubstrHash - text[i-1] * pow % m + m) * a % m;
                currSubstrHash = (currSubstrHash + text[i - pattern.length - 1]) % m;
            }
        }

        return false;

    }
}