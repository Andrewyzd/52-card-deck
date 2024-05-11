package card.andrew.yong.zheng.dao;

import java.awt.image.BufferedImage;

public class Card {
    private int cardValue;
    private BufferedImage cardImage;
    
    /**
     * @param cardValue = the value of the card
     * @param cardImage = a BufferedImage that represents the card
     */
    public Card(int cardValue, BufferedImage cardImage) 
    {
        this.cardValue = cardValue;
        this.cardImage = cardImage;  
    }
        
    /**
     * This returns the cardValue of the Card object as an Integer
     * @return cardValue
     */
    public int getCardValue()
    {
        return cardValue;
    }
    
   /**
     * This returns the cardImage of the Card object as an Integer
     * @return cardImage
     */
    public BufferedImage getCardImage()
    {
        return cardImage;
    } 
}//End of class Card


//Reference of code
/*******************************************************************
 * Title: Login Form design | Swing | Java | Hindi
 * Author: Tech-Gram Academy
 * Date: 30 January 2018
 * Availability: https://www.youtube.com/watch?v=QXVyg7lY9r8&t=1662s
*******************************************************************/