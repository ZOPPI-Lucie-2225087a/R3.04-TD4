package Base;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import Controller.MaitreZoo.Menu;
import MaitreZoo.MaitreZoo;
import ListeCreatures.*;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Base.Creature;
import Base.Enclos;
import Base.GestionnaireEnclos;
import Base.SimulerCreature;
import Base.SimulerEnclos;
import Base.ZooFantastique;
import Habitat.*;
import MaitreZoo.*;

public class ZooFantastique {
    private String nom;
    private MaitreZoo maitre;
    private int maxEnclos;
    private List<Enclos> enclosList;
    private GestionnaireEnclos gestionnaireEnclos;

    private Menu menu;
    
    public ZooFantastique(String nom, MaitreZoo maitre, int maxEnclos, GestionnaireEnclos gestionnaireEnclos) {
        this.nom = nom;
        this.maitre = maitre;
        this.maxEnclos = maxEnclos;
        this.gestionnaireEnclos = gestionnaireEnclos;
    }

    public void afficherNombreCreatures() {
        int total = 0;
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            total += enclos.getNombreCreatures();
        }
        System.out.println("Nombre total de créatures : " + total);
    }

    public void afficherCreaturesEnclos() {
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            System.out.println("Enclos : " + enclos.getNom());
            for (Creature creature : enclos.getCreatures()) {
                System.out.println("Creature : " + creature.getNom());
            }
        }
    }

    public ZooFantastique(MaitreZoo maitreZoo, GestionnaireEnclos gestionnaireEnclos) {
        this.menu = new Menu(maitreZoo, gestionnaireEnclos);
    }
    
    public void gererZoo() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("1. Afficher le nombre de créatures");
            System.out.println("2. Afficher les créatures de tous les enclos");
            System.out.println("3. Prendre la main");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ce n'est pas un numéro valide. Essayez encore.");
                scanner.next();
            }
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    afficherNombreCreatures();
                    break;
                case 2:
                    afficherCreaturesEnclos();
                    break;
                case 3:
                    menu.afficherMenu();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option non reconnue. Veuillez choisir une option valide.");
                    break;
            }
        } while (choix != 99);

        scanner.close();
    }
}