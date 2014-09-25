package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by root on 9/25/14.
 */
public class ButtonActionListener implements ActionListener {

    private AvlTree tree;
    private JTextField textField;

    public ButtonActionListener(AvlTree tree, JTextField textField) {
        this.tree = tree;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] values = textField.getText().split(" ");
        ArrayList<Integer> elements = new ArrayList<>(values.length);
        for (String s : values) {
            try {
                int element = Integer.parseInt(s);
                elements.add(element);
            } catch (NumberFormatException ex) {
                textField.setBackground(Color.RED);
                return;
            }
        }
        tree.makeEmpty();
        textField.setBackground(Color.WHITE);
        for (int element : elements) {
            tree.insert(element);
        }
    }
}
