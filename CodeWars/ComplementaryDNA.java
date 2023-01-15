package CodeWars;

/*
Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the
development and functioning of living organisms.

In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G".
Your function receives one side of the DNA; you need to return the other complementary side.
DNA strand is never empty or there is no DNA at all.

More similar exercise are found here: http://rosalind.info/problems/list-view/ (source)

Example: (input --> output)
"ATTGC" --> "TAACG"
"GTAT" --> "CATA"

 */

/*
Pretty simple exercise, just gotta do loop through the dna input and a switch to add the opposite letter to
the one being looped on. Linear complexity in time and constant complexity in space.
 */
public class ComplementaryDNA {
    public static String makeComplement(String dna) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < dna.length(); i++) {
            switch (dna.charAt(i)) {
                case 'A' -> {
                    res.append('T');
                }
                case 'T' -> {
                    res.append('A');
                }
                case 'G' -> {
                    res.append('C');
                }
                case 'C' -> {
                    res.append('G');
                }
            }
        }
        return res.toString();
    }
}
