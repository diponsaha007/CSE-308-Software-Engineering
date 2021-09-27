package Appetizer;

import Food.Food;

public class OnionRings extends Appetizer {
    public OnionRings(Food food) {
        super (food);
    }

    @Override
    public String description() {
        return super.description () + " with onion rings";
    }

}
