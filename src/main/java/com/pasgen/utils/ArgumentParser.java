package main.java.com.pasgen.utils;

import java.util.*;

public class ArgumentParser {

    public static Map<String, List<String>> parseArguments(String[] args) {
        HashMap<String, List<String>> result = new HashMap<>();
        String currentKey = "path"; // store argument name
        ArrayList<String> currentValue = new ArrayList<>(); // To store the argument data
        currentValue.add(args[0]);

        for (int i = 1; args.length > i; ++i) {
            if (args[i].startsWith("-") || args[i].startsWith("--")) {
                result.put(currentKey, currentValue);
                currentKey = args[i].replace("-", "");
                currentValue = new ArrayList<>();
                continue;
            }

            currentValue.add(args[i]);
        }

        result.put(currentKey, currentValue);

        return result;
    }
}
