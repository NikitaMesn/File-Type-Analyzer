package org;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArgsHandler {

    private byte[] fileAllBytes;
    private byte[] patternBytes;
    private String type;

    public ArgsHandler(String[] args) {
        try {
            this.fileAllBytes = Files.readAllBytes(Paths.get(args[1]));
            this.patternBytes = args[2].getBytes();
            this.type = args[3];
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public byte[] getFileAllBytes() {
        return fileAllBytes;
    }

    public byte[] getPatternBytes() {
        return patternBytes;
    }

    public String getType() {
        return type;
    }
}
