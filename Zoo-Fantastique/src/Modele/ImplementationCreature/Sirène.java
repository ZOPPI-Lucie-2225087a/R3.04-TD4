package ImplementationCreature;

import Base.Creature;
import Base.Ovipare;
import Base.Vivipare;
import Interface.CreatureMarine;

public class Sirène extends Vivipare implements CreatureMarine {
    public Sirène(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
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
