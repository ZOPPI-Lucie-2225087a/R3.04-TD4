package base;

import java.util.List;
import Interface.CreatureVolante;

public class Voliéres extends Enclos {
    private int hauteur;

    public Voliéres(String nom, double superficie, int capaciteMax, List<Creature> creatures, String proprete, int hauteur) {
        super(nom, superficie, capaciteMax, creatures, proprete);
        this.hauteur = hauteur;
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
        setProprete("BON");
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
}