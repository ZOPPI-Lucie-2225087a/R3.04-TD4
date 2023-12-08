package Habitat;

import java.util.Random;

import Base.Enclos;

/**
 * La classe EtatsEnclosVue permet de créer une vue graphique des états d'un
 * enclos en fonction de son habitat.
 * Elle remplace certains caractères spécifiques par le chiffre '0' pour
 * représenter la présence de créatures.
 */
public class EtatsEnclosVue {

    private final Enclos enclos;
    private final String habitat;
    private String ENCLOSAVECCREATURES;

    /**
     * Constructeur de la classe EtatsEnclosVue.
     *
     * @param enclos  L'enclos associé à la vue.
     * @param habitat Le type d'habitat de l'enclos.
     */
    public EtatsEnclosVue(Enclos enclos, String habitat) {
        this.enclos = enclos;
        this.habitat = habitat;
        this.ENCLOSAVECCREATURES = remplacerParZero(getEnclosGraphic(habitat), enclos.getNombreCreatures());

    }

    private static final String ENCLOSSTANDARD_STRING = // Enclos Standards sans animaux

            "┌──────────────────┐\n" +
                    "│░░░░┌─┐░░░░░┌──┐░░│\n" +
                    "│░│░░│░│░░░░░└──┘░░│\n" +
                    "│░│░░└┬┘░░│░░░░░░░░│\n" +
                    "│░░░░░│░░░░░░░░░░░░│\n" +
                    "│░░░░░░░░░░░░░░░░░░│\n" +
                    "│░░░┌┐░░┌─┐░░┌──┐░░│\n" +
                    "│░░░└┘░░└┬┘░░│░░│░░│\n" +
                    "│░░░░░░░░│░░░└──┘░░│\n" +
                    "│░░│░░░░░│░░░░░░░░░│\n" +
                    "│░░│░░░░░░░░░░░░░░░│\n" +
                    "└──────────────────┘";

    private static final String AQUARIUM_STRING = // Aquarium sans animaux

            "┌──────────────────┐\n" +
                    "│------------------│\n" +
                    "│^^▒^▒▒^^^▒^▒^^▒▒^^│\n" +
                    "│▒^^▒▒^^^▒^▒^^▒▒^^^│\n" +
                    "│▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒│\n" +
                    "│▒▒▒▒▒▒▒▒~~~▒▒▒▒▒▒▒│\n" +
                    "│▒▒~~~▒▒▒▒▒▒▒▒▒▒▒▒▒│\n" +
                    "│▒▒▒▒▒▒▒▒▒▒▒▒▒~~~▒▒│\n" +
                    "│▒▒▒▒▒▒▒▒(▒▒▒▒▒▒▒▒▒│\n" +
                    "│▒▒(▒▒▒▒▒▒)▒▒▒▒)▒▒▒│\n" +
                    "│▒▒▒)▒▒▒▒(▒▒▒▒(▒▒▒▒│\n" +
                    "└──────────────────┘";

    private static final String VOLIERE_STRING = // Volières sans animaux

            "┌──────────────────┐\n" +
                    "│    ____ _   _ _. │\n" +
                    "│  _(    `.) (_)_))│\n" +
                    "│ ( (    ) ))      │\n" +
                    "│( (   )  _)       │\n" +
                    "│ '.__)--'  _ __   │\n" +
                    "│  __      ( (  )`.│\n" +
                    "│.'  )--_ ( (    ))│\n" +
                    "│(   )   ) `-(__.' │\n" +
                    "│ (    ) ))      _ │\n" +
                    "│_(    `.)    (`','│\n" +
                    "└──────────────────┘";

    /**
     * Remplace certains caractères spécifiques dans la représentation graphique par
     * le chiffre '0'.
     *
     * @param enclos          La représentation graphique de l'enclos.
     * @param nombreCreatures Le nombre de créatures à représenter.
     * @return La représentation graphique modifiée avec les créatures.
     */
    public String remplacerParZero(String enclos, int nombreCreatures) {
        Random rand = new Random();
        char[] enclosChars = enclos.toCharArray();
        for (int i = 0; i < nombreCreatures; i++) {
            int randomIndex;
            do {
                randomIndex = rand.nextInt(enclosChars.length);
            } while (enclosChars[randomIndex] != '░' && enclosChars[randomIndex] != '▒'
                    && enclosChars[randomIndex] != ' ');
            enclosChars[randomIndex] = '0';
        }
        return new String(enclosChars);
    }

    /**
     * Récupère la représentation graphique de l'enclos en fonction de son habitat.
     *
     * @param habitat Le type d'habitat de l'enclos.
     * @return La représentation graphique de l'enclos.
     */
    public String getEnclosGraphic(String habitat) {
        if (habitat.equals("standard")) {
            return ENCLOSSTANDARD_STRING;
        } else if (habitat.equals("aquarium")) {
            return AQUARIUM_STRING;
        } else if (habitat.equals("voliere")) {
            return VOLIERE_STRING;
        }
        return " ";
    }

    /**
     * Récupère la représentation graphique de l'enclos avec les créatures.
     *
     * @return La représentation graphique de l'enclos avec les créatures.
     */
    public String getENCLOSAVECCREATURES() {
        return this.ENCLOSAVECCREATURES;
    }
}
