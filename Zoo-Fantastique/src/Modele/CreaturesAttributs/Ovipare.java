package CreaturesAttributs;

import Base.Creature;
import Base.Enclos;

import java.util.Scanner;

public abstract class Ovipare extends Creature {

    public abstract Ovipare creerNouveau(String nomEspece, char sexe, double poids, double taille, int age,
            int indicateurFaim,
            boolean dort, int indicateurSante);

    public Ovipare(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim,
            boolean dort,
            int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

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

    private Enclos trouverEnclosDeCreature(Ovipare ovipare) {
        return null;
    }
}
