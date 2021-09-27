package Pizza;

public class VeggiPizza extends Pizza{
    @Override
    public String description() {
        return "Veggi "+super.description ();
    }

    @Override
    public int cost() {
        return 300;
    }
}