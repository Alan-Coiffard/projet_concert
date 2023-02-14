/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gwendal Roy
 */
@Entity
@Table(name = "artiste")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artiste.findAll", query = "SELECT a FROM Artiste a"),
    @NamedQuery(name = "Artiste.findById", query = "SELECT a FROM Artiste a WHERE a.id = :id"),
    @NamedQuery(name = "Artiste.findByNom", query = "SELECT a FROM Artiste a WHERE a.nom = :nom"),
    @NamedQuery(name = "Artiste.findByPrenom", query = "SELECT a FROM Artiste a WHERE a.prenom = :prenom"),
    @NamedQuery(name = "Artiste.findByPseudo", query = "SELECT a FROM Artiste a WHERE a.pseudo = :pseudo"),
    @NamedQuery(name = "Artiste.findByVilleOrigine", query = "SELECT a FROM Artiste a WHERE a.villeOrigine = :villeOrigine"),
    @NamedQuery(name = "Artiste.findByDateNaissance", query = "SELECT a FROM Artiste a WHERE a.dateNaissance = :dateNaissance")})
public class Artiste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "pseudo")
    private String pseudo;
    @Column(name = "ville_origine")
    private String villeOrigine;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @JoinColumn(name = "groupe_id", referencedColumnName = "id")
    @ManyToOne
    private Groupe groupeId;

    public Artiste() {
    }

    public Artiste(Integer id) {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getVilleOrigine() {
        return villeOrigine;
    }

    public void setVilleOrigine(String villeOrigine) {
        this.villeOrigine = villeOrigine;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Groupe getGroupeId() {
        return groupeId;
    }

    public void setGroupeId(Groupe groupeId) {
        this.groupeId = groupeId;
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
        if (!(object instanceof Artiste)) {
            return false;
        }
        Artiste other = (Artiste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Artiste[ id=" + id + " ]";
    }
    
}
