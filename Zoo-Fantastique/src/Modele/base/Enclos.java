package base;

import java.util.ArrayList;
import java.util.List;

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
            creature.manger(10);
        }
    }

    public void entretenir() {
        if (creatures.isEmpty() && "sale".equals(proprete)) {
            proprete = "propre";
            System.out.println("L'enclo a été entretenu est maintenant il est propre.");
        } else {
            System.out.println("L'enclo ne peut pas être entretenu car il n'est pas vide ou n'est pas sale.");
        }
    }

    public void afficherDetails() {
        System.out.println("Nom de l'enclo: " + nom);
        System.out.println("Superficie: " + superficie + " m²");
        System.out.println("Capacité maximale: " + capaciteMax);
        System.out.println("Nombre de créature présente: " + creatures.size());
        System.out.println("Propreté: " + proprete);
        System.out.println("Détail des créature:");
        for (Creature creature : creatures) {
            System.out.println(creature.getNomEspece() + " - Age: " + creature.getAge() + " ans");
        }
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
