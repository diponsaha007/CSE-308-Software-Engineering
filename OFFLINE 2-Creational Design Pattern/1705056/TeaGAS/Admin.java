import java.util.ArrayList;

public class Admin {
    private Components components;
    private ArrayList<String> leafcollector;

    public Admin(Components c) {
        components = c;
        leafcollector = new ArrayList<> ();
    }

    public void add(String name) {
        for (String s : leafcollector) {
            if (s.equals (name)) {
                System.out.println ("Name already in database!");
                return;
            }
        }
        leafcollector.add (name);
        System.out.println ("Successfully added " + name);
    }

    public void remove(String name) {
        if (leafcollector.remove (name)) {
            System.out.println ("Removed " + name);
        }
        else {
            System.out.println (name + " not found");
        }
    }

    public void analyze() {
        System.out.println ("Analyzing the data.");
    }

    public void show() {
        components.show ();
    }

    public void weightMeasurement(String name) {
        boolean flag = false;
        for (String s : leafcollector) {
            if (s.equals (name)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println (name + " is not recognized!");
            return;
        }
        System.out.println ("Measuring weight with " + components.getaPackage ().weightMeasurement ().option ());
    }
}
