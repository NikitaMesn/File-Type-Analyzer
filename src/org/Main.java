package org;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception{

        if (args.length < 3) {
            System.out.println("Please provide input file, pattern, type");
            System.exit(0);
        } else {

            File filesDirectory = new File(args[0]);

            File[] files = filesDirectory.listFiles();
            List<ArgsHandler> argList = new ArrayList<>();

            ExecutorService es = Executors.newFixedThreadPool(10);

            List<MyCallable> tasks = new ArrayList<>();
            for (File f : files) {
                MyCallable mc = new MyCallable(new ArgsHandler(f, args[1], args[2]));
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

    ArgsHandler arg;

    public MyCallable(ArgsHandler arg) {
        this.arg = arg;
    }

    public String call() {
        SearchPattern sp = new KMPAlgorithm(arg);
        return sp.getResult();
    }
}