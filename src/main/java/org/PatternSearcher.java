package org;


public interface PatternSearcher {
    boolean isFound(byte[] fileAllBytes, byte[] pattern);
}
