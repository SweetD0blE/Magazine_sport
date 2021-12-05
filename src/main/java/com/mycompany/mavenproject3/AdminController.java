
package com.mycompany.mavenproject3;

import static com.mycompany.mavenproject3.SecondaryController.em;
import com.mycompany.mavenproject3.sportmagazine.Product;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AdminController {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_mavenproject3_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
    @FXML
    private TableView table;
    
    @FXML
    private Label nameField;
    
    @FXML
    private Label priceField;
    
    @FXML
    private Label colorField;
    
    @FXML
    private Label descriptionField;
    
    @FXML
    private Label sizeField;
   
    @FXML
    private Product selectedProduct;
 
    
    @FXML
    private TableColumn<Product, String> idColumn;
    
    @FXML
    private TableColumn<Product, String> nameColumn;
    
    @FXML
    private TableColumn<Product, String> priceColumn;
    
    @FXML
    private TextField productNameTextField;
    @FXML
    private TextField productColorTextField;
    @FXML
    private TextField productCostTextField;

    @FXML
    private void initialize(URL url, ResourceBundle rb) {
        
        Query q = em.createNamedQuery("Product.findAll");
        List<Product> productList = q.getResultList();
          
        idColumn.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getIdProduct().toString());
        });
        
        nameColumn.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getName());
        });
        
        priceColumn.setCellValueFactory((TableColumn.CellDataFeatures<Product, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getPrice().toString());
        });
        
        ObservableList<Product> products = FXCollections.observableList(productList);
        table.setItems(products);
        // TODO
    }    
    @FXML
    private void addProduct() throws IOException{
        String productName = productNameTextField.getText();
        String productColor = productColorTextField.getText();
        String productPrice = productCostTextField.getText();
        
        Product productIns = new Product();
        productIns.setName(productName);
        productIns.setColor(productColor);
        productIns.setPrice(productPrice);
        
        em.getTransaction().begin();
        em.persist(productIns);
        em.getTransaction().commit();
        
       productNameTextField.setText("");
       productColorTextField.setText("");
       productCostTextField.setText("");
        
     
        
    }
    
    @FXML
    private void deleteProduct() throws IOException{
        
        Product p = (Product) table.getSelectionModel().getSelectedItem();
        System.out.println(p);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
   
       
    }
    
     @FXML
    private void switchToPrimary1(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void onMouseClicked1() throws IOException {
        // Получаем информацию о выбранной строке таблицы:
        TableView.TableViewSelectionModel sm = table.getSelectionModel();
        int rowIndex = sm.getSelectedIndex();
//        System.out.println(rowIndex);
        
        // Получаем содержимое строки таблицы по индексу:
        selectedProduct = (Product) table.getItems().get(rowIndex);
//        System.out.println(selectedProduct);
        
        // Подгружаем данные выбранного пользователя 
        // в панель редактирования справа:
        nameField.setText(selectedProduct.getName());
        colorField.setText(selectedProduct.getColor());
        sizeField.setText(selectedProduct.getSize());
        descriptionField.setText(selectedProduct.getDescription());

    }
}
