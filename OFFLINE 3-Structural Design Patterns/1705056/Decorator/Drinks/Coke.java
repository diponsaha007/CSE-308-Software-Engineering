package Drinks;

import Food.Food;

public class Coke extends Drinks{
    public Coke(Food food) {
        super (food);
    }

    @Override
    public String description() {
        return super.description () + " and coke";
    }

    @Override
    public int cost() {
        return super.cost () + 20;
    }
}
