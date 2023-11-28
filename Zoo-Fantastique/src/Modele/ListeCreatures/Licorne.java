package ListeCreatures;

import CreaturesAttributs.Creature;
import CreaturesAttributs.CreatureTerrestre;
import CreaturesAttributs.Vivipare;

public class Licorne extends Vivipare implements CreatureTerrestre {

    public Licorne(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Creature mettreBas() {
        return null;
    }

    @Override
    public void Courir() {
        // Implémentation spécifique pour la course de la Licorne
        // Mettez ici le code pour la capacité de course de la Licorne
        System.out.println("La Licorne court gracieusement !");
    }
}
