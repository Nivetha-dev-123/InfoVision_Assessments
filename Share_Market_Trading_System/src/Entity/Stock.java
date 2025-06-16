package Entity;

import Exception.InsufficientMarketSharesException;

public class Stock {
    private final String stockId;
    private final String stockName;
    private final double pricePerShare;
    private int availableShares;

    public Stock(String stockId, String stockName, double pricePerShare, int availableShares) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.pricePerShare = pricePerShare;
        this.availableShares = availableShares;
    }

    public String getStockId() {
        return stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }

    public synchronized int getAvailableShares() {
        return availableShares;
    }

    public synchronized void buyShares(int quantity) throws InsufficientMarketSharesException {
        if (quantity > availableShares) {
            throw new InsufficientMarketSharesException("Only " + availableShares + " shares available in market for " + stockName);
        }
        availableShares -= quantity;
    }

    public synchronized void sellShares(int quantity) {
        availableShares += quantity;
    }
}
