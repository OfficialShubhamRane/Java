package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.Utils.*;

public class NextScreenParser {
    static List<Map<String,String>> fromToMapList = new ArrayList<>();

    public static void main(String[] args) {
        new NextScreenParser().nextScreenParser();
    }

    public List<Map<String,String>> nextScreenParser() {

        List<File> javaFiles = getJavaFiles(Constants.DirectoryPath);
        String methodName = "setNextScreen";

        for (File javaFile : javaFiles) {
            String fileName = javaFile.getName();
            System.out.printf("working on: [%s]\n", fileName);
            findMethodArgument(javaFile, methodName);
            System.out.println();
        }
        System.out.println(fromToMapList);
        return fromToMapList;
    }

    public static void findMethodArgument(File filePath, String methodName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile(methodName + "\\(\"(.*?)\"\\)");
            Map<String,String> fromToMap = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String argument = matcher.group(1);
                    System.out.println("Content within quotes: " + argument);
                    String a = screenNameFromPackageName(argument);
                    String b = screenNameFromFileName(filePath.getName());
                    fromToMap.put(a,b);
                }
            }
            fromToMapList.add(fromToMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<File> getJavaFiles(String directoryPath) {
        List<File> javaFiles = new ArrayList<>();
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Provided path is not a directory");
        }
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    javaFiles.add(file);
                }
            }
        }
        return javaFiles;
    }
}
