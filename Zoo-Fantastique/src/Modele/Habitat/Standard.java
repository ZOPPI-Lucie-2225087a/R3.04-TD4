package Habitat;

import java.util.List;

import Base.Creature;
import Base.Enclos;

public class Standard extends Enclos {
    private double proprete;

    public Standard(String nom, double superficie, int capaciteMax, List<Creature> creatures, double proprete) {
        super(nom, superficie, capaciteMax, creatures, proprete);
        this.proprete = 100.0;
    }

    @Override
    public String getHabitat() {
        return "standard";
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

    public double getPropreteStandard() {
        return this.proprete;
    }

    public void setPropreteStandard(double proprete) {
        super.setProprete(proprete);
    }
}