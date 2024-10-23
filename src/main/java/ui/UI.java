package ui;

import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;

import java.util.ArrayList;

public class UI {
    protected static ArrayList<Integer> array;
    public static Terminal terminal;
    protected static LineReader reader;

    public UI(Terminal terminal, LineReader reader) {
        UI.terminal = terminal;
        UI.reader = reader;
        array = new ArrayList<>();
        Utils.setSymbolBasedOnOS();
    }

    public void start() {
        while (true) {
            Menu.printOptions();
            Menu.handleOptions();
            Utils.sleepALittle(1500);
        }
    }

}
