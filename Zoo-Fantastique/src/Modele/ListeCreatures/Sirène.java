package ListeCreatures;

import CreaturesAttributs.Creature;
import CreaturesAttributs.CreatureMarine;
import CreaturesAttributs.Ovipare;
import CreaturesAttributs.Vivipare;

public class Sirène extends Vivipare implements CreatureMarine {
    public Sirène(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
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
