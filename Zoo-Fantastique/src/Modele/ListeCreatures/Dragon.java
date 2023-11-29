package ListeCreatures;

import Interface.CreatureMarine;
import Interface.CreatureTerrestre;
import Interface.CreatureVolante;
import CreaturesAttributs.Ovipare;

public class Dragon extends Ovipare implements CreatureMarine, CreatureVolante, CreatureTerrestre {
    public Dragon(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Dragon creerNouveau(char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        return new Dragon(this.getNomEspece(), sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public void Nager() {
        System.out.println("Le dragon nage");
    }

    @Override
    public void Courir() {
        System.out.println("Le dragon court");
    }

    @Override
    public void Voler() {
        System.out.println("Le dragon vole");
    }

    public void renaître() {
        this.setAge(0);
        this.setIndicateurFaim(100);
        this.setDort(false);
        this.setIndicateurSante(100);
        System.out.println("La créature renait");
    }
}