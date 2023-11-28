package ListeCreatures;

import CreaturesAttributs.Creature;
import CreaturesAttributs.CreatureMarine;
import CreaturesAttributs.CreatureTerrestre;
import CreaturesAttributs.CreatureVolante;
import CreaturesAttributs.Ovipare;

public class Dragon extends Ovipare implements CreatureMarine, CreatureVolante, CreatureTerrestre {
    public Dragon(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /*
     * marche pas a finir et a mettre dans les autre creature peut etre pas sur
     * 
     * @Override
     * public Creature Pondre() {
     * if (this.sexe == 'F') {
     * return new Dragon(this.nomEspece, 'M', this.poids, this.taille, 0, 100,
     * false, 100);
     * } else {
     * System.out.println("ne peut pas pondre car c'est un male.");
     * return null;
     * }
     * }
     */
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
}
