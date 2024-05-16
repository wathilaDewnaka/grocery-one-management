import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class SearchOrder extends JFrame {


    public SearchOrder(){
        setTitle("GroceryOne");
        setSize(1000, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());


        JPanel tittlePanel = new JPanel();
        tittlePanel.setPreferredSize(new Dimension(1000, 100));
        tittlePanel.setBackground(new Color(0,128,0));
        tittlePanel.setLayout(null);

        JLabel tittle = new JLabel("Search Customers");
        tittle.setFont(new Font("",1,30));
        tittle.setForeground(Color.WHITE);
        tittle.setBounds(425, 30, 250, 50);
        tittlePanel.add(tittle);


        JPanel bodyPanel = new JPanel();
        bodyPanel.setPreferredSize(new Dimension(1000, 700));
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setLayout(null);



        // back button :
        JButton backBtn = new JButton("Home");
        //backBtn.
        backBtn.setBounds(800, 573, 100, 40);
        backBtn.setFont(new Font("",1,20));
        backBtn.setFocusPainted(false);
        backBtn.setBorderPainted(false);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBackground(new Color(0,128,0));
        bodyPanel.add(backBtn);



        // Order id inputs :
        JLabel orderID = new JLabel("Enter Order ID :");
        orderID.setForeground(Color.BLACK);
        orderID.setFont(new Font("",1,20));
        orderID.setBounds(75, 65, 200, 50);
        bodyPanel.add(orderID);


        // Order id input txt feild :
        JTextField orderID_txt = new JTextField(10);
        orderID_txt.setFont(new Font("",1,20));
        orderID_txt.setBounds(230, 72, 200, 40);
        bodyPanel.add(orderID_txt);


        // waring text id inputs :
        JLabel invalidText = new JLabel("");
        invalidText.setForeground(Color.RED);
        invalidText.setFont(new Font("",0,17));
        invalidText.setBounds(450, 66, 300, 50);
        bodyPanel.add(invalidText);

        // Customer ID display :
        JLabel customerID = new JLabel("Customer ID : ");
        customerID.setForeground(Color.BLACK);
        customerID.setFont(new Font("",1,19));
        customerID.setBounds(128, 185, 500, 50);
        bodyPanel.add(customerID);

        // Customer ID display :
        JLabel cusName = new JLabel("Name : ");
        cusName.setForeground(Color.BLACK);
        cusName.setFont(new Font("",1,19));
        cusName.setBounds(128, 235, 500, 50);
        bodyPanel.add(cusName);

        // Customer ID display :
        JLabel burgerQty = new JLabel("QTY : ");
        burgerQty.setForeground(Color.BLACK);
        burgerQty.setFont(new Font("",1,19));
        burgerQty.setBounds(128, 285, 500, 50);
        bodyPanel.add(burgerQty);

        // Customer ID display :
        JLabel totalPrice = new JLabel("Total : ");
        totalPrice.setForeground(Color.BLACK);
        totalPrice.setFont(new Font("",1,19));
        totalPrice.setBounds(128, 335, 500, 50);
        bodyPanel.add(totalPrice);

        // Customer ID display :
        JLabel orderStatus = new JLabel("Order Status : ");
        orderStatus.setForeground(Color.BLACK);
        orderStatus.setFont(new Font("",1,19));
        orderStatus.setBounds(128, 385, 500, 50);
        bodyPanel.add(orderStatus);


        add(tittlePanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.SOUTH);


        setVisible(true);

        //Back Button Action :
        ActionListener backButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close only the current window
                new Home();
            }
        };

        backBtn.addActionListener(backButton);



        orderID_txt.addKeyListener(new KeyListener() {
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
                // This method is called when a key is released
                String OrderID = orderID_txt.getText();
                String status = "";

                AddBurger List = new AddBurger();

                for (int i = 0; i < List.details.size(); i++) {
                    if (Objects.equals(List.details.get(i).getOrder_ID(), OrderID)){
                        invalidText.setText("");
                        customerID.setText("Customer ID : "+List.getDetails().get(i).getCustomer_id());
                        cusName.setText("Name : "+List.getDetails().get(i).getCustomer_name());
                        burgerQty.setText("QTY : "+ List.getDetails().get(i).getQty());
                        totalPrice.setText("Total : "+ List.getDetails().get(i).getTotal_Price());

                        if(List.getDetails().get(i).getStatus() == 0){
                            status = "PREPARING...";
                        }else if(List.getDetails().get(i).getStatus() == 1){
                            status = "DELIVERED...";
                        }else if(List.getDetails().get(i).getStatus() == 2){
                            status = "CANCEL...";
                        }
                        orderStatus.setText("Order Status : "+status);
                    }
                }

//                Burger b = new Burger();
//                System.out.println(b);
//
//                if(b.isOrderID_Exists(OrderID)){
//                    invalidText.setText("");
//
//                    Customer temp = b.first;
//                    for(int i = 0; i < b.size(); i++){
//                        if(OrderID.equals(temp.order_ID)){
//
//
//                            customerID.setText("Customer ID : "+temp.customer_ID);
//                            cusName.setText("Name : "+temp.customer_Name);
//                            burgerQty.setText("QTY : "+String.valueOf(temp.qty));
//                            totalPrice.setText("Total : "+String.valueOf(temp.total_Price));
//
//                            if(temp.status == 0){
//                                status = "PREPARING...";
//                            }else if(temp.status == 1){
//                                status = "DELIVERED...";
//                            }else if(temp.status == 2){
//                                status = "CANCEL...";
//                            }
//
//                            orderStatus.setText("Order Status : "+status);
//
//                        }
//                        temp = temp.next;
//                    }


//                }else {
//                    invalidText.setText("*invalid order id...");
//
//                    customerID.setText("Customer ID : ");
//                    cusName.setText("Name : ");
//                    burgerQty.setText("QTY : ");
//                    totalPrice.setText("Total : ");
//                    orderStatus.setText("Order Status : ");
//                }
//


            }
        });


    }
}

