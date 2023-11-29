package ListeCreatures;

import Base.Creature;
import Interface.CreatureMarine;
import CreaturesAttributs.Vivipare;

public class Sirène extends Vivipare implements CreatureMarine {
    public Sirène(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Sirène creerNouveau(String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        return new Sirène(this.getNomEspece(),"bébé", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Creature mettreBas() {
        return null;
    }

    @Override
    public void Nager() {
        System.out.println("La siréne nage gracieusement");
    }
}
