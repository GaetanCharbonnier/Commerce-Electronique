/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.entity;

/**
 *
 * @author gaetan
 */

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



public final class ConnexionForm {
    private static final String CHAMP_CONTACT = "contact";
    private static final String CHAMP_CODE   = "code";

    private String              resultat;
    private final Map<String, String> erreurs      = new HashMap<>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Client connecterUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String contact = getValeurChamp( request, CHAMP_CONTACT );
        String code = getValeurChamp( request, CHAMP_CODE );

        Client utilisateur = new Client();

        /* Validation du champ email. */
        try {
            validationEmail( contact );
        } catch ( Exception e ) {
            setErreur( CHAMP_CONTACT, e.getMessage() );
        }
        utilisateur.setEmail( contact );

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( code );
        } catch ( Exception e ) {
            setErreur( CHAMP_CODE, e.getMessage() );
        }
        utilisateur.setMotDePasse( code );

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }

        return utilisateur;
    }

    private void setErreur(String CHAMP_CODE, String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validationMotDePasse(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validationEmail(String contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getValeurChamp(HttpServletRequest request, String CHAMP_CONTACT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
   
    