import ListeCreatures.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Base.Enclos;
import Base.SimulerEnclos;
import Controleur.MaitreZoo.Menu;
import Habitat.*;
import MaitreZoo.*;

public class Main {
        public static void main(String[] args) {
                Lycanthrope Graou = new Lycanthrope("Lycanthrope", "Graou", 'M', 15.0, 2.0, 5, 100, false, 100);
                Licorne Popcorne = new Licorne("Licorne", "Popcorne", 'F', 10.0, 2.0, 5, 100, false, 100);
                Nymphe Muse = new Nymphe("Nymphe", "Muse", 'F', 8.0, 2.0, 5, 100, false, 100);
                Kraken Kraquant = new Kraken("Kraken", "Kraquant", 'M', 20.0, 2.0, 5, 100, false, 100);
                Sirène Ariel = new Sirène("Sirène", "Ariel", 'F', 12.0, 2.0, 5, 100, false, 100);
                Mégalodon Megalo = new Mégalodon("Mégalodon", "Megalo", 'M', 25.0, 2.0, 5, 100, false, 100);
                Phénix Lion_de_cendre = new Phénix("Phénix", "Lion_de_cendre", 'M', 10.0, 2.0, 5, 100, false, 100);
                Dragon Dracaufeu = new Dragon("Dragon", "Dracaufeu", 'M', 30.0, 2.0, 5, 100, false, 100);

                Standard enclosLicornes = new Standard("enclosStandardLicorne", 100, 10,
                                new ArrayList<>(Arrays.asList(Popcorne)),
                                100.0);
                Standard enclosLycanthropes = new Standard("enclosStandardLycanthrope", 100, 10,
                                new ArrayList<>(Arrays.asList(Graou)), 100.0);
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

                List<Enclos> listeDesEnclos = new ArrayList<>();
                listeDesEnclos.add(enclosLicornes);
                listeDesEnclos.add(enclosLycanthropes);
                listeDesEnclos.add(enclosNymphes);
                listeDesEnclos.add(enclosKrakens);
                listeDesEnclos.add(enclosSirenes);
                listeDesEnclos.add(enclosMegalodons);
                listeDesEnclos.add(enclosPhenix);
                listeDesEnclos.add(enclosDragons);

                MaitreZoo maitreZoo = new MaitreZoo("Léo Oger", 'M', 19);
                Menu menu = new Menu(maitreZoo, listeDesEnclos);
                demarrerSimulation(listeDesEnclos);
                menu.afficherMenu();

        }

        public static void demarrerSimulation(List<Enclos> listeDesEnclos) {
                ScheduledExecutorService executor = Executors.newScheduledThreadPool(listeDesEnclos.size());
                for (Enclos enclos : listeDesEnclos) {
                        executor.scheduleAtFixedRate(new SimulerEnclos(enclos), 0, 1, TimeUnit.SECONDS);
                }
        }
}
