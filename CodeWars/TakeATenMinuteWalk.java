package CodeWars;

/*
You live in the city of Cartesia where all roads are laid out in a perfect grid.
You arrived ten minutes too early to an appointment, so you decided to take the opportunity to go for a short walk.
The city provides its citizens with a Walk Generating App on their phones -- everytime you press the button
it sends you an array of one-letter strings representing directions to walk (eg. ['n', 's', 'w', 'e']).
You always walk only a single block for each letter (direction) and you know it takes you one minute
to traverse one city block, so create a function that will return true if the walk the app gives you will take you
exactly ten minutes (you don't want to be early or late!) and will, of course, return you to your starting point.
Return false otherwise.

Note: you will always receive a valid array containing a random assortment of direction
letters ('n', 's', 'e', or 'w' only). It will never give you an empty array (that's not a walk, that's standing still!).
 */

import java.util.HashMap;
import java.util.Map;

/*
Input is already sanitized so don't need to bother with initial questions about empty array, ints, etc.

To check that the walk will take ten minutes, the length of the array must be 10. This can be checked in O(1).

To check that the walk will return me to the starting point, we need to understand complementary directions.
If the walk gives me a N, it needs to now give a S in the future. If the walk gives me a S, it needs to give me an N
in the future. For each direction, I need to have the complementary direction.
I can have a hashmap<char,int>. So map[n] = 2 means that I need to find 2 S in the walk. Everytime I iterate a new
direction in the walk, I reduce 1 in the map's complement. So if map[n] = 0 and I find an S, map[n] = -1.
I also need to add one to the actual direction, so map[n]=-1 and map[s]=1.

At the end of the loop, I check the map and all the entries must be at 0. Otherwise it does not return me to the
starting point.
 */
public class TakeATenMinuteWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) {
            return false;
        }
        Map<Character, Integer> dirMap = new HashMap<>();
        for (char dir : walk) {
            switch (dir) {
                case 'n' -> {
                    dirMap.put('s', dirMap.getOrDefault('s', 0) - 1);
                    dirMap.put('n', dirMap.getOrDefault('n', 0) + 1);
                }
                case 's' -> {
                    dirMap.put('n', dirMap.getOrDefault('n', 0) - 1);
                    dirMap.put('s', dirMap.getOrDefault('s', 0) + 1);
                }
                case 'e' -> {
                    dirMap.put('w', dirMap.getOrDefault('w', 0) - 1);
                    dirMap.put('e', dirMap.getOrDefault('e', 0) + 1);
                }
                case 'w' -> {
                    dirMap.put('e', dirMap.getOrDefault('e', 0) - 1);
                    dirMap.put('w', dirMap.getOrDefault('w', 0) + 1);
                }
            }
        }
        return dirMap.values().stream().noneMatch(v -> v != 0);
    }
}
