package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller extends AnchorPane
{
    private enum Operation {
        PLUS, MINUS, DIVIDE, MULT, NO_OP, DEN, POW, SQRT, LN;
    };

    private double mResult;

    private Operation operation;
    private double input;
    private double result;

    private Alert mb;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn5;

    @FXML
    private Button btn4;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btn0;

    @FXML
    private Button btn00;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSubstract;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnCompute;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClearAll;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnDen;

    @FXML
    private Button btnPow;

    @FXML
    private Button btnSqrt;

    @FXML
    private Button btnLn;

    @FXML
    private Button btnM;

    @FXML
    private Button btnMPlus;

    @FXML
    private Button btnMMinus;

    @FXML
    private Button btnMC;

    public Controller()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/sample.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }

    }

    @FXML
    void btn00OnAction(ActionEvent event) {
        showDigit("00");
    }

    @FXML
    void btn0OnAction(ActionEvent event) {
        showDigit("0");
    }

    @FXML
    void btn1OnAction(ActionEvent event) {
        showDigit("1");
    }

    @FXML
    void btn2OnAction(ActionEvent event) {
        showDigit(btn2.getText());
    }

    @FXML
    void btn3OnAction(ActionEvent event) {
        showDigit("3");
    }

    @FXML
    void btn4OnAction(ActionEvent event) {
        showDigit("4");
    }

    @FXML
    void btn5OnAction(ActionEvent event) {
        showDigit("5");
    }

    @FXML
    void btn6OnAction(ActionEvent event) {
        showDigit("6");
    }

    @FXML
    void btn7OnAction(ActionEvent event) {
        showDigit("7");
    }

    @FXML
    void btn8OnAction(ActionEvent event) {
        showDigit("8");
    }

    @FXML
    void btn9OnAction(ActionEvent event) {
        showDigit("9");
    }


    private void showDigit(String digit) {
        String text = txtInput.getText();
        if (text.equals("0")) {
            txtInput.setText(digit);
        } else {
            txtInput.setText(text + digit);
        }
    }

    private void doOperation(Operation op) {
        input = Double.parseDouble(txtInput.getText());
        operation = op;
        txtInput.setText("0");
    }

    @FXML
    void btnClearAllOnAction(ActionEvent event) {
        txtInput.setText("0");
        operation = Operation.NO_OP;
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtInput.setText("0");
    }

    @FXML
    void btnComputeOnAction(ActionEvent event) {
        result = Double.parseDouble(txtInput.getText());
        switch (operation) {
            case MULT:
                result *= input;
                break;
            case DIVIDE:
                result = input / result;
                break;
            case PLUS:
                result = result + input;
                break;
            case MINUS:
                result = input - result;
                break;
            default:
                return;
        }
        txtInput.setText("" + result);
        operation = Operation.NO_OP;
    }

    @FXML
    void btnDivideOnAction(ActionEvent event) {
        doOperation(Operation.DIVIDE);
    }

    @FXML
    void btnDotOnAction(ActionEvent event) {
        showDigit(".");
    }

    @FXML
    void btnMultiplyOnAction(ActionEvent event) {
        doOperation(Operation.MULT);
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) { // ask to quit
        if ( ButtonType.OK == mb.showAndWait().get()) {
            Platform.exit();
        }

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        doOperation(Operation.PLUS);
    }

    @FXML
    void btnSubstractOnAction(ActionEvent event) {
        doOperation(Operation.MINUS);
    }

    @FXML
    void btnDenOnAction(ActionEvent event) {
        input = Double.parseDouble(txtInput.getText());
        txtInput.setText("" + (1 / input));
        operation = Operation.NO_OP;
    }

    @FXML
    void btnLnOnAction(ActionEvent event) {
        input = Double.parseDouble(txtInput.getText());
        txtInput.setText("" + (Math.log10(input)));
        operation = Operation.NO_OP;
    }

    @FXML
    void btnPowOnAction(ActionEvent event) {
        input = Double.parseDouble(txtInput.getText());
        txtInput.setText("" + (Math.pow(input, 2)));
        operation = Operation.NO_OP;
    }

    @FXML
    void btnSqrtOnAction(ActionEvent event) {
        input = Double.parseDouble(txtInput.getText());
        txtInput.setText("" + (Math.sqrt(input)));
        operation = Operation.NO_OP;
    }

    @FXML
    void btnMCOnAction(ActionEvent event) {
        mResult = 0;
    }

    @FXML
    void btnMMinusOnAction(ActionEvent event) {
        txtInput.setText("" + (Double.parseDouble(txtInput.getText()) - mResult));
    }

    @FXML
    void btnMOnAction(ActionEvent event) {
        mResult = Double.parseDouble(txtInput.getText());
        txtInput.setText("0");
    }

    @FXML
    void btnMPlusOnAction(ActionEvent event) {
        txtInput.setText("" + (mResult + Double.parseDouble(txtInput.getText())));
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn3 != null : "fx:id=\"btn3\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn5 != null : "fx:id=\"btn5\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn4 != null : "fx:id=\"btn4\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn6 != null : "fx:id=\"btn6\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn7 != null : "fx:id=\"btn7\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn8 != null : "fx:id=\"btn8\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn9 != null : "fx:id=\"btn9\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn0 != null : "fx:id=\"btn0\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn00 != null : "fx:id=\"btn00\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSubstract != null : "fx:id=\"btnSubstract\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMultiply != null : "fx:id=\"btnMultiply\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDivide != null : "fx:id=\"btnDivide\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnCompute != null : "fx:id=\"btnCompute\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDot != null : "fx:id=\"btnDot\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnClearAll != null : "fx:id=\"btnClearAll\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnDen != null : "fx:id=\"btnDen\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnPow != null : "fx:id=\"btnPow\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSqrt != null : "fx:id=\"btnSqrt\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnLn != null : "fx:id=\"btnLn\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnM != null : "fx:id=\"btnM\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMPlus != null : "fx:id=\"btnMPlus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMMinus != null : "fx:id=\"btnMMinus\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnMC != null : "fx:id=\"btnMC\" was not injected: check your FXML file 'sample.fxml'.";

    }
}


