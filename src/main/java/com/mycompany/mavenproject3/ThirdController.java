package com.mycompany.mavenproject3;

import static com.mycompany.mavenproject3.PrimaryController.em;
import com.mycompany.mavenproject3.mydb.Role;
import com.mycompany.mavenproject3.mydb.User;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author student
 */

public class ThirdController {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_mavenproject3_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
    
    @FXML
    private void switchToLogin() throws IOException {
        Node n1 = App.getRoot().lookup("#loginTextField");
        TextField loginField = (TextField) n1;
        
        Node n2 = App.getRoot().lookup("#passwordTextField");
        TextField passwordField = (TextField) n2;
        
        Node n3 = App.getRoot().lookup("nameTextField");
        TextField nameField = (TextField) n3;
        
        String login = loginField.getText();
        String password = passwordField.getText();
        String name = nameField.getText();
        
        Query r = em.createNamedQuery("Role.findByIdRoles");
        r.setParameter("login", "0");
        
        Role rol = (Role) r.getSingleResult();
        em.getTransaction().begin();
        
        User user = new User();
        user.setLogin(login);
        user.setPassw(password);
        user.setName(name);
        user.setRolesIdRoles(rol);
        
        em.persist(user);
        em.getTransaction().commit();
        
        App.setRoot("primary");
            
    }
    
    
}
