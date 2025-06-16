package Entity;

import Interface.Tradeable;
import Exception.*;

import java.util.HashMap;
import java.util.Map;

public class Trader implements Tradeable {
    private final int traderId;
    private final String name;
    private final Market market;
    private final Map<String, Integer> portfolio = new HashMap<>();

    public Trader(int traderId, String name, Market market) {
        this.traderId = traderId;
        this.name = name;
        this.market = market;
    }

   
    @Override
    public void buyStock(String stockId, int quantity) throws StockNotFoundException, InsufficientMarketSharesException {
        synchronized (market) {
            Stock stock = market.getStock(stockId);
            stock.buyShares(quantity);
            portfolio.put(stockId, portfolio.getOrDefault(stockId, 0) + quantity);
            System.out.println(name + " bought " + quantity + " shares of " + stock.getStockName());
        }
    }

   
    public void buyStock(String stockId) throws StockNotFoundException, InsufficientMarketSharesException {
        buyStock(stockId, 1);
    }

   
    public void buyStock(String stockId, int quantity, boolean verbose) throws StockNotFoundException, InsufficientMarketSharesException {
        buyStock(stockId, quantity);
        if (verbose) {
            System.out.println(name + " now owns " + portfolio.get(stockId) + " shares of " + stockId);
        }
    }

    
    @Override
    public void sellStock(String stockId, int quantity) throws StockNotFoundException, InsufficientSharesException {
        synchronized (market) {
            int owned = portfolio.getOrDefault(stockId, 0);
            if (owned < quantity) {
                throw new InsufficientSharesException(name + " tried to sell " + quantity + " but owns only " + owned);
            }
            Stock stock = market.getStock(stockId);
            stock.sellShares(quantity);
            portfolio.put(stockId, owned - quantity);
            System.out.println(name + " sold " + quantity + " shares of " + stock.getStockName());
        }
    }

    
    public void sellStock(String stockId) throws StockNotFoundException, InsufficientSharesException {
        sellStock(stockId, 1);
    }

  
    public void sellStock(String stockId, int quantity, boolean verbose) throws StockNotFoundException, InsufficientSharesException {
        sellStock(stockId, quantity);
        if (verbose) {
            System.out.println(name + " remaining shares of " + stockId + ": " + portfolio.get(stockId));
        }
    }

    public void printPortfolio() {
        System.out.println("Portfolio of " + name + ": " + portfolio);
    }
}
