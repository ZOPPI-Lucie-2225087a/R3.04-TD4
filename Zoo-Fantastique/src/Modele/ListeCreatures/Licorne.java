package ListeCreatures;

import Base.Creature;
import Interface.CreatureTerrestre;
import CreaturesAttributs.Vivipare;

/**
 * La classe Licorne permet de gérer le comportement des Licorne.
*/
public class Licorne extends Vivipare implements CreatureTerrestre {

    /**
     * Constructeur pour créer une nouvelle Licorne.
     *
     * @param nomEspece       Nom de l'espèce de la Licorne.
     * @param nom             Nom de la Licorne.
     * @param sexe            Sexe de la Licorne.
     * @param poids           Poids de la Licorne.
     * @param taille          Taille de la Licorne.
     * @param age             Âge de la Licorne.
     * @param indicateurFaim  Indicateur de faim de la Licorne.
     * @param dort            État de sommeil de la Licorne.
     * @param indicateurSante Indicateur de santé de la Licorne.
    */
    public Licorne(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Crée une nouvelle Licorne.
     *
     * @return Un nouvel objet Licorne.
    */
    @Override
    public Licorne creerNouveau(String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        return new Licorne(this.getNomEspece(),"bébé", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Permet à la Licorne de courir.
    */
    @Override
    public void Courir() {
        System.out.println("La Licorne court gracieusement !");
    }
}
