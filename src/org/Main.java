package org;

public class Main {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Please provide input file, pattern, type");
            System.exit(0);
        } else {

            ArgsHandler arg = new ArgsHandler(args);

            if (args[0].contains("--KMP")) {
                SearchPattern sp = new KMPAlgorithm(arg);
            }

            SearchPattern sp = new NaiveAlgorithm(arg);
            sp.getResult();
        }
    }
}