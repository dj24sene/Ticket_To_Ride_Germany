import java.util.ArrayList;
/**
 * Helps manage the meeples located at different cities
 *
 * @author Abdul Samad, Brianna Davis, Zach Giannuzzi, 
 * Dan Senecal, Eric Sauer
 * @version 4/30/2018
 */
public class ManageMeeples
{
    protected ArrayList<MeeplesColor> danemark;
    protected ArrayList<MeeplesColor> niederlande;
    protected ArrayList<MeeplesColor> frankreich;
    protected ArrayList<MeeplesColor> schweiz;
    protected ArrayList<MeeplesColor> osterreich;
    protected ArrayList<MeeplesColor> kiel;
    protected ArrayList<MeeplesColor> rostock;
    protected ArrayList<MeeplesColor> emden;
    protected ArrayList<MeeplesColor> bremerhaven;
    protected ArrayList<MeeplesColor> schwerin;
    protected ArrayList<MeeplesColor> hamburg;
    protected ArrayList<MeeplesColor> bremen;
    protected ArrayList<MeeplesColor> hannover;
    protected ArrayList<MeeplesColor> berlin;
    protected ArrayList<MeeplesColor> munster;
    protected ArrayList<MeeplesColor> magdeburg;
    protected ArrayList<MeeplesColor> dortmund;
    protected ArrayList<MeeplesColor> kassel;
    protected ArrayList<MeeplesColor> leipzig;
    protected ArrayList<MeeplesColor> dresden;
    protected ArrayList<MeeplesColor> dusseldorf;
    protected ArrayList<MeeplesColor> erfurt;
    protected ArrayList<MeeplesColor> chemnitz;
    protected ArrayList<MeeplesColor> koln;
    protected ArrayList<MeeplesColor> frakfurt;
    protected ArrayList<MeeplesColor> koblenz;
    protected ArrayList<MeeplesColor> mainz;
    protected ArrayList<MeeplesColor> wurzburg;
    protected ArrayList<MeeplesColor> nurnberg;
    protected ArrayList<MeeplesColor> mannheim;
    protected ArrayList<MeeplesColor> regensburg;
    protected ArrayList<MeeplesColor> saarbrucken;
    protected ArrayList<MeeplesColor> karlsruhe;
    protected ArrayList<MeeplesColor> stuttgart;
    protected ArrayList<MeeplesColor> augsburg;
    protected ArrayList<MeeplesColor> ulm;
    protected ArrayList<MeeplesColor> munchen;
    protected ArrayList<MeeplesColor> freiburg;
    protected ArrayList<MeeplesColor> konstanz;
    protected ArrayList<MeeplesColor> lindau;
    protected ArrayList<MeeplesColor> bag;

    /**
     * Creates a ManageMeeples object
     */
    public ManageMeeples(){
        bag = new ArrayList<MeeplesColor>();
        for (int i =0; i < 10; i++)
        {
            bag.add(MeeplesColor.RED);
            bag.add(MeeplesColor.GREEN);
            bag.add(MeeplesColor.YELLOW);
            bag.add(MeeplesColor.BLACK);
            bag.add(MeeplesColor.BLUE);
            bag.add(MeeplesColor.WHITE);
        }
        
        danemark = createArray(Vertices.DANEMARK);
        niederlande = createArray(Vertices.NIEDERLANDE);
        frankreich = createArray(Vertices.FRANKREICH);
        schweiz = createArray(Vertices.SCHWEIZ);
        osterreich = createArray(Vertices.OSTERREICH);
        kiel = createArray(Vertices.KIEL);
        rostock = createArray(Vertices.ROSTOCK);
        emden = createArray(Vertices.EMDEN);
        bremerhaven = createArray(Vertices.BREMERHAVEN);
        schwerin = createArray(Vertices.SCHWERIN);
        hamburg = createArray(Vertices.HAMBURG);
        bremen = createArray(Vertices.BREMEN);
        hannover = createArray(Vertices.HANNOVER);
        berlin = createArray(Vertices.BERLIN);
        munster = createArray(Vertices.MUNSTER);
        magdeburg = createArray(Vertices.MAGDEBURG);
        dortmund = createArray(Vertices.DORTMUND);
        kassel = createArray(Vertices.KASSEL);
        leipzig = createArray(Vertices.LEIPZIG);
        dresden = createArray(Vertices.DRESDEN);
        dusseldorf = createArray(Vertices.DUSSELDORF);
        erfurt = createArray(Vertices.ERFURT);
        chemnitz = createArray(Vertices.CHEMNITZ);
        koln = createArray(Vertices.KOLN);
        frakfurt = createArray(Vertices.FRAKFURT);
        koblenz = createArray(Vertices.KOBLENZ);
        mainz = createArray(Vertices.MAINZ);
        wurzburg = createArray(Vertices.WURZBURG);
        nurnberg = createArray(Vertices.NURNBERG);
        mannheim = createArray(Vertices.MANNHEIM);
        regensburg = createArray(Vertices.REGENSBURG);
        saarbrucken = createArray(Vertices.SAARBRUCKEN);
        karlsruhe = createArray(Vertices.KARLSRUHE);
        stuttgart = createArray(Vertices.STUTTGART);
        augsburg = createArray(Vertices.AUGSBURG);
        ulm = createArray(Vertices.ULM);
        munchen = createArray(Vertices.MUNCHEN);
        freiburg = createArray(Vertices.FREIBURG);
        konstanz = createArray(Vertices.KONSTANZ);
        lindau = createArray(Vertices.LINDAU);
    }
    
    /**
     * Creates an array of meeples drawn from the bag
     * 
     * @param The vertex to create the array of meeples from
     * @return the created arrray of Meeples
     */
    public ArrayList<MeeplesColor> createArray(Vertices v){
        ArrayList<MeeplesColor> arr = new ArrayList<MeeplesColor>();
        for (int i = 0; i < v.getNumMeeples(); i++){
            arr.add(drawMeeple());
        }
        return arr;
    }
    
    /**
     *Draws meeples from the meeple bag
     *
     *@return the removed meeple
     */
    public MeeplesColor drawMeeple()
    {
        int ticIndex = (int) Math.floor(Math.random()*bag.size());
        MeeplesColor removed  = bag.remove(ticIndex);
        return removed;
    } 
    
    /**
     * If the array at a vertex contains a meeple of the color 
     * selected then it is removed.
     * 
     * @param V is the vertice to remove the meeple from
     * @param the color of the meeple to be removed
     * @return True if the meeple is removed and false otherwise
     */
    public boolean remove(Vertices v, MeeplesColor color){
        ArrayList<MeeplesColor> arr = getArray(v);
        if(arr.contains(color)){
            arr.remove(color);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Gets the array of meeples on a given vertex
     * 
     * @param V the vertex the get the array from
     * @return An array list of the meeples
     */
    public ArrayList<MeeplesColor> getArray(Vertices v){
        if (v.toString().toLowerCase().equals("danemark")){
            return danemark;
        }
        else if (v.toString().toLowerCase().equals("niederlande")){
            return niederlande;
        }
        else if (v.toString().toLowerCase().equals("frankreich")){
            return frankreich;
        }
        else if (v.toString().toLowerCase().equals("schweiz")){
            return schweiz;
        }
        else if (v.toString().toLowerCase().equals("osterreich")){
            return osterreich;
        }
        else if (v.toString().toLowerCase().equals("kiel")){
            return kiel;
        }
        else if (v.toString().toLowerCase().equals("rostock")){
            return rostock;
        }
        else if (v.toString().toLowerCase().equals("emden")){
            return emden;
        }
        else if (v.toString().toLowerCase().equals("bremerhaven")){
            return bremerhaven;
        }
        else if (v.toString().toLowerCase().equals("schwerin")){
            return schwerin;
        }
        else if (v.toString().toLowerCase().equals("hamburg")){
            return hamburg;
        }
        else if (v.toString().toLowerCase().equals("bremen")){
            return bremen;
        }
        else if (v.toString().toLowerCase().equals("hannover")){
            return hannover;
        }
        else if (v.toString().toLowerCase().equals("berlin")){
            return berlin;
        }
        else if (v.toString().toLowerCase().equals("munster")){
            return munster;
        }
        else if (v.toString().toLowerCase().equals("magdeburg")){
            return magdeburg;
        }
        else if (v.toString().toLowerCase().equals("dortmund")){
            return dortmund;
        }
        else if (v.toString().toLowerCase().equals("kassel")){
            return kassel;
        }
        else if (v.toString().toLowerCase().equals("leipzig")){
            return leipzig;
        }
        else if (v.toString().toLowerCase().equals("dresden")){
            return dresden;
        }
        else if (v.toString().toLowerCase().equals("dusseldorf")){
            return dusseldorf;
        }
        else if (v.toString().toLowerCase().equals("erfurt")){
            return erfurt;
        }
        else if (v.toString().toLowerCase().equals("chemnitz")){
            return chemnitz;
        }
        else if (v.toString().toLowerCase().equals("koln")){
            return koln;
        }
        else if (v.toString().toLowerCase().equals("frakfurt")){
            return frakfurt;
        }
        else if (v.toString().toLowerCase().equals("koblenz")){
            return koblenz;
        }
        else if (v.toString().toLowerCase().equals("mainz")){
            return mainz;
        }
        else if (v.toString().toLowerCase().equals("wurzburg")){
            return wurzburg;
        }
        else if (v.toString().toLowerCase().equals("nurnberg")){
            return nurnberg;
        }
        else if (v.toString().toLowerCase().equals("mannheim")){
            return mannheim;
        }
        else if (v.toString().toLowerCase().equals("regensburg")){
            return regensburg;
        }
        else if (v.toString().toLowerCase().equals("saarbrucken")){
            return saarbrucken;
        }
        else if (v.toString().toLowerCase().equals("karlsruhe")){
            return karlsruhe;
        }
        else if (v.toString().toLowerCase().equals("stuttgart")){
            return stuttgart;
        }
        else if (v.toString().toLowerCase().equals("augsburg")){
            return augsburg;
        }
        else if (v.toString().toLowerCase().equals("ulm")){
            return ulm;
        }
        else if (v.toString().toLowerCase().equals("munchen")){
            return munchen;
        }
        else if (v.toString().toLowerCase().equals("freiburg")){
            return freiburg;
        }
        else if (v.toString().toLowerCase().equals("konstanz")){
            return konstanz;
        }
        else if (v.toString().toLowerCase().equals("lindau")){
            return lindau;
        }
        else{
            return null;
        }
        
    }
}
