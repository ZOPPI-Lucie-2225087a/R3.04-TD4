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
            //System.out.println("L'age de  " + creature.getNom() + " est maintenant de: " + creature.getAge());
        }

        if (random.nextBoolean() && creature.getIndicateurFaim() > 0) {
            int diminutionFaim = random.nextInt(25);
            creature.setIndicateurFaim(Math.max(creature.getIndicateurFaim() - diminutionFaim, 0));
            //System.out.println("La faim de " + creature.getNom() + " est maintenant de: " + creature.getIndicateurFaim());
        }

        if (random.nextBoolean()) {
            creature.diminuerSante(random.nextInt(10));
            //System.out.println("La santé de " + creature.getNom() + " est maintenant de: " + creature.getIndicateurSante());
        }

        if (random.nextBoolean()) {
            creature.etreMalade();
            //System.out.println(creature.getNom() + " est malade.");
        }

        if (random.nextBoolean()) {
            creature.dormir();
            //System.out.println(creature.getNom() + " s'est endormie.");
        }
    }
}