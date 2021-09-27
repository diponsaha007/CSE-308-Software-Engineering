import Appetizer.FrenchFries;
import Appetizer.OnionRings;
import Drinks.Coffee;
import Drinks.Coke;
import Food.Food;
import Pizza.BeefPizza;
import Pizza.VeggiPizza;

public class Main {

    public static void main(String[] args) {
        //Beef Pizza with French fry
        Food food = new FrenchFries (new BeefPizza ());
        System.out.println (food.description ());
        System.out.println ("Cost : "+food.cost ());

        //Veggi Pizza with onion rings
        Food food1 = new OnionRings (new VeggiPizza ());
        System.out.println (food1.description ());
        System.out.println ("Cost : "+food1.cost ());

        //A combo meal with Veggi Pizza, French Fry and Coke
        Food food2 = new Coke (new FrenchFries ( new VeggiPizza ()));
        System.out.println (food2.description ());
        System.out.println ("Cost : "+food2.cost ());

        //A combo meal with Veggi Pizza, Onion Rings and Coffee
        Food food3 = new Coffee (new OnionRings ( new VeggiPizza ()));
        System.out.println (food3.description ());
        System.out.println ("Cost : "+food3.cost ());

        //A Beef Pizza only
        Food food4 = new BeefPizza ();
        System.out.println (food4.description ());
        System.out.println ("Cost : "+food4.cost ());
    }
}
