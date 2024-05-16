import java.awt.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.Border;
import java.awt.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class Update extends JFrame{

    Update(){

        setTitle("GroceryOne");
        setSize(1000, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());


        JPanel tittlePanel = new JPanel();
        tittlePanel.setPreferredSize(new Dimension(1000, 100));
        tittlePanel.setBackground(new Color(0,128,0));
        tittlePanel.setLayout(null);

        JLabel tittle = new JLabel("Update Order");
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

        backBtn.setBounds(800, 573, 100, 40);
        backBtn.setFont(new Font("",1,20));
        backBtn.setFocusPainted(false);
        backBtn.setBorderPainted(false);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBackground(new Color(0,128,0));
        bodyPanel.add(backBtn);


        JButton updateBtn = new JButton("Update Order");
        updateBtn.setBounds(522, 573, 180, 40);
        updateBtn.setFont(new Font("",1,20));
        updateBtn.setFocusPainted(false);
        updateBtn.setBorderPainted(false);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setBackground(new Color(0, 128, 0));
        bodyPanel.add(updateBtn);



        // Order Status Label :
        JLabel orderStatus = new JLabel("Order Status :");
        orderStatus.setForeground(Color.BLACK);
        orderStatus.setFont(new Font("",1,18));
        orderStatus.setBounds(100, 120, 200, 50);
        bodyPanel.add(orderStatus);


        // Order ID Label :
        JLabel orderIDLabel = new JLabel("Order ID :");
        orderIDLabel.setForeground(Color.BLACK);
        orderIDLabel.setFont(new Font("",1,18));
        orderIDLabel.setBounds(100, 180, 200, 50);
        bodyPanel.add(orderIDLabel);


        // Customer ID Label :
        JLabel customerIDLabel = new JLabel("Customer ID :");
        customerIDLabel.setForeground(Color.BLACK);
        customerIDLabel.setFont(new Font("",1,18));
        customerIDLabel.setBounds(100, 240, 200, 50);
        bodyPanel.add(customerIDLabel);


        // Name ID Label :
        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(new Font("",1,18));
        nameLabel.setBounds(100, 300, 200, 50);
        bodyPanel.add(nameLabel);


        // Order qty Label :
        JLabel orderQTY = new JLabel("Order QTY :");
        orderQTY.setForeground(Color.BLACK);
        orderQTY.setFont(new Font("",1,18));
        orderQTY.setBounds(100, 360, 200, 50);
        bodyPanel.add(orderQTY);


        // Total Label :
        JLabel totalLabel = new JLabel("Total :");
        totalLabel.setForeground(Color.BLACK);
        totalLabel.setFont(new Font("",1,18));
        totalLabel.setBounds(100, 420, 200, 50);
        bodyPanel.add(totalLabel);



        // OrderID input :
        JTextField orderID_txt = new JTextField(10);
        orderID_txt.setFont(new Font("",1,20));
        orderID_txt.setBounds(245, 186, 200, 35);
        bodyPanel.add(orderID_txt);

        // Customer Id disply label :
        JLabel customerIDOutput = new JLabel("");
        customerIDOutput.setForeground(Color.BLACK);
        customerIDOutput.setFont(new Font("",1,18));
        customerIDOutput.setBounds(245, 240, 200, 35);
        customerIDOutput.setOpaque(true);
        customerIDOutput.setBackground(new Color(176, 176, 176));
        bodyPanel.add(customerIDOutput);


        // Name disply label :
        JLabel nameOutput = new JLabel("");
        nameOutput.setForeground(Color.BLACK);
        nameOutput.setFont(new Font("",1,16));
        nameOutput.setBounds(245, 300, 200, 35);
        nameOutput.setOpaque(true);
        nameOutput.setBackground(new Color(176, 176, 176));
        bodyPanel.add(nameOutput);



        // Order QTY input :
        JTextField orderQTY_txt = new JTextField(10);
        orderQTY_txt.setFont(new Font("",1,20));
        orderQTY_txt.setBounds(245, 366, 200, 35);
        bodyPanel.add(orderQTY_txt);


        // Total disply label :
        JLabel totalOutput = new JLabel("");
        totalOutput.setForeground(new Color(209,72,72));
        totalOutput.setFont(new Font("",1,20));
        totalOutput.setBounds(245, 425, 200, 35);
        bodyPanel.add(totalOutput);

        //Order Status List:

        String status[]={"  Pending...","  Deliverd...","  Cancel..."};

        JComboBox<String> statusBox = new JComboBox<>(status);
        statusBox.setEditable(true);
        statusBox.setBounds(245, 125, 200, 32);
        statusBox.setFont(new Font("",1,18));
        statusBox.setBackground(new Color(216,216,216));
        statusBox.setEditable(false);

        // waring text id inputs :
        JLabel invalidText = new JLabel("");
        invalidText.setForeground(Color.RED);
        invalidText.setFont(new Font("",1,14));
        invalidText.setBounds(470, 107, 300, 50);
        invalidText.setVisible(false);
        bodyPanel.add(invalidText);


        JLabel invalidText2 = new JLabel("");
        invalidText2.setForeground(Color.RED);
        invalidText2.setFont(new Font("",1,14));
        invalidText2.setBounds(470, 122, 300, 50);
        invalidText2.setVisible(false);
        bodyPanel.add(invalidText2);

        JLabel invalidText3 = new JLabel("*invalid order Id");
        invalidText3.setForeground(Color.RED);
        invalidText3.setFont(new Font("",0,15));
        invalidText3.setBounds(470, 180, 300, 50);
        invalidText3.setVisible(false);
        bodyPanel.add(invalidText3);


        bodyPanel.add(statusBox);

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


        AddBurger b = new AddBurger();

        //Update Button Action :
        ActionListener updateButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < b.details.size(); i++) {
                    if (orderID_txt.getText().equals(b.details.get(i).getOrder_ID())){
                        b.details.get(i).setQty(Integer.parseInt(orderQTY_txt.getText().trim()));
                        b.details.get(i).setTotal_Price(Integer.parseInt(orderQTY_txt.getText().trim()) * 500);

                        if(statusBox.getSelectedItem().equals("  Pending...")){
                            b.details.get(i).setStatus(0);
                        }else if(statusBox.getSelectedItem().equals("  Deliverd...")){
                            b.details.get(i).setStatus(1);
                        }else if(statusBox.getSelectedItem().equals("  Cancel...")){
                            b.details.get(i).setStatus(2);
                            b.details.get(i).setTotal_Price(0);
                            b.details.get(i).setQty(0);
                        }

                        statusBox.setSelectedItem("  Pending...");
                        orderID_txt.setText("");
                        customerIDOutput.setText("");
                        nameOutput.setText("");
                        orderQTY_txt.setText("");
                        totalOutput.setText("");
                    }
                }
            }
        };

        updateBtn.addActionListener(updateButton);


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
                boolean exist = false;

                for (int i = 0; i < b.details.size(); i++) {
                    if (orderID_txt.getText().equals(b.details.get(i).getOrder_ID())) {
                        invalidText3.setVisible(false);
                        exist = true;

                        if(b.details.get(i).getStatus() == 0){
                            statusBox.setSelectedItem("  Pending...");

                        }else if(b.details.get(i).getStatus() == 1){
                            invalidText.setText("*This order hass been Delivered");
                            invalidText2.setText("Sorry. you can not update this order");
                            invalidText.setVisible(true);
                            invalidText2.setVisible(true);
                            orderQTY_txt.setEnabled(false);
                            statusBox.setEnabled(false);
                            statusBox.setSelectedItem("  Deliverd...");
                            updateBtn.setEnabled(false);

                        }else if(b.details.get(i).getStatus() == 2){

                            invalidText.setText("*This order hass been Canceled");
                            invalidText2.setText("Sorry. you can not update this order");
                            invalidText.setVisible(true);
                            invalidText2.setVisible(true);
                            orderQTY_txt.setEnabled(false);
                            statusBox.setEnabled(false);
                            statusBox.setSelectedItem("  Cancel...");
                            updateBtn.setEnabled(false);
                        }




                        customerIDOutput.setText("  "+b.details.get(i).getCustomer_id());
                        nameOutput.setText("  "+b.details.get(i).getCustomer_name());
                        orderQTY_txt.setText("  "+b.details.get(i).getQty());
                        totalOutput.setText(String.valueOf(b.details.get(i).getTotal_Price()));

                    }
                }    
                
                if (!exist){
                    invalidText.setVisible(false);
                    invalidText2.setVisible(false);
                    invalidText3.setVisible(true);
                    updateBtn.setEnabled(true);
                    orderQTY_txt.setEnabled(true);
                    statusBox.setEnabled(true);
                }
                




            }
        });

    }




}


