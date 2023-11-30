package ListeCreatures;

import Interface.CreatureMarine;
import CreaturesAttributs.Ovipare;

/**
 * La classe Mégalodon permet de gérer le comportement des Mégalodon.
*/
public class Mégalodon extends Ovipare implements CreatureMarine {

    /**
     * Constructeur pour créer un nouveau Mégalodon.
     *
     * @param nomEspece       Nom de l'espèce du Mégalodon.
     * @param nom             Nom du Mégalodon.
     * @param sexe            Sexe du Mégalodon.
     * @param poids           Poids du Mégalodon.
     * @param taille          Taille du Mégalodon.
     * @param age             Âge du Mégalodon.
     * @param indicateurFaim  Indicateur de faim du Mégalodon.
     * @param dort            État de sommeil du Mégalodon.
     * @param indicateurSante Indicateur de santé du Mégalodon.
    */
    public Mégalodon(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim,
            boolean dort, int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Crée un nouveau Mégalodon.
     *
     * @return Un nouvel objet Mégalodon.
    */
    @Override
    public Mégalodon creerNouveau(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        return new Mégalodon(this.getNomEspece(), "bébé", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Permet au Mégalodon de nager.
    */
    @Override
    public void Nager() {
        System.out.println("Le mégalodon nage puissamment !");
    }
}