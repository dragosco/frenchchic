/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import entities.Utilisateur;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sessions.GestionnaireUtilisateurs;

/**
 *
 * @author cojoc
 */
@Named(value = "auth")
@SessionScoped
public class Auth implements Serializable {
    @EJB
    private GestionnaireUtilisateurs gu;

    private final HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
    private Utilisateur utilisateur;
    private String pseudo;
    private String pass;
    private String message;

    public Auth() {
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String login() {
        utilisateur = gu.findUtilisateur(pseudo, pass);
        if (utilisateur != null) {
            session.setAttribute("utilisateur", utilisateur);
            return "index?faces-redirect=true";
        } else {
            message = "Pseudo et/ou mot de passe incorrect(s)";
//            FacesContext.getCurrentInstance().addMessage(
//					null,
//					new FacesMessage(FacesMessage.SEVERITY_WARN,
//							"E-mail et/ou mot de passe incorrect(s)",
//							"Veuillez introduire les e-mail et mot de passe corrects"));
            return "login?faces-redirect=true";
        }
    }

    public String logout() {
            session.invalidate();
            return "login?faces-redirect=true";
    }
}
