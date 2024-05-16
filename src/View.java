import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 public class View extends JFrame{

    View(){

        setTitle("GroceryOne");
        setSize(1000, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());



        // Access the image file
        ImageIcon logo = new ImageIcon(getClass().getResource("logo.png"));
        Image scaleImage = logo.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        logo.setImage(scaleImage);

        JLabel imageContainer = new JLabel();
        imageContainer.setIcon(logo);

        // this panel for hold the image :
        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(400, 800));
        logoPanel.add(imageContainer);



        // this panel for hold the content :
        JPanel contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(600, 800));
        contentPanel.setBackground(new Color(216,216,216));
        contentPanel.setLayout(null);

        // title :
        JPanel tittlePanel = new JPanel();
        tittlePanel.setPreferredSize(new Dimension(600, 60));
        tittlePanel.setBackground(new Color(0,128,0));
        tittlePanel.setBounds(0, 0, 617, 70);
        tittlePanel.setLayout(null);

        JLabel tittle = new JLabel("View Orders");
        tittle.setFont(new Font("",1,25));
        tittle.setForeground(Color.WHITE);
        tittle.setBounds(224, 12, 200, 50);
        tittlePanel.add(tittle);

        contentPanel.add(tittlePanel);

        // Creating buttons :

        String[] btnNames = {"Delivered Orders", "Processing Orders", "Canceled Orders","Home"};
        JButton[] btns = new JButton[btnNames.length];

        int x = 158;
        int y = 260;

        for(int i = 0; i < btnNames.length; i++){

            btns[i] = new JButton(btnNames[i]);

            btns[i].setBounds(x, y, 300, 40);
            btns[i].setMargin(new Insets(10, 20, 10, 20));
            btns[i].setFont(new Font("",1,20));
            btns[i].setBackground(new Color(0,128,0));
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
                new Home();
            }
        };

        btns[3].addActionListener(exitListener);



        add(logoPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.EAST);

        setVisible(true);


        //Delivered orders Button Action :
        ActionListener deliveredButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close only the current window
                new DeliveredOrderView();
            }
        };

        btns[0].addActionListener(deliveredButton);

        //Processing orders Button Action :
        ActionListener processingButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close only the current window
                new ProcessingOrderView();
            }
        };

        btns[1].addActionListener(processingButton);

        //Processing orders Button Action :
        ActionListener cancelButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close only the current window
                new CancelledOrderView();
            }
        };

        btns[2].addActionListener(cancelButton);

    }
}
