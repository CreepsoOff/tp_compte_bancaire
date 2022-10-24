/**
 * Classe principale du programme permettant de tester la classe Personne et la classe CarteB
 * @see Personne
 * @see CarteBlocable
 */
public class Main {
    public static void main(String[] args) {
        CarteBlocable carte = new CarteBlocable(100, 1000, "MonCode");
        Personne albert = new Personne("Albert");
        System.out.println(albert);
        albert.prendreCarte(carte);
        System.out.println(albert);
        System.out.println(albert.payer(50, "MonCode"));
        System.out.println(albert);

        Personne bertrand = new Personne("Bertrand");
        System.out.println(bertrand);
        albert.donnerCarte(bertrand);
        bertrand.getCarte().depenser(2, "MCode");
        System.out.println(bertrand);
        System.out.println(bertrand.payer(500, "MonCode"));
        System.out.println(bertrand);
        System.out.println(albert.payer(100, "MonCode"));
        System.out.println(albert);
        System.out.println(bertrand.payer(100, "MaCode"));
        System.out.println(bertrand);
        System.out.println(bertrand.payer(100, "MonCode"));
        System.out.println(bertrand);


    }

}
