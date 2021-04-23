package org;


public class NaiveAlgorithm implements PatternSearcher {


    @Override
    public boolean isFound(byte[] fileAllBytes, byte[] pattern) {


        return checkByte(fileAllBytes, pattern);
    }


    private boolean checkByte(byte[] fileAllBytes, byte[] pattern) {

        for (int i = 0; i < fileAllBytes.length; i++) {
            if (fileAllBytes[i] == pattern[0] && (fileAllBytes.length - i) >= pattern.length) {
                for (int j = 1; j < pattern.length; j++) {
                    if (fileAllBytes[i + j] == pattern[j]) {
                        return true;
                    }
                }
            }
        }

        return  false;
    }
}
