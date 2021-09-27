package Pizza;

import Food.Food;

public abstract class Pizza implements Food {
    @Override
    public String description() {
        return "Pizza";
    }
}
