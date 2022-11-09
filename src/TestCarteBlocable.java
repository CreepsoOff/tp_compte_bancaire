import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * <p>
 * classe de test qui permet de verifier que la classe Arc
 * fonctionne correctement
 * </p>
 * <h1>
 * !!!!! ATTENTION !!!!!
 * </h1>
 * Pour les méthodes "TimeOut" IL FAUT ECRIRE DANS LA CONSOLE 3 codes incorrects rapidement sinon, le test ne se lancera pas.
 * Utilisez le bouton "relancer test" pour relancer le test, et écrire les codes.
 */
public class TestCarteBlocable {

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestCarteBlocable(), args);
	}


	/**
	 * verification des méthodes
	 */
	public void test_00_Methodes() {
		CarteBlocable carte = new CarteBlocable("code");
		CarteBlocable carte2 = new CarteBlocable(100., 1000., "code");
		assertEquals("solde", 100.0, carte2.getSolde());

		boolean res = carte2.etreCodeCorrect("test");
		assertEquals("code correct", false, res);


		carte2.deposer(300.);
		res = carte2.depenser(100., "code");

		assertEquals("solde", 300.0, carte2.getSolde());
		assertEquals("decouvert", 1000.0, carte2.getDecouvert());
	}

	/**
	 * quand le depot est effectue avec un montant positif
	 */
	public void test_deposer_OK() {
		// preparation des donnees
		CarteBlocable carte = new CarteBlocable(100, 1000, "monCode");


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
		CarteBlocable carte = new CarteBlocable(100, 1000, "monCode");

		// methode testee
		carte.deposer(-20);

		// verifications
		assertEquals(" solde doit rester de 100 ", 100.0, carte.getSolde());
		assertEquals(" decouvert reste 1000 ", 1000.0, carte.getDecouvert());
	}

	/**
	 * quand la depense est effectuee avec un montant positif, un code correct, et un solde suffisant
	 */
	public void test_depenser_OK() {
		// preparation des donnees
		CarteBlocable carte = new CarteBlocable(100, 1000, "monCode");

		// methode testee
		boolean res = carte.depenser(20, "monCode");

		// verifications
		assertEquals(" solde doit etre de 80 ", 80.0, carte.getSolde());
		assertEquals(" decouvert reste 1000 ", 1000.0, carte.getDecouvert());
		assertEquals(" depense OK ", true, res);
	}

	/**
	 * quand la depense est effectuee avec un montant negatif, un code correct, et un solde suffisant
	 */
	public void test_depenser_negatif() {
		// preparation des donnees
		CarteBlocable carte = new CarteBlocable(100, 1000, "monCode");

		// methode testee
		boolean res = carte.depenser(-20, "monCode");

		// verifications
		assertEquals(" solde doit rester de 100 ", 100.0, carte.getSolde());
		assertEquals(" decouvert reste 1000 ", 1000.0, carte.getDecouvert());
		assertEquals(" depense OK ", false, res);
	}

	/**
	 * quand la depense est effectuee avec un montant positif, un code correct, et un solde insuffisant
	 */
	public void test_depenser_trop() {
		// preparation des donnees
		CarteBlocable carte = new CarteBlocable(100, 1000, "monCode");

		// methode testee
		boolean res = carte.depenser(1200, "monCode");

		// verifications
		assertEquals(" solde doit rester de 100 ", 100.0, carte.getSolde());
		assertEquals(" decouvert reste 1000 ", 1000.0, carte.getDecouvert());
		assertEquals(" depense OK ", false, res);
	}

	/**
	 * quand la depense est effectuee avec un montant positif, un code incorrect, et un solde suffisant
	 */
	public void test_depenser_codeFaux() {
		// preparation des donnees
		CarteBlocable carte = new CarteBlocable(100, 1000, "monCode");

		// methode testee
		boolean res = carte.depenser(20, "codeFaux");

		// verifications
		assertEquals(" solde doit rester de 100 ", 100.0, carte.getSolde());
		assertEquals(" decouvert reste 1000 ", 1000.0, carte.getDecouvert());
		assertEquals(" depense OK ", false, res);
	}

	/**
	 * Test de la méthode etreCodeCorrect avec un code correct
	 */
	public void test_etreCodeCorrect_OK() {
		// preparation des donnees
		CarteBlocable carte = new CarteBlocable(100, 1000, "monCode");

		// methode testee
		boolean res = carte.etreCodeCorrect("monCode");

		// verifications
		assertEquals(" code incorrect ", true, res);
	}

	/**
	 * quand la depense est effectuee avec un montant positif, un code incorrect 3 fois de suite et un solde suffisant
	 */
	public void test_depenser_bloque() {
		// preparation des donnees
		CarteBlocable carte = new CarteBlocable(100, 1000, "monCode");

		// methode testee
		boolean res = carte.depenser(20, "codeFaux");

		// verifications
		assertEquals(" solde doit rester de 100 ", 100.0, carte.getSolde());
		assertEquals(" decouvert reste 1000 ", 1000.0, carte.getDecouvert());
		assertEquals(" depense OK ", false, res);
		assertEquals(" carte bloquee ", true, carte.etreBloque());
	}
}
