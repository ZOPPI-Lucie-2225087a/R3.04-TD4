package Habitat;

import java.util.Random;

import Base.Enclos;

public class EtatsEnclosVue {

    private final Enclos enclos;
    private final String habitat;
    private String ENCLOSAVECCREATURES;

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

    public String remplacerParZero(String enclos, int nombreCreatures) {
        Random rand = new Random();
        char[] enclosChars = enclos.toCharArray();
        for (int i = 0; i < nombreCreatures; i++) {
            int randomIndex;
            do {
                randomIndex = rand.nextInt(enclosChars.length);
            } while (enclosChars[randomIndex] != '░' && enclosChars[randomIndex] != '▒' && enclosChars[randomIndex] != ' ');
            enclosChars[randomIndex] = '0';
        }
        return new String(enclosChars);
    }

    public String getEnclosGraphic(String habitat) {
        if (habitat.equals("standard")){
            return ENCLOSSTANDARD_STRING;
        } else if (habitat.equals("aquarium")){
            return AQUARIUM_STRING;
        } else if (habitat.equals("voliere")){
            return VOLIERE_STRING;
        }
        return " ";
    }

    public String getENCLOSAVECCREATURES(){
        return this.ENCLOSAVECCREATURES;
    }
}
