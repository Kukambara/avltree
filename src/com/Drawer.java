package com;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by root on 9/24/14.
 */
public class Drawer {

    private AvlTreePanel panel;
    private int elementWidth = 50;
    private int elementHeight = 50;
    private AvlTree tree;
    public AvlTree.AvlNode newElement;
    public AvlTree.AvlNode rotating;
    public AvlTree.AvlNode algorithmElement;

    public Drawer() {

    }

    public void draw() {
        int width = panel.getWidth();
        int height = panel.getHeight();
        if (tree.root == null)
            return;
        Graphics g1 = panel.getGraphics();
        BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_BYTE_INDEXED);
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        drawTree(tree.root, (int) Math.pow(2, tree.height(tree.root) - 1) * elementWidth * 2, 0, true, g);
        g1.drawImage(image, 0, 0, null);
        try {
            Thread.sleep(1000);
            System.out.println("sleep");
            rotating = null;
        } catch (InterruptedException ex) {
            System.out.println("Interrupted exception");
        }
    }

    public void drawTree(AvlTree.AvlNode node, int centerX, int centerY, boolean isRoot, Graphics g) {

        g.setColor(Color.GREEN);
        if (rotating != null && node.element.equals(rotating.element)) {
            g.setColor(Color.YELLOW);
        }
        if (tree.contains((Integer) node.element, rotating)) {
            g.setColor(Color.YELLOW);
        }
        if (newElement != null && node.element.equals(newElement.element)) {
            g.setColor(Color.RED);
        }
        if (algorithmElement != null && node.element.equals(algorithmElement.element)) {
            g.setColor(Color.BLUE);
        }
        g.fillRect(centerX, centerY, elementWidth, elementHeight);
        g.setColor(Color.BLACK);
        g.drawString(node.element.toString(),
                centerX + (elementWidth / 2) - (g.getFontMetrics().stringWidth(node.element.toString()) / 2),
                centerY + (elementHeight / 2));
        g.setColor(Color.BLACK);
        if (node.left != null) {
            int leftCenterX = centerX - (elementWidth * (int) Math.pow(2, (tree.height(node) - 1)));
            int leftCenterY = (int) (centerY + (1.5f * elementHeight));
            g.drawLine(leftCenterX + elementWidth / 2, leftCenterY, centerX + elementWidth / 2, centerY + elementHeight);
            drawTree(node.left, leftCenterX, leftCenterY, false, g);
        }
        if (node.right != null) {
            int rightCenterX = centerX + (elementWidth * (int) Math.pow(2, (tree.height(node) - 1)));
            int rightCenterY = (int) (centerY + (1.5f * elementHeight));
            g.drawLine(rightCenterX + elementWidth / 2, rightCenterY, centerX + elementWidth / 2, centerY + elementHeight);
            drawTree(node.right, rightCenterX, rightCenterY, false, g);
        }
    }

    public void setTree(AvlTree tree) {
        this.tree = tree;
    }

    public void setPanel(AvlTreePanel panel) {
        this.panel = panel;
    }
}
