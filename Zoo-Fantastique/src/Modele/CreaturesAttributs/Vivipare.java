package CreaturesAttributs;

import Base.Creature;

/**
 * Classe Vivipare
 * 
 * @see Creature
 */
public abstract class Vivipare extends Creature {

    /**
     * Crée une nouvelle créature vivipare.
     *
     * @param nomEspece       Le nom de l'espèce de la créature.
     * @param sexe            Le sexe de la créature.
     * @param poids           Le poids de la créature.
     * @param taille          La taille de la créature.
     * @param age             L'âge de la créature.
     * @param indicateurFaim  L'indicateur de faim de la créature.
     * @param dort            L'indicateur de sommeil de la créature.
     * @param indicateurSante L'indicateur de santé de la créature.
     * @return La créature vivipare créée.
     */
    public abstract Vivipare creerNouveau(String nomEspece, char sexe, double poids, double taille, int age,
            int indicateurFaim,
            boolean dort, int indicateurSante);

    /**
     * Constructeur de la classe Vivipare.
     *
     * @param nomEspece       Le nom de l'espèce de la créature.
     * @param nom             Le nom de la créature.
     * @param sexe            Le sexe de la créature.
     * @param poids           Le poids de la créature.
     * @param taille          La taille de la créature.
     * @param age             L'âge de la créature.
     * @param indicateurFaim  L'indicateur de faim de la créature.
     * @param dort            L'indicateur de sommeil de la créature.
     * @param indicateurSante L'indicateur de santé de la créature.
     */
    public Vivipare(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim,
            boolean dort,
            int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Simule le processus de mise bas d'une créature vivipare.
     *
     * @return La nouvelle créature née du processus de mise bas.
     */
    public Creature mettreBas() {
        if (this.getSexe() == 'F') {
            return creerNouveau(this.getNomEspece(), 'M', this.getPoids(), this.getTaille(), 0, 100, false, 100); // gros bebe garcon
        } else {
            System.out.println("Ne peut pas mettre bas car c'est un mâle.");
            return null;
        }
    }
}
