import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame {
    Home() {

        setTitle("GroceryOne");
        setSize(1000, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        ImageIcon logo = new ImageIcon(getClass().getResource("logo.png"));
        Image scaleImage = logo.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        logo.setImage(scaleImage);

        JLabel imageContainer = new JLabel();
        imageContainer.setIcon(logo);

        JLabel text = new JLabel("Welcome to GroceryOne !!!");
        text.setFont(new Font("",1,26));


        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(400, 800));
        logoPanel.setBackground(new Color(255,255,255));
        logoPanel.add(imageContainer);
        logoPanel.add(text);


        JPanel contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(600, 800));
        contentPanel.setBackground(new Color(222, 222, 222));
        contentPanel.setLayout(null);


        String[] btnNames = {"Place Order", "Best Customer", "Search Order", "Search Customer", "View Order", "Update Order", "Reset","Exit"};
        JButton[] btns = new JButton[btnNames.length];

        int x = 158;
        int y = 160;

        for (int i = 0; i < btnNames.length; i++) {
            btns[i] = new JButton(btnNames[i]);

            btns[i].setBounds(x, y, 300, 40);
            btns[i].setMargin(new Insets(10, 20, 10, 20));
            btns[i].setFont(new Font("", 1, 20));
            btns[i].setBackground(new Color(0, 128, 0));
            btns[i].setForeground(Color.WHITE);
            btns[i].setFocusPainted(false);
            btns[i].setBorderPainted(false);
            contentPanel.add(btns[i]);

            y += 65;
        }


        //Exit Button Action :
        ActionListener exitListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close only the current window
            }
        };

        btns[7].addActionListener(exitListener);


        //Place Order Button :
        ActionListener placeOrder = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new NewOrder();
            }
        };
        btns[0].addActionListener(placeOrder);


        add(logoPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.EAST);

        setVisible(true);


        //Best Customer Button Action :
        ActionListener bestCustomerButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close only the current window
                new BestCustomer();
            }
        };

        btns[1].addActionListener(bestCustomerButton);

        //View orders Button Action :
        ActionListener searchOrdersButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close only the current window
                new SearchOrder();
            }
        };

        btns[2].addActionListener(searchOrdersButton);


        //Search customer Button Action :
        ActionListener searchCustomerButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close only the current window
                new Search();
            }
        };

        btns[3].addActionListener(searchCustomerButton);


        //View orders Button Action :
        ActionListener viewOrdersButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close only the current window
                new View();
            }
        };

        btns[4].addActionListener(viewOrdersButton);


        //Update orders Button Action :
        ActionListener updateOrdersButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close only the current window
                new Update();
            }
        };

        btns[5].addActionListener(updateOrdersButton);


        ActionListener resetOrdersButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close only the current window
                new ResetPOS();
            }
        };

        btns[6].addActionListener(resetOrdersButton);
    }
}
