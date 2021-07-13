package project.engeto;

import java.util.Collections;
import java.util.Scanner;

public class MainController
{
    private static final String OUTPUT_FILE = "src/max-min-values.txt";

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        JSONOperator jsonOperator = new JSONOperator();
        MajorObjects majorObjects = jsonOperator.acquireJsonFile();
        String inputTask;

        do
        {
            System.out.println("//////////////////////////////////\n" +
                    "\tWELCOME TO STATE RATE LIST\n" +
                    "//////////////////////////////////");
            System.out.println("MENU: 1: Get State by shortcut\n" +
                    "\t  2: Get State rate by shortcut\n" +
                    "\t  3: Get States with max standard rate\n" +
                    "\t  4: Get States with min standard rate\n" +
                    "\t  5: Print max/min to text file\n" +
                    "\t  6: Get all\n" +
                    "\t  7: Exit");
            System.out.print("number: ");
            Integer input = Integer.parseInt(scanner.nextLine());

            switch (input)
            {
                case 1:
                    System.out.print("Write shortcut (e.g.,AT): ");
                    inputTask = scanner.nextLine();
                    System.out.println(inputTask + " - " + majorObjects.getRates().get(inputTask));
                    break;
                case 2:
                    System.out.print("Write shortcut (e.g.,CY): ");
                    inputTask = scanner.nextLine();
                    System.out.println(inputTask + " - standard rate: " + jsonOperator.getStateRate(majorObjects, inputTask));
                    break;
                case 3:
                    System.out.println("States with max standard rate: " + jsonOperator.getMaxThreeValues(majorObjects));
                    break;
                case 4:
                    System.out.println("States with min standard rate: " + jsonOperator.getMinThreeValues(majorObjects));
                    break;
                case 5:
                    WriteToFile write = new WriteToFile();
                    write.exportToFile(OUTPUT_FILE, jsonOperator, majorObjects);
                    System.out.println("Export completed.");
                    break;
                case 6:
                    System.out.println(majorObjects.getRates());
                    break;
                case 7:
                    return;
            }

            System.out.print("Do you want to continue? yes/no: ");
            inputTask = scanner.nextLine();

            if(inputTask.toLowerCase().equals("no"))
            {
                return;
            }
            else if(inputTask.toLowerCase().equals("yes"))
            {

            }
            else
            {
                System.out.println("Input error");
                return;
            }
        } while (true);
    }
}