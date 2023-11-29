package ListeCreatures;

import Interface.CreatureMarine;
import CreaturesAttributs.Ovipare;

public class Kraken extends Ovipare implements CreatureMarine {
    public Kraken(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Kraken creerNouveau(String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        return new Kraken(this.getNomEspece(), "bébé", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public void Nager() {
        System.out.println("Le kraken nage");
    }
}
