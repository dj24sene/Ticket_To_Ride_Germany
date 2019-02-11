import java.awt.*;
/**
 * Represents a Destination Ticket
 *
 * @author Abdul Samad, Brianna Davis, Zach Giannuzzi, 
 * Dan Senecal, Eric Sauer
 * @version 4/30/2018
 */
public class DestinationTicket {

    /* To and from, order not important */
    protected Vertices start;
    protected Vertices end;
    protected int points;
    protected Image img;
    protected Toolkit toolkit;

    /**
     * Constructs a DestinationTicket object
     * 
     * @param The from vertex on the destination ticket
     * @param The ending vertex
     */
    public DestinationTicket(Vertices from, Vertices to){
        start = from;
        end = to;
    }

    /**
     * Constructor for a DestinationTicket object
     * 
     * @param The from vertex on the destination ticket
     * @param The ending vertex
     * @param The points on the path
     */
    public DestinationTicket(Vertices from, Vertices to, int points){
        start = from;
        end = to;
        this.points = points;
        //Need to make sure order is alphabetical
        toolkit = Toolkit.getDefaultToolkit();
        String newFrom = "";
        String newTo = "";
        if (from.toString().length() >= 4){
            newFrom = from.toString().toLowerCase().substring(0,4);
        }
        else {
            newFrom = from.toString();
        }
        if (to.toString().length() >= 4){
            newTo = to.toString().toLowerCase().substring(0,4);
        }
        else {
            newTo = to.toString();
        }
        img = toolkit.getImage
        ("." + "/DestinationTics/" + newFrom + newTo + ".JPG");
    }

    /**
     * Checks if the from and to vertices are the same
     * 
     * @param From the starting vertex
     * @param to the ending vertex
     * @return True if they are equal and false if they are not
     */
    public boolean equals(Vertices from, Vertices to){
        return equals(new DestinationTicket(from,to));
    }

    /**
     * Checks if two destination tickets have 
     * the same start vertices or end vertices
     * 
     * @param the Destination ticket to check the vertices of
     * @return true if and of the vertices are the same
     */
    public boolean equals(DestinationTicket dt){
        return (this.start == dt.start && this.end == dt.end) ||
        (this.start == dt.end && this.start == dt.end);
    }

    /**
     * Gets the starting vertex
     * 
     * @return the starting vertex
     */
    public Vertices getStartingPoint()
    {
        return start;
    }

     /**
     * Gets the ending vertex
     * 
     * @return the ending vertex
     */
    public Vertices getEndingPoint()
    {
        return end;
    }

    /**
     * Gets the number of points
     * 
     * @returns the number of points
     */
    public int getPoints()
    {
        return points;
    }

    /**
     * Gets the image object
     * 
     * @return an Image
     */
    public Image getImage()
    {
        return img;
    }

}