package project.engeto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFile
{
    public void exportToFile(String file, JSONOperator jsonOperator, MajorObjects majorObjects)
    {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file))))
        {
            printWriter.println("States with miminum rate: " + jsonOperator.getMinThreeValues(majorObjects));
            printWriter.println("States with maximum rate: " + jsonOperator.getMaxThreeValues(majorObjects));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
