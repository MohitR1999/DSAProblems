import java.util.Scanner;

import abstracts.Command;
import concretes.reader.Reader;
import factory.CommandFactory;

public class App {
    public static void main(String[] args) throws Exception {
        // take input based on problem type and get the command from command factory
        Scanner scanner = Reader.getInstance().getScanner();
        String type = "";
        if (scanner.hasNext()) {
            type = scanner.next();
        }
        Command solutionCommand = CommandFactory.getCommand(type);
        if (solutionCommand != null) {
            solutionCommand.execute();
        }
        scanner.close();
    }
}
