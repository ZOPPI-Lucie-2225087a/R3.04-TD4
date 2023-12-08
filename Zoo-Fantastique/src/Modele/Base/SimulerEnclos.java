package Base;

import java.util.List;
import java.util.Random;
import Habitat.Aquarium;
import Habitat.Voliere;

/**
 * Cette classe représente un simulateur de modification d'état pour des enclos.
 * Elle implémente l'interface Runnable pour pouvoir être exécutée de manière
 * concurrente.
 */
public class SimulerEnclos implements Runnable {

    /**
     * Liste des enclos à simuler.
     */
    private List<Enclos> enclosList;
    private Random random = new Random();

    /**
     * Constructeur de la classe SimulerEnclos.
     *
     * @param enclosList La liste des enclos à simuler.
     */
    public SimulerEnclos(List<Enclos> enclosList) {
        this.enclosList = enclosList;
    }

    /**
     * Méthode exécutée lors du lancement du thread de simulation.
     * Elle parcourt la liste des enclos et applique des modifications d'état
     * aléatoires.
     */
    @Override
    public void run() {
        for (Enclos enclos : enclosList) {
            modifierEtatAleatoire(enclos);
        }
    }

    /**
     * Modifie l'état d'un enclos de manière aléatoire.
     *
     * @param enclos L'enclos dont l'état doit être modifié.
     */
    private void modifierEtatAleatoire(Enclos enclos) {

        // Modifie la propreté de l'enclos de manière aléatoire.
        if (random.nextBoolean()) {
            if (enclos.getCreatures().size() > 0) {
                double nouvelleProprete = enclos.getProprete() - (random.nextDouble() * 25);
                if (nouvelleProprete < 0) {
                    nouvelleProprete = 0;
                }
                enclos.setProprete(nouvelleProprete);
            }
        }

        // Modifie la salinité d'un aquarium de manière aléatoire.
        if (enclos instanceof Aquarium && random.nextBoolean()) {
            if (enclos.getCreatures().size() > 0) {
                double nouvelleSalinite = ((Aquarium) enclos).getSalinite() - (random.nextDouble() * 25);
                if (nouvelleSalinite < 0) {
                    nouvelleSalinite = 0;
                }
                ((Aquarium) enclos).setSalinite(nouvelleSalinite);
            }
        }

        // Modifie le toit d'une volière de manière aléatoire.
        if (enclos instanceof Voliere && random.nextBoolean()) {
            if (enclos.getCreatures().size() > 0) {
                double nouveauToit = ((Voliere) enclos).getToit() - (random.nextDouble() * 25);
                if (nouveauToit < 0) {
                    nouveauToit = 0;
                }
                ((Voliere) enclos).setToit(nouveauToit);
            }
        }
    }
}