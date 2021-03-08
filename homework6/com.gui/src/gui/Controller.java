package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import providers.CipherGenerator;
import providers.Result;
import providers.Wrapper;
import services.Cipherable;

public class Controller {

    private Alert messageBox;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSeed;

    @FXML
    private TextField txtSize;

    @FXML
    private Button btnFixedRandom;

    @FXML
    private Button btnFixedSelection;

    @FXML
    private Button btnQuit;

    @FXML
    void btnFixedRandomOnAction(ActionEvent event) {
        int seed =  Integer.parseInt(txtSeed.getText());
        int size = Integer.parseInt(txtSize.getText());

        Wrapper wrapper = new Wrapper(size);
        Cipherable cipher = wrapper.makeFixedRandom();

        Result result = CipherGenerator.countDistinct(cipher, seed);

        messageBox = new Alert (Alert.AlertType.INFORMATION);
        messageBox.setTitle("Generate random subset A-Z");
        messageBox.setHeaderText("Count distinct characters out of " + size);
        messageBox.setContentText(result.toString());
        messageBox.showAndWait();
    }

    @FXML
    void btnFixedSelectionOnAction(ActionEvent event) {
        int seed =  Integer.parseInt(txtSeed.getText());
        int size = Integer.parseInt(txtSize.getText());

        Wrapper wrapper = new Wrapper(size);
        Cipherable cipher = wrapper.makeFixedSelector();

        Result result = CipherGenerator.countDistinct(cipher, seed);

        messageBox = new Alert (Alert.AlertType.INFORMATION);
        messageBox.setTitle("Random subsequence of letters A-Z");
        messageBox.setHeaderText("Count distinct characters out of " + size);
        messageBox.setContentText(result.toString());
        messageBox.showAndWait();
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert txtSeed != null : "fx:id=\"txtSeed\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtSize != null : "fx:id=\"txtSize\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnFixedRandom != null : "fx:id=\"btnFixedRandom\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnFixedSelection != null : "fx:id=\"btnFixedSelection\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";

    }
}

