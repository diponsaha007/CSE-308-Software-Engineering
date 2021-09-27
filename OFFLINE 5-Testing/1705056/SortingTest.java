import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {
    void checkSort(ArrayList<Integer> a) {
        //this function checks if sorting is done correctly

        System.out.println ("Testing for " + a);
        //saving a
        ArrayList<Integer> temp = new ArrayList<> (a);

        ArrayList<Integer> sorted_list = Sorting.sort (a);

        System.out.println ("Sorted list " + sorted_list);
        //checking if both array are equal before and after function call
        assertEquals (a, temp);
        //checking if the array is sorted in ascending order
        MyAssertions.isSortedAscending (sorted_list);
        //checking if the contents are same
        MyAssertions.isSameContent (a, sorted_list);

        System.out.println ("Test passed!");
    }

    @Test
    void blankList() {
        //blank list
        ArrayList<Integer> a = new ArrayList<> ();
        checkSort (a);
    }

    @Test
    void singleNumber() {
        //a single number
        ArrayList<Integer> a = new ArrayList<> ();
        Random random = new Random ();
        a.add (random.nextInt ());
        checkSort (a);
    }

    @Test
    void twoNumberAscending() {
        //two numbers in ascending order
        ArrayList<Integer> a = new ArrayList<> ();
        Random random = new Random ();
        a.add (random.nextInt (101));
        a.add (random.nextInt (101) + a.get (0));
        checkSort (a);
    }

    @Test
    void twoNumberDescending() {
        //two numbers in descending order
        ArrayList<Integer> a = new ArrayList<> ();
        Random random = new Random ();
        a.add (random.nextInt (101));
        a.add (a.get (0) - random.nextInt (101));
        checkSort (a);
    }

    @Test
    void randomNumbers1() {
        //random small non-negative numbers
        for (int rep = 0; rep < 5; rep++) {
            ArrayList<Integer> a = new ArrayList<> ();
            Random random = new Random ();
            int size = random.nextInt (30) + 3;
            for (int i = 0; i < size; i++) {
                a.add (random.nextInt (101));
            }
            checkSort (a);
        }
    }

    @Test
    void randomNumbers2() {
        //random big non-negative numbers
        for (int rep = 0; rep < 5; rep++) {
            ArrayList<Integer> a = new ArrayList<> ();
            Random random = new Random ();
            int size = random.nextInt (30) + 3;
            for (int i = 0; i < size; i++) {
                a.add (random.nextInt (1000000000) + 1000000000);
            }
            checkSort (a);
        }
    }

    @Test
    void randomNumbers3() {
        //random numbers with positive and negative value
        //repeating the same test set 5 times
        for (int rep = 0; rep < 5; rep++) {
            ArrayList<Integer> a = new ArrayList<> ();
            Random random = new Random ();
            int size = random.nextInt (30) + 3;
            for (int i = 0; i < size; i++) {
                int val = random.nextInt ();
                a.add (val);
            }
            checkSort (a);
        }
    }

    @Test
    void randomNumbers4() {
        //random numbers with negative value
        for (int rep = 0; rep < 5; rep++) {
            ArrayList<Integer> a = new ArrayList<> ();
            Random random = new Random ();
            int size = random.nextInt (30) + 3;
            for (int i = 0; i < size; i++) {
                int val = random.nextInt (1000000000) + 1;
                val = -val;
                a.add (val);
            }
            checkSort (a);
        }
    }

    @Test
    void AscendingOrder() {
        //numbers in ascending order
        for (int rep = 0; rep < 5; rep++) {
            ArrayList<Integer> a = new ArrayList<> ();
            Random random = new Random ();
            int size = random.nextInt (30) + 3;
            for (int i = 0; i < size; i++) {
                int val = random.nextInt (101);
                if (a.isEmpty ())
                    a.add (val);
                else
                    a.add (a.get (a.size () - 1) + val);
            }
            checkSort (a);
        }
    }

    @Test
    void DescendingOrder() {
        //numbers in descending order
        for (int rep = 0; rep < 5; rep++) {
            ArrayList<Integer> a = new ArrayList<> ();
            Random random = new Random ();
            int size = random.nextInt (30) + 3;
            for (int i = 0; i < size; i++) {
                int val = random.nextInt (101);
                if (a.isEmpty ())
                    a.add (val);
                else
                    a.add (a.get (a.size () - 1) - val);
            }
            checkSort (a);
        }
    }

    @Test
    void equalPositiveNumbers() {
        //all numbers are equal and positive
        for (int rep = 0; rep < 5; rep++) {
            ArrayList<Integer> a = new ArrayList<> ();
            Random random = new Random ();
            int size = random.nextInt (30) + 2;
            a.add (random.nextInt (10001) + 1);
            for (int i = 1; i < size; i++) {
                a.add (a.get (a.size () - 1));
            }
            checkSort (a);
        }
    }

    @Test
    void equalNegativeNumbers() {
        //all numbers are equal and negative
        for (int rep = 0; rep < 5; rep++) {
            ArrayList<Integer> a = new ArrayList<> ();
            Random random = new Random ();
            int size = random.nextInt (30) + 2;
            a.add (-random.nextInt (10001) - 1);
            for (int i = 1; i < size; i++) {
                a.add (a.get (a.size () - 1));
            }
            checkSort (a);
        }
    }

    @Test
    void allZero() {
        //all numbers are equal and zero
        ArrayList<Integer> a = new ArrayList<> ();
        Random random = new Random ();
        int size = random.nextInt (30) + 2;
        a.add (0);
        for (int i = 1; i < size; i++) {
            a.add (a.get (a.size () - 1));
        }
        checkSort (a);
    }
}