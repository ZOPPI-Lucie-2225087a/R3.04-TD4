package ImplementationCreature;

import Interface.CreatureMarine;
import base.Creature;
import base.Ovipare;

public class Kraken extends Ovipare implements CreatureMarine {
    public Kraken(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Creature Pondre() {
        return null;
    }

    @Override
    public void Nager() {

    }
}
