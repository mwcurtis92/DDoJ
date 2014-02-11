/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.*;

/*******************************************************
 * Uses a GridBag to implement a Memory Game
 ******************************************************/
class GridBagTest extends JPanel implements ActionListener
{
    JFrame subFrame;
    Card cards[] = new Card[9];
    GridBagLayout gb;
    Card lastFlipped = null;
    
    public void startGame()
    {
        createDefaultWindow();
    }
    
    public void initializeGameMenu()
    {
        JMenuBar menu = new JMenuBar();
        
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem helpMenu = new JMenuItem("Help Menu");
        
        file.add(save);
        file.add(quit);
        help.add(helpMenu);
        
        menu.add(file);
        menu.add(help);
        
        subFrame.setJMenuBar(menu);
    }
    
    public int[] generateArray()
    {
        int intArray[] = new int[9];
        for(int i = 0; i < 9;i++)
        {
            intArray[i] = -1;
        }
        int generatedValue;
        Random generator = new Random();
        int counter = 0;
        
        for(int i = 0; i < 9; i++)
        {
            generatedValue = generator.nextInt(5);
            for(int j = 0; j < 9; j++)
            {
                if(intArray[j] == generatedValue)
                {
                    counter++;
                    if(counter >= 2)
                    {
                        generatedValue = generator.nextInt(5);
                        j = -1;
                        counter = 0; 
                    }
                }
            }
            intArray[i] = generatedValue;
        }        
 
        return intArray;
    }
    
    public void initializeDeck()
    {
        GridBagConstraints constraints = new GridBagConstraints();
        int x = 0; 
        int y = 0;
        
        constraints.fill = GridBagConstraints.BOTH;    
        constraints.weightx = 1;     //centers the cards.
        constraints.weighty = 1;    //centeres the cards.
        constraints.gridwidth = 1;
        constraints.gridheight = 1;    
        int array[] = generateArray();
        
        for(int i = 0; i < 9; i++)
        {
            cards[i] = new Card(array[i]);
            cards[i].returnLabel().addMouseListener(new CardEvents(cards[i]));
            constraints.gridx = x;
            constraints.gridy = y;
            x++;
            if(x == 3)
            {
                y++;
                x = 0;
            }
            gb.setConstraints(cards[i].returnLabel(), constraints);
            subFrame.add(cards[i].returnLabel());
        }
    }
    
    public void createDefaultWindow()
    {        
        subFrame = new JFrame("GridBag");
        subFrame.setSize(400,400);
        subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        subFrame.setLocation(20,20);
        
        gb = new GridBagLayout();
        subFrame.setLayout(gb);
        
        initializeGameMenu();
        initializeDeck();
        
        subFrame.setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent event)
    {
        startGame();
    }

     /********************************************************************
     * Class to change the cards when clicked.
     ********************************************************************/
    class CardEvents implements MouseListener
    {
        Card cardToChange;
        boolean isFlipped;
        boolean firstClick;
        public CardEvents(Card pCardToChange)
        {
            cardToChange = pCardToChange;
            firstClick = true;
        }
        
        @Override
        public void mouseExited(MouseEvent e) {};
        @Override
        public void mouseEntered(MouseEvent e){};
        @Override
        public void mouseReleased(MouseEvent e){
            if(firstClick)
            {
                cardToChange.change();
                firstClick = false;
            }
            if(lastFlipped != null)
            {
                checkForMatch();
            }
            //checkForMatch();
            lastFlipped = cardToChange;
        };
        @Override
        public void mousePressed(MouseEvent e){
            cardToChange.change();
            //checkForMatch();
//            if(lastFlipped != null)
//            {
//                checkForMatch();
//            }
            //lastFlipped = cardToChange;
        }
        
        @Override
        public void mouseClicked(MouseEvent e){};
        
        public boolean checkForMatch()
        {
            if(lastFlipped.returnCardNum() == cardToChange.returnCardNum())
            {
                System.out.println("Same");
                return true;
            }
            else
            {
                System.out.println("Different");
                return false;
            }
        }
    }
}
