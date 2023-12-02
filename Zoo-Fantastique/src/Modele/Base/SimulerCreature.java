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

    if (random.nextBoolean() && creature.getIndicateurFaim() < 100) {
        int augmentationFaim = random.nextInt(25);
        creature.setIndicateurFaim(Math.min(creature.getIndicateurFaim() + augmentationFaim, 100));
        System.out.println("Faim of creature " + creature.getNom() + " changed to: " + creature.getIndicateurFaim());
    }

    if (random.nextBoolean()) {
        creature.diminuerSante(random.nextInt(10));
        System.out.println("Sante of creature " + creature.getNom() + " changed to: " + creature.getIndicateurSante());
    }
}
}