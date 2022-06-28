package org.example;

import org.json.CDL;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Collectors;

public class CsvToJson {
    public static void main(String[] args) {
        // Read csv data file and store it in a string
        InputStream is = CsvToJson.class.getResourceAsStream("/books_data.csv");
        String csv = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(is), StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        try {
            // Convert csv text to JSON string, and save it
            // to a data.json file.
            String json = CDL.toJSONArray(csv).toString(2);
            Files.write(Path.of("src/main/resources/books_data.json"), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws Exception {
//        File input = new File("input.csv");
//        File output = new File("output.json");
//
//        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
//        CsvMapper csvMapper = new CsvMapper();
//
//        // Read data from CSV file
//        List<obj> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll();
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        // Write JSON formated data to output.json file
//        mapper.writerWithDefaultPrettyPrinter().writeValue(output, readAll);
//
//        // Write JSON formated data to stdout
//        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(readAll));
//
//    }
}