module com.example.death_note {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.death_note to javafx.fxml;
    exports com.example.death_note;
    exports com.example.death_note.controllers;
    opens com.example.death_note.controllers to javafx.fxml;
    exports com.example.death_note.elements;
    opens com.example.death_note.elements to javafx.fxml;
}