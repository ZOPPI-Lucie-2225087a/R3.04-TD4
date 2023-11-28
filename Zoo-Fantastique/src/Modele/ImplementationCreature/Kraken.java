package ImplementationCreature;

import Base.Creature;
import Base.Ovipare;
import Interface.CreatureMarine;

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
        System.out.println("Le kraken nage");
    }
}
