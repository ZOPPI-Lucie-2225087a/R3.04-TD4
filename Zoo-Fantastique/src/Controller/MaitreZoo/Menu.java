package Controller.MaitreZoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Base.Creature;
import Base.Enclos;
import Base.GestionnaireEnclos;
import Habitat.*;
import Interface.*;
import MaitreZoo.MaitreZoo;

/**
 * La classe Menu représente le menu interactif du Maître de Zoo, offrant des
 * options
 * pour examiner, nettoyer, nourrir, transférer, reproduire et soigner les
 * créatures du zoo.
 */
public class Menu {
    private MaitreZoo maitreZoo;
    private Scanner scanner;
    private GestionnaireEnclos gestionnaireEnclos;

    /**
     * Constructeur de la classe Menu.
     *
     * @param maitreZoo          L'instance du Maître de Zoo associée au menu.
     * @param gestionnaireEnclos Le gestionnaire d'enclos utilisé pour gérer les
     *                           enclos du zoo.
     */
    public Menu(MaitreZoo maitreZoo, GestionnaireEnclos gestionnaireEnclos) {
        this.maitreZoo = maitreZoo;
        this.scanner = new Scanner(System.in);
        this.gestionnaireEnclos = gestionnaireEnclos;
    }

    /**
     * Affiche les noms des enclos disponibles.
     */
    public void afficherNomsEnclos() {
        for (int i = 0; i < gestionnaireEnclos.getListeDesEnclos().size(); i++) {
            System.out.println((i + 1) + ". " + gestionnaireEnclos.getListeDesEnclos().get(i).getNom());
        }
    }

    /**
     * Affiche les enclos vides et sales qui nécessitent un nettoyage.
     *
     * @return True si des enclos nécessitent un nettoyage, sinon False.
     */
    public boolean afficherEnclosVidesEtSales() {
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            if (enclos.getNombreCreatures() == 0 && enclos.getProprete() < 50) {
                System.out.println(enclos.getNom());
                return true;
            }
        }
        return false;
    }

    /**
     * Retourne l'enclos correspondant au numéro spécifié.
     *
     * @param numero Le numéro de l'enclos à rechercher.
     * @return L'enclos correspondant au numéro, ou null s'il n'est pas trouvé.
     */
    public Enclos trouverEnclosParNumero(int numero) {
        return gestionnaireEnclos.getListeDesEnclos().get(numero - 1);
    }

    /**
     * Affiche les noms des créatures disponibles dans tous les enclos du zoo.
     */
    public void afficherNomsCreatures() {
        System.out.print("Créatures disponibles : \n");
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            for (Creature creature : enclos.getCreatures()) {
                System.out.print("-" + creature.getNom() + "\n");
            }
        }
    }

    /**
     * Affiche les noms des créatures disponibles dans un enclos spécifié.
     *
     * @param enclos L'enclos pour lequel afficher les noms des créatures.
     */
    public void afficherNomsCreaturesParEnclos(Enclos enclos) {
        System.out.print("Créatures disponibles : \n");
        for (Creature creature : enclos.getCreatures()) {
            System.out.print("-" + creature.getNom() + "\n");
        }
    }

    /**
     * Retourne l'enclos correspondant au nom spécifié (ignorant la casse).
     *
     * @param nomEnclos Le nom de l'enclos à rechercher.
     * @return L'enclos correspondant au nom, ou null s'il n'est pas trouvé.
     */
    private Enclos trouverEnclosParNom(String nomEnclos) {
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            if (enclos.getNom().toLowerCase().equals(nomEnclos.toLowerCase())) {
                return enclos;
            }
        }
        return null;
    }

    /**
     * Retourne la créature correspondant au nom spécifié (ignorant la casse).
     *
     * @param nomCreature Le nom de la créature à rechercher.
     * @return La créature correspondant au nom, ou null si elle n'est pas trouvée.
     */
    public Creature trouverCreatureParNom(String nomCreature) {
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            for (Creature creature : enclos.getCreatures()) {
                if (creature.getNom().toLowerCase().equals(nomCreature.toLowerCase())) {
                    return creature;
                }
            }
        }
        return null;
    }

    /**
     * Retourne l'enclos contenant une créature de l'espèce spécifiée (ignorant la
     * casse).
     *
     * @param espece Le nom de l'espèce de la créature recherchée.
     * @return L'enclos contenant une créature de l'espèce, ou null s'il n'est pas
     *         trouvé.
     */
    public Enclos trouverEnclosParEspece(String espece) {
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            for (Creature creature : enclos.getCreatures()) {
                if (creature.getNomEspece().toLowerCase().equals(espece.toLowerCase())) {
                    return enclos;
                }
            }
        }
        return null;
    }

    /**
     * Vérifie si une créature peut être transférée vers un certain type d'enclos.
     *
     * @param creature La créature à transférer.
     * @param enclos   L'enclos de destination.
     * @return True si la créature peut être transférée, sinon False.
     */
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

    /**
     * Retourne la liste des types d'enclos disponibles pour une certaine créature.
     *
     * @param creature La créature pour laquelle obtenir les types d'enclos
     *                 disponibles.
     * @return La liste des types d'enclos disponibles.
     */
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

    /**
     * Retourne l'enclos contenant une créature de l'espèce spécifiée et du type
     * spécifié.
     *
     * @param espece Le nom de l'espèce de la créature recherchée.
     * @param type   Le type d'enclos recherché.
     * @return L'enclos contenant une créature de l'espèce et du type, ou null s'il
     *         n'est pas trouvé.
     */
    public Enclos trouverEnclosParEspeceEtType(String espece, String type) {
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            if (enclos.getNom().equals(espece) && enclos.getClass().getSimpleName().equals(type)) {
                return enclos;
            }
        }
        return null;
    }

    /**
     * Vérifie l'existence d'au moins une créature malade dans le zoo.
     *
     * @return True s'il existe une créature malade, sinon False.
     */
    public boolean existeCreatureMalade() {
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            for (Creature creature : enclos.getCreatures()) {
                if (creature.getmalade()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Affiche les noms des créatures malades dans le zoo.
     */
    public void afficherNomsCreaturesMalades() {
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            for (Creature creature : enclos.getCreatures()) {
                if (creature.getmalade()) {
                    System.out.println("-" + creature.getNom());
                }
            }
        }
    }

    /**
     * Affiche le menu principal et permet à l'utilisateur d'interagir avec le
     * programme.
     */
    public void afficherMenu() {
        int choix;

        do {
            System.out.println("1. Examiner un enclos");
            System.out.println("2. Nettoyer un enclos");
            System.out.println("3. Nourrir les créatures d'un enclos");
            System.out.println("4. Transférer une créature d'un enclos à un autre");
            System.out.println("5. Faire reproduire des créatures");
            System.out.println("6. Soigner les créatures malades");
            System.out.println("99. Quitter");
            System.out.print("Choisissez une option : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ce n'est pas un numéro valide. Essayez encore.");
                scanner.next();
            }
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le numéro de l'enclos à examiner parmi la liste suivante : \n");
                    afficherNomsEnclos();
                    int numeroEnclosExaminer = -1;
                    int attempts = 0;
                    do {
                        if (scanner.hasNextInt()) {
                            numeroEnclosExaminer = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Ce n'est pas un numéro valide. Essayez encore.");
                            scanner.next();
                            attempts++;
                        }
                    } while (attempts < 3);
                    if (attempts == 3) {
                        System.out.println("Nombre maximum de tentatives atteint.");
                        break;
                    }
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
                        System.out.print("Entrez le nom de l'enclos à nettoyer parmi la liste suivante : ");
                        String nomEnclosNettoyer = "";
                        attempts = 0;
                        do {
                            if (scanner.hasNext()) {
                                nomEnclosNettoyer = scanner.next();
                                break;
                            } else {
                                System.out.println("Ce n'est pas un nom valide. Essayez encore.");
                                scanner.next();
                                attempts++;
                            }
                        } while (attempts < 3);
                        if (attempts == 3) {
                            System.out.println("Nombre maximum de tentatives atteint.");
                            break;
                        }
                        Enclos enclosNettoyer = trouverEnclosParNom(nomEnclosNettoyer);
                        if (enclosNettoyer.getProprete() < 50.0) {
                            maitreZoo.nettoyerEnclos(enclosNettoyer);
                        } else {
                            System.out.println("Cet enclos ne peut pas être nettoyé car pas assez sale.");
                        }
                    } else {
                        System.out.println("Aucun enclos n'a besoin d'être nettoyé ou ne peut être nettoyé.");
                    }
                    break;

                case 3:
                    System.out.print(
                            "Entrez le numéro de l'enclos dont vous voulez nourrir les créatures parmis la liste suivante : ");
                    afficherNomsEnclos();
                    int numeroEnclosNourrir = -1;
                    attempts = 0;
                    do {
                        if (scanner.hasNextInt()) {
                            numeroEnclosNourrir = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Ce n'est pas un numéro valide. Essayez encore.");
                            scanner.next();
                            attempts++;
                        }
                    } while (attempts < 3);
                    if (attempts == 3) {
                        System.out.println("Nombre maximum de tentatives atteint.");
                        break;
                    }
                    Enclos enclosNourrir = trouverEnclosParNumero(numeroEnclosNourrir);
                    if (enclosNourrir != null) {
                        maitreZoo.nourrirCreatures(enclosNourrir);
                    } else {
                        System.out.println("Aucun enclos trouvé avec ce nom.");
                    }
                    break;

                case 4:
                    System.out.print("Entrez le nom de la créature à transférer parmis la liste suivante : ");
                    afficherNomsCreatures();
                    String nomCreatureTransferer = "";
                    attempts = 0;
                    do {
                        if (scanner.hasNext()) {
                            nomCreatureTransferer = scanner.next();
                            break;
                        } else {
                            System.out.println("Ce n'est pas un nom valide. Essayez encore.");
                            scanner.next();
                            attempts++;
                        }
                    } while (attempts < 3);
                    if (attempts == 3) {
                        System.out.println("Nombre maximum de tentatives atteint.");
                        break;
                    }
                    Creature creatureTransferer = trouverCreatureParNom(nomCreatureTransferer);
                    if (creatureTransferer != null) {
                        List<String> enclosDisponibles = enclosDisponibles(creatureTransferer);
                        System.out.println("Enclos disponibles : " + enclosDisponibles);
                        System.out.print("Entrez le type de l'enclos de destination : ");
                        String typeEnclosDestination = "";
                        attempts = 0;
                        do {
                            if (scanner.hasNext() && enclosDisponibles.contains(scanner.next())) {
                                typeEnclosDestination = scanner.next();
                                break;
                            } else {
                                System.out.println("Ce n'est pas un type d'enclos valide. Essayez encore.");
                                scanner.next();
                                attempts++;
                            }
                        } while (attempts < 3);
                        if (attempts == 3) {
                            System.out.println("Nombre maximum de tentatives atteint.");
                            break;
                        }

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
                                gestionnaireEnclos.getListeDesEnclos().add(enclosDestination);
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

                case 5:
                    System.out.println("Dans quel enclos voulez-vous reproduire 2 créatures ?");
                    afficherNomsEnclos();
                    int numEnclos = -1;
                    attempts = 0;
                    do {
                        if (scanner.hasNextInt()) {
                            numEnclos = scanner.nextInt();
                            scanner.nextLine();
                            if (numEnclos >= 0 && numEnclos < gestionnaireEnclos.getListeDesEnclos().size()) {
                                break;
                            } else {
                                System.out.println("Numéro d'enclos invalide. Essayez encore.");
                                attempts++;
                            }
                        } else {
                            System.out.println("Ce n'est pas un numéro valide. Essayez encore.");
                            scanner.next();
                            attempts++;
                        }
                    } while (attempts < 3);
                    if (attempts == 3) {
                        System.out.println("Nombre maximum de tentatives atteint.");
                        break;
                    }

                    Enclos enclos = trouverEnclosParNumero(numEnclos);

                    if (enclos.getCreatures().size() == 1) {
                        System.out.println(
                                "Il n'y a qu'une seule créature dans l'enclos, la reproduction n'est pas possible.");
                        break;
                    }

                    afficherNomsCreaturesParEnclos(enclos);

                    System.out.println("Entrez le nom de la première créature :");
                    String nomCreature1 = scanner.nextLine();
                    Creature creature1 = trouverCreatureParNom(nomCreature1);

                    System.out.println("Entrez le nom de la deuxième créature :");
                    String nomCreature2 = scanner.nextLine();
                    Creature creature2 = trouverCreatureParNom(nomCreature2);

                    if (creature1 == null || creature2 == null) {
                        System.out.println("Une ou les deux créatures n'ont pas été trouvées.");
                    } else if (creature1.getSexe() == creature2.getSexe()) {
                        System.out.println("Les deux créatures sont du même sexe, elles ne peuvent pas se reproduire.");
                    } else {
                        if (creature1.getSexe() == 'F') {
                            creature1.Reproduction(gestionnaireEnclos);
                        } else {
                            creature2.Reproduction(gestionnaireEnclos);
                        }
                    }
                    break;

                case 6:
                    boolean creatureMaladeExist = existeCreatureMalade();
                    if (creatureMaladeExist) {
                        System.out.print("Entrez le nom de la créature à soigner parmi la liste suivante : ");
                        afficherNomsCreaturesMalades();
                        String nomCreatureSoigner = "";
                        attempts = 0;
                        do {
                            if (scanner.hasNext()) {
                                nomCreatureSoigner = scanner.next();
                                break;
                            } else {
                                System.out.println("Ce n'est pas un nom valide. Essayez encore.");
                                scanner.next();
                                attempts++;
                            }
                        } while (attempts < 3);
                        if (attempts == 3) {
                            System.out.println("Nombre maximum de tentatives atteint.");
                            break;
                        }
                        Creature creatureSoigner = trouverCreatureParNom(nomCreatureSoigner);
                        if (creatureSoigner != null && creatureSoigner.getmalade()) {
                            maitreZoo.soignerCreature(creatureSoigner);
                        } else {
                            System.out.println("Aucune créature malade trouvée avec ce nom.");
                        }
                    } else {
                        System.out.println("Il n'y a pas de créatures malades à soigner.");
                    }
                    break;

                case 99:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Option non reconnue. Veuillez choisir une option valide.");
                    break;
            }
        } while (choix != 99);
    }

    /**
     * Ferme le scanner utilisé pour les entrées utilisateur.
     */
    public void fermer() {
        scanner.close();
    }
}
