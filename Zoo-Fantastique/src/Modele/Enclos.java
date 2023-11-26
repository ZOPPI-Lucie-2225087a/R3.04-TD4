package Modele;

import java.util.ArrayList;

public class Enclos {
    private String nom;
    private double superficie;
    private int capaciteMax;
    private ArrayList<Creature> creatures;
    private String proprete;

    public Enclos(String nom, double superficie, int capaciteMax) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.creatures = new ArrayList<>();
        this.proprete = "propre";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public String getProprete() {
        return proprete;
    }

    public void setProprete(String proprete) {
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

    public void afficherDetails() {
        System.out.println("Nom de l'enclo: " + nom);
        System.out.println("Superficie: " + superficie + " m2");
        System.out.println("Capacité maximale: " + capaciteMax);
        System.out.println("Nombre de créature présente: " + creatures.size());
        System.out.println("Propreté: " + proprete);
        System.out.println("Détail des créature:");
        for (Creature creature : creatures) {
            System.out.println(creature.getNomEspece() + " - Age: " + creature.getAge() + " ans");
        }
    }
}
