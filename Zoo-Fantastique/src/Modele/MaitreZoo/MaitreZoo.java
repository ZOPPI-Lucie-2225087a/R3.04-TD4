package MaitreZoo;

import Base.Creature;
import Base.Enclos;

public class MaitreZoo {
    private String nom;
    private char sexe;
    private int age;

    public MaitreZoo(String nom, char sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public char getSexe() {
        return sexe;
    }
    
    public void setSexe(char sexe) {
        this.sexe = sexe;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public void examinerEnclos(Enclos enclos) {
        System.out.println("Examen de l'enclos : " + enclos.getNom());
        System.out.println(enclos.toString());
    }

    public void nettoyerEnclos(Enclos enclos) {
        enclos.setProprete("propre");
        System.out.println("L'enclos " + enclos.getNom() + " a été nettoyé.");
    }

    public void nourrirCreatures(Enclos enclos) {
        for (Creature creature : enclos.getCreatures()) {
            creature.manger();
        }
        System.out.println("Les créatures de l'enclos " + enclos.getNom() + " ont été nourries.");
    }

    public void transfererCreature(Creature creature, Enclos enclosSource, Enclos enclosDestination) {
        if (enclosSource.getCreatures().contains(creature) && enclosDestination.getNombreCreatures() < enclosDestination.getCapaciteMax()) {
            enclosSource.enleverCreature(creature);
            enclosDestination.ajouterCreature(creature);
            System.out.println("La créature a été transférée de " + enclosSource.getNom() + " à " + enclosDestination.getNom() + ".");
        } else {
            System.out.println("Le transfert de la créature n'est pas possible.");
        }
    }

}


/*
MaitreZoo maitreZoo = new MaitreZoo("Léo Oger", 'M', 19);

        Scanner scanner = new Scanner(System.in);
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
                    maitreZoo.examinerEnclos();
        break;
        case 2:
        maitreZoo.nettoyerEnclos();
        break;
        case 3:
        maitreZoo.nourrirCreatures();
        break;
        case 4:
        // Vous devez ajouter le code pour gérer le transfert d'une créature
        break;
        case 5:
        System.out.println("Au revoir !");
        break;
default:
        System.out.println("Option non reconnue. Veuillez choisir une option valide.");
        break;
        }
        } while (choix != 5);

        scanner.close();
        }
 */