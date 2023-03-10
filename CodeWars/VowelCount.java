package CodeWars;

import java.util.Arrays;
import java.util.Objects;

/*
Return the number (count) of vowels in the given string.

We will consider a, e, i, o, u as vowels for this Kata (but not y).

The input string will only consist of lower case letters and/or spaces.
*/
public class VowelCount {
    public static int getCount(String str) {
        return (int) Arrays.stream(str.split("")).filter(letter -> Objects.equals(letter, "a") || Objects.equals(letter, "e") || Objects.equals(letter, "i") || Objects.equals(letter, "o") || Objects.equals(letter, "u")).count();

    }

}
