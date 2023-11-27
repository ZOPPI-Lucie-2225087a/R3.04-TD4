package base;

public class Voliéres extends Enclos {
    private int hauteur;

    public Voliéres (int hauteur) {
        this.hauteur = hauteur;
    }

    @Override
    public void entretenir() {
        super.entretenir();
        System.out.println("Vérification du toi effectué.");
    }
}

