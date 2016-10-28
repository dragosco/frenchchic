/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cojoc
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Produit.getAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.getProduitDuJour", query = "SELECT p FROM Produit p WHERE p.produitDuJour=1")
})
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String type;
    private double prix;
    private String description;
    private int stock;
    @Temporal(value = TemporalType.DATE)
    private Date dateAjout;
    private boolean produitDuJour = false;
    
    public Produit() {
    }

    public Produit(String nom, String type, double prix, String description, int stock, Date dateAjout) {
        this.nom = nom;
        this.type = type;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
        this.dateAjout = dateAjout;
    }
    
    public void augmenterStock(int qte) {
        stock += qte;
    }
  
    public int baisserStock(int qte) {
        if (qte < stock) {
            stock -= qte;
            return qte;
        } else {
            return 0;
        }
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public boolean isProduitDuJour() {
        return produitDuJour;
    }

    public void setProduitDuJour(boolean produitDuJour) {
        this.produitDuJour = produitDuJour;
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
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Produit[ id=" + id + " ]";
    }
    
}
