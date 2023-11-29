package ListeCreatures;

import CreaturesAttributs.Creature;
import Interface.CreatureTerrestre;
import CreaturesAttributs.Vivipare;

public class Nymphe extends Vivipare implements CreatureTerrestre {

    public Nymphe(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Vivipare creerNouveau(char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        return new Nymphe("Nymphe", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Creature mettreBas() {
        return null;
    }

    @Override
    public void Courir() {
        System.out.println("La nymphe court légérement");
    }

    public void renaître() {
        this.setAge(0);
        this.setIndicateurFaim(100);
        this.setDort(false);
        this.setIndicateurSante(100);
        System.out.println("La créature renait");
    }
}
