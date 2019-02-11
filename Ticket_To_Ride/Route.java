/**
 * Represents a Route
 *
 * @author Abdul Samad, Brianna Davis, Zach Giannuzzi, 
 * Dan Senecal, Eric Sauer
 * @version 4/30/2018
 */
public class Route {
    // The two Vertices
    private Vertices vertex1;
    private Vertices vertex2;
    //numbers of trains on this route
    private int train = 0;
    // color of card required for this route, for gray 
    //this will be assigned to Color locomotive
    private TrainCardsColor color;
    /**
     * Constructs an object that keeps track of the first vertex, second vertex
     * number of trains, and the color of traincards.
     * 
     * @param dest1 the first vertex.
     * @param dest2 the second vertex.
     * @param trains, the number of trains for route.
     * @param color the color of trains for the route.
     */
        
    public Route(Vertices dest1, Vertices dest2, int trains, 
    TrainCardsColor color){
        /* Initialize everything */
        vertex1 = dest1;
        vertex2 = dest2;
        train = trains;
        this.color = color;
    }

    /**
     * Returns how many points this route is worth if claimed
     * 
     * @return how many points the route is worth if claimed.
     * */
    public int getRoutePoints(){
        int points =0;
        if(train == 1 || train == 2) 
        {
            points = train;
        }
        if(train == 3)
        {
            points= 4;
        }
        if(train == 4)
        {
            points = 7;
        }
        if(train == 5) 
        {
            points = 10;
        }
        if(train == 6) 
        {
            points = 15;
        }
        if(train == 7) 
        {
            points = 18;
        }
        return points;
    }

    /**
     * Returns the first vertex
     * 
     * @return the first Vertex
     * */
    public Vertices getVertex1(){
        return this.vertex1;
    }
    
    /**
     * Returns the second vertex
     * 
     * @return the second Vertex
     * 
     */
    public Vertices getVertex2(){
        return this.vertex2;
    }

    /**
     * Returns number of trains
     * 
     * @return the number of trains
     * 
     */
    public int getNumTrains(){
        return this.train;
    }
    
    /**
     * Returns color of train card.
     * 
     * @return the color of the train card.
     * 
     */
    public TrainCardsColor getColor(){
        return this.color;
    }
    
    /**
     * Returns A string the color of the train card 
     * and the amount player has
     * 
     * @return A string the color of the train card 
     * and the amount player has 
     * 
     */
    public String toString(){
        String result = this.color + " x" + getNumTrains();
        return result;
    }
   
}