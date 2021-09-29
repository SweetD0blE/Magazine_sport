/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject3.mydb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author student
 */
@Entity
@Table(name = "Order")
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByIdOrder", query = "SELECT o FROM Order1 o WHERE o.idOrder = :idOrder"),
    @NamedQuery(name = "Order1.findByCostOrder", query = "SELECT o FROM Order1 o WHERE o.costOrder = :costOrder"),
    @NamedQuery(name = "Order1.findByDateOrder", query = "SELECT o FROM Order1 o WHERE o.dateOrder = :dateOrder"),
    @NamedQuery(name = "Order1.findByProductIdProduct", query = "SELECT o FROM Order1 o WHERE o.productIdProduct = :productIdProduct")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_order")
    private Integer idOrder;
    @Column(name = "cost_order")
    private String costOrder;
    @Column(name = "date_order")
    @Temporal(TemporalType.DATE)
    private Date dateOrder;
    @Basic(optional = false)
    @Column(name = "product_id_product")
    private int productIdProduct;

    public Order1() {
    }

    public Order1(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Order1(Integer idOrder, int productIdProduct) {
        this.idOrder = idOrder;
        this.productIdProduct = productIdProduct;
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

    public int getProductIdProduct() {
        return productIdProduct;
    }

    public void setProductIdProduct(int productIdProduct) {
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
        return "com.mycompany.mavenproject3.mydb.Order1[ idOrder=" + idOrder + " ]";
    }
    
}
