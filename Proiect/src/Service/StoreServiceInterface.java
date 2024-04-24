package Service;

import Classes.Category;
import Classes.Distributor;
import Classes.Product;
import Classes.Stock;
import java.util.List;
import java.util.Map;

public interface StoreServiceInterface {
    void addCategory(Category category);

    Category getCategoryByName(String name);

    void addProduct(Product product);

    void addStock(Stock stock);

    List<Stock> getStockList();

    Map<String, Distributor> getDistributorMap();

    void addDistributor(String name, Distributor distributor);

    void removeDistributor(String name);

}
