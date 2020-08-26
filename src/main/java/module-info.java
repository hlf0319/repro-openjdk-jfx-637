module shuttle {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org to javafx.fxml;
    exports org;
}