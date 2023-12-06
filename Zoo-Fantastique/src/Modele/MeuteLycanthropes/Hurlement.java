package MeuteLycanthropes;

public enum Hurlement {
    COMMUNICATION,//- exprimer l’appartenance à une meute (entre les membres de la meute ou pour avertir les individus d’une autre meute) : lorsqu’un lycanthrope d’une meute utilise ce type de hurlements, tous les autres membres du clan qui l’entendent lui répondent en lançant un hurlement du même type (mais cette réponse n’appelle pas d’autres réponses) ; ceux des autres meutes peuvent répondre par leur propre hurlement de meute 
    DOMINATION, //− exprimer la domination ;
    SOUMISSION, // − exprimer la soumission (en réponse à une expression de domination) ;
    AGRESSION; // − exprimer l’agressivité (en réponse à une expression de domination ou envers un membreω).

    public void hurler(Hurlement hurlement) {
        switch (hurlement) {
            case COMMUNICATION:
                System.out.println("Je communique mon appartenance.");
                break;
            case DOMINATION:
                System.out.println("Je domine.");
                break;
            case SOUMISSION:
                System.out.println("Je me soumets.");
                break;
            case AGRESSION:
                System.out.println("Je suis agressif.");
                break;
        }
    }
}