module com.gui {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.providers;
    requires com.services;

    opens gui to javafx.fxml;
    exports gui to javafx.graphics;
}