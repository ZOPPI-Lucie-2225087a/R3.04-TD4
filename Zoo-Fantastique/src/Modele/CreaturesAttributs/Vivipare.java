package CreaturesAttributs;

import Base.Creature;

public abstract class Vivipare extends Creature {

    public abstract Vivipare creerNouveau(char sexe, double poids, double taille, int age, int indicateurFaim,
            boolean dort, int indicateurSante);

    public Vivipare(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    public Creature mettreBas() {
        if (this.getSexe() == 'F') {
            return creerNouveau('M', this.getPoids(), this.getTaille(), 0, 100, false, 100); //gros bebe garcon
        } else {
            System.out.println("Ne peut pas mettre bas car c'est un mâle.");
            return null;
        }
    }
}
