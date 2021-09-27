package Pizza;

public class BeefPizza extends Pizza{
    @Override
    public String description() {
        return "Beef "+super.description ();
    }

    @Override
    public int cost() {
        return 600;
    }
}
