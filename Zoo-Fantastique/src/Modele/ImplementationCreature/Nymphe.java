package ImplementationCreature;

import Base.Creature;
import Base.Vivipare;
import Interface.CreatureTerrestre;

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
        System.out.println("La nymphe court légérement");
    }
    
    public void renaître() {
        this.age = 0;
        this.indicateurFaim = 100;
        this.dort = false;
        this.indicateurSante = 100;
        System.out.println("La créature a renaît !");
    }
}
