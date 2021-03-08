//JavaFX application to draw lines

package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();
        Scene scene = new Scene(group, 500, 500);

        double weight = scene.getWidth();
        double height = scene.getHeight();

        for(int i = 0; i < height; i += 25)
        {
            Line line1 = new Line(0, i, i, height);
            line1.setStroke(Color.ORANGE);
            line1.setStrokeWidth(1);
            group.getChildren().add(line1);
        }

        for(int i = 0; i < height; i += 25)
        {
            Line line2 = new Line(weight, i, weight - i, height);
            line2.setStroke(Color.ORANGE);
            line2.setStrokeWidth(1);
            group.getChildren().add(line2);
        }

        for(int i = 0; i < height; i += 25)
        {
            Line line3 = new Line(i, 0, weight, i);
            line3.setStroke(Color.ORANGE);
            line3.setStrokeWidth(1);
            group.getChildren().add(line3);
        }

        for(int i = 0; i < height; i += 25)
        {
            Line line3 = new Line(0, height - i, i, 0);
            line3.setStroke(Color.ORANGE);
            line3.setStrokeWidth(1);
            group.getChildren().add(line3);
        }

        primaryStage.setTitle("Canvas demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
