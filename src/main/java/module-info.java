module com.mycompany.mavenproject3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    
    opens com.mycompany.mavenproject3 to javafx.fxml;
    opens com.mycompany.mavenproject3.mydb;
    exports com.mycompany.mavenproject3;
}
