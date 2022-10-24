import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;


/**
 * classe de test qui permet de verifier que la classe Personne
 * fonctionne correctement
 */
public class TestPersonne {

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPersonne(), args);
	}

	/**
	 * verifie methodes correctes
	 */
	public void test_00_testMethodes(){
		Personne p = new Personne("Albert");
		String nom = p.getNom();
		CarteBlocable carte = p.getCarte();

		CarteBlocable cb=new CarteBlocable("Moncode");
		p.prendreCarte(cb);

		Personne p2 = new Personne("B");
		boolean res = p.donnerCarte(p2);

		String resString = p.payer(200.,"Moncode");
	}

}
