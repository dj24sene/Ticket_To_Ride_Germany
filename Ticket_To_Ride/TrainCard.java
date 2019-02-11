import java.awt.*;
/**
 * Represents a Train Card
 *
 * @author Abdul Samad, Brianna Davis, Zach Giannuzzi, 
 * Dan Senecal, Eric Sauer
 * @version 4/30/2018
 */

public class TrainCard {

    private TrainCardsColor color;
    
    private Image img;
    
    /**
     * Creates a train card object
     * 
     * @param The color of the card
     * @param The image of the card
     */
    public TrainCard(TrainCardsColor color, Image img)
    {
        this.color = color;
        this.img = img;
    }

    /**
     * Gets the color of the train card
     * 
     * @return The color of the card
     */
    public TrainCardsColor getTrainCardColor()
    {
        return this.color;
    }
    
    /**
     * Gets the image being used
     * 
     * @return The image
     */
    public Image getImage()
    {
        return img;
    }
}
