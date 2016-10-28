/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Utilisateur;
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
public class GestionnaireUtilisateurs {
    @PersistenceContext(unitName = "FrenchChic-ejbPU")
    private EntityManager em;

    public void createUtilisateur(String pseudo, String email, String pass, String nom, String prenom, String tel) {
        Date dateInscription = new Date();
        Utilisateur u = new Utilisateur(pseudo, email, pass, nom, prenom, tel, dateInscription);
        em.persist(u);
    }

    public Utilisateur getUtilisateur(String pseudo) {
        Query query = em.createNamedQuery("Utilisateur.findByPseudo");
        query.setParameter("pseudo", pseudo);
        List<Utilisateur> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }
        
    public Utilisateur findUtilisateur(String pseudo, String pass) {
        Utilisateur u = getUtilisateur(pseudo);
        if (u !=  null) {
            if (u.getPass().equals(pass)) {
                return u;
            } else {
                return null;
            }
        } else {
            return null;
        }
        
    }
}
