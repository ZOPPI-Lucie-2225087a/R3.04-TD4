package Base;

import java.util.List;
import java.util.Random;

/**
 * Cette classe représente un simulateur de modification d'état pour des
 * créatures.
 * Elle implémente l'interface Runnable pour pouvoir être exécutée de manière
 * concurrente.
 */
public class SimulerCreature implements Runnable {

    /**
     * Liste des créatures à simuler.
     */
    private final List<Creature> listeCreatures;
    private final Random random = new Random();

    /**
     * Constructeur de la classe SimulerCreature.
     *
     * @param listeCreatures La liste des créatures à simuler.
     */
    public SimulerCreature(List<Creature> listeCreatures) {
        this.listeCreatures = listeCreatures;
    }

    /**
     * Méthode exécutée lors du lancement du thread de simulation.
     * Elle parcourt la liste des créatures et applique des modifications d'état
     * aléatoires.
     */
    @Override
    public void run() {
        for (Creature creature : listeCreatures) {
            modifierEtatAleatoire(creature);
        }
    }

    /**
     * Modifie l'état d'une créature de manière aléatoire.
     *
     * @param creature La créature dont l'état doit être modifié.
     */
    private void modifierEtatAleatoire(Creature creature) {

        if (random.nextBoolean()) {
            creature.vieillir();
            System.out.println("L'age de " + creature.getNom() + " est maintenant de: " + creature.getAge());
        }

        if (random.nextBoolean() && creature.getIndicateurFaim() > 0) {
            int diminutionFaim = random.nextInt(25);
            creature.setIndicateurFaim(Math.max(creature.getIndicateurFaim() - diminutionFaim, 0));
            System.out
                    .println("La faim de " + creature.getNom() + " est maintenant de: " + creature.getIndicateurFaim());
        }

        if (random.nextBoolean()) {
            creature.diminuerSante(random.nextInt(10));
            System.out.println(
                    "La santé de " + creature.getNom() + " est maintenant de: " + creature.getIndicateurSante());
        }

        if (random.nextBoolean()) {
            creature.etreMalade();
            System.out.println(creature.getNom() + " est malade.");
        }

        if (random.nextBoolean()) {
            creature.dormir();
            System.out.println(creature.getNom() + " s'est endormie.");
        }
    }
}