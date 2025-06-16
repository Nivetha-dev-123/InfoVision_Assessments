package Interface;

import Exception.InsufficientMarketSharesException;
import Exception.InsufficientSharesException;
import Exception.StockNotFoundException;

public interface Tradeable {
	void buyStock(String stockId, int quantity) throws StockNotFoundException, InsufficientMarketSharesException;
    void sellStock(String stockId, int quantity) throws StockNotFoundException, InsufficientSharesException;
}



