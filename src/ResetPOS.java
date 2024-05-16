import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Objects;
import javax.swing.JFrame;

public class ResetPOS extends JFrame {
    JTextField customerID_txt;
    JTextField qty_txt;
    JPanel bodyPanel;
    JTextField customerName_txt;


    public ResetPOS() {

        setTitle("GroceryOne");
        setSize(1000, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());


        JPanel tittlePanel = new JPanel();
        tittlePanel.setPreferredSize(new Dimension(1000, 100));
        tittlePanel.setBackground(new Color(0, 128, 0));
        tittlePanel.setLayout(null);

        JLabel tittle = new JLabel("Reset POS");
        tittle.setFont(new Font("", 1, 30));
        tittle.setForeground(Color.WHITE);
        tittle.setBounds(425, 30, 250, 50);
        tittlePanel.add(tittle);


        bodyPanel = new JPanel();
        bodyPanel.setPreferredSize(new Dimension(1000, 700));
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setLayout(null);



        JLabel customerID = new JLabel("Username : ");
        customerID.setForeground(Color.BLACK);
        customerID.setFont(new Font("", 1, 20));
        customerID.setBounds(100, 230, 200, 50);


        customerID_txt = new JTextField(10);
        customerID_txt.setFont(new Font("", 0, 20));
        customerID_txt.setBounds(273, 238, 200, 40);


        JLabel customerName = new JLabel("Password : ");
        customerName.setForeground(Color.BLACK);
        customerName.setFont(new Font("", 1, 20));
        customerName.setBounds(100, 320, 200, 50);


        customerName_txt = new JTextField(10);
        customerName_txt.setFont(new Font("", 0, 20));
        customerName_txt.setBounds(273, 328, 200, 40);

        bodyPanel.add(customerID);
        bodyPanel.add(customerID_txt);

        bodyPanel.add(customerName);
        bodyPanel.add(customerName_txt);


        JButton placeOrderBTN = new JButton("Reset");
        placeOrderBTN.setBackground(new Color(0, 128, 0));
        placeOrderBTN.setForeground(Color.WHITE);
        placeOrderBTN.setBounds(700, 240, 200, 40);
        placeOrderBTN.setFocusPainted(false);
        placeOrderBTN.setBorderPainted(false);
        placeOrderBTN.setFont(new Font("", 1, 16));

        // Back to home page :
        JButton backBTN = new JButton("Home");
        backBTN.setBackground(new Color(0, 128, 0));
        backBTN.setForeground(Color.WHITE);
        backBTN.setBounds(700, 310, 200, 40);
        backBTN.setFocusPainted(false);
        backBTN.setBorderPainted(false);
        backBTN.setFont(new Font("", 1, 16));

        // cancel :
        JButton cancelBTN = new JButton("Cancel");
        cancelBTN.setBackground(new Color(0, 128, 0));
        cancelBTN.setForeground(Color.WHITE);
        cancelBTN.setBounds(700, 380, 200, 40);
        cancelBTN.setFocusPainted(false);
        cancelBTN.setBorderPainted(false);
        cancelBTN.setFont(new Font("", 1, 16));


        bodyPanel.add(placeOrderBTN);
        bodyPanel.add(backBTN);
        bodyPanel.add(cancelBTN);


        add(tittlePanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.SOUTH);


        //Cancel Button :
        ActionListener cancel = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerName_txt.setText("");
                customerID_txt.setText("");
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

                if (customerID_txt.getText().equals("admin") && customerName_txt.getText().equals("admin123")) {

                    // adding background color to the msg box :
                    JPanel panel = new JPanel();
                    panel.setForeground(Color.WHITE);
                    panel.setBackground(new Color(230, 232, 231));
                    panel.setPreferredSize(new Dimension(300, 100));
                    panel.setLayout(null);

                    JLabel label = new JLabel("Reset Successfull");
                    label.setBounds(93, 13, 290, 20);
                    label.setFont(new Font("", 1, 13));

                    JButton okButton = new JButton("OK");
                    okButton.setBounds(121, 55, 55, 27);
                    okButton.setBackground(new Color(0, 128, 0));
                    okButton.setForeground(Color.WHITE);
                    okButton.setFont(new Font("", 1, 12));
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
                        AddBurger b = new AddBurger();
                        b.dropDatabase();

                        b.details = new LinkedList<Customer>();
                        b.unique_details = new LinkedList<Customer>();

                        dialog.dispose();
                    });

                    dialog.setContentPane(panel);
                    dialog.setLocationRelativeTo(null);
                    dialog.pack();
                    dialog.setVisible(true);


                } else {

                    JPanel panel = new JPanel();
                    panel.setForeground(Color.WHITE);
                    panel.setBackground(new Color(230, 232, 231));
                    panel.setPreferredSize(new Dimension(300, 100));
                    panel.setLayout(null);

                    JLabel label = new JLabel("Wrong Username or Password");
                    label.setBounds(55, 13, 290, 20);
                    label.setFont(new Font("", 1, 13));

                    JButton okButton = new JButton("OK");
                    okButton.setBounds(121, 55, 55, 27);
                    okButton.setBackground(new Color(0, 128, 0));
                    okButton.setForeground(Color.WHITE);
                    okButton.setFont(new Font("", 1, 12));
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

        setVisible(true);

    }
}