package order.order;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private String customer_name;

    private String food_item;

    private int quantity;

    private double total_amount;

    private LocalDate order_date;

    private String order_status;

    public Order() {
    }

    public Order(String customer_name, String food_item, int quantity, double total_amount,
                 LocalDate order_date, String order_status) {
        this.customer_name = customer_name;
        this.food_item = food_item;
        this.quantity = quantity;
        this.total_amount = total_amount;
        this.order_date = order_date;
        this.order_status = order_status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getFood_item() {
        return food_item;
    }

    public void setFood_item(String food_item) {
        this.food_item = food_item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customer_name=" + customer_name
                + ", food_item=" + food_item + ", quantity=" + quantity
                + ", total_amount=" + total_amount + ", order_date=" + order_date
                + ", order_status=" + order_status + "]";
    }
}
