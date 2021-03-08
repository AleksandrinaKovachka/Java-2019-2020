//program to draw square shaped spiral
package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.shape.Line;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Group group = new Group();
        Scene scene = new Scene(group, 400, 400);

        //the center of scene
        double xOffset = scene.getWidth() / 2;
        double yOffset = scene.getHeight() / 2;

        for(int i = 0; i < 5; ++i)
        {
            //vertical lines
            Line line1 = new Line(xOffset + (30 * i), yOffset - (30 * i), xOffset + (30 * i), yOffset + 30 + (30 * i));
            line1.setStroke(Color.RED);
            line1.setStrokeWidth(1);
            group.getChildren().add(line1);

            //horizontal lines
            Line line2 = new Line(xOffset + (30 * i), yOffset + 30 + (30 * i), xOffset - 30 - (30 * i), yOffset + 30 + (30 * i));
            line2.setStroke(Color.RED);
            line2.setStrokeWidth(1);
            group.getChildren().add(line2);

            //vertical lines
            Line line3 = new Line(xOffset - 30 - (30 * i), yOffset + 30 + (30 * i), xOffset - 30 - (30 * i), yOffset - 30 - (30 * i));
            line3.setStroke(Color.RED);
            line3.setStrokeWidth(1);
            group.getChildren().add(line3);

            //horizontal lines
            Line line4 = new Line(xOffset - 30 - (30 * i), yOffset - 30 - (30 * i), xOffset + 30 + (30 * i), yOffset - 30 - (30 * i));
            line4.setStroke(Color.RED);
            line4.setStrokeWidth(1);
            group.getChildren().add(line4);
        }

        primaryStage.setTitle("Draw square shaped spiral");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
