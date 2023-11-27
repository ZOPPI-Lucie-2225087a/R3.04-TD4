package base;
import base.Creature;


public abstract class Ovipare extends Creature {
    public Ovipare(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }
    /* marche pas encore a finir
    @Override
    public Creature Pondre() {
        if (this.sexe == 'F') {
            return new Ovipare(this.nomEspece, 'M', this.poids, this.taille, 0, 100, false, 100);
        } else {
            System.out.println("ne peut pas pondre car c'est un male.");
            return null;
        }
    }
    */
}
