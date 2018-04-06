package com.alev.csci323.assignment1.file;

import java.io.File;
import java.io.FileNotFoundException;

public class SimpleRetriever implements FileRetriever {
    public static final String FILE_PREFIX = "Num";
    public static final String FILE_SUFFIX = ".txt";
    public static final int BASE_TWO = 2;

    private File directoryLocation;
    private File files[];
    private int startExponent;
    private int endExponent;

    public SimpleRetriever(String directoryLocation, int
            startExponent, int endExponent)
            throws IllegalArgumentException {
        this.directoryLocation = new File(directoryLocation);
        if (!this.directoryLocation.isDirectory()) {
            throw new IllegalArgumentException("File provided is not a directory");
        }
        if (startExponent < endExponent) {
            this.startExponent = endExponent;
            this.endExponent = startExponent;
        }
    }

    @Override
    public File[] retrieveDataFiles() throws FileNotFoundException {
        if (files == null) {
            files = new File[endExponent - startExponent];
            for (int i = startExponent; i < endExponent; ++i) {
                String fileName = String.format("%s%d%s", FILE_PREFIX, (int)
                        Math.pow(BASE_TWO, i), FILE_SUFFIX);
                File createdFile = new File(directoryLocation, fileName);
                if (!createdFile.exists()) {
                    throw new FileNotFoundException(fileName + " not found in directory " + directoryLocation.getName());
                }
                files[i - startExponent] = new File(directoryLocation, fileName);
            }
        }
        return files;
    }


}
