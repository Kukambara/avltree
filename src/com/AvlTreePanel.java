package com;

import javax.swing.*;
import java.awt.*;

/**
 * Created by root on 9/24/14.
 */
public class AvlTreePanel extends JPanel {

    Drawer drawer;

    public AvlTreePanel(Drawer drawer) {
        this.drawer = drawer;
        this.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        drawer.draw();
    }


}
