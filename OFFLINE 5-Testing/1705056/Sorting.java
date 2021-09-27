import java.util.ArrayList;

public class Sorting {
    public static ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer>a = new ArrayList<> (input);
        int n = a.size ();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a.get (j) > a.get (j + 1)) {
                    // swap index j and j+1
                    int temp = a.get (j);
                    a.set (j, a.get (j + 1));
                    a.set (j + 1, temp);
                }
            }
        }
        return a;
    }
}
