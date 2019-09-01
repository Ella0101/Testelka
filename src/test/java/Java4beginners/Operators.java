package Java4beginners;

import org.junit.jupiter.api.Test;

public class Operators {
    @Test
    public void examples(){
        int pierwsza = 11;
        int druga =2;

        int wynikDodawanie = pierwsza + druga;
        int wynikDodawaniaLiczb = 11+2;
        int wynikOdejmowania = pierwsza - druga;
        int wynikMnozenia = pierwsza*druga;
        int wynikDzielenia = pierwsza/druga;

        float pierwszaFloat = 11;
        double wynikdzieleniaDouble = pierwszaFloat/druga;

        int wynikModulo = pierwsza%druga;

        System.out.println(druga);
        System.out.println(druga--);
        System.out.println(druga);
        System.out.println(--druga);
        System.out.println(druga);

        int wynik = ++pierwsza + druga;
    }
}
