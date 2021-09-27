package Drinks;

import Food.Food;

public class Coffee extends Drinks {
    public Coffee(Food food) {
        super (food);
    }

    @Override
    public String description() {
        return super.description () + " and coffee";
    }

    @Override
    public int cost() {
        return super.cost () + 30;
    }
}
