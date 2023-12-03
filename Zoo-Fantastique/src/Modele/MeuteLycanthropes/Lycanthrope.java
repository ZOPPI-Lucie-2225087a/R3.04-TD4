package MeuteLycanthropes;

import Base.Creature;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import MeuteLycanthropes.Meute;

public class Lycanthrope {

    private char sexe;
    private String categorieAge;
    private int force;
    private int domination;
    private RangDomination rangDomination;
    private int niveau;
    private int facteurImpetuosite;
    private Meute meute;

    public Lycanthrope(char sexe, String categorieAge, RangDomination rangDomination) {
        this.sexe = sexe;
        this.categorieAge = categorieAge;
        this.force = (rangDomination == RangDomination.ALPHA) ? 3 : 1;
        this.domination = 0;
        this.rangDomination = rangDomination;
        this.niveau = calculerNiveau();
        this.facteurImpetuosite = facteurImpetuositeAleatoire();
        this.meute = null;
    }

    public void afficherCaracteristiques() {
        System.out.println("Sexe: " + sexe);
        System.out.println("Catégorie d'âge: " + categorieAge);
        System.out.println("Force: " + force);
        System.out.println("Domination: " + domination);
        System.out.println("Rang de domination: " + rangDomination.getSymbol());
        System.out.println("Niveau: " + niveau);
        System.out.println("Facteur d'impétuosité: " + facteurImpetuosite);
        System.out.println("Appartenance à une meute: " + ((meute != null) ? "Oui" : "Non"));
    }

    public Lycanthrope(RangDomination rangDomination) {
        this.rangDomination = rangDomination;
    }

    public boolean estPlusFortQue(Lycanthrope autre) {
        return this.rangDomination.ordinal() > autre.rangDomination.ordinal();
    }

    public void entendreHurler() {
        System.out.println("J'entends des hurlements");
    }

    public void seTransformerEnHumain() {
        // a faire transformation en maitre zoo
    }

    public int calculerNiveau() {
        int niveauAge = CategorieAge.valueOf(this.categorieAge.toUpperCase()).ordinal();
        int niveauForce = this.force;
        int niveauDomination = domination;
        int niveauRang = this.rangDomination.ordinal();

        return niveauAge + niveauForce + niveauDomination + niveauRang;
    }

    public void rejoindreMeute(Meute meute) {
        this.meute = meute;
    }

    public void quitterMeute() {
        this.meute = null;
    }

    public boolean estSolitaire() {
        return this.meute == null;
    }

    public int getFacteurImpetuosite() {
        return this.facteurImpetuosite;
    }

    public void augmenterImpetuosite() {
        this.facteurImpetuosite++;
    }

    public void diminuerImpetuosite() {
        if (this.facteurImpetuosite > 0) {
            this.facteurImpetuosite--;
        }
    }

    public void facteurImpetuositeAleatoire() {
        Random random = new Random();
        this.facteurImpetuosite = random.nextInt(100);
    }

    public void hurler() {
        Hurlement hurlement = Hurlement.COMMUNICATION; // a changer pour que chaque cri marche 
        hurlement.hurler(hurlement);
    }
}
