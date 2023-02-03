package CodeWars;

/*
Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James.
Since James doesn't know how to make this happen, he needs your help.

Task
You need to return a string that looks like a diamond shape when printed on the screen, using asterisk (*) characters.
Trailing spaces should be removed, and every line must be terminated with a newline character (\n).

Return null/nil/None/... if the input is an even number or negative,
as it is not possible to print a diamond of even or negative size.

Examples
A size 3 diamond:

 *
***
 *
...which would appear as a string of " *\n***\n *\n"

A size 5 diamond:

  *
 ***
*****
 ***
  *
...that is:

"  *\n ***\n*****\n ***\n  *\n"
 */

/*
The idea here is to first sanitize n to be able to assume that it's odd. Once we've done that, we can iterate it in
increments of two, and then again but lowering.

For example, for a size 5 diamond. We begin at n 1, printing *. Then we add 2, and print ***. Then we add 2, and print
*****. We have reached 5 and thus the apex of the diamond. To cut the lower section, we remove 2 from the counter,
printing ***. We remove 2 again, printing *. We stop when we reach 1.

Now we have to think about the trailing whitespaces to print. At most, we will have to print 2 whitespaces for a size 5.
That's because the apex of that diamond is 5 asterisks, and the middle asterisk would be in position 3. So the first
asterisk, that always is in the middle position, needs to have trailing spaces equalling the floor division of the middle
section. From there, for each floor, we remove 1 space. The middle always has no spaces. After that, we begin adding 1
space back at a time.
 */

public class GiveMeADiamond {
    public static String print(int n) {
        if (n < 0 || n % 2 == 0) {
            return null;
        }

        StringBuilder diamond = new StringBuilder();
        int whiteSpaceCount = Math.floorDiv(n, 2);
        // Building the top of the diamond, stopping at the middle (included)
        for (int asteriskCount = 1; asteriskCount < n; asteriskCount = asteriskCount + 2) {
            diamond.append(" ".repeat(whiteSpaceCount)).append("*".repeat(asteriskCount)).append("\n");
            whiteSpaceCount--;
        }
        // Building the bottom of the diamond, not including the middle.
        for (int asteriskCount = n; asteriskCount > 0; asteriskCount = asteriskCount - 2) {
            diamond.append(" ".repeat(whiteSpaceCount)).append("*".repeat(asteriskCount)).append("\n");
            whiteSpaceCount++;
        }

        return diamond.toString();
    }
}
