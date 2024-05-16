import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Objects;
import javax.swing.JFrame;

public class NewOrder extends JFrame{
    JTextField customerID_txt;
    JTextField qty_txt;
    JPanel bodyPanel;
    JTextField customerName_txt;


    public NewOrder(){

        setTitle("GroceryOne");
        setSize(1000, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());


        JPanel tittlePanel = new JPanel();
        tittlePanel.setPreferredSize(new Dimension(1000, 100));
        tittlePanel.setBackground(new Color(0,128,0));
        tittlePanel.setLayout(null);

        JLabel tittle = new JLabel("Place Order");
        tittle.setFont(new Font("",1,30));
        tittle.setForeground(Color.WHITE);
        tittle.setBounds(425, 30, 250, 50);
        tittlePanel.add(tittle);


        bodyPanel = new JPanel();
        bodyPanel.setPreferredSize(new Dimension(1000, 700));
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setLayout(null);

        JLabel orderID = new JLabel("Order ID :");
        orderID.setForeground(Color.BLACK);
        orderID.setFont(new Font("",1,20));
        orderID.setBounds(100, 180, 200, 50);

        JLabel orID = new JLabel(getOrderID());
        orID.setForeground(Color.BLACK);
        orID.setFont(new Font("",1,20));
        orID.setBounds(273, 180, 80, 50);


        JLabel customerID = new JLabel("Customer ID:");
        customerID.setForeground(Color.BLACK);
        customerID.setFont(new Font("",1,20));
        customerID.setBounds(100, 230, 200, 50);


        customerID_txt = new JTextField(10);
        customerID_txt.setFont(new Font("",0,20));
        customerID_txt.setBounds(273, 238, 200, 40);


        JLabel customerName = new JLabel("Customer Name :");
        customerName.setForeground(Color.BLACK);
        customerName.setFont(new Font("",1,20));
        customerName.setBounds(100, 340, 200, 50);


        customerName_txt = new JTextField(10);
        customerName_txt.setFont(new Font("",0,20));
        customerName_txt.setBounds(273, 348, 200, 40);


        JLabel qty = new JLabel("Item Quantity :");
        qty.setForeground(Color.BLACK);
        qty.setFont(new Font("",1,20));
        qty.setBounds(100, 400, 200, 50);


        qty_txt = new JTextField(10);
        qty_txt.setFont(new Font("",0,20));
        qty_txt.setBounds(273, 408, 200, 40);


        JLabel status = new JLabel("Order Status :");
        status.setForeground(Color.BLACK);
        status.setFont(new Font("",1,20));
        status.setBounds(100, 460, 200, 40);


        JLabel status_txt = new JLabel("Pending...");
        status_txt.setForeground(Color.BLACK);
        status_txt.setFont(new Font("",1,20));
        status_txt.setBounds(273, 454, 120, 50);

        bodyPanel.add(orderID);
        bodyPanel.add(customerID);
        bodyPanel.add(qty);
        bodyPanel.add(status);
        bodyPanel.add(customerID_txt);
        bodyPanel.add(orID);
        bodyPanel.add(qty_txt);
        bodyPanel.add(status_txt);
        bodyPanel.add(customerName);
        bodyPanel.add(customerName_txt);



        JButton placeOrderBTN = new JButton("Place Order");
        placeOrderBTN.setBackground(new Color(0, 128, 0));
        placeOrderBTN.setForeground(Color.WHITE);
        placeOrderBTN.setBounds(700, 240, 200, 40);
        placeOrderBTN.setFocusPainted(false);
        placeOrderBTN.setBorderPainted(false);
        placeOrderBTN.setFont(new Font("",1,16));

        // Back to home page :
        JButton backBTN = new JButton("Home");
        backBTN.setBackground(new Color(0, 128, 0));
        backBTN.setForeground(Color.WHITE);
        backBTN.setBounds(700, 310, 200, 40);
        backBTN.setFocusPainted(false);
        backBTN.setBorderPainted(false);
        backBTN.setFont(new Font("",1,16));

        // cancel :
        JButton cancelBTN = new JButton("Cancel");
        cancelBTN.setBackground(new Color(0, 128, 0));
        cancelBTN.setForeground(Color.WHITE);
        cancelBTN.setBounds(700, 380, 200, 40);
        cancelBTN.setFocusPainted(false);
        cancelBTN.setBorderPainted(false);
        cancelBTN.setFont(new Font("",1,16));


        bodyPanel.add(placeOrderBTN);
        bodyPanel.add(backBTN);
        bodyPanel.add(cancelBTN);


        add(tittlePanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.SOUTH);


        JLabel totalLabel = new JLabel("Total :");
        totalLabel.setForeground(Color.BLACK);
        totalLabel.setBounds(700, 480, 150, 40);
        totalLabel.setFont(new Font("",1, 20));


        JLabel totalValue = new JLabel("Rs. 0.00");
        totalValue.setForeground(new Color(0,128,0));
        totalValue.setBounds(780, 479, 300, 40);
        totalValue.setFont(new Font("",1, 25));


        bodyPanel.add(totalValue);
        bodyPanel.add(totalLabel);


        //Cancel Button :
        ActionListener cancel = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalValue.setText("Rs. 0.00");
                customerName_txt.setText("");
                customerID_txt.setText("");
                qty_txt.setText("");
            }
        };
        cancelBTN.addActionListener(cancel);


        //Back to home page Button :
        ActionListener mainMenu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Home(); // Call the home window
            }
        };
        backBTN.addActionListener(mainMenu);



        //Place order Button :
        ActionListener placeOrder = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(customerID_txt.getText().length() == 10 && customerName_txt.getText() != "" && qty_txt.getText() != ""){

                    // adding background color to the msg box :
                    JPanel panel = new JPanel();
                    panel.setForeground(Color.WHITE);
                    panel.setBackground(new Color(230, 232, 231));
                    panel.setPreferredSize(new Dimension(300, 100));
                    panel.setLayout(null);

                    JLabel label = new JLabel("Order successfull");
                    label.setBounds(93,13,290,20);
                    label.setFont(new Font("",1,13));

                    JButton okButton = new JButton("OK");
                    okButton.setBounds(121,55,55,27);
                    okButton.setBackground(new Color(0,128,0));
                    okButton.setForeground(Color.WHITE);
                    okButton.setFont(new Font("",1,12));
                    okButton.setFocusPainted(false);
                    okButton.setBorderPainted(false);

                    panel.add(label);
                    panel.add(okButton);

                    // Create a JDialog for your custom dialog
                    JDialog dialog = new JDialog();
                    dialog.setTitle("order");
                    dialog.setModal(true); // Make the dialog modal



                    // Handle button click events (if needed)
                    okButton.addActionListener(actionEvent -> {
                           Customer customer = new Customer(getOrderID(), customerID_txt.getText(), customerName_txt.getText(), Integer.valueOf(qty_txt.getText()), Integer.valueOf(qty_txt.getText()) * 500, 0);
                           AddBurger List = new AddBurger();
                           List.insertToDatabase(customer);
                           List.add(customer);

                        orID.setText(getOrderID());

                        totalValue.setText("Rs. 0.00");
                        customerName_txt.setText("");
                        customerID_txt.setText("");
                        qty_txt.setText("");

                        dialog.dispose();
                    });

                    dialog.setContentPane(panel);
                    dialog.setLocationRelativeTo(null);
                    dialog.pack();
                    dialog.setVisible(true);



                }else{

                    JPanel panel = new JPanel();
                    panel.setForeground(Color.WHITE);
                    panel.setBackground(new Color(230, 232, 231));
                    panel.setPreferredSize(new Dimension(300, 100));
                    panel.setLayout(null);

                    JLabel label = new JLabel("Wrong Customer ID");
                    label.setBounds(93,13,290,20);
                    label.setFont(new Font("",1,13));

                    JButton okButton = new JButton("OK");
                    okButton.setBounds(121,55,55,27);
                    okButton.setBackground(new Color(0,128,0));
                    okButton.setForeground(Color.WHITE);
                    okButton.setFont(new Font("",1,12));
                    okButton.setFocusPainted(false);
                    okButton.setBorderPainted(false);

                    panel.add(label);
                    panel.add(okButton);

                    // Create a JDialog for your custom dialog
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Error");
                    dialog.setModal(true); // Make the dialog modal



                    // Handle button click events (if needed)
                    okButton.addActionListener(actionEvent -> {
                        dialog.dispose();
                    });

                    dialog.setContentPane(panel);
                    dialog.setLocationRelativeTo(null);
                    dialog.pack();
                    dialog.setVisible(true);

                }



            }
        };
        placeOrderBTN.addActionListener(placeOrder);


        customerID_txt.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // This method is called when a key is typed
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // This method is called when a key is pressed
            }

            @Override
            public void keyReleased(KeyEvent e) {
                AddBurger List = new AddBurger();

                for (int i = 0; i < List.details.size(); i++) {
                   if (Objects.equals(List.details.get(i).getCustomer_id(), customerID_txt.getText())){
                       customerName_txt.setText(List.getDetails().get(i).getCustomer_name());
                       break;
                    }
                }


                // check is that first number is 0 :
                if(customerID_txt.getText().charAt(0) != '0'){


                    // adding background color to the msg box :
                    JPanel panel = new JPanel();
                    panel.setForeground(Color.WHITE);
                    panel.setBackground(new Color(230, 232, 231));
                    panel.setPreferredSize(new Dimension(300, 100));
                    panel.setLayout(null);

                    JLabel label = new JLabel("Please enter '0' at the beginning");
                    label.setBounds(45,13,290,20);
                    label.setFont(new Font("",1,13));

                    JButton okButton = new JButton("OK");
                    okButton.setBounds(121,55,55,27);
                    okButton.setBackground(new Color(0,128,0));
                    okButton.setForeground(Color.WHITE);
                    okButton.setFont(new Font("",1,12));
                    okButton.setFocusPainted(false);
                    okButton.setBorderPainted(false);

                    panel.add(label);
                    panel.add(okButton);

                    // Create a JDialog for your custom dialog
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Attention");
                    dialog.setModal(true); // Make the dialog modal



                    // Handle button click events (if needed)
                    okButton.addActionListener(actionEvent -> {

                        dialog.dispose();
                        customerID_txt.setText("");
                    });

                    dialog.setContentPane(panel);
                    dialog.setLocationRelativeTo(null);
                    dialog.pack();
                    dialog.setVisible(true);
                }

                if(customerID_txt.getText().length() > 10){

                    // adding background color to the msg box :
                    JPanel panel = new JPanel();
                    panel.setForeground(Color.WHITE);
                    panel.setBackground(new Color(230, 232, 231));
                    panel.setPreferredSize(new Dimension(300, 100));
                    panel.setLayout(null);

                    JLabel label = new JLabel("Please Enter only 10 numbers");
                    label.setBounds(52,13,290,20);
                    label.setFont(new Font("",1,13));

                    JButton okButton = new JButton("OK");
                    okButton.setBounds(121,55,55,27);
                    okButton.setBackground(new Color(0,128,0));
                    okButton.setForeground(Color.WHITE);
                    okButton.setFont(new Font("",1,12));
                    okButton.setFocusPainted(false);
                    okButton.setBorderPainted(false);

                    panel.add(label);
                    panel.add(okButton);

                    // Create a JDialog for your custom dialog
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Attention");
                    dialog.setModal(true); // Make the dialog modal



                    // Handle button click events (if needed)
                    okButton.addActionListener(actionEvent -> {
                        dialog.dispose();
                    });

                    dialog.setContentPane(panel);
                    dialog.setLocationRelativeTo(null);
                    dialog.pack();
                    dialog.setVisible(true);

                }


            }
        });


        // adding keylisner to the qty input :

        qty_txt.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // This method is called when a key is typed
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // This method is called when a key is pressed
            }

            @Override
            public void keyReleased(KeyEvent e) {
                totalValue.setText("Rs. " + Integer.parseInt(qty_txt.getText()) * 500 +".00");
            }
        });

        setVisible(true);
    }


    public static String getOrderID(){
        String order = "";
        AddBurger b = new AddBurger();
        boolean found = false;

        for (int i = 0; i < b.details.size(); i++) {
            order = b.details.get(i).getOrder_ID();
            order = order.substring(1);

            int orderId = Integer.valueOf(order);
            order = (orderId > 10) ? "B0" : "B00" + ++orderId;

            found = true;


        }

        if (!found){
            return "B001";
        }
        return order;
    }

}
