package Base;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite représentant un enclos pour des créatures.
 */
public abstract class Enclos {
    private String nom;
    private double superficie;
    private int capaciteMax;
    private List<Creature> creatures;
    protected double proprete;

    /**
     * Méthode abstraite permettant d'obtenir le type d'habitat de l'enclos.
     *
     * @return Le type d'habitat de l'enclos.
     */
    public abstract String getHabitat();

    /**
     * Constructeur de la classe Enclos.
     *
     * @param nom         Le nom de l'enclos.
     * @param superficie  La superficie de l'enclos en m².
     * @param capaciteMax La capacité maximale d'accueil d'individus dans l'enclos.
     * @param creatures   La liste des créatures présentes dans l'enclos.
     * @param proprete    Le niveau de propreté initial de l'enclos.
     */
    public Enclos(String nom, double superficie, int capaciteMax, List<Creature> creatures, double proprete) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.creatures = new ArrayList<>(creatures);
        this.proprete = proprete;
    }

    /**
     * Méthode permettant d'ajouter une créature à l'enclos.
     *
     * @param creature La créature à ajouter.
     */
    public void ajouterCreature(Creature creature) {
        if (creatures.size() < capaciteMax) {
            creatures.add(creature);
        } else {
            System.out.println("L'enclo est plein !");
        }
    }

    /**
     * Méthode permettant de retirer une créature de l'enclos.
     *
     * @param creature La créature à retirer.
     */
    public void enleverCreature(Creature creature) {
        creatures.remove(creature);
    }

    /**
     * Méthode permettant de nourrir toutes les créatures présentes dans l'enclos.
     */
    public void nourrirCreatures() {
        for (Creature creature : creatures) {
            creature.manger();
        }
    }

    /**
     * Méthode permettant d'entretenir l'enclos, rétablissant le niveau de propreté
     * à 100%.
     */
    public void entretenir() {
        proprete = 100.0;
        System.out.println("L'enclos a été entretenu, il est désormais propre.");
    }

    /**
     * Méthode permettant d'obtenir le nom de l'enclos.
     *
     * @return Le nom de l'enclos.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode permettant d'obtenir la superficie de l'enclos.
     *
     * @return La superficie de l'enclos en m².
     */
    public double getSuperficie() {
        return superficie;
    }

    /**
     * Méthode permettant d'obtenir la capacité maximale d'accueil d'individus dans
     * l'enclos.
     *
     * @return La capacité maximale de l'enclos.
     */
    public int getCapaciteMax() {
        return capaciteMax;
    }

    /**
     * Méthode permettant d'obtenir la liste des créatures présentes dans l'enclos.
     *
     * @return La liste des créatures dans l'enclos.
     */
    public List<Creature> getCreatures() {
        return creatures;
    }

    /**
     * Méthode permettant d'obtenir le niveau de propreté de l'enclos.
     *
     * @return Le niveau de propreté de l'enclos en pourcentage.
     */
    public double getProprete() {
        return this.proprete;
    }

    /**
     * Méthode permettant d'obtenir le nombre de créatures présentes dans l'enclos.
     *
     * @return Le nombre de créatures dans l'enclos.
     */
    public int getNombreCreatures() {
        return creatures.size();
    }

    /**
     * Méthode permettant de définir le nom de l'enclos.
     *
     * @param nom Le nouveau nom de l'enclos.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode permettant de définir la superficie de l'enclos.
     *
     * @param superficie La nouvelle superficie de l'enclos en m².
     */
    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    /**
     * Méthode permettant de définir la capacité maximale d'accueil d'individus dans
     * l'enclos.
     *
     * @param capaciteMax La nouvelle capacité maximale de l'enclos.
     */
    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    /**
     * Méthode permettant de définir la liste des créatures présentes dans l'enclos.
     *
     * @param creatures La nouvelle liste des créatures dans l'enclos.
     */
    public void setCreatures(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }

    /**
     * Méthode permettant de définir le niveau de propreté de l'enclos.
     *
     * @param proprete Le nouveau niveau de propreté de l'enclos en pourcentage.
     */
    public void setProprete(double proprete) {
        this.proprete = proprete;
    }

    /**
     * Méthode permettant d'obtenir une représentation textuelle de l'enclos.
     *
     * @return Une chaîne de caractères représentant l'enclos et ses
     *         caractéristiques.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("l'").append(nom);
        sb.append(" a une superficie de ").append(superficie).append(" m² ");
        sb.append("et une capacité maximale de ").append(capaciteMax).append(" créatures\n");
        sb.append("L'enclos est propre à ").append(proprete).append("%\n");
        sb.append("Il contient ").append(creatures.size()).append(" créature.s :\n\n");
        for (Creature creature : creatures) {
            sb.append(creature.toString());
        }
        return sb.toString();
    }
}
