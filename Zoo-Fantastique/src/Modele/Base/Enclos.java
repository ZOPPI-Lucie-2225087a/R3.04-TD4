package Base;

import java.util.ArrayList;
import java.util.List;
import Base.Creature;

public class Enclos {
    private String nom;
    private double superficie;
    private int capaciteMax;
    private List<Creature> creatures;
    private String proprete;

    public Enclos(String nom, double superficie, int capaciteMax, List<Creature> creatures, String proprete) {
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
            System.out.println("L'enclo et plein !");
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
        if (creatures.isEmpty() && "sale".equals(proprete)) {
            proprete = "propre";
            System.out.println("L'enclos a été entretenu, il est désormais propre.");
        } else {
            System.out.println("L'enclos ne peut pas être entretenu car il n'est pas vide ou n'est pas sale.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom de l'enclo: ").append(nom).append("\n");
        sb.append("Superficie: ").append(superficie).append(" m²\n");
        sb.append("Capacité maximale: ").append(capaciteMax).append("\n");
        sb.append("Nombre de créature présente: ").append(creatures.size()).append("\n");
        sb.append("Propreté: ").append(proprete).append("\n");
        sb.append("Détail des créature:\n");
        for (Creature creature : creatures) {
            sb.append(creature.getNom()).append(" - Age: ").append(creature.getAge()).append(" ans\n");
        }
        return sb.toString();
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

    public String getProprete() {
        return proprete;
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

    public void setProprete(String proprete) {
        this.proprete = proprete;
    }
}
