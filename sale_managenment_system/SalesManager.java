/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sale_managenment_system;

import java.util.ArrayList;

public class SalesManager {
    private final ArrayList<Product> products = new ArrayList<>();
    private final ArrayList<Customer> customers = new ArrayList<>();
    private final ArrayList<Sale> sales = new ArrayList<>();

    public void addProduct(String name, double price) {
        products.add(new Product(name, price));
    }

    public void addCustomer(String name) {
        customers.add(new Customer(name));
    }

    public void recordSale(Product product, Customer customer) {
        sales.add(new Sale(product, customer));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String listSales() {
        if (sales.isEmpty()) {
            return "No sales recorded.";
        }
        StringBuilder result = new StringBuilder();
        for (Sale sale : sales) {
            result.append(sale.toString()).append("\n");
        }
        return result.toString();
    }
}
