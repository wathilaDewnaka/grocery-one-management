import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Search extends JFrame{

    static String name = "";

    Search(){

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


        JButton backBtn = new JButton("Home");
        backBtn.setBounds(800, 573, 100, 40);
        backBtn.setFont(new Font("",1,20));
        backBtn.setFocusPainted(false);
        backBtn.setBorderPainted(false);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBackground(new Color(0,128,0));
        bodyPanel.add(backBtn);


        JLabel orderID = new JLabel("Enter Customer ID :");
        orderID.setForeground(Color.BLACK);
        orderID.setFont(new Font("",1,20));
        orderID.setBounds(90, 80, 200, 50);
        bodyPanel.add(orderID);



        JTextField customerID_txt = new JTextField(10);
        customerID_txt.setFont(new Font("",0,20));
        customerID_txt.setBounds(285, 87, 200, 40);
        bodyPanel.add(customerID_txt);



        JLabel invalidText = new JLabel("*invalid customer id");
        invalidText.setForeground(Color.RED);
        invalidText.setFont(new Font("",0,17));
        invalidText.setBounds(500, 82, 300, 50);
        invalidText.setVisible(false);
        bodyPanel.add(invalidText);



        JLabel cusName = new JLabel("Name :  "+name);
        cusName.setForeground(Color.BLACK);
        cusName.setFont(new Font("",1, 20));
        cusName.setBounds(90, 140, 500, 50);
        bodyPanel.add(cusName);


        JPanel orderDetailPanel = new JPanel();
        orderDetailPanel.setPreferredSize(new Dimension(1100, 58));
        orderDetailPanel.setBackground(new Color(0,128,0));
        orderDetailPanel.setBounds(0, 220, 1100, 58);
        orderDetailPanel.setLayout(null);

        JLabel orderTittle = new JLabel("Order Details");
        orderTittle.setFont(new Font("",1,25));
        orderTittle.setForeground(Color.WHITE);
        orderTittle.setBounds(400, 5, 400, 50);
        orderDetailPanel.add(orderTittle);
        bodyPanel.add(orderDetailPanel);


        String[][] row= new String[0][3];


        String column[]={"Order ID","Order QTY","Total"};


        JTable searchCustomerTable = new JTable(row,column);
        searchCustomerTable.setBackground(Color.WHITE);
        searchCustomerTable.getTableHeader().setFont(new Font("",1,16));
        searchCustomerTable.getTableHeader().setPreferredSize(new Dimension(50,50));
        searchCustomerTable.setDefaultEditor(Object.class, null);


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        searchCustomerTable.setDefaultRenderer(Object.class, centerRenderer);


        searchCustomerTable.setRowHeight(30);
        searchCustomerTable.setBounds(20,0,600,400);
        searchCustomerTable.setFont(new Font("",1,14));

        //sp=new JScrollPane(searchCustomerTable);
        JScrollPane sp = new JScrollPane(searchCustomerTable);
        sp.setBounds(190,328,700,400);
        sp.setBackground(Color.WHITE);
        sp.getViewport().setBackground(Color.WHITE);
        sp.setBorder(BorderFactory.createEmptyBorder());

        sp.setVisible(false);
        bodyPanel.add(sp);



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
                // This method is called when a key is released
                AddBurger b = new AddBurger();




                String cusID = customerID_txt.getText();
                int count = 0;
                int j = 0;

                for (int i = 0; i < b.details.size(); i++) {
                    if (b.details.get(i).getCustomer_id().equals(cusID)){
                        count++;

                    }
                }
                String[][] customerDetails= new String[count][3];
                String columns[]={"Order ID","Order QTY","Total"};

                for (int i = 0; i < b.details.size(); i++) {
                    if (b.details.get(i).getCustomer_id().equals(cusID)){
                        name = b.details.get(i).getCustomer_name();
                        customerDetails[j][0] = b.details.get(i).getOrder_ID();
                        customerDetails[j][1] = String.valueOf(b.details.get(i).getQty());
                        customerDetails[j][2] = String.valueOf(b.details.get(i).getTotal_Price());
                        j++;
                    }
                }

                    // set the name :
                    cusName.setText("Name : "+ name);
                    cusName.setVisible(true);

                    JTable cusOrders = new JTable(customerDetails,columns);
                    cusOrders.setBackground(Color.WHITE);
                    cusOrders.getTableHeader().setFont(new Font("",1,16));
                    cusOrders.getTableHeader().setPreferredSize(new Dimension(50,50));
                    cusOrders.setDefaultEditor(Object.class, null);


                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment(JLabel.CENTER);

                    cusOrders.setDefaultRenderer(Object.class, centerRenderer);


                    cusOrders.setRowHeight(30);
                    cusOrders.setBounds(20,0,600,400);
                    cusOrders.setFont(new Font("",1,14));

                    sp.setViewportView(cusOrders);
                    sp.setVisible(true);

                if (count == 0){
                    invalidText.setVisible(true);
                    sp.setVisible(false);
                }

            }


        });






    }




}


