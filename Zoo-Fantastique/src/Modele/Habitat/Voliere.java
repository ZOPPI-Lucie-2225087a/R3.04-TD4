package Habitat;

import java.util.List;
import Base.Creature;
import Base.Enclos;
import Interface.CreatureVolante;

/**
 * Classe Voliere
 * 
 * @see Enclos
 */
public class Voliere extends Enclos {
    private int hauteur;
    private double Toit;

    /**
     * Constructeur pour la classe Voliere.
     *
     * @param nom         Le nom de la volière.
     * @param superficie  La superficie de la volière.
     * @param capaciteMax La capacité maximale de la volière.
     * @param creatures   La liste des créatures dans la volière.
     * @param proprete    Le niveau de propreté de la volière.
     * @param hauteur     La hauteur de la volière.
     */
    public Voliere(String nom, double superficie, int capaciteMax, List<Creature> creatures, double proprete,
            int hauteur) {
        super(nom, superficie, capaciteMax, creatures, proprete);
        this.hauteur = hauteur;
        this.Toit = 100.0;
        this.proprete = 100.0;
    }

    /**
     * Retourne le type d'habitat, qui est "voliere".
     *
     * @return Le type d'habitat de la volière.
     */
    @Override
    public String getHabitat() {
        return "voliere";
    }

    /**
     * Ajoute une créature à la volière.
     *
     * @param creature La créature à ajouter à la volière.
     */
    @Override
    public void ajouterCreature(Creature creature) {
        if (!(creature instanceof CreatureVolante)) {
            System.out.println("Seules les créatures volantes peuvent être ajoutées à une volière.");
            return;
        }
        super.ajouterCreature(creature);
    }

    /**
     * Retire une créature de la volière.
     *
     * @param creature La créature à retirer de la volière.
     */
    @Override
    public void entretenir() {
        super.entretenir();
        verifierToit();
        System.out.println("La volière a été entretenue et son toit vérifié.");
    }

    /**
     * Vérifie le toit de la volière.
     */
    private void verifierToit() {
        System.out.println("Le toit de la volière a été vérifié et est en bon état.");
    }

    /**
     * Retourne la hauteur de la volière.
     *
     * @return La hauteur de la volière.
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Modifie la hauteur de la volière.
     *
     * @param hauteur La nouvelle hauteur de la volière.
     */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    /**
     * Retourne le niveau de propreté de la volière.
     *
     * @return Le niveau de propreté de la volière.
     */
    public double getToit() {
        return Toit;
    }

    /**
     * Modifie le niveau de propreté de la volière.
     *
     * @param Toit Le nouveau niveau de propreté de la volière.
     */
    public void setToit(double Toit) {
        this.Toit = Toit;
    }

    /**
     * Retourne le niveau de propreté de la volière.
     *
     * @return Le niveau de propreté de la volière.
     */
    public double getPropreteVoliere() {
        return this.proprete;
    }

    /**
     * Modifie le niveau de propreté de la volière.
     *
     * @param proprete Le nouveau niveau de propreté de la volière.
     */
    public void setPropreteVoliere(double proprete) {
        super.setProprete(proprete);
    }
}