module com.example.barhome {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens com.example.barhome to javafx.fxml;
    exports com.example.barhome;
    exports com.example.barhome.controllers;
    opens com.example.barhome.controllers to javafx.fxml;
}