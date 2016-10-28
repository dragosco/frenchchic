package init;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import sessions.GestionnaireProduits;
import sessions.GestionnaireUtilisateurs;

/**
 *
 * @author cojoc
 */
@Singleton
@Startup
public class InitBD {
    @EJB
    private GestionnaireProduits gp;
    @EJB
    private GestionnaireUtilisateurs gu;
    
    @PostConstruct
    public void init() {
        gu.createUtilisateur("admin", "admin@frenchic.fr", "admin", "admin", "admin", "0699999999");
        gu.createUtilisateur("dragos","dragos@gmail.com", "dragos", "Cojocaru", "Dragos", "0687711971");
        gu.createUtilisateur("thais","thais@gmail.com", "thais", "Mota dos Santos", "Thais", "0600000000");
        gp.createProduit("Produit XYZ", "Type 1", 50.2, "Description bla bla", 5);
        gp.createProduit("Produit ABC", "Type 2", 12.2, "Description bla bla bla bla", 10);
        gp.createProduit("Produit 12345", "Type 1", 32.5, "Descr", 8);
        gp.getProduit(new Long(4)).setProduitDuJour(true);
        System.out.println(gp.getProduitDuJour());
    }
}

