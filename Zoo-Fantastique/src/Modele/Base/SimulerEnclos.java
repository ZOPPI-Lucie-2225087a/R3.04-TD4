package Base;

import java.util.List;
import java.util.Random;
import Habitat.Aquarium;
import Habitat.Voliere;

public class SimulerEnclos implements Runnable {

    private List<Enclos> enclosList;
    private Random random = new Random();

    public SimulerEnclos(List<Enclos> enclosList) {
        this.enclosList = enclosList;
    }

    @Override
    public void run() {
        for (Enclos enclos : enclosList) {
            modifierEtatAleatoire(enclos);
        }
    }

    private void modifierEtatAleatoire(Enclos enclos) {

        if (random.nextBoolean()) {
            if (enclos.getCreatures().size() > 0) {
                double nouvelleProprete = enclos.getProprete() - (random.nextDouble() * 25);
                if (nouvelleProprete < 0) {
                    nouvelleProprete = 0;
                }
                enclos.setProprete(nouvelleProprete);
            }
        }

        if (enclos instanceof Aquarium && random.nextBoolean()) {
            if (enclos.getCreatures().size() > 0) {
                double nouvelleSalinite = ((Aquarium) enclos).getSalinite() - (random.nextDouble() * 25);
                if (nouvelleSalinite < 0) {
                    nouvelleSalinite = 0;
                }
                ((Aquarium) enclos).setSalinite(nouvelleSalinite);
            }
        }

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