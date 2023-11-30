package ListeCreatures;

import Interface.CreatureVolante;
import CreaturesAttributs.Ovipare;

/**
 * La classe Phénix permet de gérer le comportement des Phénix.
 */
public class Phénix extends Ovipare implements CreatureVolante {

    /**
     * Constructeur pour créer un nouveau Phénix.
     *
     * @param nomEspece       Nom de l'espèce du Phénix.
     * @param nom             Nom du Phénix.
     * @param sexe            Sexe du Phénix.
     * @param poids           Poids du Phénix.
     * @param taille          Taille du Phénix.
     * @param age             Âge du Phénix.
     * @param indicateurFaim  Indicateur de faim du Phénix.
     * @param dort            État de sommeil du Phénix.
     * @param indicateurSante Indicateur de santé du Phénix.
     */
    public Phénix(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Crée un nouveau Phénix.
     *
     * @return Un nouvel objet Phénix.
     */
    @Override
    public Phénix creerNouveau(String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        return new Phénix(this.getNomEspece(), "bébé", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Permet au Phénix de voler.
     */
    @Override
    public void Voler() {
        System.out.println("Le Phénix vole majestueusement !");
    }

    /**
     * Permet au Phénix de renaître.
     */
    public void renaître() {
        this.setAge(0);
        this.setIndicateurFaim(100);
        this.setDort(false);
        this.setIndicateurSante(100);
        System.out.println("La créature renait");
    }
}
