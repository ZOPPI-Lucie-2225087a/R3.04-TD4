import ListeCreatures.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Base.Creature;
import Base.Enclos;
import Base.GestionnaireEnclos;
import Base.SimulerCreature;
import Base.SimulerEnclos;
import Base.ZooFantastique;
import Controller.MaitreZoo.Menu;
import Habitat.*;
import MaitreZoo.*;

public class Main {
        public static void main(String[] args) {
                Lycanthrope Graou = new Lycanthrope("Lycanthrope", "Graou", 'M', 15.0, 2.0, 5, 100, false, 100);
                Lycanthrope Graounette = new Lycanthrope("Lycanthrope", "Graounette", 'F', 15.0, 2.0, 5, 100, false,
                                100);
                Licorne Popcorne = new Licorne("Licorne", "Popcorne", 'F', 10.0, 2.0, 5, 100, false, 100);
                Nymphe Muse = new Nymphe("Nymphe", "Muse", 'F', 8.0, 2.0, 5, 100, false, 100);
                Kraken Kraquant = new Kraken("Kraken", "Kraquant", 'M', 20.0, 2.0, 5, 100, false, 100);
                Sirène Ariel = new Sirène("Sirène", "Ariel", 'F', 12.0, 2.0, 5, 100, false, 100);
                Mégalodon Megalo = new Mégalodon("Mégalodon", "Megalo", 'M', 25.0, 2.0, 5, 100, false, 100);
                Phénix Lion_de_cendre = new Phénix("Phénix", "Lion_de_cendre", 'F', 10.0, 2.0, 5, 100, false, 100);
                Dragon Dracaufeu = new Dragon("Dragon", "Dracaufeu", 'M', 30.0, 2.0, 5, 100, false, 100);

                List<Creature> listeDesCreatures = new ArrayList<>();

                Standard enclosLicornes = new Standard("enclosStandardLicorne", 100, 10,
                                new ArrayList<>(Arrays.asList(Popcorne)),
                                100.0);
                Standard enclosLycanthropes = new Standard("enclosStandardLycanthrope", 100, 10,
                                new ArrayList<>(Arrays.asList(Graou, Graounette)), 100.0);
                Standard enclosNymphes = new Standard("enclosStandardNymphe", 100, 10,
                                new ArrayList<>(Arrays.asList(Muse)),
                                100.0);

                Aquarium enclosKrakens = new Aquarium("aquariumKraken", 100, 10,
                                new ArrayList<>(Arrays.asList(Kraquant)),
                                100.0, 3000, 1.0);
                Aquarium enclosSirenes = new Aquarium("aquariumSirène", 100, 10, new ArrayList<>(Arrays.asList(Ariel)),
                                100.0, 200, 1.0);
                Aquarium enclosMegalodons = new Aquarium("aquariumMégalodon", 100, 10,
                                new ArrayList<>(Arrays.asList(Megalo)),
                                100.0, 20, 1.0);

                Voliere enclosPhenix = new Voliere("volierePhénix", 100, 10,
                                new ArrayList<>(Arrays.asList(Lion_de_cendre)),
                                100.0, 20);
                Voliere enclosDragons = new Voliere("voliereDragon", 100, 10, new ArrayList<>(Arrays.asList(Dracaufeu)),
                                100.0, 20);

                GestionnaireEnclos gestionnaireEnclos = new GestionnaireEnclos(new ArrayList<>());
                gestionnaireEnclos.ajouterEnclos(enclosLicornes);
                gestionnaireEnclos.ajouterEnclos(enclosLycanthropes);
                gestionnaireEnclos.ajouterEnclos(enclosNymphes);
                gestionnaireEnclos.ajouterEnclos(enclosKrakens);
                gestionnaireEnclos.ajouterEnclos(enclosSirenes);
                gestionnaireEnclos.ajouterEnclos(enclosMegalodons);
                gestionnaireEnclos.ajouterEnclos(enclosPhenix);
                gestionnaireEnclos.ajouterEnclos(enclosDragons);

                for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
                        listeDesCreatures.addAll(enclos.getCreatures());
                }

                MaitreZoo maitreZoo = new MaitreZoo("Léo Oger", 'M', 19);
                ZooFantastique zooFantastique = new ZooFantastique("Zoo Fantastique", maitreZoo, 50, gestionnaireEnclos);
                demarrerSimulation(gestionnaireEnclos, listeDesCreatures);
                zooFantastique.gererZoo();

        }

        public static void demarrerSimulation(GestionnaireEnclos gestionnaireEnclos, List<Creature> listeDesCreatures) {
                ScheduledExecutorService executor = Executors
                                .newScheduledThreadPool(gestionnaireEnclos.getListeDesEnclos().size());
                for (Enclos enclos : gestionnaireEnclos.getListeDesEnclos()) {
                        executor.scheduleAtFixedRate(new SimulerEnclos(gestionnaireEnclos.getListeDesEnclos()), 0, 1,
                                        TimeUnit.SECONDS);
                }

                ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(listeDesCreatures.size());
                for (Creature creature : listeDesCreatures) {
                        executor2.scheduleAtFixedRate(new SimulerCreature(creature), 0, 1, TimeUnit.SECONDS);
                }
        }
}
