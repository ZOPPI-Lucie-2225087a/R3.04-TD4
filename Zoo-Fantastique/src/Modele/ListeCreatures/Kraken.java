package ListeCreatures;

import Interface.CreatureMarine;
import CreaturesAttributs.Ovipare;

/**
 * La classe Kraken permet de gérer le comportement des Kraken.
*/
public class Kraken extends Ovipare implements CreatureMarine {
    
    /**
     * Constructeur pour créer un nouveau Kraken.
     *
     * @param nomEspece       Nom de l'espèce du Kraken.
     * @param nom             Nom du Kraken.
     * @param sexe            Sexe du Kraken.
     * @param poids           Poids du Kraken.
     * @param taille          Taille du Kraken.
     * @param age             Âge du Kraken.
     * @param indicateurFaim  Indicateur de faim du Kraken.
     * @param dort            État de sommeil du Kraken.
     * @param indicateurSante Indicateur de santé du Kraken.
    */
    public Kraken(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Crée un nouveau Kraken.
     *
     * @return Un nouvel objet Kraken.
    */
    @Override
    public Kraken creerNouveau(String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        return new Kraken(this.getNomEspece(), "bébé", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Permet au Kraken de nager.
    */
    @Override
    public void Nager() {
        System.out.println("Le kraken nage");
    }
}
