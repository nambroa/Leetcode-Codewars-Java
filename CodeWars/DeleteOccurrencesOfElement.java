package CodeWars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/*
Enough is enough!
Alice and Bob were on a holiday. Both of them took many pictures of the places they've been,
and now they want to show Charlie their entire collection. However, Charlie doesn't like these sessions,
since the motif usually repeats. He isn't fond of seeing the Eiffel tower 40 times.

He tells them that he will only sit for the session if they show the same motif at most N times.
Luckily, Alice and Bob are able to encode the motif as a number. Can you help them to remove numbers
such that their list contains each number only up to N times, without changing the order?

Task
Given a list and a number, create a new list that contains each number of list at most N times, without reordering.
For example if the input number is 2, and the input list is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2],
drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].
With list [20,37,20,21] and number 1, the result would be [20,37,21].
 */

/*
A pretty simple usage map solves this problem. If the list is [20, 37, 20, 21] you can make a map that has the keys
as the numbers in the list and the value the total number of appearances so far. When that number goes over maxOccurrences
you remove that element from the array (the number you are currently iterating on).

We will have the indexes to remove on a list. Then we will cast the array to an intstream and remove all elements
whose index is in the indexes to remove list. Then we cast back to array.
 */
public class DeleteOccurrencesOfElement {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        List<Integer> indexesToRemove = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < elements.length; i++) {
            countMap.put(elements[i], countMap.getOrDefault(elements[i], 0) + 1);
            if (countMap.get(elements[i]) > maxOccurrences) {
                indexesToRemove.add(i);
            }
        }
        return IntStream.range(0, elements.length) // Get index from 0 to end of elements.
                .filter(i -> !indexesToRemove.contains(i)) // Filter indexes that are contained in the list OUT.
                .map(i -> elements[i]) // Get each corresponding element from the original array.
                .toArray();

    }
}
