package Java4beginners;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class WhileDoWhile {
    @Test
    public void whileExample(){
        int silnia5 = 1*2*3*4*5;
        int silnia6 = obliczSilnię(6);
    }

    private int obliczSilnię(int liczba) {
        int silnia = 1;
        int i = 2;

        if(liczba>1){
          while(1<liczba){
              silnia = silnia*i;
              i++;
          }
        }
        return silnia;

    }

    private void czyToMojaLiczba (int liczba){
        int licznik = 0;
        Random generator = new Random();
        do{
            System.out.println("Liczba nie jest równa " + liczba);
            licznik++;
        }
        while (generator.nextInt(5)!=liczba);


        while(generator.nextInt(5)!=liczba){
            System.out.println("Liczba nie jest równa " + liczba);
            licznik++;
        }
        System.out.println("Wylosowało moją liczbę. Pętla wykonała się " + licznik + "razy.");
    }

}
