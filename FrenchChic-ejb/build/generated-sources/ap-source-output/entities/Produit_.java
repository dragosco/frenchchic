package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-28T08:10:47")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, Double> prix;
    public static volatile SingularAttribute<Produit, Boolean> produitDuJour;
    public static volatile SingularAttribute<Produit, Date> dateAjout;
    public static volatile SingularAttribute<Produit, String> description;
    public static volatile SingularAttribute<Produit, Long> id;
    public static volatile SingularAttribute<Produit, String> type;
    public static volatile SingularAttribute<Produit, Integer> stock;
    public static volatile SingularAttribute<Produit, String> nom;

}