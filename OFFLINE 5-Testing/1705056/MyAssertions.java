import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;


public class MyAssertions {
    public static void isSortedAscending(ArrayList<Integer> a) {
        int n = a.size ();
        for (int i = 1; i < n; i++) {
            //check is a[i] >= a[i-1]
            try {
                assertTrue (a.get (i) >= a.get (i - 1));
            } catch (AssertionError e) {
                String msg = "Element  (a[ " + (i - 1) + " ] =  " + a.get (i - 1) + ") > (a[ " + i + " ] = " + a.get (i) + ")";
                //System.out.println (msg);
                throw new AssertException (msg);
            }
        }
    }

    public static void isSameContent(ArrayList<Integer> a, ArrayList<Integer> b) {
        try {
            assertEquals (a.size (), b.size ());
        } catch (AssertionError e) {
            String msg = "Size of input =  " + a.size () + " , but size of sorted list = " + b.size ();
            throw new AssertException (msg);
        }

        for (int i : a) {
            int c1 = 0, c2 = 0;
            for (int j : a) {
                if (i == j)
                    c1++;
            }
            for (int j : b) {
                if (i == j)
                    c2++;
            }
            try {
                assertEquals (c1, c2);
            } catch (AssertionError e) {
                String msg = "Count mismatch of element " + i;
                throw new AssertException (msg);
            }
        }
    }

}
