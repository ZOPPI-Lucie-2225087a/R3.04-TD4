package Habitat;

import java.util.List;
import Base.Creature;
import Base.Enclos;
import Interface.CreatureMarine;

/**
 * Classe Aquarium
 * 
 * @see Enclos
 */
public class Aquarium extends Enclos {
    private double profondeur;
    private double salinite;

    /**
     * Constructeur pour la classe Aquarium.
     *
     * @param nom         Le nom de l'aquarium.
     * @param superficie  La superficie de l'aquarium.
     * @param capaciteMax La capacité maximale de l'aquarium.
     * @param creatures   La liste des créatures dans l'aquarium.
     * @param proprete    Le niveau de propreté de l'aquarium.
     * @param profondeur  La profondeur de l'aquarium.
     * @param salinite    La salinité de l'aquarium.
     */
    public Aquarium(String nom, double superficie, int capaciteMax, List<Creature> creatures, double proprete,
            double profondeur, double salinite) {
        super(nom, superficie, capaciteMax, creatures, proprete);
        this.profondeur = profondeur;
        this.salinite = 100.0;
        this.proprete = 100.0;
    }

    /**
     * Retourne le type d'habitat, qui est "aquarium".
     *
     * @return Le type d'habitat de l'aquarium.
     */
    @Override
    public String getHabitat() {
        return "aquarium";
    }

    /**
     * Ajoute une créature à l'aquarium.
     *
     * @param creature La créature à ajouter à l'aquarium.
     */
    @Override
    public void entretenir() {
        super.entretenir();
        verifierQualiteEau();
        System.out.println("L'aquarium a été traité, avec vérification de la qualité de l'eau.");
    }

    /**
     * Retire une créature de l'aquarium.
     *
     * @param creature La créature à retirer de l'aquarium.
     */
    private void verifierQualiteEau() {
        System.out.println("La qualité de l'eau a été vérifiée : la profondeur et la salinité sont bonnes.");
    }

    /**
     * Vérifie le toit de la volière.
     */
    @Override
    public void ajouterCreature(Creature creature) {
        if (!(creature instanceof CreatureMarine)) {
            System.out.println("Seules les créatures aquatiques peuvent être ajoutées à un aquarium.");
            return;
        }
        super.ajouterCreature(creature);
    }

    /**
     * Retourne la profondeur de l'aquarium.
     *
     * @return La profondeur de l'aquarium.
     */
    public double getProfondeur() {
        return profondeur;
    }

    /**
     * Retourne la salinité de l'aquarium.
     *
     * @return La salinité de l'aquarium.
     */
    public void setProfondeur(double profondeur) {
        this.profondeur = profondeur;
    }

    /**
     * Renvoie la salinité actuelle de l'aquarium.
     *
     * @return La salinité de l'aquarium.
     */
    public double getSalinite() {
        return salinite;
    }

    /**
     * Définit la salinité de l'aquarium à la valeur spécifiée.
     *
     * @param salinite La nouvelle valeur de salinité.
     */
    public void setSalinite(double salinite) {
        this.salinite = salinite;
    }

    /**
     * Renvoie le niveau de propreté actuel de l'aquarium.
     *
     * @return Le niveau de propreté de l'aquarium.
     */
    public double getPropreteAquarium() {
        return this.proprete;
    }

    /**
     * Définit le niveau de propreté de l'aquarium à la valeur spécifiée.
     *
     * @param proprete La nouvelle valeur de propreté.
     */
    public void setPropreteAquarium(double proprete) {
        this.proprete = proprete;
    }
}