module com.example.uas_1972046_JhonathanOktavianus {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens com.example.uas_1972046_JhonathanOktavianus to javafx.fxml;
    exports com.example.uas_1972046_JhonathanOktavianus;
    exports com.example.uas_1972046_JhonathanOktavianus.Entity;
}