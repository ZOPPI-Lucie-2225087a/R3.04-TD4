package ListeCreatures;

import Base.Creature;
import Interface.CreatureMarine;
import CreaturesAttributs.Vivipare;

/**
 * La classe Sirène permet de gérer le comportement des Sirènes.
 */
public class Sirène extends Vivipare implements CreatureMarine {

    /**
     * Constructeur pour créer une nouvelle Sirène.
     *
     * @param nomEspece       Nom de l'espèce de la Sirène.
     * @param nom             Nom de la Sirène.
     * @param sexe            Sexe de la Sirène.
     * @param poids           Poids de la Sirène.
     * @param taille          Taille de la Sirène.
     * @param age             Âge de la Sirène.
     * @param indicateurFaim  Indicateur de faim de la Sirène.
     * @param dort            État de sommeil de la Sirène.
     * @param indicateurSante Indicateur de santé de la Sirène.
     */
    public Sirène(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Crée une nouvelle Sirène.
     *
     * @return Un nouvel objet Sirène.
     */
    @Override
    public Sirène creerNouveau(String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        return new Sirène(this.getNomEspece(),"bébé", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Permet à la Sirène de mettre bas. Cette méthode est actuellement non implémentée (retourne null).
     *
     * @return Toujours null dans la version actuelle.
     */
    @Override
    public Creature mettreBas() {
        return null;
    }

    /**
     * Permet à la Sirène de nager.
     */
    @Override
    public void Nager() {
        System.out.println("La siréne nage gracieusement");
    }
}
