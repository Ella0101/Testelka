package Java4beginners;

import org.junit.jupiter.api.Test;

public class VisibilityRange {
    int number1 = 5;
    int number2 = 4;
    int sum = number1 + number2;
    int number3;


    @Test
    public void printOutNumber() {
        number3 = 7;
        number1 = 3;
        int numberMethod = 2;

        for (int i = 0; i < 10; i++) {
            System.out.println("The variable number1 equals: " + number1 + ". Sum of i equals: " + i);
            int localSum = number1 + i;
            if (i>=5){
                String statement = "i is larger or equals 5. ";
                System.out.println(statement);
            }
        }



    }

}

