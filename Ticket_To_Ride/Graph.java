
import java.util.ArrayList;
/**
 * Represents the Ticket to Ride Graph
 *
 * @author Abdul Samad, Brianna Davis, Zach Giannuzzi, 
 * Dan Senecal, Eric Sauer
 * @version 4/30/2018
 */
public class Graph
{
    protected ArrayList<Route> route; //all available routes to claim

    /**
     * Constucts a graph object
     */
    public Graph(){
        route = new ArrayList<Route>();
        createGraph();
    }

    /**
     * If the route does not exist already it is added
     * 
     * @param r The route to be added
     */
    public void addRoute(Route r){
        if (!contains(r)){
            route.add(r);
        }
    }
    
    /**
     * Removes the the specified route
     * 
     * @param The route to be removed
     */
    public void removeRoute(Route r){
        for (int i = 0; i < route.size(); i++){
            Route temp = route.get(i);
            if (temp.getVertex1() == r.getVertex1() && 
            temp.getVertex2() == r.getVertex2() &&
                temp.getColor() == r.getColor()){
                route.remove(i);
            }
        }
    }

    /**
     * Gets the routes between two cities
     * 
     * @param The starting city
     * @param The ending city
     * @return an arraylist of the routes between the cities
     */
    public ArrayList<Route> getRoutes(Vertices city1, Vertices city2){
        ArrayList<Route> routes = new ArrayList<Route>();
        for (Route r : route){
            if ( (r.getVertex1() == city1 && r.getVertex2() == city2) ||
                (r.getVertex1() == city2 && r.getVertex2() == city1) ){
                routes.add(r);
            }
        }
        return routes;
    }
    
    /**
     * Checks if the route is contained.
     * 
     * @param the route to check for
     * @return true if the route is contained, false otherwise
     */
    public boolean contains(Route r){
        for (int i = 0; i < route.size(); i++){
            Route temp = route.get(i);
            if (temp.getVertex1() == r.getVertex1() && temp.getVertex2()
            == r.getVertex2()
                && temp.getColor() == r.getColor()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets the coordinates of two vertices
     * 
     * @param The coordinates of the first city
     * @param The coordinates of the second city
     * @return an int array of the coordinates
     */
    public int[] getCoords(Vertices v, Vertices v2){
        int[] coords = new int[2];
        if (v == Vertices.EMDEN){
            coords[0] = 114;
            coords[1] = 209;
        }
        else if (v == Vertices.BREMEN){
            coords[0] = 245;
            coords[1] = 242;
        }
        else if (v == Vertices.BREMERHAVEN){
            coords[0] = 239;
            coords[1] = 193;
        }
        else if (v == Vertices.KIEL){
            coords[0] = 350;
            coords[1] = 112;
        }
        else if (v == Vertices.MUNSTER){
            coords[0] = 155;
            coords[1] = 351;
        }
        else if (v == Vertices.DORTMUND){
            coords[0] = 140;
            coords[1] = 407;
        }
        else if (v == Vertices.DUSSELDORF){
            coords[0] = 79;
            coords[1] = 427;
        }
        else if (v == Vertices.KOLN){
            coords[0] = 76;
            coords[1] = 485;
        }
        else if (v == Vertices.KOBLENZ){
            coords[0] = 91;
            coords[1] = 543;
        }
        else if (v == Vertices.MAINZ){
            coords[0] = 178;
            coords[1] = 591;
        }
        else if (v == Vertices.SAARBRUCKEN){
            coords[0] = 63;
            coords[1] = 653;
        }
        else if (v == Vertices.KARLSRUHE){
            coords[0] = 202;
            coords[1] = 693;
        }
        else if (v == Vertices.MANNHEIM){
            coords[0] = 206;
            coords[1] = 640;
        }
        else if (v == Vertices.FRAKFURT){
            coords[0] = 235;
            coords[1] = 557;
        }
        else if (v == Vertices.WURZBURG){
            coords[0] = 336;
            coords[1] = 591;
        }
        else if (v == Vertices.STUTTGART){
            coords[0] = 269;
            coords[1] = 705;
        }
        else if (v == Vertices.KONSTANZ){
            coords[0] = 266;
            coords[1] = 824;
        }
        else if (v == Vertices.LINDAU){
            coords[0] = 327;
            coords[1] = 832;
        }
        else if (v == Vertices.ULM){
            coords[0] = 356;
            coords[1] = 748;
        }
        else if (v == Vertices.AUGSBURG){
            coords[0] = 422;
            coords[1] = 755;
        }
        else if (v == Vertices.MUNCHEN){
            coords[0] = 523;
            coords[1] = 774;
        }
        else if (v == Vertices.REGENSBURG){
            coords[0] = 572;
            coords[1] = 677;
        }
        else if (v == Vertices.NURNBERG){
            coords[0] = 439;
            coords[1] = 615;
        }
        else if (v == Vertices.DRESDEN){
            coords[0] = 682;
            coords[1] = 463;
        }
        else if (v == Vertices.CHEMNITZ){
            coords[0] = 619;
            coords[1] = 487;
        }
        else if (v == Vertices.LEIPZIG){
            coords[0] = 547;
            coords[1] = 424;
        }
        else if (v == Vertices.BERLIN){
            coords[0] = 631;
            coords[1] = 297;
        }
        else if (v == Vertices.ROSTOCK){
            coords[0] = 531;
            coords[1] = 113;
        }
        else if (v == Vertices.SCHWERIN){
            coords[0] = 468;
            coords[1] = 184;
        }
        else if (v == Vertices.HANNOVER){
            coords[0] = 325;
            coords[1] = 329;
        }
        else if (v == Vertices.HAMBURG){
            coords[0] = 371;
            coords[1] = 192;
        }
        else if (v == Vertices.MAGDEBURG){
            coords[0] = 507;
            coords[1] = 350;
        }
        else if (v == Vertices.ERFURT){
            coords[0] = 436;
            coords[1] = 476;
        }
        else if (v == Vertices.KASSEL){
            coords[0] = 311;
            coords[1] = 438;
        }
        else if (v == Vertices.FREIBURG){
            coords[0] = 162;
            coords[1] = 798;
        }
        else if (v == Vertices.DANEMARK){
            coords[0] = 316;
            coords[1] = 37;
        }
        else if (v == Vertices.NIEDERLANDE && v2 == Vertices.EMDEN){
            coords[0] = 45;
            coords[1] = 271;
        }
        else if (v == Vertices.NIEDERLANDE && v2 == Vertices.MUNSTER){
            coords[0] = 59;
            coords[1] = 321;
        }
        else if (v == Vertices.NIEDERLANDE && v2 == Vertices.DUSSELDORF){
            coords[0] = 33;
            coords[1] = 324;
        }
        else if (v == Vertices.FRANKREICH && v2 == Vertices.SAARBRUCKEN){
            coords[0] = 49;
            coords[1] = 705;
        }
        else if (v == Vertices.FRANKREICH && v2 == Vertices.KARLSRUHE){
            coords[0] = 107;
            coords[1] = 739;
        }
        else if (v == Vertices.FRANKREICH && v2 == Vertices.FREIBURG){
            coords[0] = 60;
            coords[1] = 782;
        }
        else if (v == Vertices.SCHWEIZ && v2 == Vertices.FREIBURG){
            coords[0] = 172;
            coords[1] = 871;
        }
        else if (v == Vertices.SCHWEIZ && v2 == Vertices.KONSTANZ){
            coords[0] = 216;
            coords[1] = 853;
        }
        else if (v == Vertices.SCHWEIZ && v2 == Vertices.LINDAU){
            coords[0] = 240;
            coords[1] = 868;
        }
        else if (v == Vertices.OSTERREICH && v2 == Vertices.LINDAU){
            coords[0] = 424;
            coords[1] = 860;
        }
        else if (v == Vertices.OSTERREICH && v2 == Vertices.MUNCHEN){
            coords[0] = 626;
            coords[1] = 853;
        }
        else if (v == Vertices.OSTERREICH && v2 == Vertices.REGENSBURG){
            coords[0] = 680;
            coords[1] = 793;
        }
        
        return coords;
    }

    /**
     * Creates the graph of all of the vertices and their card
     */
    public void createGraph(){
        //start and end vertices ordered alphabetically
        route.add(new Route
        (Vertices.BREMEN,Vertices.EMDEN,3,TrainCardsColor.BLUE));
        route.add(new Route
        (Vertices.EMDEN,Vertices.MUNSTER,4,TrainCardsColor.RED));
        route.add(new Route
        (Vertices.EMDEN,Vertices.NIEDERLANDE,2,TrainCardsColor.WHITE));
        route.add(new Route
        (Vertices.DUSSELDORF,Vertices.NIEDERLANDE,3,TrainCardsColor.PINK));
        route.add(new Route
        (Vertices.BREMEN,Vertices.MUNSTER,3,TrainCardsColor.BLACK));
        route.add(new Route
        (Vertices.BREMEN,Vertices.HANNOVER,3,TrainCardsColor.YELLOW));
        route.add(new Route
        (Vertices.BREMEN,Vertices.BREMERHAVEN,1,TrainCardsColor.WHITE));
        route.add(new Route
        (Vertices.BREMEN,Vertices.HAMBURG,3,TrainCardsColor.ORANGE));
        route.add(new Route
        (Vertices.DORTMUND,Vertices.DUSSELDORF,1,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.DORTMUND,Vertices.KASSEL,4,TrainCardsColor.GREEN));
        route.add(new Route
        (Vertices.DUSSELDORF,Vertices.KOLN,1,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.KOBLENZ,Vertices.KOLN,1,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.KOBLENZ,Vertices.MAINZ,2,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.KOBLENZ,Vertices.SAARBRUCKEN,3,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.MAINZ,Vertices.SAARBRUCKEN,3,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.MAINZ,Vertices.MANNHEIM,1,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.KARLSRUHE,Vertices.MANNHEIM,1,TrainCardsColor.BLUE));
        route.add(new Route
        (Vertices.MANNHEIM,Vertices.STUTTGART,2,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.FRAKFURT,Vertices.MANNHEIM,2,TrainCardsColor.GRAY));
        route.add(new Route       
        (Vertices.FRANKREICH,Vertices.SAARBRUCKEN,1,TrainCardsColor.GREEN));
        route.add(new Route
        (Vertices.FRANKREICH,Vertices.FREIBURG,2,TrainCardsColor.YELLOW));
        route.add(new Route
        (Vertices.FRANKREICH,Vertices.KARLSRUHE,2,TrainCardsColor.BLACK));
        route.add(new Route
        (Vertices.FREIBURG,Vertices.SCHWEIZ,2,TrainCardsColor.ORANGE));
        route.add(new Route
        (Vertices.FREIBURG,Vertices.KONSTANZ,2,TrainCardsColor.BLACK));
        route.add(new Route
        (Vertices.KONSTANZ,Vertices.SCHWEIZ,1,TrainCardsColor.WHITE));
        route.add(new Route
        (Vertices.LINDAU,Vertices.SCHWEIZ,2,TrainCardsColor.BLUE));
        route.add(new Route
        (Vertices.KONSTANZ,Vertices.LINDAU,1,TrainCardsColor.YELLOW));
        route.add(new Route
        (Vertices.KARLSRUHE,Vertices.SAARBRUCKEN,3,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.MANNHEIM,Vertices.SAARBRUCKEN,3,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.FREIBURG,Vertices.KARLSRUHE,3,TrainCardsColor.WHITE));
        route.add(new Route
        (Vertices.KARLSRUHE,Vertices.STUTTGART,1,TrainCardsColor.PINK));
        route.add(new Route
        (Vertices.FREIBURG,Vertices.STUTTGART,3,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.KONSTANZ,Vertices.STUTTGART,3,TrainCardsColor.GREEN));
        route.add(new Route
        (Vertices.STUTTGART,Vertices.ULM,2,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.DORTMUND,Vertices.MUNSTER,1,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.MUNSTER,Vertices.NIEDERLANDE,2,TrainCardsColor.ORANGE));
        route.add(new Route
        (Vertices.BREMERHAVEN,Vertices.EMDEN,3,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.LINDAU,Vertices.OSTERREICH,2,TrainCardsColor.PINK));
        route.add(new Route
        (Vertices.LINDAU,Vertices.MUNCHEN,5,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.LINDAU,Vertices.ULM,2,TrainCardsColor.RED));
        route.add(new Route
        (Vertices.AUGSBURG,Vertices.ULM,1,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.AUGSBURG,Vertices.MUNCHEN,2,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.AUGSBURG,Vertices.NURNBERG,4,TrainCardsColor.ORANGE));
        route.add(new Route
        (Vertices.MUNCHEN,Vertices.NURNBERG,5,TrainCardsColor.BLUE));
        route.add(new Route
        (Vertices.MUNCHEN,Vertices.NURNBERG,5,TrainCardsColor.BLACK));
        route.add(new Route
        (Vertices.MUNCHEN,Vertices.OSTERREICH,3,TrainCardsColor.RED));
        route.add(new Route
        (Vertices.MUNCHEN,Vertices.REGENSBURG,3,TrainCardsColor.ORANGE));
        route.add(new Route
        (Vertices.OSTERREICH,Vertices.REGENSBURG,4,TrainCardsColor.YELLOW));
        route.add(new Route
        (Vertices.NURNBERG,Vertices.REGENSBURG,3,TrainCardsColor.GREEN));
        route.add(new Route
        (Vertices.DRESDEN,Vertices.REGENSBURG,7,TrainCardsColor.RED));
        route.add(new Route
        (Vertices.CHEMNITZ,Vertices.REGENSBURG,6,TrainCardsColor.PINK));
        route.add(new Route
        (Vertices.ERFURT,Vertices.NURNBERG,4,TrainCardsColor.YELLOW));
        route.add(new Route
        (Vertices.ERFURT,Vertices.NURNBERG,4,TrainCardsColor.PINK));
        route.add(new Route
        (Vertices.ERFURT,Vertices.REGENSBURG,7,TrainCardsColor.WHITE));
        route.add(new Route
        (Vertices.CHEMNITZ,Vertices.DRESDEN,1,TrainCardsColor.YELLOW));
        route.add(new Route
        (Vertices.CHEMNITZ,Vertices.ERFURT,4,TrainCardsColor.BLACK));
        route.add(new Route
        (Vertices.NURNBERG,Vertices.WURZBURG,2,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.FRAKFURT,Vertices.WURZBURG,2,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.FRAKFURT,Vertices.MAINZ,1,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.FRAKFURT,Vertices.KOLN,4,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.FRAKFURT,Vertices.KASSEL,4,TrainCardsColor.BLUE));
        route.add(new Route
        (Vertices.FRAKFURT,Vertices.KASSEL,4,TrainCardsColor.WHITE));
        route.add(new Route
        (Vertices.ERFURT,Vertices.KASSEL,3,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.CHEMNITZ,Vertices.LEIPZIG,2,TrainCardsColor.BLUE));
        route.add(new Route
        (Vertices.DRESDEN,Vertices.LEIPZIG,3,TrainCardsColor.BLACK));
        route.add(new Route
        (Vertices.ERFURT,Vertices.LEIPZIG,3,TrainCardsColor.RED));
        route.add(new Route
        (Vertices.LEIPZIG,Vertices.MAGDEBURG,2,TrainCardsColor.YELLOW));
        route.add(new Route
        (Vertices.BERLIN,Vertices.LEIPZIG,4,TrainCardsColor.ORANGE));
        route.add(new Route
        (Vertices.BERLIN,Vertices.DRESDEN,5,TrainCardsColor.GREEN));
        route.add(new Route
        (Vertices.BERLIN,Vertices.MAGDEBURG,3,TrainCardsColor.RED));
        route.add(new Route
        (Vertices.HANNOVER,Vertices.MAGDEBURG,4,TrainCardsColor.BLUE));
        route.add(new Route
        (Vertices.BERLIN,Vertices.HANNOVER,7,TrainCardsColor.BLACK));
        route.add(new Route
        (Vertices.ERFURT,Vertices.HANNOVER,5,TrainCardsColor.ORANGE));
        route.add(new Route
        (Vertices.ERFURT,Vertices.HANNOVER,5,TrainCardsColor.GREEN));
        route.add(new Route
        (Vertices.HANNOVER,Vertices.KASSEL,3,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.HANNOVER,Vertices.MUNSTER,4,TrainCardsColor.PINK));
        route.add(new Route
        (Vertices.HAMBURG,Vertices.HANNOVER,4,TrainCardsColor.RED));
        route.add(new Route
        (Vertices.HAMBURG,Vertices.HANNOVER,4,TrainCardsColor.WHITE));
        route.add(new Route
        (Vertices.BERLIN,Vertices.HAMBURG,7,TrainCardsColor.YELLOW));
        route.add(new Route
        (Vertices.BERLIN,Vertices.HAMBURG,7,TrainCardsColor.BLUE));
        route.add(new Route
        (Vertices.BERLIN,Vertices.SCHWERIN,5,TrainCardsColor.WHITE));
        route.add(new Route
        (Vertices.HAMBURG,Vertices.SCHWERIN,2,TrainCardsColor.GREEN));
        route.add(new Route
        (Vertices.HAMBURG,Vertices.KIEL,2,TrainCardsColor.BLACK));
        route.add(new Route
        (Vertices.HAMBURG,Vertices.KIEL,2,TrainCardsColor.PINK));
        route.add(new Route
        (Vertices.BREMERHAVEN,Vertices.HAMBURG,3,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.BREMERHAVEN,Vertices.KIEL,3,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.BERLIN,Vertices.ROSTOCK,6,TrainCardsColor.PINK));
        route.add(new Route
        (Vertices.KIEL,Vertices.ROSTOCK,4,TrainCardsColor.ORANGE));
        route.add(new Route
        (Vertices.KIEL,Vertices.SCHWERIN,3,TrainCardsColor.YELLOW));
        route.add(new Route
        (Vertices.DANEMARK,Vertices.KIEL,2,TrainCardsColor.GRAY));
        route.add(new Route
        (Vertices.BREMERHAVEN,Vertices.DANEMARK,5,TrainCardsColor.GREEN));
        route.add(new Route
        (Vertices.ROSTOCK,Vertices.SCHWERIN,2,TrainCardsColor.RED));
    }
}