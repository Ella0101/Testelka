package Java4beginners;

import org.junit.Test;

public class Concatenation {
    @Test
    public void example(){
        String pierwszaCzesc = "Na śniadanie zjadłam dzisiaj ";
        String drugaCzęść = "jajecznicę ";
        String trzeciaCzęść = "na maśle. ";

        String tekst = pierwszaCzesc + drugaCzęść + trzeciaCzęść;
        int liczba = 123;
        String tekstzLiczbą = tekst + liczba;
        boolean prawda = true;
        String tesktzBoolean = tekst + prawda;

        int number = 5;
        boolean truestory = true;
        String marathonrace = "I brought ";
        String wholetext = marathonrace + number +  "medals, "  + true +  "story.";
    }
}
