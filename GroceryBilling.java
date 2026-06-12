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

    public double getItemTotal() {
        return price * quantity;
    }
}

class Bill {
    private ArrayList<Item> items;
    private static final double GST_RATE = 0.05;

    public Bill() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateSubtotal() {
        double subtotal = 0;

        for (Item item : items) {
            subtotal += item.getItemTotal();
        }

        return subtotal;
    }

    public double calculateTax() {
        return calculateSubtotal() * GST_RATE;
    }

    public double calculateGrandTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public void printReceipt() {
        System.out.println("\n========== GROCERY BILL ==========");
        System.out.printf("%-5s %-15s %-10s %-10s %-10s%n",
                "No", "Item", "Price", "Qty", "Total");

        int count = 1;

        for (Item item : items) {
            System.out.printf("%-5d %-15s %-10.2f %-10d %-10.2f%n",
                    count++,
                    item.getName(),
                    item.getPrice(),
                    item.getQuantity(),
                    item.getItemTotal());
        }

        double subtotal = calculateSubtotal();
        double tax = calculateTax();
        double grandTotal = calculateGrandTotal();

        System.out.println("----------------------------------");
        System.out.printf("Subtotal     : %.2f%n", subtotal);
        System.out.printf("GST (5%%)     : %.2f%n", tax);
        System.out.printf("Grand Total  : %.2f%n", grandTotal);
        System.out.println("==================================");
    }
}

public class GroceryBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bill bill = new Bill();

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nItem " + i);

            System.out.print("Enter item name: ");
            String name = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            bill.addItem(new Item(name, price, quantity));
        }

        bill.printReceipt();

        sc.close();
    }
}
