package JavaAssessment;

import java.util.*;

public class OrderSystem {

    // Inner classes (inside same class)
    static class Item {
        String name;
        double price;
        int quantity;
        int reorderLevel;

        Item(String name, double price, int quantity, int reorderLevel) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.reorderLevel = reorderLevel;
        }
    }

    static class Customer {
        String name, address, phone, email;

        Customer(String name, String address, String phone, String email) {
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.email = email;
        }
    }

    static class Order {
        int orderId;
        Customer customer;
        List<Item> items;
        Date date;
        double totalAmount;

        Order(int orderId, Customer customer, List<Item> items) {
            this.orderId = orderId;
            this.customer = customer;
            this.items = items;
            this.date = new Date();

            totalAmount = 0;
            for (Item i : items) {
                totalAmount += i.price;
            }
        }
    }

    static List<Item> itemList = new ArrayList<>();
    static List<Customer> customerList = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Item
    static void addItem() {
        System.out.println("Enter item name:");
        String name = sc.next();

        System.out.println("Enter price:");
        double price = sc.nextDouble();

        System.out.println("Enter quantity:");
        int qty = sc.nextInt();

        System.out.println("Enter reorder level:");
        int reorder = sc.nextInt();

        itemList.add(new Item(name, price, qty, reorder));
        System.out.println("Item added successfully!");
    }

    // Add Customer
    static void addCustomer() {
        System.out.println("Enter customer name:");
        String name = sc.next();

        System.out.println("Enter address:");
        String address = sc.next();

        System.out.println("Enter phone:");
        String phone = sc.next();

        System.out.println("Enter email:");
        String email = sc.next();

        customerList.add(new Customer(name, address, phone, email));
        System.out.println("Customer added successfully!");
    }

    // Place Order
    static void placeOrder() {
        System.out.println("Enter Order ID:");
        int id = sc.nextInt();

        System.out.println("Enter Customer Name:");
        String cname = sc.next();

        Customer customer = null;

        for (Customer c : customerList) {
            if (c.name.equalsIgnoreCase(cname)) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        List<Item> selectedItems = new ArrayList<>();

        System.out.println("Enter number of items:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter item name:");
            String itemName = sc.next();

            for (Item item : itemList) {
                if (item.name.equalsIgnoreCase(itemName)) {

                    if (item.quantity <= item.reorderLevel) {
                        System.out.println("Cannot place order. " + item.name + " out of stock.");
                        return;
                    }

                    selectedItems.add(item);
                    item.quantity--;
                }
            }
        }

        orders.add(new Order(id, customer, selectedItems));
        System.out.println("Order placed successfully!");
    }

    // Search Item by Name
    static void searchItemByName() {
        System.out.println("Enter item name:");
        String name = sc.next();

        for (Item i : itemList) {
            if (i.name.equalsIgnoreCase(name)) {
                System.out.println("Item: " + i.name + " Price: " + i.price);
            }
        }
    }

    // Search Item by Price
    static void searchItemByPrice() {
        System.out.println("Enter price:");
        double price = sc.nextDouble();

        for (Item i : itemList) {
            if (i.price == price) {
                System.out.println("Item: " + i.name);
            }
        }
    }

    // 6. Get Order by ID (Simplified Output)
    static void getOrderById() {
        System.out.println("Enter order ID:");
        int id = sc.nextInt();

        for (Order o : orders) {
            if (o.orderId == id) {

                System.out.print("Customer: " + o.customer.name + " | Products: ");
                for (Item i : o.items) {
                    System.out.print(i.name + " ");
                }
                System.out.println();
                return;
            }
        }

        System.out.println("Order not found!");
    }

    // 7. Orders by Customer
    static void getOrdersByCustomer() {
        System.out.println("Enter customer name:");
        String name = sc.next();

        for (Order o : orders) {
            if (o.customer.name.equalsIgnoreCase(name)) {

                System.out.print("Customer: " + o.customer.name + " | Products: ");
                for (Item i : o.items) {
                    System.out.print(i.name + " ");
                }
                System.out.println();
            }
        }
    }

    // 8. Highest & Lowest Order
    static void getMaxMinOrder() {
        if (orders.isEmpty()) return;

        Order max = Collections.max(orders, Comparator.comparing(o -> o.totalAmount));
        Order min = Collections.min(orders, Comparator.comparing(o -> o.totalAmount));

        System.out.print("Highest -> Customer: " + max.customer.name + " | Products: ");
        for (Item i : max.items) {
            System.out.print(i.name + " ");
        }
        System.out.println();

        System.out.print("Lowest -> Customer: " + min.customer.name + " | Products: ");
        for (Item i : min.items) {
            System.out.print(i.name + " ");
        }
        System.out.println();
    }

    // 9. Last Week Orders
    static void getRecentOrders() {
        Date now = new Date();

        for (Order o : orders) {
            long diff = now.getTime() - o.date.getTime();
            long days = diff / (1000 * 60 * 60 * 24);

            if (days <= 7) {
                System.out.print("Customer: " + o.customer.name + " | Products: ");
                for (Item i : o.items) {
                    System.out.print(i.name + " ");
                }
                System.out.println();
            }
        }
    }

    // 10. Last Month Orders
    static void getLastMonthOrders() {
        Date now = new Date();

        for (Order o : orders) {
            long diff = now.getTime() - o.date.getTime();
            long days = diff / (1000 * 60 * 60 * 24);

            if (days <= 30) {
                System.out.print("Customer: " + o.customer.name + " | Products: ");
                for (Item i : o.items) {
                    System.out.print(i.name + " ");
                }
                System.out.println();
            }
        }
    }

    // MAIN
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Item");
            System.out.println("2. Add Customer");
            System.out.println("3. Place Order");
            System.out.println("4. Search Item by Name");
            System.out.println("5. Search Item by Price");
            System.out.println("6. Get Order by ID");
            System.out.println("7. Get Orders by Customer");
            System.out.println("8. Highest & Lowest Order");
            System.out.println("9. Recent Orders (Last Week)");
            System.out.println("10. Orders (Last Month)");
            System.out.println("11. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addItem(); break;
                case 2: addCustomer(); break;
                case 3: placeOrder(); break;
                case 4: searchItemByName(); break;
                case 5: searchItemByPrice(); break;
                case 6: getOrderById(); break;
                case 7: getOrdersByCustomer(); break;
                case 8: getMaxMinOrder(); break;
                case 9: getRecentOrders(); break;
                case 10: getLastMonthOrders(); break;
                case 11: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}