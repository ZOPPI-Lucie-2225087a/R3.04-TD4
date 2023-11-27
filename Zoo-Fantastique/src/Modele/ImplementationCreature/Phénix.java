package ImplementationCreature;

import base.Creature;
import base.Ovipare;
import Interface.CreatureVolante;

public class Phénix extends Ovipare implements CreatureVolante {
    public Phénix(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Creature Pondre() {
        return null;
    }

    @Override
    public void Voler() {
        // Implémentation spécifique pour le vol du Phénix
        // Mettez ici le code pour la capacité de vol du Phénix
        System.out.println("Le Phénix vole majestueusement !");
    }

    public void renaître() {
        this.age = 0;
        this.indicateurFaim = 100;
        this.dort = false;
        this.indicateurSante = 100;
        System.out.println("La creature a renait");
    }
}
