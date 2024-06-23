package concretes.reader;

import java.util.Scanner;

public class Reader {
    private Scanner scanner = null;
    private static Reader readerInstance = new Reader();
    private Reader() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public static Reader getInstance() {
        return readerInstance;
    }
}
