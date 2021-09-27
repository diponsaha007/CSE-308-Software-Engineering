package Drinks;

import Food.Food;
import Food.FoodDecorator;

public abstract class Drinks extends FoodDecorator {
    public Drinks(Food food) {
        super (food);
    }
}
