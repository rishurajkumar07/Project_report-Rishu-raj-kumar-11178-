import java.util.*;

// Item Class
class Item {
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Bill Class
class Bill {
    private Item[] items;
    private double total;
    private double tax;
    private double grandTotal;

    // Constructor
    public Bill(Item[] items) {
        this.items = items;
        calculateTotal();
    }

    // Calculate total and tax
    private void calculateTotal() {
        total = 0;

        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }

        tax = total * 0.05; // 5% GST
        grandTotal = total + tax;
    }

    // Generate Receipt
    public void generateReceipt() {
        StringBuilder sb = new StringBuilder();

        sb.append("------ Grocery Bill ------\n");
        sb.append("Item\tPrice\tQty\tTotal\n");

        for (Item item : items) {
            double itemTotal = item.getPrice() * item.getQuantity();
            sb.append(item.getName()).append("\t")
              .append(item.getPrice()).append("\t")
              .append(item.getQuantity()).append("\t")
              .append(itemTotal).append("\n");
        }

        sb.append("--------------------------\n");
        sb.append("Total: ").append(total).append("\n");
        sb.append("Tax (5%): ").append(tax).append("\n");
        sb.append("Grand Total: ").append(grandTotal).append("\n");

        System.out.println(sb.toString());
    }
}

// Main Class
public class GroceryBilling {
    public static void main(String[] args) {

        // Sample Input
        Item[] items = {
            new Item("Rice", 50, 2),
            new Item("Milk", 30, 3)
        };

        // Create Bill
        Bill bill = new Bill(items);

        // Generate Receipt
        bill.generateReceipt();
    }
}
