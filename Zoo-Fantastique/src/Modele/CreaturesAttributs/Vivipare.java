package CreaturesAttributs;

import java.util.Random;
import java.util.Scanner;

import Base.Creature;
import Base.Enclos;
import Base.GestionnaireEnclos;

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

    @Override
    public Creature Reproduction(GestionnaireEnclos gestionnaireEnclos) {
        return mettreBas(gestionnaireEnclos);
    }

    /**
     * Simule le processus de mise bas d'une créature vivipare.
     *
     * @return La nouvelle créature née du processus de mise bas.
     */
    public Creature mettreBas(GestionnaireEnclos gestionnaireEnclos) {
        if (this.getSexe() == 'F') {
            Scanner scanner = new Scanner(System.in);

            Random random = new Random();
            char sexeBebe = random.nextBoolean() ? 'M' : 'F';
            if (sexeBebe == 'M') {
                System.out.println(this.getNomEspece()
                        + " a mis bas un mâle. Comment voulez-vous nommer le bébé ?");
            } else {
                System.out.println(this.getNomEspece()
                        + " a mis bas une femelle. Comment voulez-vous nommer le bébé ?");
            }
            String nomBebe = scanner.nextLine();

            Vivipare bebe = creerNouveau(this.getNomEspece(), sexeBebe, this.getPoids(), this.getTaille(), 0, 100,
                    false,
                    100);
            bebe.setNom(nomBebe);
            System.out.println("Le bébé s'appelle maintenant " + bebe.getNom());

            Enclos enclosParent = trouverEnclosDeCreature(this, gestionnaireEnclos);
            if (enclosParent != null) {

                enclosParent.ajouterCreature(bebe);
                System.out.println("Le bébé a été ajouté à l'enclos.");
            } else {
                System.out.println("Impossible de trouver l'enclos.");
            }
            return bebe;
        } else {
            System.out.println("ne peut pas mettre bas car c'est un mâle.");
            return null;
        }
    }

    /**
     * Méthode privée pour trouver l'enclos de la créature parente.
     *
     * @param vivipare La créature vivipare.
     * @return L'enclos de la créature parente, ou null s'il n'est pas trouvé.
     */
    private Enclos trouverEnclosDeCreature(Vivipare vivipare, GestionnaireEnclos gestionnaireEnclos) {
        if (gestionnaireEnclos == null) {
            System.out.println("gestionnaireEnclos est null");
            return null;
        }
        for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
            if (enclos.getCreatures().contains(vivipare)) {
                return enclos;
            }
        }
        return null;
    }
}
