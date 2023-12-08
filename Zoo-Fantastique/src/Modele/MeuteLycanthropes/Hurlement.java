package MeuteLycanthropes;

public enum Hurlement {


    //on deifni une lethode huler pour chaque  valeur de lenum comme
    //comme ca quand on appel huler ca fait le comportement specifique associé a cette valeur tout seul
    COMMUNICATION {
        public void hurler() {
            System.out.println("Je communique mon appartenance.");
            // les autres doivenr repondrent
        }
    },
    DOMINATION {
        public void hurler() {
            System.out.println("Je domine.");
        }
    },
    SOUMISSION {
        public void hurler() {
            System.out.println("Je me soumets.");
        }
    },
    AGRESSION {
        public void hurler() {
            System.out.println("Je suis agressif.");
        }
    };

    public abstract void hurler();
}