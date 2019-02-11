import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import java.util.Collections;
/**
 * Represents a Ticket Card Deck
 *
 * @author Abdul Samad, Brianna Davis, Zach Giannuzzi, 
 * Dan Senecal, Eric Sauer
 * @version 4/30/2018
 */
public class TCDeck
{
    //remaining tickets in the deck
    protected ArrayList <TrainCard> remaining;

    //tickets that have been issued
    protected ArrayList <TrainCard> issued;

    //tickets that are on the table
    protected ArrayList <TrainCard> view;

    //tickets that have been discarded
    public static ArrayList <TrainCard> discarded;

    public TCDeck()
    {
        remaining = new ArrayList<TrainCard>();
        issued = new ArrayList<TrainCard>();
        view = new ArrayList<TrainCard>();
        discarded = new ArrayList<TrainCard>();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image greenCard = toolkit.getImage
        ("." + "/trainCards/" + "greentrainD.png");
        Image blueCard = toolkit.getImage
        ("." + "/trainCards/" + "bluetrainD.png");
        Image redCard = toolkit.getImage
        ("." + "/trainCards/" + "redtrainD.png");
        Image whiteCard = toolkit.getImage
        ("." + "/trainCards/" + "whitetrainD.png");
        Image pinkCard = toolkit.getImage
        ("." + "/trainCards/" + "purpletrainD.png");
        Image orangeCard = toolkit.getImage
        ("." + "/trainCards/" + "orangetrainD.png");
        Image locomotiveCard = toolkit.getImage
        ("." + "/trainCards/" + "locomotiveD.png");
        Image yellowCard = toolkit.getImage
        ("." + "/trainCards/" + "yellowtrainD.png");
        Image blackCard = toolkit.getImage
        ("." + "/trainCards/" + "blacktrainD.png");
        for(int i =0; i< 12; i++)
        {
            remaining.add(new TrainCard(TrainCardsColor.BLUE , blueCard ));
            remaining.add(new TrainCard(TrainCardsColor.YELLOW, yellowCard ));
            remaining.add(new TrainCard(TrainCardsColor.BLACK, blackCard ));
            remaining.add(new TrainCard(TrainCardsColor.RED, redCard ));
            remaining.add(new TrainCard(TrainCardsColor.ORANGE, orangeCard ));
            remaining.add(new TrainCard(TrainCardsColor.WHITE, whiteCard ));
            remaining.add(new TrainCard(TrainCardsColor.GREEN, greenCard ));
            remaining.add(new TrainCard(TrainCardsColor.PINK, pinkCard ));
            remaining.add
            (new TrainCard(TrainCardsColor.LOCOMOTIVE, locomotiveCard));
        }
        remaining.add(new TrainCard
        (TrainCardsColor.LOCOMOTIVE, locomotiveCard));
        remaining.add
        (new TrainCard(TrainCardsColor.LOCOMOTIVE, locomotiveCard));
        Collections.shuffle(remaining);

        for(int i =0; i< 5; i++)
        {
            view.add(drawCard());
        }
        isLegal();
    }

    /**
     * Draws a train card.
     * 
     * @return The card that was drawn.
     */
    public TrainCard drawCard()
    {   
        if(remaining.size() == 0)
        {
            shuffle();
        }
        int ticIndex = (int) Math.floor(Math.random()*remaining.size());
        TrainCard removed = remaining.remove(ticIndex);
        issued.add(removed);
        isLegal();
        return removed;
    } 

    /**
     * Checks to see if the number of locomotives on the table
     * are less than 3.
     * 
     *
     */
    public void isLegal()
    {
        int count =0;
        boolean result = false;
        do {
            for(int i = 0; i < view.size(); i++)
            {             
                if(view.get(i).getTrainCardColor().equals
                ( TrainCardsColor.LOCOMOTIVE))
                {
                    count++;
                }
            }
            if(count < 3)
            {
                result = true;
            }
            else 
            {
                while (view.size() != 0){
                    remaining.add(view.get(0));
                    view.remove(0);
                }
                for(int i =0; i< 5; i++)
                {
                    view.add(drawCard());
                }
            }
        }while(result = false);
    }

    /**
     * Shuffles the deck
     * 
     * @return An arraylist of shuffled cards.
     */
    public ArrayList<TrainCard> shuffle()
    {
        Collections.shuffle(discarded);
        for(int i =0; i < discarded.size(); i++)
        {
            remaining.add(discarded.get(i));
        }
        discarded.clear();
        return remaining;
    }
}
