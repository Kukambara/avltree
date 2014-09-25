package com;

import javax.swing.*;
import java.awt.*;

/**
 * Created by root on 9/25/14.
 */
public class DemoApplication {
    public static void main(String args[]) {

        Drawer drawer = new Drawer();
        AvlTreePanel panel = new AvlTreePanel(drawer);
        drawer.setPanel(panel);
        panel.setSize(900, 500);
        AvlTree<Integer> tree = new AvlTree<>(drawer);
        drawer.setTree(tree);

        JFrame frame = new JFrame("AVL tree");
        Container container = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JTextField textField = new JTextField(10);
        textField.setSize(100, 30);
        JButton add = new JButton("Draw");
        add.addActionListener(new ButtonActionListener(tree, textField));

        c.weightx = 0.5;
        c.weighty = 0.05;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(textField, c);

        c.gridx = 1;
        frame.add(add, c);

        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.ipady = 500;
        frame.add(panel, c);

        frame.setSize(1000, 800);
        frame.setVisible(true);

        System.out.println("Height: " + tree.height(tree.root));


    }
}
