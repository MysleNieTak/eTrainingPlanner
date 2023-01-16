package hibernate.eTrainingPlanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<CommandService> commandServiceList = new ArrayList<>(Arrays.asList(
                new ServiceAddTrainee(),
                new ServiceDeleteTrainee()

        ));
        System.out.println("Type the action to take from the following dropdown: add new trainee," +
                "delete trainee ...");
        String command = scanner.nextLine();

        for (CommandService service : commandServiceList) {
            if (service.getCommand().equalsIgnoreCase(command)) {
                service.commandService();
                System.out.println();

            }
        }
    }
}