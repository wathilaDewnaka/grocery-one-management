import java.sql.*;
import java.util.LinkedList;

public class AddBurger {
    public static LinkedList<Customer> details = new LinkedList<Customer>();
    public static LinkedList<Customer> unique_details = new LinkedList<Customer>();
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "";

    public void add(Customer customer){
        details.add(customer);
    }

    public void add(int index, Customer customer){
        details.add(index,customer);
    }

    public void pop(){
        details.pop();
    }

    public void delete(int index){
        details.remove(index);
    }

    public LinkedList<Customer> getDetails(){
        return details;
    }

    public void clear_unique(){
        unique_details.clear();

    }

    public void unique_copy(){
        unique_details.addAll(details);

    }

    public void total(){
        for (int i = 0; i < unique_details.size(); i++) {
            for (int j = i + 1; j < unique_details.size(); j++) {
                if (unique_details.get(i).getCustomer_id().equals(unique_details.get(j).getCustomer_id())){
                    double total = unique_details.get(i).getTotal_Price() + unique_details.get(j).getTotal_Price();
                    unique_details.get(i).setTotal_Price(total);

                    unique_details.remove(j);
                }
            }
        }
    }


    public void print(){
        for (int i = 0; i < unique_details.size() - 1; i++) {
            for (int j = 0; j < unique_details.size() - i - 1; j++) {
                if (unique_details.get(j).getTotal_Price() < unique_details.get(j + 1).getTotal_Price()) {
                    // swap unique_details[j] and unique_details[j+1]
                    Customer temp = unique_details.get(j);
                    unique_details.set(j, unique_details.get(j + 1));
                    unique_details.set(j + 1, temp);
                }
            }
        }

    }


    public void createDatabase(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to MySQL
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // Check if database exists, if not create one
            ResultSet resultSet = conn.getMetaData().getCatalogs();
            boolean databaseExists = false;
            while (resultSet.next()) {
                String databaseName = resultSet.getString(1);
                if (databaseName.equals("groceryone")) {
                    databaseExists = true;
                    break;
                }
            }
            resultSet.close();
            if (!databaseExists) {
                stmt.executeUpdate("CREATE DATABASE GroceryOne");
            }

            // Use the database
            stmt.executeUpdate("USE GroceryOne");

            // Check if table exists, if not create one
            ResultSet tables = conn.getMetaData().getTables(null, null, "GroceryOne_Details", null);
            if (!tables.next()) {
                stmt.executeUpdate("CREATE TABLE GroceryOne_Details (OrderID VARCHAR(255) PRIMARY KEY, CustomerName VARCHAR(255), CustomerID INT, Quantity INT, TotalPrice DOUBLE,Status INT)");
            }

            // Execute query to fetch data
            String sql = "SELECT OrderID, CustomerName, CustomerID, Quantity, TotalPrice, Status FROM GroceryOne_Details";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String orderId = rs.getString("OrderID");
                String customerName = rs.getString("CustomerName");
                int customerId = rs.getInt("CustomerID");
                int quantity = rs.getInt("Quantity");
                double totalPrice = rs.getDouble("TotalPrice");
                int status =  rs.getInt("Status");


                // Create a Customer object and add it to the linked list
                Customer customer = new Customer(String.valueOf(orderId),  String.valueOf(customerId),customerName, quantity, totalPrice, status);
                details.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void insertToDatabase(Customer customer){
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            // Connect to MySQL
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement statement = conn.createStatement();
            statement.execute("USE GroceryOne");


            // Prepare statement for inserting new order details
            String sql = "INSERT INTO GroceryOne_Details (OrderID, CustomerName, CustomerID, Quantity, TotalPrice,Status) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            // Set values for the parameters in the prepared statement
            stmt.setString(1, customer.getOrder_ID());
            stmt.setString(2,  customer.getCustomer_name());
            stmt.setInt(3, Integer.valueOf(customer.getCustomer_id()));
            stmt.setInt(4, Integer.valueOf(customer.getQty()));
            stmt.setDouble(5, customer.getTotal_Price());
            stmt.setInt(6,customer.getStatus());


            // Execute the insert statement
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new order was inserted successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    public void dropDatabase(){
        String databaseName = "groceryone"; // Database to be deleted

        // JDBC connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER,PASS);
             Statement stmt = conn.createStatement()) {

            // SQL command to delete the database
            String sql = "DROP DATABASE " + databaseName;

            // Execute the SQL command
            stmt.executeUpdate(sql);

            System.out.println("Database " + databaseName + " deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
