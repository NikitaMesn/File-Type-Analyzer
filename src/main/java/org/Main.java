package org;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {

        if (args.length < 2) {
            System.out.println("Please provide input file, pattern, type");
            System.exit(0);
        } else {
            File filesDirectory = new File(args[0]);
            String database = args[1];

            File[] files = filesDirectory.listFiles();
            SortedDatabase patternBase = new SortedDatabase(database);

            ExecutorService es = Executors.newFixedThreadPool(10);
            List<MyCallable> tasks = new ArrayList<>();

            assert files != null;
            for (File f : files) {
                if (f.isDirectory()) {
                    continue;
                }
                MyCallable mc = new MyCallable(f, patternBase);
                tasks.add(mc);
            }

            List<Future<String>> futures = es.invokeAll(tasks);

            for (Future<String> f : futures) {
                System.out.println(f.get());


            }

            es.shutdown();


        }


    }
}

class MyCallable implements Callable<String> {

    File file;
    SortedDatabase base;

    public MyCallable(File file, SortedDatabase base) {
        this.file = file;
        this.base = base;
    }

    public String call() {
        Searcher s = new Searcher(file, base);
        return s.getAnswer();
    }
}