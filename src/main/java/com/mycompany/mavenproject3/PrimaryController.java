package com.mycompany.mavenproject3;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        Node n1 = App.getRoot().lookup("#usernameTextField");
        TextField usernameField = (TextField) n1;
        
        Node n2 = App.getRoot().lookup("#passwordTextField");
        TextField passwordField = (TextField) n2;
        
        System.out.println("Username: " + usernameField.getText());
        System.out.println("Password: " + passwordField.getText());
        
        if (usernameField.getText().equals("cam1234")
                && passwordField.getText().equals("111")) {
            App.setRoot("secondary");
    } else {
                
        }
}
     
    }