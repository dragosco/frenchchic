/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Produit;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cojoc
 */
@Stateless
@LocalBean
public class GestionnaireProduits {
    @PersistenceContext(unitName = "FrenchChic-ejbPU")
    private EntityManager em;

    public void createProduit(String nom, String type, double prix, String description, int stock) {
        Date dateAjout = new Date();
        Produit p = new Produit(nom, type, prix, description, stock, dateAjout);
        em.persist(p);
    }

    public Produit getProduit(Long id) {
        return em.find(Produit.class, id);
    }
    
    public Produit getProduitDuJour() {
        Query query = em.createNamedQuery("Produit.getProduitDuJour");
        return (Produit) query.getResultList().get(0);
    }
    
    public void setNouveauProduitDuJour(Produit nouveauProduit) {
        Produit ancienProduit = getProduitDuJour();
        ancienProduit.setProduitDuJour(false);
        nouveauProduit.setProduitDuJour(true);
    }
}
