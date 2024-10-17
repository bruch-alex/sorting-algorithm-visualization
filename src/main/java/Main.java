import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        UI ui;
        try{
            Terminal terminal = TerminalBuilder.builder().system(true).build();
            LineReader reader = LineReaderBuilder.builder().terminal(terminal).build();
            ui = new UI(terminal, reader);
            ui.start();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
