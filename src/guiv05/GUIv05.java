package guiv05;

import java.awt.Graphics;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GUIv05{
   
    public static class BasicEventListener extends JPanel implements MouseListener{
       Graphics g;
        
        public BasicEventListener(){
           setBackground(Color.BLACK);
           addMouseListener(this);
       }
        
       int startX;
       int startY;
       int endX;
       int endY;
   
        public void mousePressed(MouseEvent evt){
            g = getGraphics();
            startX = evt.getX();
            startY = evt.getY();
            g.setColor(Color.GREEN);
            g.dispose();
        }
        
        public void mouseClicked(MouseEvent evt){
            g = getGraphics();
            startX = evt.getX();
            startY = evt.getY();
            System.out.println("startX:" + startX + " StartY: " + startY);
            g.setColor(Color.GREEN);
        }
        
        public void mouseReleased(MouseEvent evt){
            Graphics g = getGraphics();
            g = getGraphics();
            endX = evt.getX();
            endY = evt.getY();
            
            if(evt.isShiftDown())
                g.setColor(Color.RED);
            else if(evt.isAltDown())
                g.setColor(Color.GREEN);
            else if(evt.isControlDown())
                g.setColor(Color.ORANGE);
            else
                g.setColor(Color.BLUE);
            
            g.drawLine(startX, startY, endX, endY);
            g.dispose();
            
        }
        public void mouseEntered(MouseEvent evt){ }
        public void mouseExited(MouseEvent evt){ }
    }
    
    public static void main(String[] args) {
        BasicEventListener display = new BasicEventListener();
        
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(display, BorderLayout.CENTER);
        content.addMouseListener(new BasicEventListener());
        
        JFrame window = new JFrame();
        window.setContentPane(content);
        window.setSize(500, 500);
        window.setLocation(100, 100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}