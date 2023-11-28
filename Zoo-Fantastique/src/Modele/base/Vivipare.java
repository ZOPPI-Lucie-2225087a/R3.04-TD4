package Base;

public abstract class Vivipare extends Creature {
    public Vivipare(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    public abstract Creature mettreBas();
}
