import java.awt.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.Border;
import java.awt.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class DeliveredOrderView extends JFrame{

    public DeliveredOrderView(){

        setTitle("GroceryOne");
        setSize(1000, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());


        JPanel tittlePanel = new JPanel();
        tittlePanel.setPreferredSize(new Dimension(1000, 100));
        tittlePanel.setBackground(new Color(0,128,0));
        tittlePanel.setLayout(null);

        JLabel tittle = new JLabel("Delivered Orders");
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
            if (cc.getStatus() == 1){
                count++;
            }
        }

        String[][] customerDetails = new String[count][5];
        String column[]={"Order ID","Customer ID","Name", "Order QTY", "Total"};

        for (Customer cc : c.details){
            if (cc.getStatus() == 1){
                customerDetails[j][0] = cc.getOrder_ID();
                customerDetails[j][1] = cc.getCustomer_id();
                customerDetails[j][2] = cc.getCustomer_name();
                customerDetails[j][3] = String.valueOf(cc.getQty());
                customerDetails[j][4] = String.valueOf(cc.getTotal_Price());
                j++;
                count++;
            }
        }


        JTable devilerdTable = new JTable(customerDetails,column);
        devilerdTable.setBackground(Color.WHITE);
        devilerdTable.getTableHeader().setFont(new Font("",1,16));
        devilerdTable.getTableHeader().setPreferredSize(new Dimension(50,50));
        devilerdTable.setDefaultEditor(Object.class, null);


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        devilerdTable.setDefaultRenderer(Object.class, centerRenderer);


        devilerdTable.setRowHeight(30);
        devilerdTable.setBounds(20,0,800,400);
        devilerdTable.setFont(new Font("",1,14));

        JScrollPane sp=new JScrollPane(devilerdTable);
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




