package org;


public class NaiveAlgorithm implements SearchPattern{

    final private byte[] fileAllBytes;
    final private byte[] pattern;
    final private String type;
    final String fileName;

    public NaiveAlgorithm(ArgsHandler args) {
        this.fileAllBytes = args.getFileAllBytes();
        this.pattern = args.getPatternBytes();
        this.type = args.getType();
        this.fileName = args.getFileName();
    }

    @Override
    public String getResult() {

        boolean isFound = checkByte();

        if (!isFound) {
            return fileName + ": " + "Unknown file type";
        } else {
            return fileName + ": " + type;
        }
    }

    private boolean checkByte() {

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
