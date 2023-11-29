package ListeCreatures;

import CreaturesAttributs.Creature;
import Interface.CreatureTerrestre;
import CreaturesAttributs.Vivipare;

public class Lycanthrope extends Vivipare implements CreatureTerrestre {

    public Lycanthrope(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim,
            boolean dort, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Lycanthrope creerNouveau(char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        return new Lycanthrope("Lycanthrope", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Creature mettreBas() {
        // ajouter spec
        return null;
    }

    @Override
    public void Courir() {
        System.out.println("Le lycanthrope court rapidement !");
    }
}
