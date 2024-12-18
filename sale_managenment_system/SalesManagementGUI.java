/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sale_managenment_system;

import javax.swing.*;

public class SalesManagementGUI {
    private SalesManager manager = new SalesManager();
    private JFrame frame;
    private JTextArea displayArea;

    public SalesManagementGUI() {
        frame = new JFrame("Sales Management System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton addProductButton = new JButton("Add Product");
        addProductButton.setBounds(50, 50, 150, 30);
        frame.add(addProductButton);

        JButton addCustomerButton = new JButton("Add Customer");
        addCustomerButton.setBounds(50, 100, 150, 30);
        frame.add(addCustomerButton);

        JButton recordSaleButton = new JButton("Record Sale");
        recordSaleButton.setBounds(50, 150, 150, 30);
        frame.add(recordSaleButton);

        JButton listSalesButton = new JButton("List Sales Records");
        listSalesButton.setBounds(50, 200, 150, 30);
        frame.add(listSalesButton);

        displayArea = new JTextArea();
        displayArea.setBounds(50, 250, 400, 150);
        frame.add(displayArea);

        // thêm sản phẩm 
        addProductButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Product Name:");
            String priceStr = JOptionPane.showInputDialog("Enter Product Price:");
            if (name != null && priceStr != null) {
                try {
                    double price = Double.parseDouble(priceStr);
                    manager.addProduct(name, price);
                    JOptionPane.showMessageDialog(frame, "Product added successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid price!");
                }
            }
        });
// thêm khách hàng 
        
        addCustomerButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Customer Name:");
            if (name != null) {
                manager.addCustomer(name);
                JOptionPane.showMessageDialog(frame, "Customer added successfully!");
            }
        });
// ghi nhận bán hàng 
        
        recordSaleButton.addActionListener(e -> {
            if (manager.getProducts().isEmpty() || manager.getCustomers().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Add products and customers first!");
                return;
            }

            Product product = manager.getProducts().get(0); 
            Customer customer = manager.getCustomers().get(0); 
            manager.recordSale(product, customer);
            JOptionPane.showMessageDialog(frame, "Sale recorded successfully!");
        });

       // liệt kê hoá đơn
        listSalesButton.addActionListener(e -> {
            displayArea.setText(manager.listSales());
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SalesManagementGUI());
    }
}