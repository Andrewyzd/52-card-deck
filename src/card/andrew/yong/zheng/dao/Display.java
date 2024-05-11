package card.andrew.yong.zheng.dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display extends JFrame implements ActionListener       
{
    private final int SIZE = 1000;
    private final JPanel introPane = new JPanel();
    private final JPanel cardPane = new JPanel();
    private final JPanel cardPane2 = new JPanel();
    private final JPanel buttonPane = new JPanel();
    private final JMenuBar topBar = new JMenuBar();
    private final JMenu menu1 = new JMenu("Setting");
    private final JMenuItem resetname = new JMenuItem("New Name");
    private final JButton shuffle = new JButton("Shuffle");
    private final JButton resetcard = new JButton("Reset");
    private final Card[] card = new Card[53];
    private JLabel cardLabel = new JLabel();
    private JLabel cardLabel2 = new JLabel();
    private JLabel cardIntro = new JLabel();
    private int nOfCard = 0;
    ImageIcon card1,card2;
    Image image, temp_image;
    Card cards;
     
    /*
     *Default constructor of Display class to show JFrame 
     */
    public Display()
    {
        name();  
        showFrame();
        makeFrame();
    }
    
    /*Method to make the window of the game*/
    public void showFrame()
    {
        super.setTitle("Welcome to Joker Club");
        setSize(SIZE, SIZE);
        setLayout(new FlowLayout());
	setVisible(true);
	setResizable(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
    }
    
    /*Method to implement all the feature and the layout of the window for the game*/
    public void makeFrame()
    {   
        // add the menu to the frame
        setJMenuBar(topBar);
        topBar.add(menu1);
        menu1.add(resetname);   
        // call method to print the message
        cardIntroduction();
        //set the colour and the boundaries of the left card panel
        cardPane.setBackground(new Color((SIZE-SIZE),(SIZE-918),(SIZE-967)));
        cardPane.setBounds((SIZE-880),(SIZE-450),(SIZE-870),(SIZE-820));       
        // set the colour and the boundary of the right card panel
        cardPane2.setBackground(new Color((SIZE-SIZE),(SIZE-918),(SIZE-967)));
        cardPane2.setBounds((SIZE-230),(SIZE-450),(SIZE-870),(SIZE-820));     
        //access to the back card
        card1 = new ImageIcon("src\\Image/b2fv.png");
        card2 = new ImageIcon("src\\Image/backCard.png");       
        //pass the image to the method to add the back card to left and right panel
        changeCard(card1,card2);       
        // add the button to the panel
        buttonPane.add(shuffle);
        buttonPane.add(resetcard);
        // set the colour and the panel of the button
        buttonPane.setBackground(new Color((SIZE-SIZE),(SIZE-918),(SIZE-967)));
        buttonPane.setBounds((SIZE-570),(SIZE-900),(SIZE-830),(SIZE-960));      
        //response to the button, take action after click the button
        shuffle.addActionListener(this);
        resetcard.addActionListener(this);
        resetname.addActionListener(this);       
        // set the background of the frame
        
        ImageIcon joker = new ImageIcon("src\\Image/joker.png");
        image = joker.getImage();
        temp_image = image.getScaledInstance(SIZE, (SIZE+130), Image.SCALE_SMOOTH);
        joker = new ImageIcon(temp_image);
        JLabel background = new JLabel(joker,JLabel.CENTER);
        background.add(introPane);
        background.add(cardPane);
        background.add(cardPane2);
        background.add(buttonPane);
        //add the picture to the frame
        add(background);
        setVisible(true);                              
    }
    
    /*Method to generate the information and prompt the player to enter the name*/
    public void name()
    {
        String name = JOptionPane.showInputDialog(null,"Enter your name: ","eg. Joker");
        String introMessage = "Welcome, " + name +". Please click on shuffle button to obtain two cards.";
        cardIntro = new JLabel(introMessage);
    }
    
    /*Method to change and display the card before and after shuffle and get the card*/
    public void changeCard(ImageIcon card1, ImageIcon card2)
    {
        image = card1.getImage();
        temp_image = image.getScaledInstance((SIZE-870), (SIZE-825), Image.SCALE_SMOOTH);
        card1 = new ImageIcon(temp_image);
        cardLabel = new JLabel(card1);
        cardPane.add(cardLabel);  
        
        image = card2.getImage();
        temp_image = image.getScaledInstance((SIZE-870), (SIZE-825), Image.SCALE_SMOOTH);
        card2 = new ImageIcon(temp_image);
        cardLabel2 = new JLabel(card2);
        cardPane2.add(cardLabel2);      
    }
    
    /*Method to display the header and the instruction of the game*/
    public void cardIntroduction()
    {
        introPane.setBackground(new Color((SIZE-SIZE),(SIZE-918),(SIZE-967)));
        introPane.setBounds(0, 0, SIZE,(SIZE-900));    
        introPane.add(cardIntro);
        cardIntro.setForeground(Color.WHITE);
        cardIntro.setFont(new Font("Arial", Font.ITALIC, 30));
    }
    
    /*Method to insert the card object to the array*/
    public void insert(Card cards)
    {
        card[nOfCard] = cards;
        nOfCard++;
    }
    
    /*Method to shuffle the position of card object*/
    public void shuffle()
    {
        int shuffling = 0;
        for(int i = 0; i < getNumberOfCard(); i++)
        {
            //random generate the number for 1-52
            shuffling = (int) (Math.random()*getNumberOfCard()-1);
            //swap the position of the card in array
            Card temp = card[i];
            card[i] = card[shuffling];
            card[shuffling] = temp;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        //if user select shuffle button
        if(source == shuffle)
        {    
            shuffle();// call shuffle() to shuffle the card
            //remove the image of back of the card
            cardPane.remove(cardLabel);
            cardPane2.remove(cardLabel2);
            //select the first and second image of the card
            card1 = new ImageIcon(card[0].getCardImage());
            card2 = new ImageIcon(card[1].getCardImage());
            //pass the image to the method to add the card image to left and right panel
            changeCard(card1,card2);
            cardPane.validate();
            cardPane.repaint();
            cardPane2.validate();
            cardPane.repaint();
        }
        //if user select reset button
        else if(source == resetcard)
        {
            //remove the image of the cards
            cardPane.remove(cardLabel);
            cardPane2.remove(cardLabel2);
            //access to the back card
            card1 = new ImageIcon("src\\Image/b2fv.png");
            card2 = new ImageIcon("src\\Image/backCard.png");
            //pass the image to the method to add the back card to left and right panel
            changeCard(card1,card2);
            cardPane.validate();
            cardPane.repaint();
            cardPane2.validate();
            cardPane2.repaint();
        }
        //if user select New name button on the manu bar
        else if(source == resetname)
        {
            //remove the message form the panel
            introPane.remove(cardIntro);
            //call mehod to prompt user to enter the name
            name();
            // call method to print the message
            cardIntroduction();
            introPane.validate();
            introPane.repaint();
        }      
    }
    
   /**
     * This returns the size of the array as an Integer
     * @return this.nOfCard
     */
    public int getNumberOfCard(){
        return this.nOfCard;
    }
}//End of class Display

//Reference of code
/*******************************************************************
 * Title: Login Form design | Swing | Java | Hindi
 * Author: Tech-Gram Academy
 * Date: 30 January 2018
 * Availability: https://www.youtube.com/watch?v=QXVyg7lY9r8&t=1662s
*******************************************************************/
