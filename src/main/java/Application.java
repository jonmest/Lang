import controller.Controller;
import entity.WordEntity;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import service.FileService;
import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        FileService fileService = new FileService();
        List<WordEntity> wordList = fileService.readFileToWordList("C:\\Users\\40118123\\PycharmProjects\\lines\\non_verbs.txt");
        Controller controller = new Controller(wordList);
        controller.run();
    }
}
