package com.mycompany.mavenproject3;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.mycompany.mavenproject3.sportmagazine.User;
import javax.persistence.NoResultException;

public class PrimaryController {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_mavenproject3_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();

    @FXML
    private void switchToSecondary() throws IOException {
        Node n1 = App.getRoot().lookup("#usernameTextField");
        TextField usernameField = (TextField) n1;
        
        Node n2 = App.getRoot().lookup("#passwordTextField");
        TextField passwordField = (TextField) n2;
        
        System.out.println("Username: " + usernameField.getText());
        System.out.println("Password: " + passwordField.getText());

        String username = usernameField.getText();
        String password = passwordField.getText();

        Query u = em.createNamedQuery("User.findByLogin");
        u.setParameter("login", username);
        Label err = (Label) App.getRoot().lookup("#err");

        try {
            User user = (User) u.getSingleResult();

            if (user.getPassw().equals(password)) {
//                err.setText("");
                App.setRoot("secondary");
            } else {
                err.setText("Неверный логин и пароль");
            }
        } catch (NoResultException e) {
            err.setText("Неверный логин и пароль");
        }
        
             
    }
    
    @FXML
    private void switchToThird() throws IOException {
        App.setRoot("registration");
    }
}
    