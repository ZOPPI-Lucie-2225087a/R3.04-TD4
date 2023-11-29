package ListeCreatures;

import Interface.CreatureMarine;
import CreaturesAttributs.Ovipare;

public class Mégalodon extends Ovipare implements CreatureMarine {
    public Mégalodon(String nomEspece, String nom, char sexe, double poids, double taille, int age, int indicateurFaim,
            boolean dort, int indicateurSante) {
        super(nomEspece, nom, sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public Mégalodon creerNouveau(String nomEspece, char sexe, double poids, double taille, int age, int indicateurFaim, boolean dort, int indicateurSante) {
        return new Mégalodon(this.getNomEspece(), "bébé", sexe, poids, taille, age, indicateurFaim, dort, indicateurSante);
    }

    @Override
    public void Nager() {
        System.out.println("Le mégalodon nage puissamment !");
    }
}