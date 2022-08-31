package service;

import entity.WordEntity;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileService {
    public List<WordEntity> readFileToWordList(String path) throws IOException {
        Path filePath = Path.of(path);
        List<WordEntity> words = new ArrayList<>();
        try (Stream<String> stream
                     = Files.lines(filePath, StandardCharsets.UTF_8))
        {
            stream.forEach(lines -> {
                String[] parts = lines.strip().split("•");
                if (parts.length >= 2) {
                    words.add(new WordEntity(parts[0], Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length))));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  words;
    }
}