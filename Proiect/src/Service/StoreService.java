package Services;

import Classes.Category;
import Classes.Distributor;
import Classes.Product;
import Classes.Stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class StoreService {
    private List<Stock> stockList;
    private Map<String, Distributor> distributorMap;

    public StoreService() {
        this.stockList = new ArrayList<>();
        this.distributorMap = new HashMap<>();
    }

    public void addStock(Stock stock) {
        stockList.add(stock);
    }

    public void removeStock(Stock stock) {
        stockList.remove(stock);
    }

    public void addDistributor(String name, Distributor distributor) {
        distributorMap.put(name, distributor);
    }

    public void removeDistributor(String name) {
        distributorMap.remove(name);
    }


    public List<Stock> getStockList() {
        return stockList;
    }

    public Map<String, Distributor> getDistributorMap() {
        return distributorMap;
    }
}