import CreaturesAttributs.Creature;
import Habitat.Enclos;

public class MaitreZoo {
    private String nom;
    private char sexe;
    private int age;

    public MaitreZoo(String nom, char sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    public char getSexe() {
        return sexe;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public void examinerEnclos(Enclos enclos) {
        System.out.println(enclos.toString());
    }

    public void nettoyerEnclos(Enclos enclos) {
        enclos.entretenir();
    }

    public void nourrirCreatures(Enclos enclos) {
        for (Creature creature : enclos.getCreatures()) {
            creature.manger();
        }
    }

    public void transfererCreature(Creature creature, Enclos enclosSource, Enclos enclosDestination) {
        enclosSource.enleverCreature(creature);
        enclosDestination.ajouterCreature(creature);
    }
}