package ListeCreatures;

import CreaturesAttributs.Creature;
import CreaturesAttributs.CreatureVolante;
import CreaturesAttributs.Ovipare;

public class Phoenix extends Ovipare implements CreatureVolante {
    public Phoenix(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Phoenix creerNouveau(char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort,
            int indicateurSante) {
        return new Phoenix(this.getNomEspece(), sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public void Voler() {
        // Implémentation spécifique pour le vol du Phoenix
        // Mettez ici le code pour la capacité de vol du Phoenix
        System.out.println("Le Phoenix vole majestueusement !");
    }

    public void renaître() {
        this.setAge(0);
        this.setIndicateurFaim(100);
        this.setDort(false);
        this.setIndicateurSante(100);
        System.out.println("La créature renait");
    }
}
