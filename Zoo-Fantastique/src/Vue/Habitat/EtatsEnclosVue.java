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
    
    private static final String ENCLOSSTANDARDPLEIN_STRING = //Enclos Standars avec animaux et propre
    
    "┌──────────────────┐\n" +
    "│░░░░┌─┐░0░░░┌──┐░░│\n" +
    "│░│░░│░│░░░░░└──┘░░│\n" +
    "│░│░░└┬┘░░│░░░0░░░░│\n" +
    "│░░0░░│░░░░░░░░░░░░│\n" +
    "│░░░░░░░░░░0░░░░░░░│\n" +
    "│░░░┌┐░░┌─┐░░┌──┐░░│\n" +
    "│░░░└┘░░└┬┘░░│░░│░░│\n" +
    "│░░0░░░░░│░░░└──┘░░│\n" + 
    "│░░│░░░░░│░░░░░░░░░│\n" +
    "│░░│░░░░░░░░░░0░░░░│\n" +
    "└──────────────────┘";    


    // a refaire en mieux
    public static String getEnclosStandardGraphic() {
        return ENCLOSSTANDARD_STRING;
    }

    public static String getEnclosStandardPleinGraphic() {
        return ENCLOSSTANDARDPLEIN_STRING;
    }
}
