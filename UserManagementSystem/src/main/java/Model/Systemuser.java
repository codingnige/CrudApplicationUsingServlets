/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nigelantwi-boasiako
 */
@Entity
@Table(name = "SYSTEMUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Systemuser.findAll", query = "SELECT s FROM Systemuser s"),
    @NamedQuery(name = "Systemuser.findById", query = "SELECT s FROM Systemuser s WHERE s.id = :id"),
    @NamedQuery(name = "Systemuser.findByTitle", query = "SELECT s FROM Systemuser s WHERE s.title = :title"),
    @NamedQuery(name = "Systemuser.findByFirstname", query = "SELECT s FROM Systemuser s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "Systemuser.findBySurname", query = "SELECT s FROM Systemuser s WHERE s.surname = :surname"),
    @NamedQuery(name = "Systemuser.findByDateofbirth", query = "SELECT s FROM Systemuser s WHERE s.dateofbirth = :dateofbirth"),
    @NamedQuery(name = "Systemuser.findByStatus", query = "SELECT s FROM Systemuser s WHERE s.status = :status")})
public class Systemuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 10)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 60)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 60)
    @Column(name = "SURNAME")
    private String surname;
    @Size(max = 8)
    @Column(name = "DATEOFBIRTH")
    private String dateofbirth;
    @Size(max = 15)
    @Column(name = "STATUS")
    private String status;

    public Systemuser() {
    }

    public Systemuser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Systemuser)) {
            return false;
        }
        Systemuser other = (Systemuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Systemuser[ id=" + id + " ]";
    }
    
}
