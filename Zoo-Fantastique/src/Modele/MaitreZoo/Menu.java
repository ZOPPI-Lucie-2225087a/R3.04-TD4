package MaitreZoo;

import java.util.List;
import java.util.Scanner;

import Base.Creature;
import Base.Enclos;
import Habitat.*;

public class Menu {
    private MaitreZoo maitreZoo;
    private Scanner scanner;
    private List<Enclos> listeDesEnclos;

    public Menu(MaitreZoo maitreZoo, List<Enclos> listeDesEnclos) {
        this.maitreZoo = maitreZoo;
        this.scanner = new Scanner(System.in);
        this.listeDesEnclos = listeDesEnclos;
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

    public boolean peutEtreTransfere(Enclos enclos) {
        if (this.peutVoler() && enclos instanceof Voliere) {
            return true;
        }
        if (this.peutCourir() && enclos instanceof Standard) {
            return true;
        }
        if (this.peutNager() && enclos instanceof Aquarium) {
            return true;
        }
        return false;
    }

    public void afficherMenu() {
        int choix;

        do {
            System.out.println("1. Examiner un enclos");
            System.out.println("2. Nettoyer un enclos");
            System.out.println("3. Nourrir les créatures d'un enclos");
            System.out.println("4. Transférer une créature d'un enclos à un autre");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le nom de l'enclos à examiner : ");
                    String nomEnclosExaminer = scanner.next();
                    Enclos enclosExaminer = trouverEnclosParNom(nomEnclosExaminer);
                    if (enclosExaminer != null) {
                        maitreZoo.examinerEnclos(enclosExaminer);
                    } else {
                        System.out.println("Aucun enclos trouvé avec ce nom.");
                    }
                    break;
                case 2:
                    System.out.print("Entrez le nom de l'enclos à nettoyer : ");
                    String nomEnclosNettoyer = scanner.next();
                    Enclos enclosNettoyer = trouverEnclosParNom(nomEnclosNettoyer);
                    if (enclosNettoyer != null) {
                        maitreZoo.nettoyerEnclos(enclosNettoyer);
                    } else {
                        System.out.println("Aucun enclos trouvé avec ce nom.");
                    }
                    break;
                case 3:
                    System.out.print("Entrez le nom de l'enclos dont vous voulez nourrir les créatures : ");
                    String nomEnclosNourrir = scanner.next();
                    Enclos enclosNourrir = trouverEnclosParNom(nomEnclosNourrir);
                    if (enclosNourrir != null) {
                        maitreZoo.nourrirCreatures(enclosNourrir);
                    } else {
                        System.out.println("Aucun enclos trouvé avec ce nom.");
                    }
                    break;
                case 4:
                    System.out.print("Entrez le nom de la créature à transférer : ");
                    String nomCreatureTransferer = scanner.next();
                    Creature creatureTransferer = trouverCreatureParNom(nomCreatureTransferer);
                    if (creatureTransferer != null) {
                        System.out.print("Entrez le nom de l'enclos de destination : ");
                        String nomEnclosDestination = scanner.next();
                        Enclos enclosDestination = trouverEnclosParNom(nomEnclosDestination);
                        if (enclosDestination != null) {
                            Enclos enclosSource = trouverEnclosParEspece(nomCreatureTransferer);
                            maitreZoo.transfererCreature(creatureTransferer, enclosSource, enclosDestination);
                        } else {
                            System.out.println("Aucun enclos de destination trouvé avec ce nom.");
                        }
                    } else {
                        System.out.println("Aucune créature trouvée avec ce nom.");
                    }
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option non reconnue. Veuillez choisir une option valide.");
                    break;
            }
        } while (choix != 5);
    }
}
