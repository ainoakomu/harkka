/**
 * moduuli sisaltaa ohjelmointi iii harjoitustyon kaikki tarvittavat tiedot
 */
module com.example.budjettiharjoitustyo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.budjettiharjoitustyo to javafx.fxml;
    exports com.example.budjettiharjoitustyo;
}