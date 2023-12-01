package Habitat;

import java.util.List;

import Base.Creature;
import Base.Enclos;
import Interface.CreatureVolante;

public class Voliere extends Enclos {
    private int hauteur;
    private double Toit;

    public Voliere(String nom, double superficie, int capaciteMax, List<Creature> creatures, double proprete,
            int hauteur) {
        super(nom, superficie, capaciteMax, creatures, proprete);
        this.hauteur = hauteur;
        this.Toit = 100.0;
        this.proprete = 100.0;
    }

    @Override
    public void ajouterCreature(Creature creature) {
        if (!(creature instanceof CreatureVolante)) {
            System.out.println("Seules les créatures volantes peuvent être ajoutées à une volière.");
            return;
        }
        super.ajouterCreature(creature);
    }

    @Override
    public void entretenir() {
        super.entretenir();
        verifierToit();
        System.out.println("La volière a été entretenue et son toit vérifié.");
    }

    private void verifierToit() {
        System.out.println("Le toit de la volière a été vérifié et est en bon état.");
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public double getToit() {
        return Toit;
    }

    public void setToit(double Toit) {
        this.Toit = Toit;
    }

    public double getPropreteVoliere() {
        return this.proprete;
    }

    public void setPropreteVoliere(double proprete) {
        super.setProprete(proprete);
    }
}