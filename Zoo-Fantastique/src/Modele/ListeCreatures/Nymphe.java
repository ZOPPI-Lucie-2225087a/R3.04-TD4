package ListeCreatures;

import Base.Creature;
import Interface.CreatureTerrestre;
import CreaturesAttributs.Vivipare;

/**
 * La classe Nymphe permet de gérer le comportement des Nymphes.
 */
public class Nymphe extends Vivipare implements CreatureTerrestre {

    /**
     * Constructeur pour créer une nouvelle Nymphe.
     *
     * @param nomEspece       Nom de l'espèce de la Nymphe.
     * @param nom             Nom de la Nymphe.
     * @param sexe            Sexe de la Nymphe.
     * @param poids           Poids de la Nymphe.
     * @param taille          Taille de la Nymphe.
     * @param age             Âge de la Nymphe.
     * @param indicateurFaim  Indicateur de faim de la Nymphe.
     * @param dort            État de sommeil de la Nymphe.
     * @param indicateurSante Indicateur de santé de la Nymphe.
     */
    public Nymphe(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Crée une nouvelle Nymphe.
     *
     * @return Un nouvel objet Nymphe.
     */
    @Override
    public Nymphe creerNouveau(String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        return new Nymphe(this.getNomEspece(),"bébé", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Permet à la Nymphe de mettre bas. Cette méthode est actuellement non implémentée (retourne null).
     *
     * @return Toujours null dans la version actuelle.
     */
    @Override
    public Creature mettreBas() {
        return null;
    }

    /**
     * Permet à la Nymphe de courir.
     */
    @Override
    public void Courir() {
        System.out.println("La nymphe court légérement");
    }

    /**
     * Permet à la Nymphe de renaître.
     */
    public void renaître() {
        this.setAge(0);
        this.setIndicateurFaim(100);
        this.setDort(false);
        this.setIndicateurSante(100);
        System.out.println("La créature renait");
    }
}
