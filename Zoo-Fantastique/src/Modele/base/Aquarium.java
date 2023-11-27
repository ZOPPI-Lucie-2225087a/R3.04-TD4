package base;
import base.Enclos;

public class Aquarium extends Enclos {
    private int profondeur;
    private double salinite;

    public Aquarium(int profondeur, double salinite) {
        this.profondeur = profondeur;
        this.salinite = salinite;
    }
}