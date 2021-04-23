package org;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedDatabase {
    private final List patterns = Collections.synchronizedList(new ArrayList());
    //private final List<String[]> patterns = new ArrayList<>();

    public SortedDatabase(String path) throws IOException {
        String thisLine;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        List<String[]> temp = new ArrayList<>();

        while ((thisLine = bufferedReader.readLine()) != null ) {
            temp.add(thisLine.split(";"));
        }

        String[][] temple = temp.toArray(new String[temp.size()][3]);

        mergeSort(temple, 0, temple.length);

        Collections.addAll(patterns, temple);

    }


    private static void mergeSort(String[][] array, int leftIncl, int rightExcl) {

        if (rightExcl <= leftIncl + 1) {
            return;
        }

        int middle = leftIncl + (rightExcl - leftIncl) / 2;

        mergeSort(array, leftIncl, middle);  //
        mergeSort(array, middle, rightExcl); //

        merge(array, leftIncl, middle, rightExcl);


    }
    private static void merge(String[][] array, int left, int middle, int right) {
        int i = left;
        int j = middle;
        int k = 0;

        String[][] temp = new String[right - left][3];

        while (i < middle && j < right) {

            if (Integer.parseInt(array[i][0]) >= Integer.parseInt(array[j][0])) {
                temp[k] = array[i];
                i++;

            } else {
                temp[k] = array[j];
                j++;

            }
            k++;
        }

        for (; i < middle; i++, k++) {
            temp[k] = array[i];
        }

        for (; j < right; j++, k++) {
            temp[k] = array[j];
        }
        System.arraycopy(temp, 0, array, left, temp.length);
    }

    public List<String[]> getPatterns() {
        return patterns;
    }

}
