package com.alev.csci323.assignment1.file;

import java.io.File;
import java.io.FileNotFoundException;

public class SimpleRetriever implements FileRetriever {
    public static final String FILE_PREFIX = "Num";
    public static final String FILE_SUFFIX = ".txt";
    private static final int STARTING_EXPONENT = 3;
    private static final int ENDING_EXPONENT = 15;
    private static final int BASE = 2;
    private File directoryLocation;
    private File files[];

    public SimpleRetriever(String directoryLocation) throws IllegalArgumentException {
        this.directoryLocation = new File(directoryLocation);
        if (!this.directoryLocation.isDirectory()) {
            throw new IllegalArgumentException("File provided is not a directory");
        }
    }

    @Override
    public File[] retrieveDataFiles() throws FileNotFoundException {
        if (files == null) {
            files = new File[ENDING_EXPONENT - STARTING_EXPONENT];
            for (int i = STARTING_EXPONENT; i < ENDING_EXPONENT; ++i) {
                String fileName = String.format("%s%d%s", FILE_PREFIX, (int) Math.pow(BASE, i), FILE_SUFFIX);
                File createdFile = new File(directoryLocation, fileName);
                if (!createdFile.exists()) {
                    throw new FileNotFoundException(fileName + " not found in directory " + directoryLocation.getName());
                }
                files[i - STARTING_EXPONENT] = new File(directoryLocation, fileName);
            }
        }
        return files;
    }
}
