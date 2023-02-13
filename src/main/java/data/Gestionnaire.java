/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gwendal Roy
 */
@Entity
@Table(name = "gestionnaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestionnaire.findAll", query = "SELECT g FROM Gestionnaire g"),
    @NamedQuery(name = "Gestionnaire.findById", query = "SELECT g FROM Gestionnaire g WHERE g.id = :id"),
    @NamedQuery(name = "Gestionnaire.findByEstAssociation", query = "SELECT g FROM Gestionnaire g WHERE g.estAssociation = :estAssociation"),
    @NamedQuery(name = "Gestionnaire.findByNom", query = "SELECT g FROM Gestionnaire g WHERE g.nom = :nom"),
    @NamedQuery(name = "Gestionnaire.findByPrenom", query = "SELECT g FROM Gestionnaire g WHERE g.prenom = :prenom"),
    @NamedQuery(name = "Gestionnaire.findByNomAssociation", query = "SELECT g FROM Gestionnaire g WHERE g.nomAssociation = :nomAssociation"),
    @NamedQuery(name = "Gestionnaire.findByNomPresident", query = "SELECT g FROM Gestionnaire g WHERE g.nomPresident = :nomPresident"),
    @NamedQuery(name = "Gestionnaire.findByPrenomPresident", query = "SELECT g FROM Gestionnaire g WHERE g.prenomPresident = :prenomPresident")})
public class Gestionnaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "est_association")
    private Boolean estAssociation;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "nom_association")
    private String nomAssociation;
    @Column(name = "nom_president")
    private String nomPresident;
    @Column(name = "prenom_president")
    private String prenomPresident;

    public Gestionnaire() {
    }

    public Gestionnaire(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEstAssociation() {
        return estAssociation;
    }

    public void setEstAssociation(Boolean estAssociation) {
        this.estAssociation = estAssociation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomAssociation() {
        return nomAssociation;
    }

    public void setNomAssociation(String nomAssociation) {
        this.nomAssociation = nomAssociation;
    }

    public String getNomPresident() {
        return nomPresident;
    }

    public void setNomPresident(String nomPresident) {
        this.nomPresident = nomPresident;
    }

    public String getPrenomPresident() {
        return prenomPresident;
    }

    public void setPrenomPresident(String prenomPresident) {
        this.prenomPresident = prenomPresident;
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
        if (!(object instanceof Gestionnaire)) {
            return false;
        }
        Gestionnaire other = (Gestionnaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Gestionnaire[ id=" + id + " ]";
    }
    
}
