package application;

import client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthPage extends JFrame {
    private JLabel emailLabel = new JLabel("Write your Email:");
    private JTextField email = new JTextField();
    private JButton send = new JButton("Send");

    public AuthPage() {
        super("Authorization");
        setBounds(100, 100, 300,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        setLayout(new GridLayout(3, 2));
        container.add(emailLabel);
        container.add(email);
        send.addActionListener(new AuthEventListener());
        container.add(send);
    }

    class AuthEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent action) {
            ApplicationFacade app = new ApplicationFacade();
            String userEmail = email.getText();
            Client client;
            try {
                client = app.getClientByEmail(userEmail);
                setVisible(false);
                MainPage page = new MainPage(client);
                page.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
