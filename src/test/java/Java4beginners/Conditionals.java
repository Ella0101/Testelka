package Java4beginners;

import org.junit.jupiter.api.Test;

public class Conditionals {
    @Test
    public void ifExample() {
        int number = 87;

        if (number > 100) {
            System.out.println("Number " + number + " is larger than 100");
            //number++;
        } else {
            System.out.println("Number " + number + " is not larger than 100");
            //number = 100;
        }
        number = 100;
        System.out.println("Game over. Number equals " + number);
    }

    @Test
    public void switchExample(){
        int number = 0;

        switch (number){
            case 0:
                System.out.println("number equals 0");
                break;

            case 1:
                System.out.println("number equals 1");
                break;

            case 2:
                System.out.println("number equals 2");
                break;

             default:
                 System.out.println("number is incorrect");
        }
    }


}
