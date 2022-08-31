package entity;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class WordEntity {
    private String originalWord;
    private List<String> translations;

    public WordEntity(String originalWord, List<String> translations) {
        this.originalWord = originalWord;
        this.translations = translations.stream().map(String::toLowerCase).collect(Collectors.toList());
    }
}
