/**
 * Classe CarteB représentant la carte bancaire d'une Personne
 *
 * @see Personne
 */
public class CarteB {

    /**
     * Attribut représentant le montant sur la carte
     */
    private double solde;

    /**
     * Attribut représentant le découvert autorisé sur la carte
     */
    private double decouvert;

    /**
     * Attribut représentant le code de la carte
     */
    private String codeCarte;

    /**
     * Constructeur de la classe CarteB
     * @param codeCarte le code de la carte
     */
    public CarteB(String codeCarte) {
        this.codeCarte = codeCarte;
        this.solde = 0;
        this.decouvert = 100;
    }

    /**
     * Constructeur de la classe CarteB
     * @param montant le solde de la carte (positif)
     * @param decouv le découvert autorisé sur la carte (positif)
     * @param code le code de la carte
     */
    public CarteB(double montant, double decouv, String code) {
        this.codeCarte = code;
        this.solde = montant < 0 ? 0 : montant;
        this.decouvert = decouv < 0 ? 0 : decouv;
    }

    /**
     * Méthode permettant de retourner le solde de la carte
     * @return le solde de la carte
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Méthode permettant de retourner le découvert autorisé sur la carte
     * @return le découvert autorisé sur la carte
     */
    public double getDecouvert() {
        return decouvert;
    }

    /**
     * Méthode permettant de vérifier si le code de la carte est correct
     * @param code le code à vérifier
     * @return true si le code est correct, false sinon
     */
    public boolean etreCodeCorrect(String code) {
        return codeCarte.equals(code);
    }

    /**
     * Méthode permettant de déposer de l'argent sur la carte
     * @param montant le montant à déposer
     */
    public void deposer(double montant) {
        solde = montant < 0 ? solde : solde + montant;
    }

    /**
     * Méthode permettant de dépenser l'argent sur la carte
     * @param montant le montant à dépenser
     * @param code le code de la carte
     * @return true si le montant a été dépensé, false sinon
     */
    public boolean depenser(double montant, String code) {
        boolean b = false;
        if (etreCodeCorrect(code) && (solde + decouvert >= montant) && montant > 0) {
            solde -= montant;
            b = true;
        }
        return b;
    }

    /**
     * Méthode toString de la classe CarteB
     * @return une chaîne de caractères représentant la carte sous la forme : "carteB: solde / -decouvert"
     */
    public String toString() {
        return "carteB: " + solde + " / -" + decouvert;
    }


}
