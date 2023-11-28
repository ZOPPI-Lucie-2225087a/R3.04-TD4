package ListeCreatures;

import CreaturesAttributs.Creature;
import CreaturesAttributs.CreatureMarine;
import CreaturesAttributs.Ovipare;

public class Kraken extends Ovipare implements CreatureMarine {
    public Kraken(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Kraken creerNouveau(char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        return new Kraken(this.getNomEspece(), sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public void Nager() {
        System.out.println("Le kraken nage");
    }
}
