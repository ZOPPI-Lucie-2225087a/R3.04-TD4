package Habitat;

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
        System.out.println(nombreCreatures);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : enclos.toCharArray()) {
            if (c == '░' || c == '▒' || c == ' ' && count < nombreCreatures) {
                sb.append('0');
                count++;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
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
