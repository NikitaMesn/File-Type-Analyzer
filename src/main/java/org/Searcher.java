package org;

import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.*;
import java.io.File;

public class Searcher {


    private final File file;
    private final SortedDatabase patterns;
    private byte[] fileAllBytes;
    PatternSearcher searcher;

    public Searcher(File file, SortedDatabase patterns) {
        this.searcher = new KMPAlgorithm();
        this.patterns = patterns;
        this.file = file;
        try {
            this.fileAllBytes = Files.readAllBytes(Paths.get(file.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getAnswer() {
        String fileName = file.getName();
        String type = "Unknown file type";

        for (String[] line : patterns.getPatterns()) {
            String pattern = line[1].replace("\"", "" );
            String foundType = line[2].replace("\"", "" );
            if (searcher.isFound(fileAllBytes, pattern.getBytes(StandardCharsets.UTF_8))) {
                return fileName + ": " + foundType;
            }
        }

        return fileName + ": " + type;
    }


}
