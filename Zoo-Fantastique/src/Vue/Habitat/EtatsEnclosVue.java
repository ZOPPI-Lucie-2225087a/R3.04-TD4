package Habitat;

import Base.Enclos;

public class EtatsEnclosVue {
    
    private static final String ENCLOSSTANDARD_STRING = //Enclos Standars sans animaux et propre
    
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

    public String remplacerParZero(String enclos, int nombreCreatures) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : enclos.toCharArray()) {
            if (c == '░' && count < nombreCreatures) {
                sb.append('0');
                count++;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    String enclosAvecCreatures = remplacerParZero(ENCLOSSTANDARD_STRING, getNombreCreatures);

    private static final String AQUARIUM_STRING =

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

    private static final String AQUARIUMPLEIN_STRING =

    "┌──────────────────┐\n" +
    "│------------------│\n" +
    "│^^▒^▒▒^^^▒^▒^^▒▒^^│\n" +
    "│▒^^▒▒^^^▒^▒^^▒▒^^^│\n" +
    "│▒0▒▒▒▒▒▒▒▒▒▒▒▒▒0▒▒│\n" +
    "│▒▒▒▒0▒▒▒~~~▒▒▒0▒▒▒│\n" +
    "│▒▒~~~▒▒▒▒▒0▒▒▒▒▒▒▒│\n" +
    "│▒▒▒▒▒0▒▒▒▒▒▒▒~~~▒▒│\n" +
    "│▒▒▒▒▒▒▒▒(▒0▒▒▒▒▒▒▒│\n" + 
    "│▒▒(▒▒▒▒▒▒)▒▒▒▒)▒▒▒│\n" +
    "│▒▒▒)▒▒▒▒(▒▒▒▒(▒▒▒▒│\n" +
    "└──────────────────┘"; 

private static final String VOLIERE_STRING =

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

    // a refaire en mieux
    public static String getEnclosStandardGraphic() {
        return ENCLOSSTANDARD_STRING;
    }

    public static String getEnclosStandardPleinGraphic() {
        return ENCLOSSTANDARDPLEIN_STRING;
    }
}
