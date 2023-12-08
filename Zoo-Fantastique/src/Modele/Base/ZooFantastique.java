package Base;

import java.util.List;
import java.util.Scanner;
import Controller.MaitreZoo.Menu;
import MaitreZoo.MaitreZoo;

import Base.ZooFantastique;

/**
 * La classe ZooFantastique représente un zoo fantastique qui peut être géré par
 * un utilisateur (MaitreZoo).
 * Elle permet d'afficher des informations sur les créatures et les enclos,
 * ainsi que de gérer le zoo en utilisant un menu.
 */
public class ZooFantastique {
    private String nom;
    private MaitreZoo maitre;
    private int maxEnclos;
    private List<Enclos> enclosList;
    private GestionnaireEnclos gestionnaireEnclos;

    private Menu menu;

    /**
     * Constructeur de la classe ZooFantastique.
     *
     * @param nom                Le nom du zoo.
     * @param maitre             Le MaitreZoo qui gère le zoo.
     * @param maxEnclos          Le nombre maximal d'enclos dans le zoo.
     * @param gestionnaireEnclos Le gestionnaire des enclos du zoo.
     */
    public ZooFantastique(String nom, MaitreZoo maitre, int maxEnclos, GestionnaireEnclos gestionnaireEnclos) {
        this.nom = nom;
        this.maitre = maitre;
        this.maxEnclos = maxEnclos;
        this.gestionnaireEnclos = gestionnaireEnclos;
        this.maitre = maitre;
        this.menu = new Menu(maitre, gestionnaireEnclos);
    }

    /**
     * Affiche le nombre total de créatures dans tous les enclos du zoo.
     */
    public void afficherNombreCreatures() {
        int total = 0;
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            total += enclos.getNombreCreatures();
        }
        System.out.println("Nombre total de créatures : " + total);
    }

    /**
     * Affiche les créatures de tous les enclos du zoo.
     */
    public void afficherCreaturesEnclos() {
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            System.out.println("Enclos : " + enclos.getNom());
            for (Creature creature : enclos.getCreatures()) {
                System.out.println("Creature : " + creature.getNom());
            }
        }
    }

    /**
     * Permet de gérer le zoo en affichant un menu interactif.
     */
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
                    this.menu.afficherMenu();
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