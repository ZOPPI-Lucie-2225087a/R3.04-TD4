package Base;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import MaitreZoo.MaitreZoo;

public class ZooFantastique {
    private String nom;
    private MaitreZoo maitre;
    private int maxEnclos;
    private List<Enclos> enclosList;

    public ZooFantastique(String nom, MaitreZoo maitre, int maxEnclos) {
        this.nom = nom;
        this.maitre = maitre;
        this.maxEnclos = maxEnclos;
        this.enclosList = new ArrayList<>();
    }

    public void afficherNombreCreatures() {
        int total = 0;
        for (Enclos enclos : enclosList) {
            total += enclos.getNombreCreatures();
        }
        System.out.println("Nombre total de créatures : " + total);
    }

    public void afficherCreaturesEnclos() {
        for (Enclos enclos : enclosList) {
            System.out.println("Enclos : " + enclos.getNom());
            for (Creature creature : enclos.getCreatures()) {
                System.out.println("Creature : " + creature.getNom());
            }
        }
    }
}