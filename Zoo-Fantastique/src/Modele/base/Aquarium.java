package base;

import java.util.List;
import Interface.CreatureMarine;

public class Aquarium extends Enclos {
    private double profondeur;
    private double salinite;

    public Aquarium(String nom, double superficie, int capaciteMax, List<Creature> creatures, String proprete, double profondeur, double salinite) {
        super(nom, superficie, capaciteMax, creatures, proprete);
        this.profondeur = profondeur;
        this.salinite = salinite;
    }

    @Override
    public void entretenir() {
        super.entretenir();
        verifierQualiteEau(); 
        System.out.println("L'aquarium a éter entretenu, avec vérification de la qualité de l'eau.");
    }

    private void verifierQualiteEau() { 
        System.out.println("La qualité de l'eau a éter vérifié : profondeur et salinité sont bonnes.");
    }

    @Override
    public void ajouterCreature(Creature creature) {
        if (!(creature instanceof CreatureMarine)) {
            System.out.println("Seules les créatures aquatiques peuvent être ajoutées à un aquarium.");
            return;
        }
        super.ajouterCreature(creature);
    }

    public double getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(double profondeur) {
        this.profondeur = profondeur;
    }

    public double getSalinite() {
        return salinite;
    }

    public void setSalinite(double salinite) {
        this.salinite = salinite;
    }
}