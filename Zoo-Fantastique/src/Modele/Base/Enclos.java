package Base;

import java.util.ArrayList;
import java.util.List;

public abstract class Enclos {
    private String nom;
    private double superficie;
    private int capaciteMax;
    private List<Creature> creatures;
    protected double proprete;

    public abstract String getHabitat();

    public Enclos(String nom, double superficie, int capaciteMax, List<Creature> creatures, double proprete) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.creatures = new ArrayList<>(creatures);
        this.proprete = proprete;
    }

    public void ajouterCreature(Creature creature) {
        if (creatures.size() < capaciteMax) {
            creatures.add(creature);
        } else {
            System.out.println("L'enclo est plein !");
        }
    }

    public void enleverCreature(Creature creature) {
        creatures.remove(creature);
    }

    public void nourrirCreatures() {
        for (Creature creature : creatures) {
            creature.manger();
        }
    }

    public void entretenir() {
        proprete = 100.0;
        System.out.println("L'enclos a été entretenu, il est désormais propre.");
    }

    public String getNom() {
        return nom;
    }

    public double getSuperficie() {
        return superficie;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public double getProprete() {
        return this.proprete;
    }

    public int getNombreCreatures() {
        return creatures.size();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public void setCreatures(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }

    public void setProprete(double proprete) {
        this.proprete = proprete;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("l'").append(nom);
        sb.append(" a une superficie de ").append(superficie).append(" m² ");
        sb.append("et une capacité maximale de ").append(capaciteMax).append(" créatures\n");
        sb.append("L'enclos est propre à ").append(proprete).append("%\n");
        sb.append("Il contient ").append(creatures.size()).append(" créature.s :\n");
        for (Creature creature : creatures) {
            sb.append(creature.toString());
        }
        return sb.toString();
    }
}
