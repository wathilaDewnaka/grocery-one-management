public class Customer {
    private String customer_name;
    private String customer_id;
    private String order_ID;
    private int qty;
    private double total_Price;
    private int status;

    public Customer(String order_ID, String customer_id, String customer_name, int qty, double total_Price, int status) {
        this.order_ID = order_ID;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.qty = qty;
        this.total_Price = total_Price;
        this.status = status;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(String order_ID) {
        this.order_ID = order_ID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(double total_Price) {
        this.total_Price = total_Price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
