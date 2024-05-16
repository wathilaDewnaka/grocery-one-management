import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableCellRenderer;


class ProcessingOrderView extends JFrame{

    public ProcessingOrderView(){

        setTitle("GroceryOne");
        setSize(1000, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());


        JPanel tittlePanel = new JPanel();
        tittlePanel.setPreferredSize(new Dimension(1000, 100));
        tittlePanel.setBackground(new Color(0,128,0));
        tittlePanel.setLayout(null);

        JLabel tittle = new JLabel("Processing Orders");
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
        backBtn.setBounds(700, 573, 100, 40);
        backBtn.setFont(new Font("",1,20));
        backBtn.setFocusPainted(false);
        backBtn.setBorderPainted(false);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBackground(new Color(0,128,0));
        bodyPanel.add(backBtn);
        AddBurger c = new AddBurger();
        int count = 0;
        int j = 0;

        for (Customer cc : c.details){
            if (cc.getStatus() == 0){
                count++;
            }
        }

        String[][] customerDetails = new String[count][5];
        String column[]={"Order ID","Customer ID","Name", "Order QTY", "Total"};

        for (Customer cc : c.details){
            if (cc.getStatus() == 0){
                customerDetails[j][0] = cc.getOrder_ID();
                customerDetails[j][1] = cc.getCustomer_id();
                customerDetails[j][2] = cc.getCustomer_name();
                customerDetails[j][3] = String.valueOf(cc.getQty());
                customerDetails[j][4] = String.valueOf(cc.getTotal_Price());
                j++;
                count++;
            }
        }

        JTable processingTable = new JTable(customerDetails,column);
        processingTable.setBackground(Color.WHITE);
        processingTable.getTableHeader().setFont(new Font("",1,16));
        processingTable.getTableHeader().setPreferredSize(new Dimension(50,50));
        processingTable.setDefaultEditor(Object.class, null);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        processingTable.setDefaultRenderer(Object.class, centerRenderer);


        processingTable.setRowHeight(30);
        processingTable.setBounds(20,0,800,400);
        processingTable.setFont(new Font("",1,14));

        JScrollPane sp=new JScrollPane(processingTable);
        sp.setBounds(147,100,800,400);
        sp.setBackground(Color.WHITE);
        sp.getViewport().setBackground(Color.WHITE);
        sp.setBorder(BorderFactory.createEmptyBorder());

        bodyPanel.add(sp);


        add(tittlePanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.SOUTH);

        setVisible(true);



        //Back Button Action :
        ActionListener backButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close only the current window
                new View();
            }
        };

        backBtn.addActionListener(backButton);

    }




}


