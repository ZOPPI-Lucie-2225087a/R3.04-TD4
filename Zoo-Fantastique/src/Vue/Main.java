import ListeCreatures.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Base.GestionnaireCreature;
import Base.GestionnaireEnclos;
import Base.SimulerCreature;
import Base.SimulerEnclos;
import Base.ZooFantastique;
import Habitat.*;
import MaitreZoo.*;

public class Main {
        public static void main(String[] args) {
                Lycanthrope Graou = new Lycanthrope("Lycanthrope", "Graou", 'M', 15.0, 200.0, 5, 100, false, 100);
                Lycanthrope Graounette = new Lycanthrope("Lycanthrope", "Graounette", 'F', 15.0, 200.0, 5, 100, false,
                                100);

                Licorne Popcorne = new Licorne("Licorne", "Popcorne", 'F', 10.0, 200.0, 5, 100, false, 100);
                Licorne Popcornos = new Licorne("Licorne", "Popcornos", 'M', 10.0, 200.0, 5, 100, false, 100);

                Nymphe Muse = new Nymphe("Nymphe", "Muse", 'F', 8.0, 200.0, 5, 100, false, 100);
                Nymphe Muso = new Nymphe("Nymphe", "Muso", 'M', 8.0, 200.0, 5, 100, false, 100);

                Kraken Kraquant = new Kraken("Kraken", "Kraquant", 'M', 20.0, 200.0, 5, 100, false, 100);
                Kraken Kraquante = new Kraken("Kraken", "Kraquante", 'F', 20.0, 200.0, 5, 100, false, 100);

                Sirène Ariel = new Sirène("Sirène", "Ariel", 'F', 12.0, 200.0, 5, 100, false, 100);
                Sirène Arielo = new Sirène("Sirène", "Arielo", 'M', 12.0, 200.0, 5, 100, false, 100);

                Mégalodon Megalo = new Mégalodon("Mégalodon", "Megalo", 'M', 25.0, 200.0, 5, 100, false, 100);
                Mégalodon Megala = new Mégalodon("Mégalodon", "Megala", 'F', 25.0, 200.0, 5, 100, false, 100);

                Phénix Lion_de_cendre = new Phénix("Phénix", "Lion_de_cendre", 'M', 10.0, 200.0, 5, 100, false, 100);
                Phénix Lionne_de_cendre = new Phénix("Phénix", "Lionne_de_cendre", 'F', 10.0, 200.0, 5, 100, false,
                                100);

                Dragon Dracaufeu = new Dragon("Dragon", "Dracaufeu", 'M', 30.0, 200.0, 5, 100, false, 100);
                Dragon Drattack = new Dragon("Dragon", "Drattack", 'F', 30.0, 200.0, 5, 100, false, 100);

                GestionnaireCreature gestionnaireCreature = new GestionnaireCreature();
                gestionnaireCreature.ajouterCreature(Graou);
                gestionnaireCreature.ajouterCreature(Graounette);
                gestionnaireCreature.ajouterCreature(Popcorne);
                gestionnaireCreature.ajouterCreature(Popcornos);
                gestionnaireCreature.ajouterCreature(Muse);
                gestionnaireCreature.ajouterCreature(Muso);
                gestionnaireCreature.ajouterCreature(Kraquant);
                gestionnaireCreature.ajouterCreature(Kraquante);
                gestionnaireCreature.ajouterCreature(Ariel);
                gestionnaireCreature.ajouterCreature(Arielo);
                gestionnaireCreature.ajouterCreature(Megalo);
                gestionnaireCreature.ajouterCreature(Megala);
                gestionnaireCreature.ajouterCreature(Lion_de_cendre);
                gestionnaireCreature.ajouterCreature(Lionne_de_cendre);
                gestionnaireCreature.ajouterCreature(Dracaufeu);
                gestionnaireCreature.ajouterCreature(Drattack);

                Standard enclosLicornes = new Standard("enclosStandardLicorne", 100, 10,
                                new ArrayList<>(Arrays.asList(Popcorne, Popcornos)),
                                100.0);
                Standard enclosLycanthropes = new Standard("enclosStandardLycanthrope", 100, 10,
                                new ArrayList<>(Arrays.asList(Graou, Graounette)), 100.0);
                Standard enclosNymphes = new Standard("enclosStandardNymphe", 100, 10,
                                new ArrayList<>(Arrays.asList(Muse, Muso)),
                                100.0);

                Aquarium enclosKrakens = new Aquarium("aquariumKraken", 100, 10,
                                new ArrayList<>(Arrays.asList(Kraquant, Kraquante)),
                                100.0, 3000, 1.0);
                Aquarium enclosSirenes = new Aquarium("aquariumSirène", 100, 10,
                                new ArrayList<>(Arrays.asList(Ariel, Arielo)),
                                100.0, 200, 1.0);
                Aquarium enclosMegalodons = new Aquarium("aquariumMégalodon", 100, 10,
                                new ArrayList<>(Arrays.asList(Megalo, Megala)),
                                100.0, 20, 1.0);

                Voliere enclosPhenix = new Voliere("volierePhénix", 100, 10,
                                new ArrayList<>(Arrays.asList(Lion_de_cendre, Lionne_de_cendre)),
                                100.0, 20);
                Voliere enclosDragons = new Voliere("voliereDragon", 100, 10,
                                new ArrayList<>(Arrays.asList(Dracaufeu, Drattack)),
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

                MaitreZoo maitreZoo = new MaitreZoo("Léo Oger", 'M', 19);
                ZooFantastique zooFantastique = new ZooFantastique("Zoo Fantastique", maitreZoo, 50,
                                gestionnaireEnclos);
                demarrerSimulation(gestionnaireEnclos, gestionnaireCreature);
                zooFantastique.gererZoo();

        }

        public static void demarrerSimulation(GestionnaireEnclos gestionnaireEnclos,
                        GestionnaireCreature gestionnaireCreature) {
                ScheduledExecutorService executor = Executors
                                .newScheduledThreadPool(gestionnaireCreature.getListeDesCreatures().size());
                executor.scheduleAtFixedRate(new SimulerEnclos(gestionnaireEnclos.getListeDesEnclos()), 0, 10,
                                TimeUnit.SECONDS);

                executor.scheduleAtFixedRate(new SimulerCreature(gestionnaireCreature.getListeDesCreatures()), 0, 10,
                                TimeUnit.SECONDS);
        }
}
