import ListeCreatures.*;

import java.util.ArrayList;
import java.util.Arrays;

import Habitat.Aquarium;
import Habitat.Standard;
import Habitat.Voliere;

public class Main {
    public static void main(String[] args) {
        Lycanthrope Graou = new Lycanthrope("Graou", 'M', 15.0, 2.0, 5, 100, false, 100);
        Licorne Popcorne = new Licorne("Popcorne", 'F', 10.0, 2.0, 5, 100, false, 100);
        Nymphe Muse = new Nymphe("Muse", 'F', 8.0, 2.0, 5, 100, false, 100);
        Kraken Kraquant = new Kraken("Kraquant", 'M', 20.0, 2.0, 5, 100, false, 100);
        Sirène Ariel = new Sirène("Ariel", 'F', 12.0, 2.0, 5, 100, false, 100);
        Mégalodon Megalo = new Mégalodon("Megalo", 'M', 25.0, 2.0, 5, 100, false, 100);
        Phénix Lion_de_cendre = new Phénix("Lion de cendre", 'M', 10.0, 2.0, 5, 100, false, 100);
        Dragon Dracaufeu = new Dragon("Dracaufeu", 'M', 30.0, 2.0, 5, 100, false, 100);

        Standard enclosLicornes = new Standard("Enclos Licornes", 100, 10, new ArrayList<>(Arrays.asList(Popcorne)),
                "propre");
        Standard enclosLycanthropes = new Standard("Enclos Lycanthropes", 100, 10,
                new ArrayList<>(Arrays.asList(Graou)), "propre");
        Standard enclosNymphes = new Standard("Enclos Nymphes", 100, 10, new ArrayList<>(Arrays.asList(Muse)),
                "propre");

        Aquarium enclosKrakens = new Aquarium("Enclos Krakens", 100, 10, new ArrayList<>(Arrays.asList(Kraquant)),
                "propre", 3000, 1.0);
        Aquarium enclosSirenes = new Aquarium("Enclos Sirènes", 100, 10, new ArrayList<>(Arrays.asList(Ariel)),
                "propre", 200, 1.0);
        Aquarium enclosMegalodons = new Aquarium("Enclos Megalodons", 100, 10, new ArrayList<>(Arrays.asList(Megalo)),
                "propre", 20, 1.0);

        Voliere enclosPhenix = new Voliere("Enclos Phénix", 100, 10, new ArrayList<>(Arrays.asList(Lion_de_cendre)),
                "propre", 20);
        Voliere enclosDragons = new Voliere("Enclos Dragons", 100, 10, new ArrayList<>(Arrays.asList(Dracaufeu)),
                "propre", 20);


    }
}
