package Base;

import java.util.Random;

public class SimulerCreature implements Runnable {

    private Creature creature;
    private Random random = new Random();

    public SimulerCreature(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void run() {
        modifierEtatAleatoire(creature);
    }

    private void modifierEtatAleatoire(Creature creature) {

        if (random.nextBoolean()) {
            creature.vieilir();
            System.out.println("Age of creature " + creature.getNom() + " changed to: " + creature.getAge());
        }

        if (random.nextBoolean()) {
            creature.manger();
            System.out.println("Faim of creature " + creature.getNom() + " changed to: " + creature.getIndicateurFaim());
        }
    }
}