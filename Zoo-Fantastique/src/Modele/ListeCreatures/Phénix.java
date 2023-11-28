package ListeCreatures;

import CreaturesAttributs.CreatureVolante;
import CreaturesAttributs.Ovipare;

public class Phénix extends Ovipare implements CreatureVolante {
    public Phénix(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Phénix creerNouveau(char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        return new Phénix(this.getNomEspece(), sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public void Voler() {
        // Implémentation spécifique pour le vol du Phénix
        // Mettez ici le code pour la capacité de vol du Phénix
        System.out.println("Le Phénix vole majestueusement !");
    }

    public void renaître() {
        this.setAge(0);
        this.setIndicateurFaim(100);
        this.setDort(false);
        this.setIndicateurSante(100);
        System.out.println("La créature renait");
    }
}
