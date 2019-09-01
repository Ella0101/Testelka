package Java4beginners;

import org.junit.jupiter.api.Test;

public class Arrays {
    @Test
    public void example() {
        String[] planets = new String[8];
        planets[0] = "Jupiter";
        planets[1] = "Venus";
        planets[2] = "Mercury";
        planets[3] = "Earth";
        planets[4] = "Mars";
        planets[5] = "Saturn";
        planets[6] = "Uranos";
        planets[7] = "Neptune";

        String planetFirst = planets[0];
    }

    @Test
    public void example2() {
        String[] planets = {"Jupiter", "Mercury", "Venus", "Earth", "Mars", "Saturn", "Uranos", "Neptune"};
        String planetFourth = planets[3];
    }

    @Test
    public void example3() {
        int[][] planetsRatio = new int[8][2];
        planetsRatio[0][0] = 1;
        planetsRatio[0][1] = 4879;
        planetsRatio[1][0] = 2;
        planetsRatio[1][1] = 12104;
        planetsRatio[0][0] = 1;
    }

    @Test
    public void example4() {
        int[][] planetsRatio = {{1, 4879}, {2, 12104}, {3, 12756},
                {4, 6805}, {5, 142984}, {6, 120536}, {7, 51118}, {8, 49528}};
    }

}

