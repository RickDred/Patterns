package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {
    private final JButton register = new JButton("Register");
    private final JButton authorization = new JButton("Auth");
    public WelcomePage() {
        super("Welcome to our shop");
        setBounds(100, 100, 300,80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        setLayout(new GridLayout(1, 2));
        register.addActionListener(new RegisterEventListener());
        container.add(register);
        authorization.addActionListener(new AuthorizationEventListener());
        container.add(authorization);
    }

    class RegisterEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RegisterPage page = new RegisterPage();
            setVisible(false);
            page.setVisible(true);
        }
    }
    class AuthorizationEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AuthPage page = new AuthPage();
            setVisible(false);
            page.setVisible(true);
        }
    }
}
