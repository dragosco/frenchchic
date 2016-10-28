/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import entities.Produit;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.jboss.weld.context.http.HttpRequestContext;
import sessions.GestionnaireProduits;

/**
 *
 * @author cojoc
 */
@Named(value = "produitMBean")
@ViewScoped
public class ProduitMBean implements Serializable {
    @EJB
    private GestionnaireProduits gp;
    private Produit produitDuJour;
    
    @PostConstruct
    public void init() {
        produitDuJour = gp.getProduitDuJour();
    }

    public Produit getProduitDuJour() {
        return produitDuJour;
    }

    public void setProduitDuJour(Produit produitDuJour) {
        this.produitDuJour = produitDuJour;
    }
   
}
