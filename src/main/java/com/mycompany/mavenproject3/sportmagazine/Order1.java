/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.sportmagazine;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "order")
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByIdOrder", query = "SELECT o FROM Order1 o WHERE o.idOrder = :idOrder"),
    @NamedQuery(name = "Order1.findByCostOrder", query = "SELECT o FROM Order1 o WHERE o.costOrder = :costOrder"),
    @NamedQuery(name = "Order1.findByDateOrder", query = "SELECT o FROM Order1 o WHERE o.dateOrder = :dateOrder"),
    @NamedQuery(name = "Order1.findByProductidproduct", query = "SELECT o FROM Order1 o WHERE o.productidproduct = :productidproduct")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_order")
    private Integer idOrder;
    @Column(name = "cost_order")
    private String costOrder;
    @Column(name = "date_order")
    private String dateOrder;
    @Basic(optional = false)
    @Column(name = "Product_id_product")
    private int productidproduct;

    public Order1() {
    }

    public Order1(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Order1(Integer idOrder, int productidproduct) {
        this.idOrder = idOrder;
        this.productidproduct = productidproduct;
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

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getProductidproduct() {
        return productidproduct;
    }

    public void setProductidproduct(int productidproduct) {
        this.productidproduct = productidproduct;
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
        return "com.mycompany.mavenproject3.sportmagazine.Order1[ idOrder=" + idOrder + " ]";
    }
    
}
