import java.util.ArrayList;
import javax.swing.*;
/**
 * Represents a Player
 *
 * @author Abdul Samad, Brianna Davis, Zach Giannuzzi, 
 * Dan Senecal, Eric Sauer
 * @version 4/30/2018
 */
public class Player
{
    /* The hand of cards the player has */
    public ArrayList<TrainCard> hand;
  
    /* The destination tickets this player currently holds */
    public ArrayList<DestinationTicket> tickets;

    //routes that have been claimed by the player
    protected ArrayList<Route> claimedRoutes;

    /* Number of points the player has */
    protected int points = 0;

    /* Number of total train pieces the player has left, starting with 45 */
    private int trainPieces = 45;

    /* Player color */
    private String color = "";

    /* Player name */
    private String playerName = "";
    
    protected ArrayList<DestinationTicket> achieved;

    //meeples that the player currently holds
    private ArrayList<MeeplesColor> playerMeeples;
    
    protected int pointsAdded, pointsSubtracted;

    /**
     * Creates a player object
     * 
     * @param The name of the player
     * @param The color the player selected
     */
    public Player(String name, String color)
    {
        playerName = name;
        this.color = color;
        pointsAdded = 0;
        pointsSubtracted = 0;
        achieved = new ArrayList<DestinationTicket>();
        hand = new ArrayList<TrainCard>();
        tickets = new ArrayList<DestinationTicket>();
        playerMeeples = new ArrayList<MeeplesColor>();
        claimedRoutes = new ArrayList<Route>();        
    }

    /**
     * Gets the name of the player
     * 
     * @return The name of the player
     */
    public String getName()
    {
        return playerName;
    }

    /**
     * Gets the color the player selected
     * 
     * @return The color selected
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Adds a meeple to the players meeple count
     * 
     * @param The color of the meeple being added
     */
    public void addMeeple(MeeplesColor color)
    {
        playerMeeples.add(color);
    }

     /**
     * Gets the number of meeples the player has
     * 
     * @return the size of the players meeple arraylist
     */
    public int getTotalNumPlayerMeeples()
    {
        return playerMeeples.size();
    }

    /**
     * Gets the colors of the players meeples
     * 
     * @return An arraylist of the colors of the meeples
     */
    public ArrayList<MeeplesColor> getPlayerMeeplesColor()
    {
        return playerMeeples;
    }

    /**
     * Gets the count of a color of meeple a player has
     * 
     * @param The color to count the number of meeples of
     * @return The number of meeples of that color
     */
    public int getPlayerMeeplesOfColor(MeeplesColor color)
    {
        int count =0;
        for( int i =0; i<playerMeeples.size(); i++)
        {
            if (playerMeeples.get(i).equals(color))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Gets the hand of train cards a player has
     * 
     * @return An arraylist of the players train cards
     */
    public ArrayList<TrainCard> getHand()
    {
        return hand;
    }

    /**
     * Gets the destination tickets a player has
     * 
     * @return An arraylist of the players destination tickets
     */
    public ArrayList<DestinationTicket> getDestinationTickets()
    {
        return tickets;
    }

    /**
     * Adds an amount of points to the players score
     * 
     * @param The amount of points to be added
     */
    public void addPoints(int amount)
    {
        points += amount;
    }

    /**
     * Gets the number of train pieces
     * 
     * @return The number of train pieces
     */
    public int getNumTrainPieces()
    {
        return trainPieces;
    }

    /**
     * Sets the number of train pieces
     * 
     * @param The number of train pieces to be removed
     * 
     */
    public void removeTrainPieces(int amount)
    {
        trainPieces -= amount;
    }

    /**
     * Getter for points
     * 
     * @return The number of points player has
     * 
     */
    public int getPoints()
    {
        return points;
    }

    /**
     * Returns the number of train cards this player has of the given color
     * 
     * @param The color of cards to search for
     * @return the number of train cards of the selected cards
     * 
     */
    public int getNumTrainCard(TrainCardsColor cardColor)
    {
        int count = 0;
        for(TrainCard card : this.hand)
        {
            if(card.getTrainCardColor() == cardColor) 
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Adding and removing cards from the players hand
     * 
     * @param The new train card to be added
     * 
     */
    public void addTrainCard(TrainCard newCard)
    {
        hand.add(newCard);
    }

    /**
     * Removes a train card from the players hand
     * 
     * @param The train card to be removed from the hand
     */
    public void removeTrainCard(TrainCard card)
    {
        if(hand == null || card == null) 
        {
            return;
        }
        if(!hand.contains(card))
        {
            return;
        }
        hand.remove(card);
    }

    /**
     * Add destination tickets
     * 
     * @param the ticket to be added hahahahah
     * 
     */
    public void addDestinationTicket(DestinationTicket ticket)
    {
        tickets.add(ticket);
    }

    /**
     * Remove destination tickets
     * 
     * @param the ticket to be added hahahahah
     * 
     */
    public void removeDestinationTicket(DestinationTicket ticket){
        if(hasDestinationTickets(ticket)){
            tickets.remove(getDestinationTicket(ticket));
        }
    }

    //helper method
    private boolean hasDestinationTickets(DestinationTicket ticket){
        return getDestinationTicket(ticket) != null;
    }

    /**
     * Helper method
     * Gets the instance of the given ticket actually in our hand
     *
     * @param ticket The destination ticket.
     * 
     * @return returns the destination ticket or null if the 
     * ticket is not in the list.
     */
    private DestinationTicket getDestinationTicket(DestinationTicket ticket){
        for(DestinationTicket myTicket : tickets)
        {
            if(myTicket.equals(ticket)) 
            {
                return myTicket;
            }
        }
        return null;
    } 

    /**
     * Invoked at the end of the game. 
     * Subtracts away the destination ticket values from 
     * the player's score if not completed
     * 
     */
    public void subtractRemainingDT(){
        for(DestinationTicket ticket : tickets)
        {
            this.addPoints(-1 * ticket.getPoints());
        }
    }

    /**
     * Claims a route for a certain color
     * 
     * @param The route to claim
     * @param The color for the route
     * @param The cards used to claim the route
     */
    public boolean claimRoute(Route rt, TrainCardsColor color, int[] cards)
    {
        boolean result = false;
        int numColorTrains = cards[0];
        int numLocoTrains = cards[1];
      
        if((rt.getColor().equals(color)) && 
        (rt.getNumTrains() == cards[0]+cards[1]) &&
        (getNumTrainCard(color) >= cards[0] && 
        rt.getNumTrains() <= trainPieces))
        {
            ArrayList<TrainCard> usedCards = new ArrayList<TrainCard>();
            for(int i = 0; i < hand.size(); i++)
            {
                if(hand.get(i).getTrainCardColor().equals(color) 
                && numColorTrains > 0) 
                {
                    TCDeck.discarded.add(hand.get(i));
                    usedCards.add(hand.get(i));
                    numColorTrains--;
                    result = true;
                }
              
                if( numLocoTrains > 0 && 
             hand.get(i).getTrainCardColor().equals(TrainCardsColor.LOCOMOTIVE)) 
                {
                    TCDeck.discarded.add(hand.get(i));
                    usedCards.add(hand.get(i));
                    numLocoTrains--;
                    result = true;
                }
            }
            for (TrainCard card : usedCards){
                hand.remove(card);
            }
            addRoutePoints(rt);
            claimedRoutes.add(rt);
            trainPieces = trainPieces - rt.getNumTrains();
        }
      
        else if (color == TrainCardsColor.GRAY){
           ArrayList<TrainCardsColor> colors = new ArrayList<TrainCardsColor>();
           if (getNumTrainCard(TrainCardsColor.YELLOW) >= numColorTrains){
                colors.add(TrainCardsColor.YELLOW);
           }
           if (getNumTrainCard(TrainCardsColor.BLUE) >= numColorTrains){
                colors.add(TrainCardsColor.BLUE);
           }
           if (getNumTrainCard(TrainCardsColor.GREEN) >= numColorTrains){
                colors.add(TrainCardsColor.GREEN);
           }
           if (getNumTrainCard(TrainCardsColor.PINK) >= numColorTrains){
                colors.add(TrainCardsColor.PINK);
           }
           if (getNumTrainCard(TrainCardsColor.RED) >= numColorTrains){
                colors.add(TrainCardsColor.RED);
           }
           if (getNumTrainCard(TrainCardsColor.BLACK) >= numColorTrains){
                colors.add(TrainCardsColor.BLACK);
           }
           if (getNumTrainCard(TrainCardsColor.ORANGE) >= numColorTrains){
                colors.add(TrainCardsColor.ORANGE);
           }
           if (getNumTrainCard(TrainCardsColor.WHITE) >= numColorTrains){
                colors.add(TrainCardsColor.WHITE);
           }
           int answer = -1;
           String[] buttons = new String[colors.size()];
              
           if (colors.size() > 0){
                for (int i = 0; i < colors.size(); i++){
                    buttons[i] = colors.get(i).toString();
                }
                answer = JOptionPane.showOptionDialog(null, 
                "Which color would you like to use?", "Choose Color",
                0, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
           }
           else { return false;}
           TrainCardsColor selectedColor = colors.get(answer);
           color = selectedColor;
           ArrayList<TrainCard> usedCards = new ArrayList<TrainCard>();
            
           for(int i = 0; i < hand.size(); i++)
           {
              if(hand.get(i).getTrainCardColor().equals(color) && 
              numColorTrains > 0)
              {
                    TCDeck.discarded.add(hand.get(i));
                    usedCards.add(hand.get(i));
                    numColorTrains--;
                    result = true;
              }
            
              if(hand.get(i).getTrainCardColor().
              equals(TrainCardsColor.LOCOMOTIVE) 
              && numLocoTrains > 0)
              {
                    TCDeck.discarded.add(hand.get(i));
                    usedCards.add(hand.get(i));
                    numLocoTrains--;
                    result = true;
              }
           }
           for (TrainCard card : usedCards){
                hand.remove(card);
           }
           addRoutePoints(rt);
           claimedRoutes.add(rt);
           trainPieces = trainPieces - rt.getNumTrains();
        }
        else if( rt.getNumTrains() > trainPieces)
        {
              
            JOptionPane.showMessageDialog(null,
            "You do not have enough TRAIN CARS to claim this route", 
            "Invalid", JOptionPane.ERROR_MESSAGE);
            
        }
        return result;
    }
    
    /**
    * Gets the score for the claimed route
    */
    public void DTScore(){
        int count = 0;
        for (DestinationTicket t : tickets){
            ArrayList<Route> path = new ArrayList<Route>();
            ArrayList<Route> routesLeft = new ArrayList<Route>();
            for (Route r : claimedRoutes){
                routesLeft.add(r);
            }
            if (tickets.size() <= count){
                break;
            }
             
            boolean result = 
            achievedDestinationTicket(t,routesLeft,path,t.getStartingPoint());
            if (result){
                achieved.add(t);
                pointsAdded += t.getPoints();
            }
            else {
                count++;
                pointsSubtracted = pointsSubtracted + t.getPoints();
            }
        }
    }
  
    
    /**
     * Determines if the destination ticket has been achieved
     * 
     * @param The destination ticket
     * @param The array of remaining routes
     * @param The path of the ticket
     * @param The vertices for the path
     * @return true if the ticket has been achieved 
     */
    public boolean achievedDestinationTicket(
    DestinationTicket t, ArrayList<Route> routesLeft, 
    ArrayList<Route> path, Vertices v){
        boolean result = false;
        Vertices vertex = v;
        
        if (path.size() > 0 && (path.get(path.size()-1).getVertex1() ==
        t.getEndingPoint() || path.get(path.size()-1).getVertex2() == 
        t.getEndingPoint())){
            return true;
        }
        int size = routesLeft.size();
        for (int i = 0; i < size; i++){
            Route r = routesLeft.get(i); 
            if (r.getVertex1() == vertex){ 
                path.add(r);
                routesLeft.remove(r);
             
                result = achievedDestinationTicket(t,routesLeft,path,
                r.getVertex2());
                if (result == false){
                    path.remove(path.size()-1);
                    routesLeft.add(r);
                }
                else { //result == true
                    result = true;
                    break;
                }
            }
            else if (r.getVertex2() == vertex){ 
                path.add(r);
                routesLeft.remove(r);
                result = achievedDestinationTicket(t,routesLeft,path,
                r.getVertex1());
                if (result == false){
                    path.remove(path.size()-1);
                    routesLeft.add(r);
                }
                else { //result == true
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    
     /**
     * Adds route points
     * 
     * @param The route that is getting points added to
     */
    private void addRoutePoints(Route rt) 
    {
        points += rt.getRoutePoints();
    }
}
