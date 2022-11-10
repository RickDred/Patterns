package application;

import client.Client;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
    public MainPage(Client client) {
        super("Registration");
        setBounds(100, 100, 300,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
    }
}
