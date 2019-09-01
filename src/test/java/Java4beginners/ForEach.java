package Java4beginners;

import org.junit.jupiter.api.Test;

public class ForEach {
    @Test
    public void forExample(){
        int silnia5 = 1 * 2 * 3 * 4 *5;
        int silnia4 = 1 * 2 * 3 * 4;
        int silnia1 = 1;
        int silnia0 = 1;
        int silnia6 = obliczSilnię(6);
    }

    private int obliczSilnię(int liczba) {
        int silnia = 1;


        if (liczba>1){
            for(int i = 2; i<=liczba; i++){
                silnia = silnia*i;
            }
        }

        return silnia;
    }
    @Test
    public void forEachExample(){
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranos", "Neptune"};
        String text = "Planets of our solar system: ";

        for(String planet : planets){
            text = text + "\n" + planet;
        }
        System.out.println(text);
    }
}
