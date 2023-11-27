package ImplementationCreature;

import Interface.CreatureTerrestre;
import base.Vivipare;

public class Lycanthrope extends Vivipare implements CreatureTerrestre {

    public Lycanthrope(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public void Courir() {

    }
}
