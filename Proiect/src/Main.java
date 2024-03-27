import Classes.Category;
import Classes.Distributor;
import Classes.Product;
import Classes.Stock;
import Services.StoreService;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        StoreService storeService = new StoreService();

        //Adaugare produse si distribuitori pentru a testa
        Category electronics = new Category("Electronice");
        Category clothing = new Category("Imbracaminte");

        Distributor distributor1 = new Distributor("Emag");
        Distributor distributor2 = new Distributor("Amazon");

        Product laptop = new Product("Laptop", 1500.0, electronics);
        Product shirt = new Product("Camasa", 50.0, clothing);

        // Adaugare stoc la produse
        Stock laptopStock = new Stock("Laptop", 1500.0, electronics, 10);
        Stock shirtStock = new Stock("Camasa", 50.0, clothing, 20);

        storeService.addStock(laptopStock);
        storeService.addStock(shirtStock);

        // Adăugare nume pentru distribuitori
        storeService.addDistributor("Emag", distributor1);
        storeService.addDistributor("Amazon", distributor2);

        // Testare
        System.out.println("Lista de stocuri:");
        for (Stock stock : storeService.getStockList()) {
            System.out.println("Produs: " + stock.getName() + ", Cantitate: " + stock.getQuantity());
        }

        System.out.println("\nMapa de distribuitori:");
        for (Map.Entry<String, Distributor> entry : storeService.getDistributorMap().entrySet()) {
            System.out.println("Nume: " + entry.getKey() + ", Distribuitor: " + entry.getValue().getName());
        }
    }
}
