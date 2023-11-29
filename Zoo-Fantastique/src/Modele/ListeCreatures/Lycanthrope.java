package ListeCreatures;

import Base.Creature;
import Interface.CreatureTerrestre;
import CreaturesAttributs.Vivipare;

public class Lycanthrope extends Vivipare implements CreatureTerrestre {

    public Lycanthrope(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim,
            boolean dort, int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Lycanthrope creerNouveau(String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        return new Lycanthrope(this.getNomEspece(),"bébé", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
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
