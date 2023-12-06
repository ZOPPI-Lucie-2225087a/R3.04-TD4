package CreaturesAttributs;

import Base.Creature;
import Base.Enclos;
import java.util.Scanner;

/**
 * Classe Ovipare
 * 
 * @see Creature
 */
public abstract class Ovipare extends Creature {

    /**
     * Crée une nouvelle créature ovipare.
     *
     * @param nomEspece       Le nom de l'espèce de la créature.
     * @param sexe            Le sexe de la créature.
     * @param poids           Le poids de la créature.
     * @param taille          La taille de la créature.
     * @param age             L'âge de la créature.
     * @param indicateurFaim  L'indicateur de faim de la créature.
     * @param dort            L'indicateur de sommeil de la créature.
     * @param indicateurSante L'indicateur de santé de la créature.
     * @return La créature ovipare créée.
     */
    public abstract Ovipare creerNouveau(String nomEspece, char sexe, double poids, double taille, int age,
            int indicateurFaim,
            boolean dort, int indicateurSante);

    /**
     * Constructeur de la classe Ovipare.
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
    public Ovipare(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim,
            boolean dort,
            int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    /**
     * Simule le processus de ponte d'une créature ovipare.
     *
     * @return Le nouveau-né issu du processus de ponte.
     */
    public Creature Pondre() {
        if (this.getSexe() == 'F') {
            Scanner scanner = new Scanner(System.in);
            System.out.println(this.getNomEspece() + " a pondu un nouvel oeuf. Comment voulez-vous nommer le bébé ?");
            String nomBebe = scanner.nextLine();
            Ovipare bebe = creerNouveau(this.getNomEspece(), 'M', this.getPoids(), this.getTaille(), 0, 100, false,
                    100);
            bebe.setNom(nomBebe);
            System.out.println("Le bébé s'appelle maintenant " + bebe.getNom());

            // Trouver l'enclos de la créature parente
            Enclos enclosParent = trouverEnclosDeCreature(this);
            if (enclosParent != null) {
                // Ajouter le bébé à l'enclos de la créature parente
                enclosParent.ajouterCreature(bebe);
                System.out.println("Le bébé a été ajouté à l'enclos de la créature parente.");
            } else {
                System.out.println("Impossible de trouver l'enclos de la créature parente.");
            }

            scanner.close();
            return bebe;
        } else {
            System.out.println("ne peut pas pondre car c'est un male.");
            return null;
        }
    }

    /**
     * Méthode privée pour trouver l'enclos de la créature parente.
     *
     * @param ovipare La créature ovipare.
     * @return L'enclos de la créature parente, ou null s'il n'est pas trouvé.
     */
    private Enclos trouverEnclosDeCreature(Ovipare ovipare) {// a faire 
        return null;
    }
}
