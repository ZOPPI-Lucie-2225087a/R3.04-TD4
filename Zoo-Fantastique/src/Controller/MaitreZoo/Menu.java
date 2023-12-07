package Controller.MaitreZoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Base.Creature;
import Base.Enclos;
import Habitat.*;
import Interface.CreatureMarine;
import Interface.CreatureTerrestre;
import Interface.CreatureVolante;
import MaitreZoo.MaitreZoo;

public class Menu {
    private MaitreZoo maitreZoo;
    private Scanner scanner;
    private List<Enclos> listeDesEnclos;

    public Menu(MaitreZoo maitreZoo, List<Enclos> listeDesEnclos) {
        this.maitreZoo = maitreZoo;
        this.scanner = new Scanner(System.in);
        this.listeDesEnclos = listeDesEnclos;
    }

    public void afficherNomsEnclos() {
        for (int i = 0; i < listeDesEnclos.size(); i++) {
            System.out.println((i + 1) + ". " + listeDesEnclos.get(i).getNom());
        }
    }

    public boolean afficherEnclosVidesEtSales() {
        for (Enclos enclos : listeDesEnclos) {
            if (enclos.getNombreCreatures() == 0 && enclos.getProprete() < 50) {
                System.out.println(enclos.getNom());
                return true;
            }
        }
        return false;
    }

    public Enclos trouverEnclosParNumero(int numero) {
        return listeDesEnclos.get(numero - 1);
    }

    public void afficherNomsCreatures() {
        System.out.print("Créatures disponibles : ");
        for (Enclos enclos : listeDesEnclos) {
            for (Creature creature : enclos.getCreatures()) {
                System.out.print(creature.getNom() + " | ");
            }
        }
        System.out.println();
    }

    private Enclos trouverEnclosParNom(String nomEnclos) {
        for (Enclos enclos : listeDesEnclos) {
            if (enclos.getNom().equals(nomEnclos)) {
                return enclos;
            }
        }
        return null;
    }

    public Creature trouverCreatureParNom(String nomCreature) {
        for (Enclos enclos : listeDesEnclos) {
            for (Creature creature : enclos.getCreatures()) {
                if (creature.getNom().equals(nomCreature)) {
                    return creature;
                }
            }
        }
        return null;
    }

    public Enclos trouverEnclosParEspece(String espece) {
        for (Enclos enclos : listeDesEnclos) {
            for (Creature creature : enclos.getCreatures()) {
                if (creature.getNomEspece().equals(espece)) {
                    return enclos;
                }
            }
        }
        return null;
    }

    public boolean peutEtreTransfere(Creature creature, Enclos enclos) {
        if (creature instanceof CreatureVolante && enclos instanceof Voliere) {
            return true;
        }
        if (creature instanceof CreatureTerrestre && enclos instanceof Standard) {
            return true;
        }
        if (creature instanceof CreatureMarine && enclos instanceof Aquarium) {
            return true;
        }
        return false;
    }

    public List<String> enclosDisponibles(Creature creature) {
        List<String> enclos = new ArrayList<>();
        if (creature instanceof CreatureVolante) {
            enclos.add("Voliere");
        }
        if (creature instanceof CreatureTerrestre) {
            enclos.add("Standard");
        }
        if (creature instanceof CreatureMarine) {
            enclos.add("Aquarium");
        }
        return enclos;
    }

    public Enclos trouverEnclosParEspeceEtType(String espece, String type) {
        for (Enclos enclos : listeDesEnclos) {
            if (enclos.getNom().equals(espece) && enclos.getClass().getSimpleName().equals(type)) {
                return enclos;
            }
        }
        return null;
    }

    public void afficherMenu() {
        int choix;

        do {
            System.out.println("1. Examiner un enclos");
            System.out.println("2. Nettoyer un enclos");
            System.out.println("3. Nourrir les créatures d'un enclos");
            System.out.println("4. Transférer une créature d'un enclos à un autre");
            System.out.println("99. Quitter");
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le numéro de l'enclos à examiner parmi la liste suivante : \n");
                    afficherNomsEnclos();
                    int numeroEnclosExaminer = scanner.nextInt();
                    Enclos enclosExaminer = trouverEnclosParNumero(numeroEnclosExaminer);
                    if (enclosExaminer != null) {
                        maitreZoo.examinerEnclos(enclosExaminer, enclosExaminer.getHabitat());
                        System.out.println(enclosExaminer.toString());
                    } else {
                        System.out.println("Aucun enclos trouvé.");
                    }
                    break;

                case 2:
                    if (afficherEnclosVidesEtSales()) {
                        System.out.print("Entrez le numéro de l'enclos à nettoyer parmi la liste suivante : ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Ce n'est pas un numéro valide. Essayez encore.");
                            scanner.next();
                        }
                        int numeroEnclosNettoyer = scanner.nextInt();
                        Enclos enclosNettoyer = trouverEnclosParNumero(numeroEnclosNettoyer);
                        if (enclosNettoyer != null) {
                            maitreZoo.nettoyerEnclos(enclosNettoyer);
                        } else {
                            System.out.println("Aucun enclos trouvé avec ce numéro.");
                        }
                    } else {
                        System.out.println("Aucun enclos n'a besoin d'être nettoyé ou ne peut être nettoyé.");
                    }
                    break;

                case 3:
                    System.out.print(
                            "Entrez le numéro de l'enclos dont vous voulez nourrir les créatures parmis la liste suivante : ");
                    afficherNomsEnclos();
                    int nomEnclosNourrir = scanner.nextInt();
                    Enclos enclosNourrir = trouverEnclosParNumero(nomEnclosNourrir);
                    if (enclosNourrir != null) {
                        maitreZoo.nourrirCreatures(enclosNourrir);
                    } else {
                        System.out.println("Aucun enclos trouvé avec ce nom.");
                    }
                    break;

                case 4:
                    System.out.print("Entrez le nom de la créature à transférer parmis la liste suivante : ");
                    afficherNomsCreatures();
                    String nomCreatureTransferer = scanner.next();
                    Creature creatureTransferer = trouverCreatureParNom(nomCreatureTransferer);
                    if (creatureTransferer != null) {
                        List<String> enclosDisponibles = enclosDisponibles(creatureTransferer);
                        System.out.println("Enclos disponibles : " + enclosDisponibles);
                        System.out.print("Entrez le type de l'enclos de destination : ");
                        String typeEnclosDestination = scanner.next();
                        if (enclosDisponibles.contains(typeEnclosDestination)) {
                            String nomEnclos = typeEnclosDestination.toLowerCase() + creatureTransferer.getNomEspece();
                            Enclos enclosDestination = trouverEnclosParNom(nomEnclos);
                            if (enclosDestination == null) {

                                if (typeEnclosDestination.equals("Voliere")) {
                                    enclosDestination = new Voliere(("voliere" + creatureTransferer.getNomEspece()),
                                            100, 10, new ArrayList<>(), 100.0, 20);
                                } else if (typeEnclosDestination.equals("Standard")) {
                                    enclosDestination = new Standard(
                                            ("enclosStandard" + creatureTransferer.getNomEspece()), 100, 10,
                                            new ArrayList<>(), 100.0);
                                } else if (typeEnclosDestination.equals("Aquarium")) {
                                    enclosDestination = new Aquarium(("aquarium" + creatureTransferer.getNomEspece()),
                                            100, 10, new ArrayList<>(), 100.0, 200, 1.0);
                                }
                                listeDesEnclos.add(enclosDestination);
                            }
                            Enclos enclosSource = trouverEnclosParEspece(creatureTransferer.getNomEspece());
                            maitreZoo.transfererCreature(creatureTransferer, enclosSource, enclosDestination);
                        } else {
                            System.out.println("La créature ne peut pas être transférée à cet enclos.");
                        }
                    } else {
                        System.out.println("Aucune créature trouvée avec ce nom.");
                    }
                    break;

                case 99:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Option non reconnue. Veuillez choisir une option valide.");
                    break;
            }
        } while (choix != 5);
    }
}
