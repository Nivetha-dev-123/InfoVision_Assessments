package Entity;

import java.util.*;
import Exception.StockNotFoundException;

public class Market {
    private final Map<String, Stock> stocks = new HashMap<>();

    public void addStock(Stock stock) {
        stocks.put(stock.getStockId(), stock);
    }

    public synchronized Stock getStock(String stockId) throws StockNotFoundException {
        Stock stock = stocks.get(stockId);
        if (stock == null) {
            throw new StockNotFoundException("Stock with ID " + stockId + " not found.");
        }
        return stock;
    }

    public Collection<Stock> getAllStocks() {
        return stocks.values();
    }
}
