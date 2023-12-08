package MaitreZoo;

import java.util.Scanner;

import Base.Creature;
import Base.Enclos;
import Habitat.EtatsEnclosVue;

/**
 * La classe MaitreZoo représente un maître de zoo qui peut effectuer
 * différentes actions liées à la gestion des créatures
 * et des enclos dans le zoo fantastique.
 */
public class MaitreZoo {
    private String nom;
    private char sexe;
    private int age;

    /**
     * Constructeur de la classe MaitreZoo.
     *
     * @param nom  Le nom du maître de zoo.
     * @param sexe Le sexe du maître de zoo.
     * @param age  L'âge du maître de zoo.
     */
    public MaitreZoo(String nom, char sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    /**
     * Obtient le nom du maître de zoo.
     *
     * @return Le nom du maître de zoo.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du maître de zoo.
     *
     * @param nom Le nouveau nom du maître de zoo.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le sexe du maître de zoo.
     *
     * @return Le sexe du maître de zoo.
     */
    public char getSexe() {
        return sexe;
    }

    /**
     * Définit le sexe du maître de zoo.
     *
     * @param sexe Le nouveau sexe du maître de zoo.
     */
    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    /**
     * Obtient l'âge du maître de zoo.
     *
     * @return L'âge du maître de zoo.
     */
    public int getAge() {
        return age;
    }

    /**
     * Définit l'âge du maître de zoo.
     *
     * @param age Le nouvel âge du maître de zoo.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Examine un enclos et affiche ses états à l'aide d'une vue spécifique à un
     * habitat.
     *
     * @param enclos  L'enclos à examiner.
     * @param habitat Le type d'habitat de l'enclos.
     */
    public void examinerEnclos(Enclos enclos, String habitat) {
        System.out.println("Examen de l'enclos : " + enclos.getNom());
        EtatsEnclosVue vue = new EtatsEnclosVue(enclos, habitat);
        System.out.println(vue.getENCLOSAVECCREATURES());
    }

    /**
     * Nettoie un enclos en le rendant complètement propre.
     *
     * @param enclos L'enclos à nettoyer.
     */
    public void nettoyerEnclos(Enclos enclos) {
        enclos.setProprete(100.0);
        enclos.entretenir();
    }

    /**
     * Soigne une créature en restaurant son indicateur de santé.
     *
     * @param creature La créature à soigner.
     */
    public void soignerCreature(Creature creature) {
        creature.etreSoigne();
    }

    /**
     * Nourrit toutes les créatures d'un enclos.
     *
     * @param enclos L'enclos dont les créatures doivent être nourries.
     */
    public void nourrirCreatures(Enclos enclos) {
        for (Creature creature : enclos.getCreatures()) {
            creature.manger();
        }
        System.out.println("Les créatures de l'enclos " + enclos.getNom() + " ont été nourries.");
    }

    /**
     * Transfère une créature d'un enclos source à un enclos de destination.
     *
     * @param creature          La créature à transférer.
     * @param enclosSource      L'enclos source de la créature.
     * @param enclosDestination L'enclos de destination pour la créature.
     */
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