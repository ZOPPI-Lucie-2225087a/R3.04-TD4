package ImplementationCreature;

import Interface.CreatureMarine;
import Interface.CreatureTerrestre;
import Interface.CreatureVolante;
import base.Ovipare;

public class Dragon extends Ovipare implements CreatureMarine, CreatureVolante, CreatureTerrestre {
    public Dragon(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public void Nager() {

    }

    @Override
    public void Courir() {

    }

    @Override
    public void Voler() {

    }
}
