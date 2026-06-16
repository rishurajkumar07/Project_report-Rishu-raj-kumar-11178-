import java.util.*;

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

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

    public Bill(Item[] items) {
        this.items = items;
        calculateTotal();
    }

    private void calculateTotal() {
        total = 0;

        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }

        tax = total * 0.05; // 5% GST
        grandTotal = total + tax;
    }

    public void generateReceipt() {
        System.out.println("\n------ Grocery Bill ------");
        System.out.println("Item\tPrice\tQty\tTotal");

        for (Item item : items) {
            double itemTotal = item.getPrice() * item.getQuantity();
            System.out.println(item.getName() + "\t" +
                    item.getPrice() + "\t" +
                    item.getQuantity() + "\t" +
                    itemTotal);
        }

        System.out.println("--------------------------");
        System.out.println("Total: " + total);
        System.out.println("Tax (5%): " + tax);
        System.out.println("Grand Total: " + grandTotal);
    }
}

// Main Class
public class GroceryBilling2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of item " + (i + 1));

            System.out.print("Item Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            items[i] = new Item(name, price, quantity);
        }

        Bill bill = new Bill(items);
        bill.generateReceipt();

        sc.close();
    }
}
