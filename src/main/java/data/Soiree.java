/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gwendal Roy
 */
@Entity
@Table(name = "soiree")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soiree.findAll", query = "SELECT s FROM Soiree s"),
    @NamedQuery(name = "Soiree.findById", query = "SELECT s FROM Soiree s WHERE s.id = :id"),
    @NamedQuery(name = "Soiree.findByNom", query = "SELECT s FROM Soiree s WHERE s.nom = :nom"),
    @NamedQuery(name = "Soiree.findByPrix", query = "SELECT s FROM Soiree s WHERE s.prix = :prix")})
public class Soiree implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nom")
    private String nom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix")
    private Float prix;
    @OneToMany(mappedBy = "concertSoireeId1")
    private Set<Billet> billetSet;
    @OneToMany(mappedBy = "soireeId")
    private Set<Compose> composeSet;

    public Soiree() {
    }

    public Soiree(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    @XmlTransient
    public Set<Billet> getBilletSet() {
        return billetSet;
    }

    public void setBilletSet(Set<Billet> billetSet) {
        this.billetSet = billetSet;
    }

    @XmlTransient
    public Set<Compose> getComposeSet() {
        return composeSet;
    }

    public void setComposeSet(Set<Compose> composeSet) {
        this.composeSet = composeSet;
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
        if (!(object instanceof Soiree)) {
            return false;
        }
        Soiree other = (Soiree) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Soiree[ id=" + id + " ]";
    }
    
}
