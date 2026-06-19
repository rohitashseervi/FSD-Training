package order.order;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        OrderDAO dao = new OrderDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== ORDER MENU =====");
            System.out.println("1. Insert Order");
            System.out.println("2. Read All Orders");
            System.out.println("3. Update Order");
            System.out.println("4. Delete Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = sc.nextLine();
                    System.out.print("Enter food item: ");
                    String foodItem = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter total amount: ");
                    double totalAmount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter order date (yyyy-MM-dd): ");
                    LocalDate orderDate = LocalDate.parse(sc.nextLine());
                    System.out.print("Enter order status: ");
                    String orderStatus = sc.nextLine();
                    dao.saveOrder(new Order(customerName, foodItem, quantity, totalAmount, orderDate, orderStatus));
                    System.out.println("Order inserted successfully!");
                    break;

                case 2:
                    List<Order> orders = dao.getAllOrders();
                    if (orders.isEmpty()) {
                        System.out.println("No orders found.");
                    } else {
                        for (Order o : orders) {
                            System.out.println(o);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter id of order to update: ");
                    int updateId = sc.nextInt();
                    Order existing = dao.getOrder(updateId);
                    if (existing == null) {
                        System.out.println("Order not found.");
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Enter new customer name: ");
                    existing.setCustomer_name(sc.nextLine());
                    System.out.print("Enter new food item: ");
                    existing.setFood_item(sc.nextLine());
                    System.out.print("Enter new quantity: ");
                    existing.setQuantity(sc.nextInt());
                    System.out.print("Enter new total amount: ");
                    existing.setTotal_amount(sc.nextDouble());
                    sc.nextLine();
                    System.out.print("Enter new order date (yyyy-MM-dd): ");
                    existing.setOrder_date(LocalDate.parse(sc.nextLine()));
                    System.out.print("Enter new order status: ");
                    existing.setOrder_status(sc.nextLine());
                    dao.updateOrder(existing);
                    System.out.println("Order updated successfully!");
                    break;

                case 4:
                    System.out.print("Enter id of order to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteOrder(deleteId);
                    System.out.println("Order deleted (if it existed).");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
