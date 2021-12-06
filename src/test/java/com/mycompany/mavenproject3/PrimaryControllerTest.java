/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject3;

import com.mycompany.mavenproject3.sportmagazine.Product;
import com.mycompany.mavenproject3.sportmagazine.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class PrimaryControllerTest {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_mavenproject3_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
    public PrimaryControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
      public void testGetName() {
      System.out.println("getName");
        Query q = em.createNamedQuery("User.findByIdUser");

        q.setParameter("idUser", 1);
        User u = (User) q.getSingleResult();
        String expResult = "Илья";
        
        String result = u.getName();
        assertEquals(expResult, result);
}
      @Test
      public void FailedTestGetName() {
      System.out.println("getName");
        Query q = em.createNamedQuery("User.findByIdUser");

        q.setParameter("idUser", 1);
        User u = (User) q.getSingleResult();
        String expResult = "Кирилл";
        
        String result = u.getName();
        assertEquals(expResult, result);
}
      @Test
      public void testGetProduct() {
            System.out.println("getProduct");
        Query q = em.createNamedQuery("Product.findByIdProduct");

        q.setParameter("idProduct", 1);
        Product p = (Product) q.getSingleResult();
        String expResult = "Гантель";
        
        String result = p.getName();
        assertEquals(expResult, result);
      }
      @Test
      public void FailedTestGetProduct() {
            System.out.println("getProduct");
        Query q = em.createNamedQuery("Product.findByIdProduct");

        q.setParameter("idProduct", 1);
        Product p = (Product) q.getSingleResult();
        String expResult = "Эспандер";
        
        String result = p.getName();
        assertEquals(expResult, result);
      }
      
    

}
