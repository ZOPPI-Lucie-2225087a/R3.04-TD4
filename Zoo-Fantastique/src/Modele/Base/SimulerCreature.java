package Base;

import java.util.List;
import java.util.Random;

public class SimulerCreature implements Runnable {

    private final List<Creature> listeCreatures;
    private final Random random = new Random();

    public SimulerCreature(List<Creature> listeCreatures) {
        this.listeCreatures = listeCreatures;
    }

    @Override
    public void run() {
        for (Creature creature : listeCreatures) {
                modifierEtatAleatoire(creature);
        }
    }

    private void modifierEtatAleatoire(Creature creature) {

        if (random.nextBoolean()) {
            creature.vieillir();
        }

        if (random.nextBoolean() && creature.getIndicateurFaim() > 0) {
            int diminutionFaim = random.nextInt(25);
            creature.setIndicateurFaim(Math.max(creature.getIndicateurFaim() - diminutionFaim, 0));
        }

        if (random.nextBoolean()) {
            creature.diminuerSante(random.nextInt(10));
        }

        if (random.nextBoolean()) {
            creature.etreMalade();
        }

        if (random.nextBoolean()) {
            creature.dormir();
        }
    }
}