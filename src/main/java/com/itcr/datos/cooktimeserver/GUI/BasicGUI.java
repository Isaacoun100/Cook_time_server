package com.itcr.datos.cooktimeserver.GUI;

import com.itcr.datos.cooktimeserver.CookTimeServerApplication;
import com.itcr.datos.cooktimeserver.restfull.*;
import org.springframework.boot.SpringApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicGUI extends JFrame implements{
    public JLabel userLabel, chefLabel;
    public JTextField userTextField;
    public JTextArea guiTextArea;


    BasicGUI(String[] args){
        this.setTitle("Sever GUI");
        this.setBounds(250,30,800,530);
        this.setPreferredSize(new Dimension(900,720));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);



        Container container = this.getContentPane();
        container.setBackground(Color.darkGray);
        container.setLayout(null);

        guiTextArea = new JTextArea();
        guiTextArea.setBackground(Color.lightGray);
        guiTextArea.setFont(new Font("SANS_SERIF", Font.BOLD, 14));


        userLabel = new JLabel("Users: " );
        userLabel.setForeground(Color.black);
        userLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 14));

        userTextField = new JTextField();

        chefLabel = new JLabel("Chefs: ");
        chefLabel.setForeground(Color.black);
        chefLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 14));

        JButton addUserButton = new JButton("Add");
        addUserButton.setBackground(Color.BLUE);
        addUserButton.setForeground(Color.black);
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CookTimeServerApplication.main(args);

            }
        });


        JButton deleteUserButton = new JButton("Delete");
        deleteUserButton.setBackground(Color.BLUE);
        deleteUserButton.setForeground(Color.black);
        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("1");
                String key = userTextField.getText();
                System.out.println(key);
                System.out.println("2");
                userTextField.setText("");
                System.out.println("3");
                System.out.println(UserTree.getUserTree().toString());
                System.out.println("5");
            }
        });

        JButton verifyChefButton = new JButton("Verify");
        verifyChefButton.setBackground(Color.BLUE);
        verifyChefButton.setForeground(Color.black);

        JButton loadServerButton = new JButton("Load Server");
        loadServerButton.setBackground(Color.BLUE);
        loadServerButton.setForeground(Color.black);

        JButton closeServerButton = new JButton("Close Server");
        closeServerButton.setBackground(Color.BLUE);
        closeServerButton.setForeground(Color.black);
        /*
        closeServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrar();
            }
        });

         */

        guiTextArea.setBounds(100, 40,550,300);
        userLabel.setBounds(65, 360, 100, 30);
        userTextField.setBounds(120, 360, 160, 30);
        addUserButton.setBounds(120, 400, 60, 20);
        deleteUserButton.setBounds(190, 400, 80, 20);

        closeServerButton.setBounds(750, 600, 100, 30);


        container.add(closeServerButton);
        container.add(loadServerButton);
        container.add(verifyChefButton);
        container.add(deleteUserButton);
        container.add(addUserButton);
        container.add(closeServerButton);
        container.add(userLabel);
        container.add(userTextField);
        container.add(guiTextArea);

        this.setVisible(true);
        JOptionPane.showMessageDialog(null, "Server GUI");


    }

    public static void main(String[] args) {
        new BasicGUI(args);

    }
}
