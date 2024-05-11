package card.andrew.yong.zheng.dao;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Driver{
    public static void main(String[] args) throws IOException {
        Display display = new Display();
        Card card;     
        //Insert the deck of 52 card
        for(int i = 1; i < 53 ; i++)
        {
            card = new Card(i, ImageIO.read(new File("src\\Image/"+i+".png")));
            display.insert(card);
        }//End of for-loop
        
    }//End of main class
}//End of Driver class
