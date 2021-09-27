package Appetizer;

import Food.Food;

public class FrenchFries extends Appetizer {
    public FrenchFries(Food food) {
        super (food);
    }

    @Override
    public String description() {
        return super.description () + " with french fries";
    }

}
