package MaitreZoo;

import Base.Creature;
import Base.Enclos;
import Habitat.EtatsEnclosVue;

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
        System.out.println(EtatsEnclosVue.getEnclosGraphic());
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
        if (creature == null) {
            System.out.println("La créature est null.");
            return;
        }
        if (enclosSource == null) {
            System.out.println("L'enclos source est null.");
            return;
        }
        if (enclosDestination == null) {
            System.out.println("L'enclos de destination est null.");
            return;
        }
        if (enclosSource.getCreatures().contains(creature)
                && enclosDestination.getNombreCreatures() < enclosDestination.getCapaciteMax()) {
            enclosSource.enleverCreature(creature);
            enclosDestination.ajouterCreature(creature);
            System.out.println("La créature a été transférée de " + enclosSource.getNom() + " à "
                    + enclosDestination.getNom() + ".");
        } else {
            System.out.println("Le transfert de la créature n'est pas possible.");
        }
    }

}