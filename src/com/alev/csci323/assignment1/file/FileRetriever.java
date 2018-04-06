package com.alev.csci323.assignment1.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface FileRetriever {
    List<File> retrieveDataFiles() throws FileNotFoundException;
}
