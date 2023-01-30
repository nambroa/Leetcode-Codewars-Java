package CodeWars;

/*
Build Tower
Build a pyramid-shaped tower, as an array/list of strings,
given a positive integer number of floors. A tower block is represented with "*" character.


For example, a tower with 3 floors looks like this:

[
  "  *  ",
  " *** ",
  "*****"
]
And a tower with 6 floors looks like this:

[
  "     *     ",
  "    ***    ",
  "   *****   ",
  "  *******  ",
  " ********* ",
  "***********"
]
 */

/*
The "trick" to remember here is that all floors except the last one must have trailing and ending whitespace
equalling the total floors minus one, descending on each floor. (validated by codewars's test suite).
So we need to add those manually while we build the asterisks.
For example, if nFloors is 3. First floor has 2 trailing and ending ws, second floor has 1, third floor has 0.

 We will use StringBuilder to build each floor since Strings are inmutable in java and thus manipulating a String
 manually would cause the String to be rebuilt multiple times, with a high performance cost.
 */

import java.util.stream.IntStream;

public class BuildTower {
    public static String[] towerBuilder(int nFloors) {
        String[] tower = new String[nFloors];
        int floorMultiplier = 0;
        int amountOfWhitespaceInFloor = nFloors -1;
        for (int i = 1; i <= nFloors; i++) {
            StringBuilder floor = new StringBuilder(i);

            IntStream.range(0, amountOfWhitespaceInFloor).forEach(j -> floor.append(" "));
            IntStream.range(0, i + floorMultiplier).forEach(j -> floor.append("*"));
            IntStream.range(0, amountOfWhitespaceInFloor).forEach(j -> floor.append(" "));

            tower[i - 1] = floor.toString();
            floorMultiplier++;
            amountOfWhitespaceInFloor--;
        }
        return tower;
    }
}
