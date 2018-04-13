package com.alev.csci323.assignment1.analysis;

import com.alev.csci323.assignment1.file.CSVWriter;
import com.alev.csci323.assignment1.file.SortedListWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import static com.alev.csci323.assignment1.file.CSVWriter.Assignment1Result;

public class AnalysisSaver {

    private CSVWriter csvFileWriter;
    private SortedListWriter arrayListWriter;
    private Map<String, ArrayList<Assignment1Result>> results;

    public AnalysisSaver(CSVWriter csvFileWriter,
                         SortedListWriter arrayListWriter) {

        this.csvFileWriter = Objects.requireNonNull(csvFileWriter);
        this.arrayListWriter = Objects.requireNonNull(arrayListWriter);
    }

    public void save(Path analysisFilePath, Path sortFileDirectoryPath) throws
            IOException {
        Files.createDirectories(analysisFilePath.getParent());
        Files.createDirectories(sortFileDirectoryPath);
        if (!Files.exists(analysisFilePath)) {
            Files.createFile(analysisFilePath);
        }
        BufferedWriter br = Files.newBufferedWriter(analysisFilePath);
        for (Map.Entry<String, ArrayList<Assignment1Result>> fileResults : results.entrySet()) {
            for (Assignment1Result result : fileResults.getValue()) {
                csvFileWriter.addResult(fileResults.getKey(), result);
                arrayListWriter.setList(result.getSortedArray());
                writeArrayListToDirectory(sortFileDirectoryPath, result,
                        fileResults.getKey());
            }
        }
        csvFileWriter.writeCSVFile(br);
    }

    public void addResults(Map<String, ArrayList<Assignment1Result>> results) {
        this.results = Objects.requireNonNull(results);
    }

    private void writeArrayListToDirectory(Path directoryName,
                                           Assignment1Result result,
                                           String originalFileName) throws IOException {
        Path sorterDirectory = directoryName.resolve(
                (result.sorterType.name() + File.separator).toLowerCase());
        try {
            Files.createDirectory(sorterDirectory);
        } catch (FileAlreadyExistsException ignored) {
        }
        BufferedWriter br = Files.newBufferedWriter(sorterDirectory.resolve
                (originalFileName));
        arrayListWriter.writeList(br);
    }
}
