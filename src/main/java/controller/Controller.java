package controller;

import entity.WordEntity;
import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Controller {

    private final List<WordEntity> list;
    private BufferedReader reader;

    private int attempts;
    private int correct;

    public Controller(List<WordEntity> list) {
        this.list = list;
        this.reader = new BufferedReader(
                new InputStreamReader(System.in));
        attempts = 0;
        correct = 0;
    }

    private void init() {

    }

    private boolean validateAnswer(String answer, WordEntity word) {
        return word.getTranslations().contains(answer.toLowerCase());
    }

    private void printIncorrectAnswer(WordEntity word) {
        System.out.print("Incorrect, right answers are: ");
        for (String s: word.getTranslations()) {
            System.out.print(" " + s + " ");
        }
        System.out.print("\n");
    }

    public void run() throws IOException {
        for (WordEntity word: list) {
            System.out.print(word.getOriginalWord() + ": ");
            String answer = reader.readLine();
            if ("q".equals(answer)) {
                break;
            }
            attempts++;
            if (validateAnswer(answer, word)){
                correct++;
            } else {
                printIncorrectAnswer(word);
            }
        }

        System.out.println("You got " + correct + " correct out of " + attempts);
    }
}
