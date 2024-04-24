package Implement;

import Service.StoreServiceInterface;
import Classes.Category;
import Classes.Distributor;
import Classes.Product;
import Classes.Stock;
import Service.WriteService;
import Service.ReadService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreServiceImpl implements StoreServiceInterface {
    private static StoreServiceImpl instance;
    private List<Category> categories;
    private List<Distributor> distributors;
    private List<Product> products;
    private List<Stock> stocks;
    private Map<String, Distributor> distributorMap;

    private StoreServiceImpl() {
        this.categories = new ArrayList<>();
        this.distributors = new ArrayList<>();
        this.products = new ArrayList<>();
        this.stocks = new ArrayList<>();
        this.distributorMap = new HashMap<>();
    }

    public static StoreServiceImpl getInstance() {
        if (instance == null) {
            instance = new StoreServiceImpl();
        }
        return instance;
    }

    @Override
    public void addCategory(Category category) {
        categories.add(category);
    }

    @Override
    public Category getCategoryByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public List<Stock> getStockList() {
        return stocks;
    }

    @Override
    public Map<String, Distributor> getDistributorMap() {
        return distributorMap;
    }

    @Override
    public void addDistributor(String name, Distributor distributor) {
        distributorMap.put(name, distributor);
    }

    @Override
    public void removeDistributor(String name) {
        distributorMap.remove(name);
    }
}
