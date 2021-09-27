package Food;

public abstract class FoodDecorator implements Food {
    private Food food;

    public FoodDecorator(Food food) {
        this.food = food;
    }

    @Override
    public String description() {
        return food.description ();
    }

    @Override
    public int cost() {
        return food.cost ();
    }
}
