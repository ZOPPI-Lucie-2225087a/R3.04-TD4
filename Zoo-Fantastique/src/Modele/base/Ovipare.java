package base;

public abstract class Ovipare extends Creature{
    public Ovipare(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    public abstract Creature Pondre();
}
