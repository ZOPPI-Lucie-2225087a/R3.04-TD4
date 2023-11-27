package ImplementationCreature;

import Interface.CreatureTerrestre;
import base.Creature;
import base.Vivipare;

public class Nymphe extends Vivipare implements CreatureTerrestre {

    public Nymphe(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Creature mettreBas() {
        return null;
    }

    @Override
    public void Courir() {
        //mettre ici les spec de courses de la nymphe
    }
}
