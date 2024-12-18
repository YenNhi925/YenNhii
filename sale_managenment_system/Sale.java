/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sale_managenment_system;

public class Sale {
    private final Product product;
    private final Customer customer;

    public Sale(Product product, Customer customer) {
        this.product = product;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return customer.getName() + " bought " + product.getName() + " for $" + product.getPrice();
    }
}

