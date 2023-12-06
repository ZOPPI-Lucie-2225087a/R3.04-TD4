package Habitat;

import java.util.List;
import Base.Creature;
import Base.Enclos;

/**
 * Classe Standard
 * 
 * @see Enclos
 */
public class Standard extends Enclos {
    private double proprete;

    /**
     * Constructeur pour la classe Standard.
     *
     * @param nom         Le nom de l'enclos terrestre.
     * @param superficie  La superficie de l'enclos terrestre.
     * @param capaciteMax La capacité maximale de l'enclos terrestre.
     * @param creatures   La liste des créatures dans l'enclos terrestre.
     * @param proprete    Le niveau de propreté de l'enclos terrestre.
     */
    public Standard(String nom, double superficie, int capaciteMax, List<Creature> creatures, double proprete) {
        super(nom, superficie, capaciteMax, creatures, proprete);
        this.proprete = 100.0;
    }

    /**
     * Retourne le type d'habitat, qui est "standard".
     *
     * @return Le type d'habitat de l'enclos terrestre.
     */
    @Override
    public String getHabitat() {
        return "standard";
    }

    /**
     * Ajoute une créature à l'enclos terrestre.
     *
     * @param creature La créature à ajouter à l'enclos terrestre.
     */
    @Override
    public void entretenir() {
        super.entretenir();
        System.out.println("L'enclos terrestre a été entretenu.");
    }

    /**
     * Retire une créature de l'enclos terrestre.
     *
     * @param creature La créature à retirer de l'enclos terrestre.
     */
    @Override
    public void ajouterCreature(Creature creature) {
        super.ajouterCreature(creature);
    }

    /**
     * Retourne le niveau de propreté de l'enclos terrestre.
     *
     * @return Le niveau de propreté de l'enclos terrestre.
     */
    public double getPropreteStandard() {
        return this.proprete;
    }

    /**
     * Modifie le niveau de propreté de l'enclos terrestre.
     *
     * @param proprete Le nouveau niveau de propreté de l'enclos terrestre.
     */
    public void setPropreteStandard(double proprete) {
        super.setProprete(proprete);
    }
}