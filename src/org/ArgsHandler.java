package org;

import java.io.IOException;
import java.nio.file.*;
import java.io.File;

public class ArgsHandler {

    private byte[] fileAllBytes;
    private byte[] patternBytes;
    private File file;
    private String fileName;
    private String type;

    public ArgsHandler(File file, String pattern, String type) {
        try {
            this.file = file;
            this.fileAllBytes = Files.readAllBytes(Paths.get(file.getPath()));
            this.patternBytes = pattern.getBytes();
            this.type = type;
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

    public String getFileName() {
        return file.getName();
    }
}
