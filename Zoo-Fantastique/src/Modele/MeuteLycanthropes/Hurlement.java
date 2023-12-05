package MeuteLycanthropes;

public enum Hurlement { //rajouter des truc + logqiue
    COMMUNICATION,
    DOMINATION,
    APPEL;

    public void hurler(Hurlement hurlement) {
        switch (hurlement) {
            case COMMUNICATION:
                System.out.println("communication");
                break;
            case DOMINATION:
                System.out.println("je domine");
                break;
            case APPEL:
                System.out.println("j'appelle");
                break;
        }
    }
}