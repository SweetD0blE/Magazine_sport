package com.mycompany.mavenproject3;

import static com.mycompany.mavenproject3.PrimaryController.em;
import com.mycompany.mavenproject3.sportmagazine.Role;
import com.mycompany.mavenproject3.sportmagazine.User;
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
    
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;
    
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_mavenproject3_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
    
    @FXML
    private void switchToLogin() throws IOException {
        
        String login = loginTextField.getText();
        String password = passwordTextField.getText();
        String name = nameTextField.getText();
        
        Query r = em.createNamedQuery("Role.findByName");
        r.setParameter("name","User");
        Role role = (Role) r.getSingleResult();
        em.getTransaction().begin();
        
        User user = new User();  
        user.setLogin(login);
        user.setPassw(password);
        user.setName(name);
        user.setRoleidroles(role);
        
        em.persist(user);
        em.getTransaction().commit();
        
      
        System.out.println("Registration was successful: " + login);
        System.out.println("Password: " + password);
        
        App.setRoot("primary");
            
    }
    
    
}
