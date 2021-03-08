package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class App extends Application
{
    private TextField txtSeed;
    private TextField txtSize;

    private Alert messageBox;

    @Override
    public void start(Stage stage) throws Exception
    {
        AnchorPane root = new AnchorPane();
        GridPane gridPane = new GridPane();
        root.getChildren().add(gridPane);

        messageBox  = new Alert (Alert.AlertType.INFORMATION);

        txtSeed = new TextField("Enter the seed");
        txtSize = new TextField("Enter the size");

        Button btnFixedRandom = new Button("Generate random A-Z");
        Button btnFixedSelection = new Button("Random subset of A-Z");
        Button btnQuit = new Button("Quit");

        gridPane.add(txtSeed, 0, 1);
        //txtSeed.setAlignment(Pos.CENTER);
        gridPane.add(txtSize, 0, 2);
        gridPane.add(btnFixedRandom, 0, 3);
        gridPane.add(btnFixedSelection, 1, 3);
        gridPane.add(btnQuit, 0, 4);

        gridPane.setHgap(8);
        gridPane.setVgap(8);

        AnchorPane.setLeftAnchor(root, 8.0);
        AnchorPane.setRightAnchor(root, 8.0);
        AnchorPane.setTopAnchor(root, 8.0);
        AnchorPane.setBottomAnchor(root, 8.0);

        stage.setTitle("Counting Sort");
        stage.setScene(new Scene(root, 300, 150));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
 */
