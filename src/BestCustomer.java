import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableCellRenderer;


public class BestCustomer extends JFrame{

    BestCustomer(){
        setTitle("GroceryOne");
        setSize(1000, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());


        JPanel tittlePanel = new JPanel();
        tittlePanel.setPreferredSize(new Dimension(1000, 100));
        tittlePanel.setBackground(new Color(0,128,0));
        tittlePanel.setLayout(null);

        JLabel tittle = new JLabel("Best Customer - Loyality");
        tittle.setFont(new Font("",1,30));
        tittle.setForeground(Color.WHITE);
        tittle.setBounds(325, 30, 450, 50);
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

        AddBurger burger = new AddBurger();

        burger.clear_unique();
        burger.unique_copy();
        burger.total();
        burger.print();


        String[][] customerDetails = new String[burger.unique_details.size()][4];
        String column[]={"CustomerID","Name","Total Purchases","Loyality Points"};

        for (int i = 0; i < burger.unique_details.size(); i++) {
            customerDetails[i][0] = burger.unique_details.get(i).getCustomer_id();
            customerDetails[i][1] = burger.unique_details.get(i).getCustomer_name();
            customerDetails[i][2] = String.valueOf(burger.unique_details.get(i).getTotal_Price());
            customerDetails[i][3] = String.valueOf(burger.unique_details.get(i).getTotal_Price() / 100);

        }


        JTable bestCustomerTable = new JTable(customerDetails,column);
        bestCustomerTable.setBackground(Color.WHITE);
        bestCustomerTable.getTableHeader().setFont(new Font("",1,16));
        bestCustomerTable.getTableHeader().setPreferredSize(new Dimension(50,50));
        bestCustomerTable.setDefaultEditor(Object.class, null);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        bestCustomerTable.setDefaultRenderer(Object.class, centerRenderer);


        bestCustomerTable.setRowHeight(30);
        bestCustomerTable.setBounds(15,0,600,400);
        bestCustomerTable.setFont(new Font("",1,14));

        JScrollPane sp=new JScrollPane(bestCustomerTable);
        sp.setBounds(180,100,600,400);
        sp.setBackground(Color.WHITE);
        sp.getViewport().setBackground(Color.WHITE);
        sp.setBorder(BorderFactory.createEmptyBorder());

        bodyPanel.add(sp);


        add(tittlePanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.SOUTH);

        setVisible(true);



        ActionListener backButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Home();
            }
        };

        backBtn.addActionListener(backButton);

    }




}

