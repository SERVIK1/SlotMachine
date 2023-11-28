module sample.slotmachine {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.slotmachine to javafx.fxml;
    exports sample.slotmachine;
    exports controllers;
    opens controllers to javafx.fxml;
}