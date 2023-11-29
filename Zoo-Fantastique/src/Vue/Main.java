import ListeCreatures.*;
import MaitreZoo.MaitreZoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Base.Enclos;
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
        Phénix Lion_de_cendre = new Phénix("Phénix", "Lion de cendre", 'M', 10.0, 2.0, 5, 100, false, 100);
        Dragon Dracaufeu = new Dragon("Dragon", "Dracaufeu", 'M', 30.0, 2.0, 5, 100, false, 100);

        Standard enclosLicornes = new Standard("Licornes", 100, 10, new ArrayList<>(Arrays.asList(Popcorne)),
                "propre");
        Standard enclosLycanthropes = new Standard("Lycanthropes", 100, 10,
                new ArrayList<>(Arrays.asList(Graou)), "propre");
        Standard enclosNymphes = new Standard("Nymphes", 100, 10, new ArrayList<>(Arrays.asList(Muse)),
                "propre");

        Aquarium enclosKrakens = new Aquarium("Krakens", 100, 10, new ArrayList<>(Arrays.asList(Kraquant)),
                "propre", 3000, 1.0);
        Aquarium enclosSirenes = new Aquarium("Sirenes", 100, 10, new ArrayList<>(Arrays.asList(Ariel)),
                "propre", 200, 1.0);
        Aquarium enclosMegalodons = new Aquarium("Megalodons", 100, 10, new ArrayList<>(Arrays.asList(Megalo)),
                "propre", 20, 1.0);

        Voliere enclosPhenix = new Voliere("Phenix", 100, 10, new ArrayList<>(Arrays.asList(Lion_de_cendre)),
                "propre", 20);
        Voliere enclosDragons = new Voliere("Dragons", 100, 10, new ArrayList<>(Arrays.asList(Dracaufeu)),
                "propre", 20);

        List<Enclos> listeDesEnclos = Arrays.asList(enclosLicornes, enclosLycanthropes, enclosNymphes, enclosKrakens, enclosSirenes, enclosMegalodons, enclosPhenix, enclosDragons);

        MaitreZoo maitreZoo = new MaitreZoo("Léo Oger",'M',19);
        Menu menu = new Menu(maitreZoo, listeDesEnclos);
        menu.afficherMenu();


    }
}
