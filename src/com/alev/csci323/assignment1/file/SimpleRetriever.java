package com.alev.csci323.assignment1.file;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class SimpleRetriever implements FileRetriever {
    public static final String FILE_PREFIX = "Num";
    public static final String FILE_SUFFIX = ".txt";

    private File directoryLocation;
    private File files[];

    public SimpleRetriever(String directoryLocation)
            throws IllegalArgumentException {
        this.directoryLocation = new File(directoryLocation);
        if (!this.directoryLocation.isDirectory()) {
            throw new IllegalArgumentException("File provided is not a directory");
        }
    }
    @Override
    public File[] retrieveDataFiles() {
        files = directoryLocation.listFiles();
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String fileNum1 = o1.getName();
                fileNum1 = fileNum1.substring(FILE_PREFIX.length(),
                        fileNum1.length() - FILE_SUFFIX.length());
                String fileNum2 = o2.getName();
                fileNum2 = fileNum2.substring(FILE_PREFIX.length(),
                        fileNum2.length() - FILE_SUFFIX.length());
                return Integer.parseInt(fileNum1) - Integer.parseInt(fileNum2);
            }
        });
        return files;
    }


}
