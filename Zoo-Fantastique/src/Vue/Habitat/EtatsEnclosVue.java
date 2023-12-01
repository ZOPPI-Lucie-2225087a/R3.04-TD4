package Habitat;

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

    public static String getEnclosGraphic() {
        return ENCLOSSTANDARD_STRING;
    }
}
