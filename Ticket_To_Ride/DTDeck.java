import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Scanner;
/**
 * Represents a Destination Ticket Deck
 *
 * @author Abdul Samad, Brianna Davis, Zach Giannuzzi, 
 * Dan Senecal, Eric Sauer
 * @version 4/30/2018
 */
public class DTDeck
{
    //remaining tickets in the deck
    private ArrayList <DestinationTicket> remaining;

    //tickets that have been issued
    private ArrayList <DestinationTicket> issued;
    //tickets that have been issued
    protected ArrayList <DestinationTicket> pick;
    /**
     * Constructs a DTDeck Object
     */
    public DTDeck()
    {
        remaining = new ArrayList<DestinationTicket>();
        issued = new ArrayList<DestinationTicket>();
        pick = new ArrayList<DestinationTicket>();
        //remianing.add(new DestinationTicket (
        remaining.add
(new DestinationTicket (Vertices.BERLIN,Vertices.CHEMNITZ,6));
        remaining.add
(new DestinationTicket (Vertices.BERLIN,Vertices.DUSSELDORF,13));
        remaining.add
(new DestinationTicket (Vertices.BERLIN,Vertices.ERFURT,7));
        remaining.add
(new DestinationTicket (Vertices.BERLIN,Vertices.FRAKFURT,14));
        remaining.add
(new DestinationTicket (Vertices.BERLIN,Vertices.KOLN,14));
        remaining.add
(new DestinationTicket (Vertices.BERLIN,Vertices.LEIPZIG,4));
        remaining.add
(new DestinationTicket (Vertices.BERLIN,Vertices.MAINZ,15));
        remaining.add
(new DestinationTicket (Vertices.BERLIN,Vertices.MUNCHEN,15));
        remaining.add
(new DestinationTicket (Vertices.BERLIN,Vertices.SCHWEIZ,20));
        remaining.add
(new DestinationTicket (Vertices.BERLIN,Vertices.STUTTGART,18));
        remaining.add
(new DestinationTicket (Vertices.BREMEN,Vertices.BERLIN,10));
        remaining.add
(new DestinationTicket (Vertices.BREMEN,Vertices.DUSSELDORF,5));
        remaining.add
(new DestinationTicket (Vertices.BREMERHAVEN,Vertices.FRANKREICH,12));
        remaining.add
(new DestinationTicket (Vertices.BREMEN,Vertices.KASSEL,6));
        remaining.add
(new DestinationTicket (Vertices.BREMERHAVEN,Vertices.KOLN,7));
        remaining.add
(new DestinationTicket (Vertices.BREMERHAVEN,Vertices.REGENSBURG,16));
        remaining.add
(new DestinationTicket (Vertices.DANEMARK,Vertices.BERLIN,10));
        remaining.add
(new DestinationTicket (Vertices.DANEMARK,Vertices.LINDAU,22));
        remaining.add
(new DestinationTicket (Vertices.DANEMARK,Vertices.NIEDERLANDE,10));
        remaining.add
(new DestinationTicket (Vertices.DORTMUND,Vertices.ERFURT,7));
        remaining.add
(new DestinationTicket (Vertices.DORTMUND,Vertices.MAGDEBURG,9));
        remaining.add
(new DestinationTicket (Vertices.DORTMUND,Vertices.MANNHEIM,6));
        remaining.add
(new DestinationTicket (Vertices.DORTMUND,Vertices.MUNCHEN,13));
        remaining.add
(new DestinationTicket (Vertices.DRESDEN,Vertices.AUGSBURG,12));
        remaining.add
(new DestinationTicket (Vertices.DRESDEN,Vertices.SAARBRUCKEN,16));
        remaining.add
(new DestinationTicket (Vertices.DUSSELDORF,Vertices.KONSTANZ,10));
        remaining.add
(new DestinationTicket (Vertices.EMDEN,Vertices.FREIBURG,15));
        remaining.add
(new DestinationTicket (Vertices.EMDEN,Vertices.HAMBURG,6));
        remaining.add
(new DestinationTicket (Vertices.EMDEN,Vertices.OSTERREICH,19));
        remaining.add
(new DestinationTicket (Vertices.ERFURT,Vertices.WURZBURG,6));
        remaining.add
(new DestinationTicket (Vertices.FRANKREICH,Vertices.DANEMARK,17));
        remaining.add
(new DestinationTicket (Vertices.FRAKFURT,Vertices.MUNCHEN,9));
        remaining.add
(new DestinationTicket (Vertices.FRANKREICH,Vertices.MUNCHEN,8));
        remaining.add
(new DestinationTicket (Vertices.FRANKREICH,Vertices.LEIPZIG,15));
        remaining.add
(new DestinationTicket (Vertices.FRAKFURT,Vertices.LINDAU,8));
        remaining.add
(new DestinationTicket (Vertices.FRAKFURT,Vertices.OSTERREICH,10));
        remaining.add
(new DestinationTicket (Vertices.FRAKFURT,Vertices.STUTTGART,4));
        remaining.add
(new DestinationTicket (Vertices.HAMBURG,Vertices.BERLIN,7));
        remaining.add
(new DestinationTicket (Vertices.HAMBURG,Vertices.DRESDEN,12));
        remaining.add
(new DestinationTicket (Vertices.HAMBURG,Vertices.FRAKFURT,11));
        remaining.add
(new DestinationTicket (Vertices.HAMBURG,Vertices.KARLSRUHE,14));
        remaining.add
(new DestinationTicket (Vertices.HAMBURG,Vertices.KASSEL,7));
        remaining.add
(new DestinationTicket (Vertices.HAMBURG,Vertices.KOBLENZ,10));
        remaining.add
(new DestinationTicket (Vertices.HAMBURG,Vertices.KOLN,9));
        remaining.add
(new DestinationTicket (Vertices.HAMBURG,Vertices.LEIPZIG,10));
        remaining.add
(new DestinationTicket (Vertices.HAMBURG,Vertices.MUNCHEN,18));
        remaining.add
(new DestinationTicket (Vertices.HAMBURG,Vertices.ROSTOCK,4));
        remaining.add
(new DestinationTicket (Vertices.HAMBURG,Vertices.STUTTGART,15));
        remaining.add
(new DestinationTicket (Vertices.HANNOVER,Vertices.FRAKFURT,7));
        remaining.add
(new DestinationTicket (Vertices.HANNOVER,Vertices.LEIPZIG,6));
        remaining.add
(new DestinationTicket (Vertices.HANNOVER,Vertices.SAARBRUCKEN,11));
        remaining.add
(new DestinationTicket (Vertices.KARLSRUHE,Vertices.AUGSBURG,4));
        remaining.add
(new DestinationTicket (Vertices.KARLSRUHE,Vertices.REGENSBURG,9));
        remaining.add
(new DestinationTicket (Vertices.KASSEL,Vertices.FREIBURG,10));
        remaining.add
(new DestinationTicket (Vertices.KIEL,Vertices.NURNBERG,15));
        remaining.add
(new DestinationTicket (Vertices.KIEL,Vertices.SCHWEIZ,20));
        remaining.add
(new DestinationTicket (Vertices.KIEL,Vertices.STUTTGART,17));
        remaining.add
(new DestinationTicket (Vertices.KOBLENZ,Vertices.ULM,7));
        remaining.add
(new DestinationTicket (Vertices.KOLN,Vertices.FRAKFURT,4));
        remaining.add
(new DestinationTicket (Vertices.KOLN,Vertices.LEIPZIG,12));
        remaining.add
(new DestinationTicket (Vertices.KOLN,Vertices.MUNCHEN,11));
        remaining.add
(new DestinationTicket (Vertices.KOLN,Vertices.NURNBERG,8));
        remaining.add
(new DestinationTicket (Vertices.KOLN,Vertices.REGENSBURG,11));
        remaining.add
(new DestinationTicket (Vertices.KOLN,Vertices.SAARBRUCKEN,4));
        remaining.add
(new DestinationTicket (Vertices.KOLN,Vertices.SCHWEIZ,10));
        remaining.add
(new DestinationTicket (Vertices.LEIPZIG,Vertices.MUNCHEN,11));
        remaining.add
(new DestinationTicket (Vertices.LEIPZIG,Vertices.STUTTGART,14));
        remaining.add
(new DestinationTicket (Vertices.LEIPZIG,Vertices.ULM,12));
        remaining.add
(new DestinationTicket (Vertices.LEIPZIG,Vertices.FRAKFURT,10));
        remaining.add
(new DestinationTicket (Vertices.LEIPZIG,Vertices.NURNBERG,7));
        remaining.add
(new DestinationTicket (Vertices.MAGDEBURG,Vertices.KOLN,11));
        remaining.add
(new DestinationTicket (Vertices.MAINZ,Vertices.STUTTGART,3));
        remaining.add
(new DestinationTicket (Vertices.MANNHEIM,Vertices.STUTTGART,2));
        remaining.add
(new DestinationTicket (Vertices.MANNHEIM,Vertices.WURZBURG,4));
        remaining.add
(new DestinationTicket (Vertices.MUNCHEN,Vertices.FREIBURG,8));
        remaining.add
(new DestinationTicket (Vertices.MUNCHEN,Vertices.KONSTANZ,6));
        remaining.add
(new DestinationTicket (Vertices.MUNCHEN,Vertices.STUTTGART,5));
        remaining.add
(new DestinationTicket (Vertices.MUNCHEN,Vertices.WURZBURG,7));
        remaining.add
(new DestinationTicket (Vertices.MUNSTER,Vertices.MUNCHEN,14));
        remaining.add
(new DestinationTicket (Vertices.MUNSTER,Vertices.OSTERREICH,15));
        remaining.add
(new DestinationTicket (Vertices.MUNSTER,Vertices.STUTTGART,9));
        remaining.add
(new DestinationTicket (Vertices.NIEDERLANDE,Vertices.BERLIN,13));
        remaining.add
(new DestinationTicket (Vertices.NIEDERLANDE,Vertices.FRAKFURT,8));
        remaining.add
(new DestinationTicket (Vertices.NIEDERLANDE,Vertices.KARLSRUHE,9));
        remaining.add
(new DestinationTicket (Vertices.NURNBERG,Vertices.STUTTGART,7));
        remaining.add
(new DestinationTicket (Vertices.ROSTOCK,Vertices.KONSTANZ,22));
        remaining.add
(new DestinationTicket (Vertices.ROSTOCK,Vertices.OSTERREICH,22));
        remaining.add
(new DestinationTicket (Vertices.SCHWERIN,Vertices.KOBLENZ,12));
        remaining.add
(new DestinationTicket (Vertices.SCHWERIN,Vertices.FRAKFURT,13));

        Collections.shuffle(remaining);
    }
    
    /**
     * The method for drawing a short ticket
     * 
     * @return the removed Destination ticket
     */
    public DestinationTicket drawShortTicket()
    {
        if(remaining.size() == 0)
        {
            return null;
        }
        DestinationTicket removed = remaining.get(0);
        for (int i = 0 ; i < remaining.size(); i++){ 
            if(remaining.get(i).getPoints() < 12){
                removed = remaining.remove(i);
                issued.add(removed);
                break;
            }
        }
        return removed;
    }
    
    /**
     * The method for drawing a long ticket
     * 
     * @return the removed long destination ticket
     */
    public DestinationTicket drawLongTicket()
    {
        if(remaining.size() == 0)
        {
            return null;
        }
        DestinationTicket removed = remaining.get(0);
        for (int i = 0 ; i < remaining.size(); i++){ 
            if(remaining.get(i).getPoints() >= 12){
                removed = remaining.remove(i);
                issued.add(removed);
                break;
            }
        }
        return removed;
    }

     /**
     * Determines if the ticket has been issued
     * 
     * @param The ticket to find
     * @return True if the ticket has been issued, false otherwise
     */
    public boolean isIssued(DestinationTicket ticket)
    {
        for(DestinationTicket issued : remaining)
        {
            if(issued.equals(ticket)) 
            {
                return true;
            }
        }

        return false;
    }
    
    /**
     * Gets the name of the destination ticket
     * 
     * @param The name of the first vertex of the route
     * @param The name of the second vertex of the route
     * @return  the string of the image
     */
    public String processImage(String vertex1, String vertex2)
    {
        String result = "";
        result = vertex1.substring(0,3)+vertex2.substring(0,3)+".jpg";
        return result;
    }

    /**
     * Returns the ticket to the remaining deck from the issued deck
     * 
     * @param The ticket to be returned to the deck
     * @return True if the ticket is returned
     */
    public boolean returnTic(DestinationTicket ticket)
    {

        if(ticket == null) 
        {
            return false;
        }

        if(!issued.contains(ticket)) 
        {
            return false;
        }
        remaining.add(ticket);
        issued.remove(ticket);
        
        return true;
    }

    /**
     * Shuffles the deck of remaining cards
     * 
     * @return The new array of shuffled cards
     */
    public ArrayList<DestinationTicket> shuffle()
    {
        Collections.shuffle(remaining);
        return remaining;
    }
}

