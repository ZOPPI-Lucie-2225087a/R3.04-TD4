package CreaturesAttributs;

import Base.Creature;

import java.util.Scanner;

public abstract class Ovipare extends Creature {

    public abstract Ovipare creerNouveau(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim,
            boolean dort, int indicateurSante);

    public Ovipare(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    public Creature Pondre() {
        if (this.getSexe() == 'F') {
            Scanner scanner = new Scanner(System.in);
            System.out.println(this.getNomEspece() + " a pondu un nouvel oeuf. Comment voulez-vous nommer le bébé ?");
            String nomBebe = scanner.nextLine();
            Ovipare bebe = creerNouveau(this.getNomEspece(), 'M', this.getPoids(), this.getTaille(), 0, 100, false, 100); //wtf le gros bébé garçon
            bebe.setNom(nomBebe);
            System.out.println("Le bébé s'appelle maintenant " + bebe.getNom());
            scanner.close();
            return bebe;
        } else {
            System.out.println("ne peut pas pondre car c'est un male.");
            return null;
        }
    }

}
