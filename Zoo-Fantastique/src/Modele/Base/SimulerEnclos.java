package Base;

import java.util.Random;
import Habitat.Aquarium;
import Habitat.Voliere;

public class SimulerEnclos implements Runnable {

    private Enclos enclos;
    private Random random = new Random();

    public SimulerEnclos(Enclos enclos) {
        this.enclos = enclos;
    }

    @Override
    public void run() {
        modifierEtatAleatoire(enclos);
    }

    private void modifierEtatAleatoire(Enclos enclos) {

        if (random.nextBoolean()) {
            enclos.setProprete(random.nextDouble() * 100);
        }

        if (enclos instanceof Aquarium && random.nextBoolean()) {
            ((Aquarium) enclos).setSalinite(random.nextInt(100));
        }

        if (enclos instanceof Voliere && random.nextBoolean()) {
            ((Voliere) enclos).setToit(random.nextDouble() * 100);
        }
    }
}