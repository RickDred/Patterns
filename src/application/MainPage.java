package application;

import client.Client;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
    private JButton catalog = new JButton("Catalog");
    private JLabel clientName;
    public MainPage(Client client) {
        super("Registration");
        setBounds(100, 100, 300,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clientName = new JLabel(client.getName());

        Container container = getContentPane();
        container.add(catalog);

    }
}
