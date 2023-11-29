package Habitat;

import java.util.List;

import Base.Creature;
import Base.Enclos;

public class Standard extends Enclos {

    public Standard(String nom, double superficie, int capaciteMax, List<Creature> creatures, String proprete) {
        super(nom, superficie, capaciteMax, creatures, proprete);
    }

    @Override
    public void entretenir() {
        super.entretenir();
        System.out.println("L'enclos terrestre a été entretenu.");
    }

    @Override
    public void ajouterCreature(Creature creature) {
        super.ajouterCreature(creature);
    }
}