
/**
 * Driver for running the Ticket to Ride Game
 * 
 * @author Abdul Samad, Brianna Davis, Zach Giannuzzi, 
 * Dan Senecal, Eric Sauer
 * @version 4/30/2018
 */
public class TicketToRideDriver
{
    /**
     * Main method that runs the TicketToRide game.
     * 
     * @param args Doesn't use args
     */
    public static void main(String []args)
    {
        Board game = new Board();
        game.createAndShowGUI();
    }
}
