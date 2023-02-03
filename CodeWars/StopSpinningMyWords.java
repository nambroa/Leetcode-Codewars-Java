package CodeWars;

/*
Write a function that takes in a string of one or more words, and returns the same string
but with all five or more letter words reversed (Just like the name of this Kata).
Strings passed in will consist of only letters and spaces.
Spaces will be included only when more than one word is present.

Examples:

spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
spinWords( "This is a test") => returns "This is a test"
spinWords( "This is another test" )=> returns "This is rehtona test"

 */

/*
So, we need to split the sentence into words. Then we iterate every word, and for each word that is longer than
5 letters, we reverse it. We will use a StringBuilder to make this happen.
 */

import java.util.Arrays;
import java.util.stream.Collectors;

public class StopSpinningMyWords {

    public String spinWords(String sentence) {
        StringBuilder ansBuilder = new StringBuilder(sentence.length());
        String[] words = sentence.split(" ");
        Arrays.stream(words).forEach(word -> {
            if (word.length() < 5) {
                ansBuilder.append(word);
            } else {
                ansBuilder.append(new StringBuilder(word).reverse());
            }
            ansBuilder.append(" ");
        });
        ansBuilder.deleteCharAt(ansBuilder.length() - 1); // Delete last unnecessary whitespace appended.
        return ansBuilder.toString();
    }

    // Another, more concise solution.
    public String spinWordsTwo(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(word -> word.length() > 4 ? new StringBuilder(word).reverse().toString() : word)
                .collect(Collectors.joining(" "));
    }

}
