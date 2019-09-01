package Java4beginners;

import org.junit.jupiter.api.Test;

public class Methods {
    @Test
    public void example(){
        double poleTrapezuPierwszego = obliczPoleTrapezu(8, 10, 5);
        double poleTrapezuDrugiego = ((6+8)*3)/2;
        double poleTrapezuTrzeciego = ((12+10)*6/2);
        String tekst = "Pola trapezów to: " + poleTrapezuPierwszego + ", " + poleTrapezuDrugiego + ", " + poleTrapezuTrzeciego + ", ";
        System.out.println("Koniec tekstu.");
    }

    double obliczPoleTrapezu(double pierwszaPodstawa, double drugaPodstawa, double wysokość){
        double poleTrapezu = ((pierwszaPodstawa + drugaPodstawa)*wysokość)/2;
        return poleTrapezu;
    }


}
