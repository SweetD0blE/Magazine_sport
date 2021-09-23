/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydb;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author student
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "order")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @javax.persistence.NamedQuery(name = "Order1.findByIdOrder", query = "SELECT o FROM Order1 o WHERE o.idOrder = :idOrder"),
    @javax.persistence.NamedQuery(name = "Order1.findByCostOrder", query = "SELECT o FROM Order1 o WHERE o.costOrder = :costOrder"),
    @javax.persistence.NamedQuery(name = "Order1.findByDateOrder", query = "SELECT o FROM Order1 o WHERE o.dateOrder = :dateOrder")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "id_order")
    private Integer idOrder;
    @javax.persistence.Column(name = "cost_order")
    private String costOrder;
    @javax.persistence.Column(name = "date_order")
    @javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOrder;
    @javax.persistence.JoinTable(name = "users_has_order", joinColumns = {
        @javax.persistence.JoinColumn(name = "order_id_order", referencedColumnName = "id_order")}, inverseJoinColumns = {
        @javax.persistence.JoinColumn(name = "user_id_user", referencedColumnName = "id_user")})
    @javax.persistence.ManyToMany
    private Collection<User> userCollection;
    @javax.persistence.JoinColumn(name = "product_id_product", referencedColumnName = "id_product")
    @javax.persistence.ManyToOne(optional = false)
    private Product productIdProduct;

    public Order1() {
    }

    public Order1(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public String getCostOrder() {
        return costOrder;
    }

    public void setCostOrder(String costOrder) {
        this.costOrder = costOrder;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public Product getProductIdProduct() {
        return productIdProduct;
    }

    public void setProductIdProduct(Product productIdProduct) {
        this.productIdProduct = productIdProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrder != null ? idOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.idOrder == null && other.idOrder != null) || (this.idOrder != null && !this.idOrder.equals(other.idOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mydb.Order1[ idOrder=" + idOrder + " ]";
    }
    
}
