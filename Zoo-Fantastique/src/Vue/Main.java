import ImplementationCreature.*;
import Base.*;

public class Main {
    public static void main(String[] args) {
        Phoenix Phoenix = new Phoenix("Phoenix", 'F', 10.0, 2.0, 5, 100, false, 100);

        Creature oeuf = Phoenix.Pondre();

        if (oeuf instanceof Phoenix) {
            System.out.println("Un nouvel oeuf de Phoenix a été pondu !");
        } else {
            System.out.println("Aucun oeuf n'a été pondu.");
        }
    }
}