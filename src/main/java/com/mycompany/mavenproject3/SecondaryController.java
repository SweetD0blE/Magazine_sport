package com.mycompany.mavenproject3;

import static com.mycompany.mavenproject3.PrimaryController.em;
import com.mycompany.mavenproject3.mydb.Product;
import java.io.IOException;
import javafx.fxml.FXML;
import java.io.IOException;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class SecondaryController {
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
    public void initialize() {
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
    }
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void onMouseClicked() throws IOException {
        // Получаем информацию о выбранной строке таблицы:
        TableView.TableViewSelectionModel sm = table.getSelectionModel();
        int rowIndex = sm.getSelectedIndex();
        System.out.println(rowIndex);
        
        // Получаем содержимое строки таблицы по индексу:
        selectedProduct = (Product) table.getItems().get(rowIndex);
        System.out.println(selectedProduct);
        
        // Подгружаем данные выбранного пользователя 
        // в панель редактирования справа:
        nameField.setText(selectedProduct.getName());
        colorField.setText(selectedProduct.getColor());
        sizeField.setText(selectedProduct.getSize());
        descriptionField.setText(selectedProduct.getDescription());

    }


}