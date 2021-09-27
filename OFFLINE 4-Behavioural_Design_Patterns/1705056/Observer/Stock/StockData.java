package Stock;

import java.io.Serializable;

public class StockData implements Serializable {
    private String name;
    private int cnt;
    private double price;

    public StockData(String name, int cnt, double price) {
        this.name = name;
        this.cnt = cnt;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
