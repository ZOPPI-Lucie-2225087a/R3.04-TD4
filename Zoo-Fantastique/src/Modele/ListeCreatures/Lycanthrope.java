package ListeCreatures;

import Base.Creature;
import Interface.CreatureTerrestre;
import CreaturesAttributs.Vivipare;

/**
 * La classe Lycanthrope permet de gérer le comportement des Lycanthrope.
*/
public class Lycanthrope extends Vivipare implements CreatureTerrestre {

    /**
     * Constructeur pour créer un nouveau Lycanthrope.
     *
     * @param nomEspece       Nom de l'espèce du Lycanthrope.
     * @param nom             Nom du Lycanthrope.
     * @param sexe            Sexe du Lycanthrope.
     * @param poids           Poids du Lycanthrope.
     * @param taille          Taille du Lycanthrope.
     * @param age             Âge du Lycanthrope.
     * @param indicateurFaim  Indicateur de faim du Lycanthrope.
     * @param dort            État de sommeil du Lycanthrope.
     * @param indicateurSante Indicateur de santé du Lycanthrope.
    */
    public Lycanthrope(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim,
            boolean dort, int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Crée un nouveau Lycanthrope.
     *
     * @return Un nouvel objet Lycanthrope.
    */
    @Override
    public Lycanthrope creerNouveau(String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        return new Lycanthrope(this.getNomEspece(),"bébé", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Permet au Lycanthrope de courir.
    */
    @Override
    public void Courir() {
        System.out.println("Le lycanthrope court rapidement !");
    }
}
