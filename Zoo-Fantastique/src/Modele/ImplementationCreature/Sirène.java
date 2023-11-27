package ImplementationCreature;

import Interface.CreatureMarine;
import base.Ovipare;
import base.Vivipare;

public class Sirène extends Vivipare implements CreatureMarine {
    public Sirène(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public void Nager() {

    }
}
