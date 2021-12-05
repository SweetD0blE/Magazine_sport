module com.mycompany.mavenproject3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires javafx.base;
    requires javafx.graphics;
    
    opens com.mycompany.mavenproject3 to javafx.fxml;
    opens com.mycompany.mavenproject3.sportmagazine;
    
    exports com.mycompany.mavenproject3;
   
}
