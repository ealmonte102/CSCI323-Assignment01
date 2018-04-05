package com.alev.file;

import java.io.File;
import java.io.FileNotFoundException;

public interface Assignment1FileRetriever {
    File[] retrieveDataFiles() throws FileNotFoundException;
}
