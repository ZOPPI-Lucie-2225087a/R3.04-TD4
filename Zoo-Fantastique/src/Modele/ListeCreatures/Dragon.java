package ListeCreatures;

import Interface.CreatureMarine;
import Interface.CreatureTerrestre;
import Interface.CreatureVolante;
import CreaturesAttributs.Ovipare;

/**
 * La classe Dragon permet de gérer le comportement des dragons.
*/
public class Dragon extends Ovipare implements CreatureMarine, CreatureVolante, CreatureTerrestre {

    /**
     * Constructeur pour la création d'un nouveau dragon.
     *
     * @param nomEspece       Nom de l'espèce du dragon.
     * @param nom             Nom du dragon.
     * @param sexe            Sexe du dragon.
     * @param poids           Poids du dragon.
     * @param taille          Taille du dragon.
     * @param age             Âge du dragon.
     * @param indicateurFaim  Indicateur de faim du dragon.
     * @param dort            État de sommeil du dragon.
     * @param indicateurSante Indicateur de santé du dragon.
    */
    public Dragon(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Crée un nouveau dragon.
     *
     * @return Un nouvel objet Dragon.
    */
    @Override
    public Dragon creerNouveau(String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        return new Dragon(this.getNomEspece(), "bébé", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Permet au dragon de nager.
    */
    @Override
    public void Nager() {
        System.out.println("Le dragon nage");
    }

    /**
     * Permet au dragon de courir.
    */
    @Override
    public void Courir() {
        System.out.println("Le dragon court");
    }

    /**
     * Permet au dragon de voler.
    */
    @Override
    public void Voler() {
        System.out.println("Le dragon vole");
    }

    /**
     * Réinitialise l'âge, l'indicateur de faim, l'état de sommeil et l'indicateur de santé du dragon à leurs valeurs par défaut.
     * Ceci simule la renaissance du dragon.
    */
    public void renaître() {
        this.setAge(0);
        this.setIndicateurFaim(100);
        this.setDort(false);
        this.setIndicateurSante(100);
        System.out.println("La créature renait");
    }
}