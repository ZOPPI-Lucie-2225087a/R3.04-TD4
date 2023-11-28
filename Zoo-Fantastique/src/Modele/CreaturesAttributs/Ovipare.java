package CreaturesAttributs;

import ListeCreatures.Phoenix;

public abstract class Ovipare extends Creature {

    public abstract Ovipare creerNouveau(char sexe, double poids, double taille, int age, int indicateurFaim,
            boolean dort, int indicateurSante);

    public Ovipare(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    public Creature Pondre() {
        if (this.getSexe() == 'F') {
            return creerNouveau('M', this.getPoids(), this.getTaille(), 0, 100, false, 100);
        } else {
            System.out.println("ne peut pas pondre car c'est un male.");
            return null;
        }
    }

}
