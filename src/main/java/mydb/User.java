/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydb;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author student
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "user")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @javax.persistence.NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser"),
    @javax.persistence.NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @javax.persistence.NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login"),
    @javax.persistence.NamedQuery(name = "User.findByPassw", query = "SELECT u FROM User u WHERE u.passw = :passw")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "id_user")
    private Integer idUser;
    @javax.persistence.Column(name = "name")
    private String name;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "login")
    private String login;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "passw")
    private String passw;
    @javax.persistence.ManyToMany(mappedBy = "userCollection")
    private Collection<Order1> order1Collection;
    @javax.persistence.JoinColumn(name = "roles_id_roles", referencedColumnName = "id_roles")
    @javax.persistence.ManyToOne(optional = false)
    private Roles rolesIdRoles;

    public User() {
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public User(Integer idUser, String login, String passw) {
        this.idUser = idUser;
        this.login = login;
        this.passw = passw;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    public Roles getRolesIdRoles() {
        return rolesIdRoles;
    }

    public void setRolesIdRoles(Roles rolesIdRoles) {
        this.rolesIdRoles = rolesIdRoles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mydb.User[ idUser=" + idUser + " ]";
    }
    
}
