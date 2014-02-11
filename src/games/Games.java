package games;
import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout.*;
import java.awt.event.*;

/*************************************************************************
 * Creates a grid Layout
 ************************************************************************/
class Grid implements ActionListener 
{
    JFrame subWindow;
    public void createWindow()
    {
        subWindow = new JFrame("GridLayout");
        subWindow.setSize(300,300);
        subWindow.setLocation(20,20);
        subWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        subWindow.setLayout(new GridLayout(3,2));
        
        JButton test1 = new JButton("1");
        JButton test2 = new JButton("2");
        JButton test3 = new JButton("3");
        JButton test4 = new JButton("4");
        JButton test5 = new JButton("5");
        JButton test6 = new JButton("6");
        
        subWindow.add(test1);
        subWindow.add(test2);
        subWindow.add(test3);
        subWindow.add(test4);
        subWindow.add(test5);
        subWindow.add(test6);

        subWindow.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        createWindow();
    }    
}

/******************************************************************************
 * Creates the main window with a BorderLayout.
 *****************************************************************************/
class Graphic extends JPanel
{
    private static JFrame mainWindow;
    Graphic()
    {
        mainWindow = new JFrame("");
        mainWindow.setSize(300,300);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(new BorderLayout());
        
        JButton test1 = new JButton("Memory HC");
        test1.addActionListener(new GridBagTest());
        mainWindow.add(test1, BorderLayout.NORTH);
        
        JButton test2 = new JButton("test2");
        mainWindow.add(test2, BorderLayout.SOUTH);
        
        JButton test3 = new JButton("test3");
        test3.addActionListener(new Grid());
        mainWindow.add(test3, BorderLayout.CENTER);
        
        JButton test4 = new JButton("test4");
        mainWindow.add(test4, BorderLayout.EAST);
        
        JButton test5 = new JButton("test5");
        mainWindow.add(test5, BorderLayout.WEST);
        
        mainWindow.setVisible(true);
    }
}

/*****************************************************************************
 * Instantiates the windows
 ****************************************************************************/
public class Games {

    public static void main(String[] args) {
        Graphic item = new Graphic();
    }
}