package application;

import Database.UserDB;
import client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPage extends JFrame{
    private JLabel emailLabel = new JLabel("Write your Email:");
    private JTextField email = new JTextField();
    private JLabel nameLabel = new JLabel("Write your name");
    private JTextField name = new JTextField("default");
    private JButton register = new JButton("Register");
    public RegisterPage() {
        super("Registration");
        setBounds(100, 100, 300,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        setLayout(new GridLayout(3, 2));
        container.add(emailLabel);
        container.add(email);
        container.add(nameLabel);
        container.add(name);
        register.addActionListener(new Register());
        container.add(register);
    }

    private class Register implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String userEmail = email.getText();
            String userName = name.getText();
            if(userName == null || userEmail == null) {
                return;
            }
            Client client = new Client(userName, userEmail);
            UserDB db = new UserDB();
            db.addClient(client);
            MainPage page = new MainPage(client);
            setVisible(false);
            page.setVisible(true);
        }
    }
}
