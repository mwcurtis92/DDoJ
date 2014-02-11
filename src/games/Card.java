/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/************************************************************************
 * A class that describes a Card object. Contains it's image, the JLabel,
 * and whether it is flipped or active.
 ***********************************************************************/
class Card
{
    JLabel card;
    ImageIcon img;
    int imageNum;
    boolean flipped;
    boolean active;
    
    public Card(int pImageNum)
    {
        imageNum = pImageNum;
        card = new JLabel();
        active = true;
        flipped = true;
        
        ImageIcon newCard = new ImageIcon("cardNormal.png");
        Image imgTemp = newCard.getImage();
        imgTemp = imgTemp.getScaledInstance(75, 100, Image.SCALE_SMOOTH);
        Icon newIcon = new ImageIcon(imgTemp);
        card.setIcon(newIcon);
    }
    
    public int returnCardNum()
    {
        return imageNum;
    }
    
    public JLabel returnLabel()
    {
        return card;
    }
    
    public void change()
    {
        String image = "card" + imageNum + ".png";
        if(flipped)
        {
            ImageIcon newCard = new ImageIcon("cardNormal.png");
            Image imgTemp = newCard.getImage();
            imgTemp = imgTemp.getScaledInstance(75, 100, Image.SCALE_SMOOTH);
            Icon newIcon = new ImageIcon(imgTemp);
            card.setIcon(newIcon);
            flipped = false;
        }
        else 
        {
            ImageIcon newCard = new ImageIcon(image);
            Image imgTemp = newCard.getImage();
            imgTemp = imgTemp.getScaledInstance(75, 100, Image.SCALE_SMOOTH);
            Icon newIcon = new ImageIcon(imgTemp);
            card.setIcon(newIcon);
            flipped = true;
        }
     }   
}