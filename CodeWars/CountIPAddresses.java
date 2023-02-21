package CodeWars;

/*
Implement a function that receives two IPv4 addresses, and returns the number of addresses between them
(including the first one, excluding the last one).

All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater than the first one.

Examples
* With input "10.0.0.0", "10.0.0.50"  => return   50
* With input "10.0.0.0", "10.0.1.0"   => return  256
* With input "20.0.0.10", "20.0.1.0"  => return  246
 */

import java.util.Arrays;

public class CountIPAddresses {
    public static long ipsBetween(String start, String end) {
        long ipsBetween = 0;
        long[] startIp = Arrays.stream(start.split("\\.")).mapToLong(Long::parseLong).toArray();
        long[] endIp = Arrays.stream(end.split("\\.")).mapToLong(Long::parseLong).toArray();

        ipsBetween = (endIp[0] - startIp[0]) * 256 * 256 * 256 + (endIp[1] - startIp[1]) * 256 * 256 + (endIp[2] - startIp[2]) * 256 + (endIp[3] - startIp[3]);

        return ipsBetween;
    }

}
