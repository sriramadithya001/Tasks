import java.io.*;
import java.util.*;
import java.util.regex.*;

class FoodItem {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class FoodMenu {
    private List<FoodItem> items = new ArrayList<>();

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public List<FoodItem> getItems() {
        return items;
    }
}

class Order {
    private List<FoodItem> orderItems = new ArrayList<>();

    public void addFoodItem(FoodItem item) {
        orderItems.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (FoodItem item : orderItems) {
            total += item.getPrice();
        }
        return total;
    }

    public List<FoodItem> getOrderItems() {
        return orderItems;
    }
}

public class FoodOrderApp {
    private FoodMenu menu = new FoodMenu();
    private Order currentOrder = new Order();

    public void displayMenu() {
        System.out.println("Menu:");
        List<FoodItem> items = menu.getItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + ". " + items.get(i).getName() + " - Rs." + items.get(i).getPrice());
        }
    }

    public void addToOrder(int menuItemIndex) {
        List<FoodItem> items = menu.getItems();
        if (menuItemIndex >= 0 && menuItemIndex < items.size()) {
            currentOrder.addFoodItem(items.get(menuItemIndex));
            System.out.println("Added " + items.get(menuItemIndex).getName() + " to your order.");
        } else {
            System.out.println("Invalid menu item.");
        }
    }

    public void displayOrder() {
        System.out.println("Your Order:");
        List<FoodItem> items = currentOrder.getOrderItems();
        for (FoodItem item : items) {
            System.out.println(item.getName() + " - Rs" + item.getPrice());
        }
        System.out.println("Total: Rs." + currentOrder.calculateTotal());
    }

    public void saveOrderToFile() {
        try (PrintWriter writer = new PrintWriter("C:\\Users\\Administrator\\Desktop\\Test_4\\order.txt")) {
            List<FoodItem> items = currentOrder.getOrderItems();
            for (FoodItem item : items) {
                writer.println(item.getName() + " - Rs." + item.getPrice());
            }
            writer.println("Total: Rs." + currentOrder.calculateTotal());
            System.out.println("Order saved to order.txt");
        } catch (IOException e) {
            System.out.println("Error saving the order.");
        }
    }

    public static void main(String[] args) {
        FoodOrderApp app = new FoodOrderApp();

        FoodItem item1 = new FoodItem("Pizza", 400);
        FoodItem item2 = new FoodItem("Burger", 200);
        FoodItem item3 = new FoodItem("Salad", 100);

        app.menu.addItem(item1);
        app.menu.addItem(item2);
        app.menu.addItem(item3);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Display Menu");
            System.out.println("2. Add to Order");
            System.out.println("3. Display Order");
            System.out.println("4. Save Order to File");
            System.out.println("5. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    app.displayMenu();
                    break;
                case 2:
                    System.out.print("Enter the menu item number to add to the order: ");
                    int menuItemIndex = scanner.nextInt();
                    app.addToOrder(menuItemIndex - 1);
                    break;
                case 3:
                    app.displayOrder();
                    break;
                case 4:
                    app.saveOrderToFile();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
