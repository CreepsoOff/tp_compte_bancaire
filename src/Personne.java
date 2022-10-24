/**
 * Classe Personne représentant une personne possédant une carte bancaire
 *
 * @see CarteBlocable
 */
public class Personne {
    private String nom;
    private CarteBlocable carte;

    /**
     * Constructeur de la classe Personne
     *
     * @param pNom le nom de la personne
     */
    public Personne(String pNom) {
        this.nom = pNom;
        this.carte = null;
    }

    /**
     * Méthode permettant de retourner le nom de la personne
     *
     * @return le nom de la personne
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode permettant de retourner la carte de la personne
     *
     * @return la carte de la personne
     */
    public CarteBlocable getCarte() {
        return carte;
    }

    /**
     * Méthode permettant de prendre une carte
     *
     * @param pCarte la carte à prendre
     */
    public void prendreCarte(CarteBlocable pCarte) {
        this.carte = pCarte;
    }

    /**
     * Méthode permettant de donner sa carte à une autre personne
     *
     * @param pPersonne la personne à qui donner la carte
     * @return true si la carte a été donnée, false sinon
     */
    public boolean donnerCarte(Personne pPersonne) {
        boolean res = false;
        if (pPersonne != null && pPersonne.getCarte() == null && this.carte != null) {
            pPersonne.prendreCarte(this.carte);
            this.carte = null;
            res = true;
        }
        return res;
    }

    /**
     * Méthode permettant de payer avec la carte
     *
     * @param montant le montant à payer
     * @param code    le code de la carte
     * @return le message de retour
     */
    public String payer(double montant, String code) {
        String res = "";
        if (this.carte != null) {
            if (this.carte.etreCodeCorrect(code)) {
                if (this.carte.depenser(montant, code)) {
                    res = "* montant accepte";
                } else {
                    res = "* montant refuse";
                }
            } else {
                res = "* code incorrect";
            }
        } else {
            res = "* pas de carte";
        }
        return res;
    }

    /**
     * Méthode permettant de retourner la description de la personne
     * <ul>
     *     <li>
     *        nom désigne le nom de la personne ;
     *     </li>
     *     <li>
     *         solde désigne le solde de la carte ;
     *     </li>
     *     <li>
     *         decouvert désigne le découvert autorisé.
     *     </li>
     * </ul>
     *
     * @return la description de la personne
     */
    public String toString() {
        return this.carte == null ? nom + "(pas de carte)" : nom + "(" + carte + ")";
    }
}
