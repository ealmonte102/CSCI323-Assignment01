package com.alev.csci323.assignment1.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SimpleRetriever implements FileRetriever {
    public static final String FILE_PREFIX = "Num";
    public static final String FILE_SUFFIX = ".txt";

    public static String FILE_REGEX =
            String.format("((?i)%s)\\d*%s", FILE_PREFIX, FILE_SUFFIX);

    private File directoryLocation;
    private List<File> dataFiles;

    public SimpleRetriever(String directoryLocation)
            throws IllegalArgumentException {
        this.directoryLocation = new File(directoryLocation);
        if (!this.directoryLocation.isDirectory()) {
            throw new IllegalArgumentException("File provided is not a directory");
        }
    }
    @Override
    public List<File> retrieveDataFiles() {
        if (dataFiles == null) {
            dataFiles = new ArrayList<>();
            File[] filesInDirectory = directoryLocation.listFiles();
            for (File file : filesInDirectory) {
                String name = file.getName();
                if (name.matches(FILE_REGEX)) {
                    dataFiles.add(file);
                }
            }
            dataFiles.sort((o1, o2) -> {
                String fileNum1 = o1.getName();
                fileNum1 = fileNum1.substring(FILE_PREFIX.length(),
                        fileNum1.length() - FILE_SUFFIX.length());
                String fileNum2 = o2.getName();
                fileNum2 = fileNum2.substring(FILE_PREFIX.length(),
                        fileNum2.length() - FILE_SUFFIX.length());
                return Integer.parseInt(fileNum1) - Integer.parseInt(fileNum2);
            });
        }
        return dataFiles;
    }
}
