package Appetizer;

import Food.Food;
import Food.FoodDecorator;

public abstract class Appetizer extends FoodDecorator {

    public Appetizer(Food food) {
        super (food);
    }

    @Override
    public int cost() {
        return 100+ super.cost ();
    }
}
