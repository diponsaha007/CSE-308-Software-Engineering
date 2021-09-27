package Client;

import Stock.*;
import util.*;

public interface iUser {
    void update(StockData stockData, String notification);

    String getUsername();

    void addStock(StockData st);

    void removeStock(StockData st);

    boolean hasStock(StockData st);
}
