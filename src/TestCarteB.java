import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;


/**
 * classe de test qui permet de verifier que la classe CarteB
 * fonctionne correctement
 */
public class TestCarteB {

    /**
     * methode de lancement des tests
     *
     * @param args
     */
    public static void main(String[] args) {
        lancer(new TestCarteB(), args);
    }

    /**
     * verification des méthodes
     */
    public void test_00_Methodes() {
        CarteB carte = new CarteB("code");
        CarteB carte2 = new CarteB(100., 1000., "code");
        assertEquals("solde", 100.0, carte2.getSolde());

        boolean res = carte2.etreCodeCorrect("test");
        carte2.deposer(300.);

        res = carte2.depenser(100., "code");
    }

    public void test_deposer_OK() {
        // preparation des donnees
        CarteB carte = new CarteB(100, 1000, "monCode");


        // methode testee
        carte.deposer(20);

        // verifications
        assertEquals(" solde doit etre de 120 ", 120.0, carte.getSolde());
        assertEquals(" decouvert reste 1000 ", 1000.0, carte.getDecouvert());
    }

    /**
     * quand le depot est effectue avec un montant negatif
     */
    public void test_deposer_negatif() {
        // preparation des donnees
        CarteB carte = new CarteB(100, 1000, "monCode");

        // methode testee
        carte.deposer(-20);

        // verifications
        assertEquals(" solde doit rester de 100 ", 100.0, carte.getSolde());
        assertEquals(" decouvert reste 1000 ", 1000.0, carte.getDecouvert());
    }


}
