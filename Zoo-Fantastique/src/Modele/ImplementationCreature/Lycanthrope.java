package ImplementationCreature;

import Interface.CreatureTerrestre;
import base.Creature;
import base.Vivipare;

public class Lycanthrope extends Vivipare implements CreatureTerrestre {

    public Lycanthrope(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Creature mettreBas() {
        //ajouter spec
        return null;
    }

    @Override
    public void Courir() {
        //metttre ici les carac de courses du lycantrhopes
    }
}
