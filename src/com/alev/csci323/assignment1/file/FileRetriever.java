package com.alev.csci323.assignment1.file;

import java.io.File;
import java.io.FileNotFoundException;

public interface FileRetriever {
    File[] retrieveDataFiles() throws FileNotFoundException;
}
