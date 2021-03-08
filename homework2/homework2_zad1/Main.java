//program to displays a calendar for a month
package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;

public class Main extends Application
{
    //function to create input dialog box
    public static String inputDialog(String infoMessage, String titleBar, String headerMessage)
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titleBar);
        dialog.setHeaderText(headerMessage);
        dialog.setContentText(infoMessage);
        return dialog.showAndWait().get();
    }

    @Override
    public void start(Stage primaryStage)
    {
        Group group = new Group();
        Scene scene = new Scene(group, 300, 200);

        //input string with month and year
        String input = inputDialog("Input month and year: ", "Calendar", "!!! Input number of month, space and number of year!!!");

        //temp array - use to split the input array
        String[] arr = input.split(" ", 2);
        int month = Integer.parseInt(arr[0]); //input month
        int year = Integer.parseInt(arr[1]); //input year

        //the beginning of display day of month
        double xOffset = 30;
        double yOffset = 30;
        double x = xOffset; // use for change position of x cordinate

        String[] arrayWithDayOfWeek = new String[]{"MON", "TUE", "WED", "THR", "FRI", "SAT", "SUN"};

        //display the name of the day
        for(int i = 0; i < arrayWithDayOfWeek.length; ++i)
        {
            Text text = new Text(x, yOffset, arrayWithDayOfWeek[i]);
            group.getChildren().add(text);
            x += 35;
        }
        //continue with next line
        yOffset += 20;

        //check if the today is in display month
        LocalDate todayDate = LocalDate.now();
        boolean isSameDate = false;
        int today = todayDate.getDayOfMonth();
        if(todayDate.getMonthValue() == month && todayDate.getYear() == year)
        {
            isSameDate = true;
        }

        //get position of first day of month
        LocalDate date = LocalDate.of(year, month, 1);
        int dayOfWeek = date.getDayOfWeek().getValue();
        YearMonth wantedYear = YearMonth.of(year, month);
        int numberOfDays = wantedYear.lengthOfMonth();

        //when count is 7 - continue to next line
        int count = dayOfWeek;
        x = xOffset + (dayOfWeek - 1) * 35;
        for(int i = 1; i <= numberOfDays; ++i)
        {
            if(today == i && isSameDate)
            {
                Text textLine = new Text(x, yOffset, Integer.toString(i));
                textLine.setFill(Color.RED);
                group.getChildren().add(textLine);
            }
            else
            {
                Text textLine = new Text(x, yOffset, Integer.toString(i));
                group.getChildren().add(textLine);
            }
            x += 35;
            if(count == 7)
            {
                x = xOffset;
                yOffset += 20;
                count = 0;
            }
            ++count;
        }

        primaryStage.setTitle("Calendar for " + date.getMonth() + " " + year);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
