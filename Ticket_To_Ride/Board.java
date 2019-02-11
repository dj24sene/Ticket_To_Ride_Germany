import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.sound.sampled.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;
/**
 * Represents the Ticket To Ride Board
 *
 * @author Abdul Samad, Brianna Davis, Zach Giannuzzi, 
 * Dan Senecal, Eric Sauer
 * @version 4/30/2018
 */
public class Board extends JPanel implements MouseListener
{
   
    private Image board,redPlayer,intro,card, infoG, globetrotter;
    private Image background,greenPlayer,turn1,redtrain, purpletrain;
    private Image blacktrain,turn2,greentrain, orangetrain,whitetrain,endPic;
    private Image bluetrain,yellowtrain, locomotive,trainDeck,destDeck,bpic;
    private Toolkit toolkit;
    private int width,height,drawn, selected, lastTurn, counter,x, needsG;
    private int score1, score2, pic;
    private String player1, player2;
    private TCDeck deck;
    private DTDeck ticDeck;
    private Player playerOne, playerTwo;
    private Color color;
    private boolean player1Turn, checkCards, checkCards2;
    private Image intro1, intro2;
    protected static boolean beginning,end, destination, start, enabled;
    protected int[] city1Coords;
    protected final int OFF = 29;
    protected Graph map;
    protected boolean drewCard,endDeck, picked, picked2, picked3, picked4;
    protected ArrayList<DestinationTicket> temp;
    protected ManageMeeples meeples;
    
    /**
     * Constructs a Board object with decks, players, meeples, 
     * and all routes
     */
    public Board(){
        drewCard = false;
        endDeck = false;
        destination = false;
        setPreferredSize(new Dimension(1100,930));
        toolkit = Toolkit.getDefaultToolkit();
        background = toolkit.getImage("background1.png");
        endPic= toolkit.getImage("end1.jpg");
        color = new Color(128,128,128,127);
        intro1 = toolkit.getImage("."+"/PicturesLayout/"+"intro1.jpeg");
        intro2 = toolkit.getImage("."+"/PicturesLayout/"+"intro2.jpeg");
        turn1 = toolkit.getImage("." + "/trainCards/" + "turn1.jpg");
        turn2 = toolkit.getImage("." + "/trainCards/" + "turn2.jpg");
        bpic = toolkit.getImage("."+"/PicturesLayout/"+"buttons.jpg");
        infoG = toolkit.getImage("infoG.png");
        playerOne  = new Player(player1,"green");
        playerTwo  = new Player(player2,"red");
        drawn = 0;
        selected = 0;
        score1 = 0;
        score2 = 0;
        map = new Graph();
        city1Coords = new int[2];
        player1Turn = true;
        enabled = true;
        deck = new TCDeck();
        ticDeck = new DTDeck();
        for(int i = 0; i < 4;i++){
            playerOne.hand.add(deck.drawCard());
            playerTwo.hand.add(deck.drawCard());

        }
        counter =0;
        lastTurn =0;
        addMouseListener(this);
        beginning = true;
        start = false;
        end = false;
        int x = 0;
        needsG= 2;
        meeples = new ManageMeeples();
        intro = toolkit.getImage("."+"/PicturesLayout/"+"background.png");
        temp = new ArrayList<DestinationTicket>();
        pic = 0;
        checkCards = false;
        checkCards2 = false;
        picked = false;
        picked2 = false;
        picked3 = false;
        picked4 = false;
    }
    
    // All mouseEvent listeners.
    public void mouseEntered( MouseEvent e ) { }

    public void mouseExited( MouseEvent e ) { }

    public void mousePressed( MouseEvent e ) { }

    public void mouseReleased( MouseEvent e ) { }

    /**
     * Changes objects based on where the player clicks
     * 
     * @ e MouseEvent that gets the needed x and y information
     */
    public void mouseClicked( MouseEvent e ) {
        if ((destination == true && player1Turn == true) ||
        (start && player1Turn)){
            if(e.getX() >= 15 && e.getX() <= 165 &&
            e.getY() >= 50 && e.getY() <= 250){
                picked = true;
                temp.add(ticDeck.pick.get(0));
                repaint();
            }
            if(e.getX() >= 15 && e.getX() <= 165 &&
            e.getY() >= 280 && e.getY() <= 480){
                picked = false;
                temp.remove(ticDeck.pick.get(0));
                repaint();
            }

            if(e.getX() >= 190 && e.getX() <= 340 && 
            e.getY() >= 50 && e.getY() <= 250){
                picked2 = true;
                temp.add(ticDeck.pick.get(1));
                repaint();
            }
            if(e.getX() >= 190 && e.getX() <= 340 && 
            e.getY() >= 280 && e.getY() <= 480){
                picked2 = false;
                temp.remove(ticDeck.pick.get(1));
                repaint();
            }

            if(e.getX() >= 365 && e.getX() <= 520 && 
            e.getY() >= 50 && e.getY() <= 250){
                picked3 = true;
                temp.add(ticDeck.pick.get(2));
                repaint();
            }
            if(e.getX() >= 365 && e.getX() <= 520 && 
            e.getY() >= 280 && e.getY() <= 480){
                picked3 = false;
                temp.remove(ticDeck.pick.get(2));
                repaint();
            }

            if(e.getX() >= 540 && e.getX() <= 690 && 
            e.getY() >= 50 && e.getY() <= 250){
                picked4 = true;
                temp.add(ticDeck.pick.get(3));
                repaint();
            }
            if(e.getX() >= 540 && e.getX() <= 690 &&
            e.getY() >= 280 && e.getY() <= 480){
                picked4 = false;
                temp.remove(ticDeck.pick.get(3));
                repaint();
            }            
            if(temp.size() >= 1 && e.getX() >= 290 && 
            e.getX() <= 405 && e.getY() >= 500 && e.getY() <= 620){
                if (start && temp.size() <2){
                    JOptionPane.showMessageDialog(null, 
                    "You should at least choose 2 tickets", "Invalid",
                    JOptionPane.ERROR_MESSAGE);
                }
                else if( !start && temp.size() < 1){
                    JOptionPane.showMessageDialog(null, 
                    "You should at least choose 1 ticket", "Invalid",
                    JOptionPane.ERROR_MESSAGE);
                }
                else{
                    for(int i = 0; i < temp.size();i++){
                        playerOne.tickets.add(temp.get(i));
                        ticDeck.pick.remove(temp.get(i));
                    }
                    for(int i = 0; i < ticDeck.pick.size();i++){
                        ticDeck.returnTic(ticDeck.pick.get(i));
                    }

                    destination = false;
                    ticDeck.pick.clear();
                    temp.clear();
                    if (start){                    
                       player2 = 
                JOptionPane.showInputDialog("Player 2 enter your name");
                       picTickets(player2);
                       destination = true;
                       beginning = false;
                    }
                    else{
                        repaint();
                    }
                    changeTurn();
                }
            }            
        }
        else if((destination == true && player1Turn == false) ||
        (start && !player1Turn)){
            if(e.getX() >= 15 && e.getX() <= 165 && 
            e.getY() >= 50 && e.getY() <= 250){
                picked = true;
                temp.add(ticDeck.pick.get(0));
                repaint();
            }
            if(e.getX() >= 15 && e.getX() <= 165 &&
            e.getY() >= 280 && e.getY() <= 480){
                picked = false;
                temp.remove(ticDeck.pick.get(0));
                repaint();
            }

            if(e.getX() >= 190 && e.getX() <= 340 &&
            e.getY() >= 50 && e.getY() <= 250){
                picked2 = true;
                temp.add(ticDeck.pick.get(1));
                repaint();
            }
            if(e.getX() >= 190 && e.getX() <= 340 &&
            e.getY() >= 280 && e.getY() <= 480){
                picked2 = false;
                temp.remove(ticDeck.pick.get(1));
                repaint();
            }

            if(e.getX() >= 365 && e.getX() <= 520 &&
            e.getY() >= 50 && e.getY() <= 250){
                picked3 = true;
                temp.add(ticDeck.pick.get(2));
                repaint();
            }
            if(e.getX() >= 365 && e.getX() <= 520 &&
            e.getY() >= 280 && e.getY() <= 480){
                picked3 = false;
                temp.remove(ticDeck.pick.get(2));
                repaint();
            }

            if(e.getX() >= 540 && e.getX() <= 690 &&
            e.getY() >= 50 && e.getY() <= 250){
                picked4 = true;
                temp.add(ticDeck.pick.get(3));
                repaint();
            }
            if(e.getX() >= 540 && e.getX() <= 690 &&
            e.getY() >= 280 && e.getY() <= 480){
                picked4 = false;
                temp.remove(ticDeck.pick.get(3));
                repaint();
            }
            if( e.getX() >= 290 && e.getX() <= 405 &&
            e.getY() >= 500 && e.getY() <= 620){
                if (start && temp.size() <2){
                    JOptionPane.showMessageDialog(null, 
                    "You should at least draw 2 tickets", "Invalid",
                    JOptionPane.ERROR_MESSAGE);

                }
                else if( !start && temp.size() < 1){
                    JOptionPane.showMessageDialog(null, 
                    "You should at least draw 1 ticket", "Invalid", 
                    JOptionPane.ERROR_MESSAGE);
                }                
                else{
                    for(int i = 0; i < temp.size();i++){
                        playerTwo.tickets.add(temp.get(i));
                        //ticDeck.remaining.remove(temp.get(i));
                    }
                    for(int i = 0; i < ticDeck.pick.size();i++){
                        ticDeck.returnTic(ticDeck.pick.get(i));
                    }
                    changeTurn();
                    start = false;
                    destination = false;
                    repaint();
                }
            }
        }
        else{
            if (drawn == 1)
            {
                drewCard = true;
            }
            else 
            {
                drewCard = false;
            }
            if (deck.remaining.size() == 0)
            {
                endDeck = true;
            }
            else
            {
                endDeck = false;
            }

            if (beginning){
                if (e.getX() >= 478 && e.getX() <= 1017 &&
                e.getY() >= 128 && e.getY() <= 349){
                    intro2 = null;
                    player1 =                     
                JOptionPane.showInputDialog("Player 1 enter your name");
                    picTickets(player1);
                    destination =true;
                    repaint();
                    start = true;
                }
            }

            if( (!beginning) && (!end)){
                if (e.getX() >= 874 && e.getX() <= 902 &&
                e.getY() >= 544 && e.getY() <= 591){ //needs instructions
                    needsG++;
                    repaint();
                }
            }

            if(((playerOne.getNumTrainPieces() > 2) && 
            (playerTwo.getNumTrainPieces() > 2)) ||(lastTurn == 1) &&
            (counter < 2))
            {
                if(!checkCards && !checkCards2){
                    if (!beginning && e.getX() <= 699 &&
                    e.getY() <= 881){ //in range of map
                        if (drewCard == false){
                            selected++;
                            if (selected == 1){
                                city1Coords[0] = e.getX();
                                city1Coords[1] = e.getY();
                            }
                               
                            else if (selected == 2){ //selected two points
                              //call method for city locations
                              Route route = getSelectedRoute(city1Coords[0],
                              city1Coords[1],e.getX(),e.getY());                                
                              selected = 0;
                            }
                            repaint();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,                           
           "You cannot draw train cards and claim routes in a single turn.",
              "Invalid", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                if(player1Turn){
                    if(e.getX() >= 720 && e.getX() <= 830 && 
                    e.getY() >= 320 && e.getY() <= 388 && drawn < 2){
                        if(!endDeck && deck.view.get(0).getTrainCardColor
                        ().equals(TrainCardsColor.LOCOMOTIVE)){
                            if(drawn < 1 ){
                                playerOne.hand.add(deck.view.get(0));
                                deck.view.remove(0);
                                deck.view.add(0,deck.drawCard());
                                deck.isLegal();
                                repaint();
                                changeTurn();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,
             "You cannot draw a locomotive. Please pick a different card",
             "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            playerOne.hand.add(deck.view.get(0));
                            deck.view.remove(0);
                            if (!endDeck){
                                deck.view.add(0,deck.drawCard());
                                deck.isLegal();
                            }
                            drawn++;
                            repaint();
                        }
                    }                      
                    if(e.getX() >= 840 && e.getX() <= 944 &&
                    e.getY() >= 320 && e.getY() <= 388  && drawn < 2){
                        if(!endDeck && deck.view.get(1).getTrainCardColor
                        ().equals(TrainCardsColor.LOCOMOTIVE)){
                            if(drawn < 1){
                                playerOne.hand.add(deck.view.get(1));
                                deck.view.remove(1);
                                deck.view.add(1,deck.drawCard());
                                deck.isLegal();
                                repaint();
                                changeTurn();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, 
                "You cannot draw a locomotive. Please pick a different card",
                "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                            }                             
                        }
                        else{
                            playerOne.hand.add(deck.view.get(1));
                            deck.view.remove(1);
                            if (!endDeck){
                                deck.view.add(1,deck.drawCard());
                                deck.isLegal();
                            }
                            drawn++;
                            repaint();
                        }
                    }

                    if(e.getX() >= 958 && e.getX() <= 1061 &&
                    e.getY() >= 320 && e.getY() <= 388 && drawn < 2)
                    {
                        if(!endDeck && deck.view.get(2).getTrainCardColor
                        ().equals(TrainCardsColor.LOCOMOTIVE))
                        {
                            if(drawn < 1){
                                playerOne.hand.add(deck.view.get(2));
                                deck.view.remove(2);
                                deck.view.add(2,deck.drawCard());
                                deck.isLegal();
                                repaint();
                                changeTurn();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, 
                "You cannot draw a locomotive. Please pick a different card",
                "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                        {
                            playerOne.hand.add(deck.view.get(2));
                            deck.view.remove(2);
                            if (!endDeck){
                                deck.view.add(2,deck.drawCard());
                                deck.isLegal();
                            }
                            drawn++;
                            repaint();
                        }
                    }

                    if(e.getX() >= 790 && e.getX() <= 888 &&
                    e.getY() >= 403 && e.getY() <= 456 && drawn < 2){
                        if(!endDeck && deck.view.get(3).getTrainCardColor
                        ().equals(TrainCardsColor.LOCOMOTIVE)){
                            if(drawn < 1){
                                playerOne.hand.add(deck.view.get(3));
                                deck.view.remove(3);
                                deck.view.add(3,deck.drawCard());
                                deck.isLegal();
                                repaint();
                                changeTurn();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, 
             "You cannot draw a locomotive. Please pick a different card", 
             "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                        {
                            playerOne.hand.add(deck.view.get(3));
                            deck.view.remove(3);
                            if (!endDeck){
                                deck.view.add(3,deck.drawCard());
                                deck.isLegal();
                            }
                            drawn++;
                            repaint();
                        }
                    }

                    if(e.getX() >= 905 && e.getX() <= 1004 &&
                    e.getY() >= 403 && e.getY() <= 461 && drawn < 2){
                        if(!endDeck && deck.view.get(4).getTrainCardColor
                        ().equals(TrainCardsColor.LOCOMOTIVE)){
                            if(drawn < 1){
                                playerOne.hand.add(deck.view.get(4));
                                deck.view.remove(4);
                                deck.view.add(4,deck.drawCard());
                                deck.isLegal();
                                repaint();
                                changeTurn();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, 
              "You cannot draw a locomotive. Please pick a different card", 
              "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            playerOne.hand.add(deck.view.get(4));
                            deck.view.remove(4);
                            if (!endDeck){
                                deck.view.add(4,deck.drawCard());
                                deck.isLegal();
                            }
                            drawn++;
                            repaint();
                        }
                    }

                    if(e.getX() >= 727 && e.getX() <= 827 &&
                    e.getY() >= 532 && e.getY() <= 594 && drawn < 2)
                    {
                        if (deck.remaining.size() == 0){
                            endDeck = true;
                        }
                        else{
                            playerOne.hand.add(deck.drawCard());
                            drawn++;
                        }
                        repaint();
                    }

                    if((e.getX() >= 935 && e.getX() <= 1045 &&
                    e.getY() >= 530 && e.getY() <= 600 && drawn < 2) 
                    && (drewCard == false))
                    {
                        picTickets(player1);
                        destination = true;

                        repaint();
                    }
                    else if((e.getX() >= 935 && e.getX() <= 1045 &&
                    e.getY() >= 530 && e.getY() <= 600 && drawn < 2)
                    && (drewCard == true))
                    {                         
                        JOptionPane.showMessageDialog(null, 
      "You cannot draw train cards and destination tickets in a single turn",
      "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                    }                      
                    if(checkCards == false && e.getX() >= 903 
                    && e.getX() <= 957 && e.getY() >= 25 &&
                    e.getY() <= 45){
                        checkCards = true;
                        repaint();
                    }
                    if(checkCards == true && e.getX() >= 500 
                    && e.getX() <= 615 && e.getY() >= 750 &&
                    e.getY() <= 870)
                    {
                        checkCards = false;
                        repaint();
                    }
                    if (drawn ==2) {
                        changeTurn();
                    }
                }               
                else
                {
                    if(e.getX() >= 720 && e.getX() <= 830 
                    && e.getY() >= 320 && e.getY() <= 388 &&
                    drawn < 2){
                        if(!endDeck && 
                        deck.view.get(0).getTrainCardColor
                        ().equals(TrainCardsColor.LOCOMOTIVE)){
                            if(drawn <1 ){
                                playerTwo.hand.add(deck.view.get(0));
                                deck.view.remove(0);
                                deck.view.add(0,deck.drawCard());
                                deck.isLegal();
                                repaint();
                                changeTurn();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, 
           "You cannot draw a locomotive. Please pick a different card", 
           "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            playerTwo.hand.add(deck.view.get(0));
                            deck.view.remove(0);
                            if (!endDeck){
                                deck.view.add(0,deck.drawCard());
                                deck.isLegal();
                            }
                            drawn++;
                            repaint();
                        }
                    }
                    if(e.getX() >= 840 && e.getX() <= 944 && 
                    e.getY() >= 320 
                    && e.getY() <= 388  && drawn < 2){
                        if(!endDeck && 
                        deck.view.get(1).getTrainCardColor
                        ().equals(TrainCardsColor.LOCOMOTIVE)){
                            if(drawn < 1){
                                playerTwo.hand.add(deck.view.get(1));
                                deck.view.remove(1);
                                deck.view.add(1,deck.drawCard());
                                deck.isLegal();
                                repaint();
                                changeTurn();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, 
             "You cannot draw a locomotive. Please pick a different card", 
             "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            playerTwo.hand.add(deck.view.get(1));
                            deck.view.remove(1);
                            if (!endDeck){
                                deck.view.add(1,deck.drawCard());
                                deck.isLegal();
                            }
                            drawn++;
                            repaint();
                        }
                    }
                    if(e.getX() >= 958 && e.getX() <= 1061 &&
                    e.getY() >= 320 && e.getY() <= 388 && drawn < 2)
                    {
                        if(!endDeck && 
                        deck.view.get(2).getTrainCardColor
                        ().equals(TrainCardsColor.LOCOMOTIVE))
                        {
                            if(drawn < 1){
                                playerTwo.hand.add(deck.view.get(2));
                                deck.view.remove(2);
                                deck.view.add(2,deck.drawCard());
                                deck.isLegal();
                                repaint();                                 
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, 
               "You cannot draw a locomotive. Please pick a different card", 
               "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                        {
                            playerTwo.hand.add(deck.view.get(2));
                            deck.view.remove(2);
                            if (!endDeck){
                                deck.view.add(2,deck.drawCard());
                                deck.isLegal();
                            }
                            drawn++;
                            repaint();
                        }
                    }
                    if(e.getX() >= 790 && e.getX() <= 888 && 
                    e.getY() >= 403 && e.getY() <= 456 && drawn < 2){
                        if(!endDeck && 
                        deck.view.get(3).getTrainCardColor
                        ().equals(TrainCardsColor.LOCOMOTIVE)){
                            if(drawn < 1){
                                playerTwo.hand.add(deck.view.get(3));
                                deck.view.remove(3);
                                deck.view.add(3,deck.drawCard());
                                deck.isLegal();
                                repaint();
                                changeTurn();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, 
           "You cannot draw a locomotive. Please pick a different card",
           "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                        {
                            playerTwo.hand.add(deck.view.get(3));
                            deck.view.remove(3);
                            if (!endDeck){
                                deck.view.add(3,deck.drawCard());
                                deck.isLegal();
                            }
                            drawn++;
                            repaint();
                        }
                    }

                    if(e.getX() >= 905 && e.getX() <= 1004 && 
                    e.getY() >= 403 && e.getY() <= 461 && drawn < 2){
                        if(!endDeck && 
                        deck.view.get(4).getTrainCardColor
                        ().equals(TrainCardsColor.LOCOMOTIVE)){
                            if(drawn < 1){
                                playerTwo.hand.add(deck.view.get(4));
                                deck.view.remove(4);
                                deck.view.add(4,deck.drawCard());
                                deck.isLegal();
                                repaint();
                                changeTurn();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, 
            "You cannot draw a locomotive. Please pick a different card",
            "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            playerTwo.hand.add(deck.view.get(4));
                            deck.view.remove(4);
                            if (!endDeck){
                                deck.view.add(4,deck.drawCard());
                                deck.isLegal();
                            }
                            drawn++;
                            repaint();
                        }
                    }

                    if(e.getX() >= 727 && e.getX() <= 827 && 
                    e.getY() >= 532 && e.getY() <= 594 && drawn < 2)
                    {
                        if (deck.remaining.size() == 0){
                            endDeck = true;
                        }
                        else{
                            playerTwo.hand.add(deck.drawCard());
                            drawn++;
                        }
                        repaint();
                    }

                    if((e.getX() >= 935 && e.getX() <= 1045 && 
                    e.getY() >= 530 && e.getY() <= 600 && drawn < 2) &&
                    (drewCard == false))
                    {
                        picTickets(player2);
                        destination = true;

                        repaint();
                    }
                    else if((e.getX() >= 935 && e.getX() <= 1045 &&
                    e.getY() >= 530 && e.getY() <= 600 && drawn < 2) && 
                    (drewCard == true))
                    {
                        JOptionPane.showMessageDialog(null, 
       "You cannot draw train cards and destination tickets in a single turn", 
       "Invalid Choice", JOptionPane.ERROR_MESSAGE);
                    }

                    if(checkCards2 == false && e.getX() >= 903 &&
                    e.getX() <= 957 && e.getY() >= 825 &&
                    e.getY() <= 845){
                        checkCards2 = true;
                        repaint();
                    }
                    if(checkCards2 == true && e.getX() >= 500 && 
                    e.getX() <= 615 && e.getY() >= 750 &&
                    e.getY() <= 870){
                        checkCards2 = false;
                        repaint();
                    }

                    if (drawn ==2) {
                        changeTurn();
                    }
                }

            }

            if((playerOne.getNumTrainPieces() <= 2) || 
            (playerTwo.getNumTrainPieces() <= 2))
            { 
                if (lastTurn ==0)
                {
                    lastTurn = 1;

                    JOptionPane.showMessageDialog(null, 
                    "This will be your last turn", "Last Turn",
                    JOptionPane.INFORMATION_MESSAGE);

                }
                else if (( counter==1) && (x == 1))
                {
                    x++;
                    JOptionPane.showMessageDialog(null, 
                    "This will be your last turn", "Last Turn", 
                    JOptionPane.INFORMATION_MESSAGE);
                }

            }

            if((lastTurn ==1) && (counter ==2))
            {
                lastTurn =2;
                end = true;
                score1 = playerOne.getPoints();
                score2 = playerTwo.getPoints();
                playerOne.DTScore();
                playerTwo.DTScore();
                playerOne.addPoints(playerOne.pointsAdded);
                playerTwo.addPoints(playerTwo.pointsAdded);
                endPoints();
            }

        }
    }

    /**
     * Calculates the points for both players.
     */
    public void endPoints(){
        int redOnePoints = 
        playerOne.getPlayerMeeplesOfColor(MeeplesColor.RED);
        int redTwoPoints = 
        playerTwo.getPlayerMeeplesOfColor(MeeplesColor.RED);

        int yellowOnePoints = 
        playerOne.getPlayerMeeplesOfColor(MeeplesColor.YELLOW);
        int yellowTwoPoints = 
        playerTwo.getPlayerMeeplesOfColor(MeeplesColor.YELLOW);

        int blueOnePoints = 
        playerOne.getPlayerMeeplesOfColor(MeeplesColor.BLUE);
        int blueTwoPoints = 
        playerTwo.getPlayerMeeplesOfColor(MeeplesColor.BLUE);

        int blackOnePoints = 
        playerOne.getPlayerMeeplesOfColor(MeeplesColor.BLACK);
        int blackTwoPoints = 
        playerTwo.getPlayerMeeplesOfColor(MeeplesColor.BLACK);

        int whiteOnePoints = 
        playerOne.getPlayerMeeplesOfColor(MeeplesColor.WHITE);
        int whiteTwoPoints = 
        playerTwo.getPlayerMeeplesOfColor(MeeplesColor.WHITE);

        int greenOnePoints = 
        playerOne.getPlayerMeeplesOfColor(MeeplesColor.GREEN);
        int greenTwoPoints = 
        playerTwo.getPlayerMeeplesOfColor(MeeplesColor.GREEN);

        if (redOnePoints < redTwoPoints){
            playerOne.addPoints(10);
            playerTwo.addPoints(20);
        }
        else if (redOnePoints > redTwoPoints){
            playerOne.addPoints(20);
            playerTwo.addPoints(10);
        }
        else{
            playerOne.addPoints(20);
            playerTwo.addPoints(20);
        }
        //Yellow Meep
        if (yellowOnePoints < yellowTwoPoints){
            playerOne.addPoints(10);
            playerTwo.addPoints(20);
        }
        else if (yellowOnePoints > yellowTwoPoints){
            playerOne.addPoints(20);
            playerTwo.addPoints(10);
        }
        else{
            playerOne.addPoints(20);
            playerTwo.addPoints(20);
        }
        //Blue Meep
        if (blueOnePoints < blueTwoPoints){
            playerOne.addPoints(10);
            playerTwo.addPoints(20);
        }
        else if (blueOnePoints > blueTwoPoints){
            playerOne.addPoints(20);
            playerTwo.addPoints(10);
        }
        else{
            playerOne.addPoints(20);
            playerTwo.addPoints(20);
        }
        //Black Meep
        if (blackOnePoints < blackTwoPoints){
            playerOne.addPoints(10);
            playerTwo.addPoints(20);
        }
        else if (blackOnePoints > blackTwoPoints){
            playerOne.addPoints(20);
            playerTwo.addPoints(10);
        }
        else{
            playerOne.addPoints(20);
            playerTwo.addPoints(20);
        }
        //White
        if (whiteOnePoints < whiteTwoPoints){
            playerOne.addPoints(10);
            playerTwo.addPoints(20);
        }
        else if (whiteOnePoints > whiteTwoPoints){
            playerOne.addPoints(20);
            playerTwo.addPoints(10);
        }
        else{
            playerOne.addPoints(20);
            playerTwo.addPoints(20);
        }
        //Green
        if (greenOnePoints < greenTwoPoints){
            playerOne.addPoints(10);
            playerTwo.addPoints(20);
        }
        else if (greenOnePoints > greenTwoPoints){
            playerOne.addPoints(20);
            playerTwo.addPoints(10);
        }
        else{
            playerOne.addPoints(20);
            playerTwo.addPoints(20);
        }

        playerOne.points = playerOne.points - playerOne.pointsSubtracted;
        playerTwo.points = playerTwo.points - playerTwo.pointsSubtracted;

        //Globetrotter Bonus
        if ( playerOne.achieved.size() > playerTwo.achieved.size())
        {
            playerOne.addPoints(15);
        }
        else if ( playerOne.achieved.size() < playerTwo.achieved.size())
        {
            playerTwo.addPoints(15);
        }
        else
        {
            playerOne.addPoints(15);
            playerTwo.addPoints(15);
        }
    }

    /**
     * PaintComponent method for JPanel.
     * 
     * @param  g   the Graphics object for this applet
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (enabled){
            // display images
            Collections.shuffle(deck.discarded);
            for (int i = 0 ; i < deck.discarded.size(); i++){
                deck.remaining.add(deck.discarded.get(i));
            }
            Collections.shuffle(deck.remaining);
            deck.discarded.clear();
            while (deck.view.size() != 5 && 
            deck.remaining.size() > 0){
                deck.view.add(deck.drawCard());
            }

            if (destination == true){
                g.drawImage(intro,0,0,this);
                g.drawImage(bpic,290,500,this);
                if (ticDeck.pick.size() != 0){
                    if(picked == false){
                        g.drawImage
                        (ticDeck.pick.get(0).getImage(),15,50,this);
                    }
                    else{
                        g.drawImage
                        (ticDeck.pick.get(0).getImage(),15,280,this);
                    }
                    if(picked2 == false){
                        g.drawImage
                        (ticDeck.pick.get(1).getImage(),190,50,this);
                    }
                    else{
                        g.drawImage
                        (ticDeck.pick.get(1).getImage(),190,280,this);
                    }
                    if(picked3 == false){
                        g.drawImage
                        (ticDeck.pick.get(2).getImage(),365,50,this);
                    }
                    else{
                        g.drawImage
                        (ticDeck.pick.get(2).getImage(),365,280,this);
                    }
                    if(picked4 == false){
                        g.drawImage
                        (ticDeck.pick.get(3).getImage(),540,50,this);
                    }
                    else{
                        g.drawImage
                        (ticDeck.pick.get(3).getImage(),540,280,this);
                    }                    
                }
            }
            else 
            if (beginning){
                g.drawImage(intro2,0,31,this);
            }

            else if(end)
            {
                g.drawImage(endPic, 0, 0, this);
                g.setColor(Color.WHITE);
                Font courierBold50 = new Font("Courier", Font.BOLD, 50);
                g.setFont(courierBold50);

                g.drawString(player1.toUpperCase(), 95, 90);
                g.drawString(player2.toUpperCase(), 800, 90);

                g.drawString(score1+"" , 265, 158);
                g.drawString(score2+"" , 790, 155);

                Font courierBold40 = new Font("Courier", Font.BOLD, 40);
                g.setFont(courierBold40);
                // Calculate Meeples points //20 1st place, 10 2nd place
                int redOnePoints = 
                playerOne.getPlayerMeeplesOfColor(MeeplesColor.RED);
                int redTwoPoints = 
                playerTwo.getPlayerMeeplesOfColor(MeeplesColor.RED);

                int yellowOnePoints = 
                playerOne.getPlayerMeeplesOfColor(MeeplesColor.YELLOW);
                int yellowTwoPoints = 
                playerTwo.getPlayerMeeplesOfColor(MeeplesColor.YELLOW);

                int blueOnePoints = 
                playerOne.getPlayerMeeplesOfColor(MeeplesColor.BLUE);
                int blueTwoPoints = 
                playerTwo.getPlayerMeeplesOfColor(MeeplesColor.BLUE);

                int blackOnePoints = 
                playerOne.getPlayerMeeplesOfColor(MeeplesColor.BLACK);
                int blackTwoPoints = 
                playerTwo.getPlayerMeeplesOfColor(MeeplesColor.BLACK);

                int whiteOnePoints = 
                playerOne.getPlayerMeeplesOfColor(MeeplesColor.WHITE);
                int whiteTwoPoints = 
                playerTwo.getPlayerMeeplesOfColor(MeeplesColor.WHITE);

                int greenOnePoints = 
                playerOne.getPlayerMeeplesOfColor(MeeplesColor.GREEN);
                int greenTwoPoints = 
                playerTwo.getPlayerMeeplesOfColor(MeeplesColor.GREEN);
                //Red Meep
                if (redOnePoints < redTwoPoints){
                    g.drawString(redOnePoints+"    +10" , 230, 250);
                    g.drawString(redTwoPoints+"    +20" , 750, 250);
                }
                else if (redOnePoints > redTwoPoints){
                    g.drawString(redOnePoints+"    +20" , 230, 250);
                    g.drawString(redTwoPoints+"    +10" , 750, 250);
                }
                else{
                    g.drawString(redOnePoints+"    +20" , 230, 250);
                    g.drawString(redTwoPoints+"    +20" , 750, 250);
                }
                //Yellow Meep
                if (yellowOnePoints < yellowTwoPoints){
                    g.drawString(yellowOnePoints+"    +10" , 230, 295);
                    g.drawString(yellowTwoPoints+"    +20" , 750, 295);
                }
                else if (yellowOnePoints > yellowTwoPoints){
                    g.drawString(yellowOnePoints+"    +20" , 230, 295);
                    g.drawString(yellowTwoPoints+"    +10" , 750, 295);
                }
                else{
                    g.drawString(yellowOnePoints+"    +20" , 230, 295);
                    g.drawString(yellowTwoPoints+"    +20" , 750, 295);
                }                
                //Blue Meep
                if (blueOnePoints < blueTwoPoints){
                    g.drawString(blueOnePoints+"    +10" , 230, 340);
                    g.drawString(blueTwoPoints+"    +20" , 750, 340);
                }
                else if (blueOnePoints > blueTwoPoints){
                    g.drawString(blueOnePoints+"    +20" , 230, 340);
                    g.drawString(blueTwoPoints+"    +10" , 750, 340);
                }
                else{
                    g.drawString(blueOnePoints+"    +20" , 230, 340);
                    g.drawString(blueTwoPoints+"    +20" , 750, 340);
                }
                //Black Meep
                if (blackOnePoints < blackTwoPoints){
                    g.drawString(blackOnePoints+"    +10" , 230, 385);
                    g.drawString(blackTwoPoints+"    +20" , 750, 385);
                }
                else if (blackOnePoints > blackTwoPoints){
                    g.drawString(blackOnePoints+"    +20" , 230, 385);
                    g.drawString(blackTwoPoints+"    +10" , 750, 385);
                }
                else{
                    g.drawString(blackOnePoints+"    +20" , 230, 385);
                    g.drawString(blackTwoPoints+"    +20" , 750, 385);
                }
                //White
                if (whiteOnePoints < whiteTwoPoints){
                    g.drawString(whiteOnePoints+"    +10" , 230, 430);
                    g.drawString(whiteTwoPoints+"    +20" , 750, 430);
                }
                else if (whiteOnePoints > whiteTwoPoints){
                    g.drawString(whiteOnePoints+"    +20" , 230, 430);
                    g.drawString(whiteTwoPoints+"    +10" , 750, 430);
                }
                else{
                    g.drawString(whiteOnePoints+"    +20" , 230, 430);
                    g.drawString(whiteTwoPoints+"    +20" , 750, 430);
                }
                //Green
                if (greenOnePoints < greenTwoPoints){
                    g.drawString(greenOnePoints+"    +10" , 230, 475);
                    g.drawString(greenTwoPoints+"    +20" , 750, 475);
                }
                else if (greenOnePoints > greenTwoPoints){
                    g.drawString(greenOnePoints+"    +20" , 230, 475);
                    g.drawString(greenTwoPoints+"    +10" , 750, 475);
                }
                else{
                    g.drawString(greenOnePoints+"    +20" , 230, 475);
                    g.drawString(greenTwoPoints+"    +20" , 750, 475);
                }

                //Total Tickets
                g.drawString(playerOne.tickets.size() + "", 360, 550);
                g.drawString(playerTwo.tickets.size() + "", 850, 550);

                //Achieved
                g.drawString(playerOne.achieved.size() + "", 360, 595);
                g.drawString(playerTwo.achieved.size() + "", 850, 595);

                //Points:
                g.drawString(playerOne.pointsAdded + "", 360, 640);
                g.drawString(playerTwo.pointsAdded + "", 850, 640);


                //Uncompleted
                g.drawString(playerOne.tickets.size() - 
                playerOne.achieved.size() + "", 360, 685);
                g.drawString(playerTwo.tickets.size() - 
                playerTwo.achieved.size() + "", 860, 685);

                //Penalty
               g.drawString("-" + playerOne.pointsSubtracted + "", 360, 730);
               g.drawString("-" + playerTwo.pointsSubtracted + "", 850, 730);
                //Globetrotter Bonus
                if ( playerOne.achieved.size() > playerTwo.achieved.size())
                {
                    g.drawString("+15", 360, 775);
                    g.drawString("0", 850, 775);
                }
                
                else if ( playerOne.achieved.size() <
                playerTwo.achieved.size())
                {
                    g.drawString("0", 360, 775);
                    g.drawString("+15", 850, 775);
                }
                else
                {
                    g.drawString("+15", 360, 775);
                    g.drawString("+15", 850, 775);
                }

                Font courierBold101 = new Font("Courier", Font.BOLD, 101);
                g.setFont(courierBold101);

                if (playerOne.getPoints() > playerTwo.getPoints())
                {
                    g.drawString(player1.toUpperCase()+" WINS", 309, 915);
                }
                else if (playerOne.getPoints() < playerTwo.getPoints())
                {
                    g.drawString(player2.toUpperCase()+" WINS", 309, 915);
                }
                else{
                    g.drawString("It's a tie", 369, 915);
                }
                g.setFont(courierBold50);
                g.drawString(playerOne.getPoints()+"" , 270, 820);
                g.drawString(playerTwo.getPoints()+"", 815, 820);

            }
            else if(checkCards == true && player1Turn == true){
                g.drawImage(intro,0,0,this);
                g.drawImage(bpic,500,750,this);
                int k = 0;
                for(int i = 0; i < playerOne.tickets.size(); i++){

                    if (i < 6){
                        g.drawImage
                        (playerOne.tickets.get(i).getImage()
                        ,pic + (i * 175),50,this);
                    }

                    else if (i < 12) {
                        g.drawImage
                        (playerOne.tickets.get(i).getImage()
                        ,pic + (k * 175),300,this);
                        k++;
                    }
                    else if (i < 20) {
                        if (k == 6) { k = 0;}
                        g.drawImage
                        (playerOne.tickets.get(i).getImage()
                        ,pic + (k * 175),600,this);
                        k++;                        
                    }
                }
            }
            else if(checkCards2 == true && player1Turn == false){
                g.drawImage(intro,0,0,this);
                g.drawImage(bpic,500,750,this);
                int j = 0;
                for(int i = 0; i < playerTwo.tickets.size(); i++){

                    if (i < 6){
                        g.drawImage
                        (playerTwo.tickets.get(i).getImage(),pic +
                        (i * 175),50,this);
                    }

                    else if (i < 12) {
                        g.drawImage
                        (playerTwo.tickets.get(i).getImage(),pic +
                        (j * 175),300,this);
                        j++;
                    }
                    else if (i < 20) {
                        if (j == 6) { j = 0;}
                        g.drawImage
                        (playerTwo.tickets.get(i).getImage(),pic + 
                        (j * 175),600,this);
                        j++;
                    }
                }
            }
            else
            { 

                g.drawImage(background, 0, 0, this);
                g.drawImage(board, 20, 30, this);
                if (deck.view.size() > 0){
                    g.drawImage(deck.view.get(0).getImage(),720,320,this);
                }
                if (deck.view.size() > 1){
                    g.drawImage(deck.view.get(1).getImage(),835,320,this);
                }
                if (deck.view.size() > 2){
                    g.drawImage(deck.view.get(2).getImage(),950,320,this);
                }
                if (deck.view.size() > 3){
                    g.drawImage(deck.view.get(3).getImage(),780,395,this);
                }
                if (deck.view.size() > 4){
                    g.drawImage(deck.view.get(4).getImage(),895,395,this);
                }
                g.setColor(Color.white);
                g.drawLine(1095,280,690,280);
                g.drawLine(1095,625,690,625);

                // g.drawString(player1,
                Font courierBold101 = new Font("Courier", Font.BOLD, 23);
                Font courierBold10 = new Font("Courier", Font.BOLD, 17);
                g.setFont(courierBold101);
                g.drawString(player1.toUpperCase(), 866, 22);
                g.drawString(player2.toUpperCase(), 870, 820);
                Font courierBold12 = new Font("Courier", Font.BOLD, 14);
                g.setFont(courierBold12);
                g.drawString("SCORE:", 870, 58);
                g.drawString("SCORE:", 870, 860);
                Font courierBold18 = new Font("Courier", Font.BOLD, 15);
                g.setFont(courierBold18);
                g.drawString(playerTwo.getNumTrainPieces() + "", 977, 890);
                g.drawString(playerOne.getNumTrainPieces() + "", 977, 90);
                Font courierBold30 = new Font("Courier", Font.BOLD, 33);
                g.setFont(courierBold30);
                g.drawString(playerTwo.getPoints() + "", 888, 894);
                g.drawString(playerOne.getPoints() + "", 888, 90);
                g.setFont(courierBold10);
                g.drawString(playerTwo.hand.size() + "", 855, 840);
                g.drawString(playerOne.hand.size() + "", 855, 40);
                g.drawString(playerOne.tickets.size() + "", 971, 40);
                g.drawString(playerTwo.tickets.size() + "", 971, 840);

                g.setColor(color);
                //Traincards Player 1
                g.fill3DRect(740,120,30,30,true);
                g.fill3DRect(835,120,30,30,true);
                g.fill3DRect(930,120,30,30,true);
                g.fill3DRect(1025,120,30,30,true);
                g.fill3DRect(740,175,30,30,true);
                g.fill3DRect(835,175,30,30,true);
                g.fill3DRect(930,175,30,30,true);
                g.fill3DRect(1025,175,30,30,true);
                g.fill3DRect(882,230,30,30,true);
                //Traincards Player 2
                g.fill3DRect(739,702,30,30,true);
                g.fill3DRect(835,702,30,30,true);
                g.fill3DRect(930,702,30,30,true);
                g.fill3DRect(1025,702,30,30,true);
                g.fill3DRect(740,757,30,30,true);
                g.fill3DRect(835,757,30,30,true);
                g.fill3DRect(930,757,30,30,true);
                g.fill3DRect(1025,757,30,30,true);
                g.fill3DRect(882,647,30,30,true);
                //Meeples Player 1
                g.fill3DRect(720,240,22,22,true);
                g.fill3DRect(769,240,22,22,true);
                g.fill3DRect(815,240,22,22,true);
                g.fill3DRect(957,240,22,22,true);
                g.fill3DRect(1005,240,22,22,true);
                g.fill3DRect(1053,240,22,22,true);
                //Meeples Player 1
                g.fill3DRect(720,653,22,22,true);
                g.fill3DRect(769,653,22,22,true);
                g.fill3DRect(815,653,22,22,true);
                g.fill3DRect(957,653,22,22,true);
                g.fill3DRect(1005,653,22,22,true);
                g.fill3DRect(1053,653,22,22,true);
                g.setColor(Color.white);
                g.drawString(playerOne.getNumTrainCard
                (TrainCardsColor.GREEN) + "",750,142);
                g.drawString(playerOne.getNumTrainCard
                (TrainCardsColor.BLACK) + "",845,142);
                g.drawString(playerOne.getNumTrainCard
                (TrainCardsColor.RED) + "",940,142);
                g.drawString(playerOne.getNumTrainCard
                (TrainCardsColor.ORANGE) + "",1035,142);
                g.drawString(playerOne.getNumTrainCard
                (TrainCardsColor.PINK) + "",750,197);
                g.drawString(playerOne.getNumTrainCard
                (TrainCardsColor.WHITE) + "",845,197);
                g.drawString(playerOne.getNumTrainCard
                (TrainCardsColor.YELLOW) + "",940,197);
                g.drawString(playerOne.getNumTrainCard
                (TrainCardsColor.BLUE) + "",1035,197);
                g.drawString(playerOne.getNumTrainCard
                (TrainCardsColor.LOCOMOTIVE) + "",892,250);
                g.drawString(playerTwo.getNumTrainCard
                (TrainCardsColor.PINK) + "",750,724);
                g.drawString(playerTwo.getNumTrainCard
                (TrainCardsColor.WHITE) + "",845,724);
                g.drawString(playerTwo.getNumTrainCard
                (TrainCardsColor.YELLOW) + "",940,724);
                g.drawString(playerTwo.getNumTrainCard
                (TrainCardsColor.BLUE) + "",1035,724);
                g.drawString(playerTwo.getNumTrainCard
                (TrainCardsColor.GREEN) + "",750,779);
                g.drawString(playerTwo.getNumTrainCard
                (TrainCardsColor.BLACK) + "",845,779);
                g.drawString(playerTwo.getNumTrainCard
                (TrainCardsColor.RED) + "",940,779);
                g.drawString(playerTwo.getNumTrainCard
                (TrainCardsColor.ORANGE) + "",1035,779);
                g.drawString(playerTwo.getNumTrainCard
                (TrainCardsColor.LOCOMOTIVE) + "",892,667);
                Font courierBold14 = new Font("Courier", Font.BOLD, 14);
                g.setFont(courierBold14);
                g.drawString(playerOne.getPlayerMeeplesOfColor
                (MeeplesColor.BLACK) + "",728,257);
                g.drawString(playerOne.getPlayerMeeplesOfColor
                (MeeplesColor.BLUE)  + "",777,257);
                g.drawString(playerOne.getPlayerMeeplesOfColor
                (MeeplesColor.GREEN) + "",823,257);
                g.drawString(playerOne.getPlayerMeeplesOfColor
                (MeeplesColor.RED)  + "",964,257);
                g.drawString(playerOne.getPlayerMeeplesOfColor
                (MeeplesColor.YELLOW)  + "",1013,257);
                g.drawString(playerOne.getPlayerMeeplesOfColor
                (MeeplesColor.WHITE)  + "",1061,257);
                g.drawString(playerTwo.getPlayerMeeplesOfColor
                (MeeplesColor.BLACK) + "",728,670);
                g.drawString(playerTwo.getPlayerMeeplesOfColor
                (MeeplesColor.BLUE)  + "",777,670);
                g.drawString(playerTwo.getPlayerMeeplesOfColor
                (MeeplesColor.GREEN) + "",823,670);
                g.drawString(playerTwo.getPlayerMeeplesOfColor
                (MeeplesColor.RED)  + "",964,670);
                g.drawString(playerTwo.getPlayerMeeplesOfColor
                (MeeplesColor.YELLOW)  + "",1013,670);
                g.drawString(playerTwo.getPlayerMeeplesOfColor
                (MeeplesColor.WHITE)  + "",1061,670);
                if(player1Turn)
                {
                    g.drawImage(turn1,700,627,this);
                }
                else
                {
                    g.drawImage(turn2,700,108,this);
                }
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(5));
                g2.setColor(Color.GREEN);
                for (Route r : playerOne.claimedRoutes){
                    int[] coords1 = map.getCoords
                    (r.getVertex1(), r.getVertex2());
                    int[] coords2 = map.getCoords
                    (r.getVertex2(), r.getVertex1());
                    g2.drawLine
                    (coords1[0],coords1[1],coords2[0],coords2[1]);
                }
                //changeTurn();
                g2.setColor(Color.RED);
                for (Route r : playerTwo.claimedRoutes){
                    int[] coords1 = map.getCoords
                    (r.getVertex1(), r.getVertex2());
                    int[] coords2 = map.getCoords
                    (r.getVertex2(), r.getVertex1());
                    g2.drawLine
                    (coords1[0],coords1[1],coords2[0],coords2[1]);
                }
                //changeTurn();
                if (needsG % 2 == 1){
                    g.drawImage(infoG,341,183,null);
                }

            }
        }

    }

    /**
     * Gets the coordinates for the routes.
     * 
     * @param x1 The first Xcoordinate
     * @param y1 The first Ycoordinate 
     * @param x2 The second Xcoordinate
     * @param y2 The second Ycoordinate
     * 
     */
    public Route getSelectedRoute(int x1, int y1, int x2, int y2){
        Vertices city1 = getCity(x1,y1);
        Vertices city2 = getCity(x2,y2);
        ArrayList<Route> routes = map.getRoutes(city1,city2);
        Route selectedRoute = null;
        if (routes.size() == 0){
            JOptionPane.showMessageDialog
            (null, "You have selected an invalid route",
            "Invalid", JOptionPane.ERROR_MESSAGE);
        }
        else if (routes.size() == 1){
            selectedRoute = routes.get(0);
        }
        else{
            // "Which route would you like to claim?"
            String[] buttons = { routes.get(0).toString(), 
                routes.get(1).toString() };
            int answer = JOptionPane.showOptionDialog(null,
          "Which route would you like to claim?", "Choose Route",
                    0, JOptionPane.QUESTION_MESSAGE,
                    null, buttons, buttons[1]);                    
            if (answer == 0){
                selectedRoute = routes.get(0);
            }
            else {
                selectedRoute = routes.get(1);
            }
        }

        if (selectedRoute != null){
            if (player1Turn){
                if (map.contains(selectedRoute)){
                    int[] cards = whichCards(playerOne, selectedRoute);
                    if (playerOne.claimRoute
                    (selectedRoute,selectedRoute.getColor(),cards)){ 
                        //Buttons for meeples                   
                        Route rt = selectedRoute;
                        int meeplesSize1 = 
                        meeples.getArray(rt.getVertex1()).size();
                        int meeplesSize2 = 
                        meeples.getArray(rt.getVertex2()).size();
                      String[] meepleButtons1 = new String[meeplesSize1];
                      String[] meepleButtons2 = new String[meeplesSize2];
                        ArrayList<MeeplesColor> arr1 = 
                        meeples.getArray(rt.getVertex1());
                        ArrayList<MeeplesColor> arr2 = 
                        meeples.getArray(rt.getVertex2());
                        for (int i = 0; i < meeplesSize1; i++){
                            meepleButtons1[i] = arr1.get(i).toString();
                        }
                        for (int i = 0; i < meeplesSize2; i++){
                            meepleButtons2[i] = arr2.get(i).toString();
                        }
                        if (meepleButtons1.length > 0){
                            int response1 = JOptionPane.showOptionDialog
                            (null, "Which Meeple would you like from "+
                            rt.getVertex1().toString() + "?",
                            "Choose Meeple",
                                    0, JOptionPane.QUESTION_MESSAGE, null,
                                    meepleButtons1, meepleButtons1[0]);
                            playerOne.addMeeple(arr1.get(response1));
                            meeples.remove(rt.getVertex1(),
                            arr1.get(response1));
                        }
                        if (meepleButtons2.length > 0){
                            int response2 = JOptionPane.showOptionDialog(null, 
                            "Which Meeple would you like from "+ 
                            rt.getVertex2().toString() + "?",
                            "Choose Meeple",
                                    0, JOptionPane.QUESTION_MESSAGE, null,
                                    meepleButtons2, meepleButtons2[0]);
                            playerOne.addMeeple(arr2.get(response2));
                            meeples.remove(rt.getVertex2(),
                            arr2.get(response2));
                        }                             
                        changeTurn();
                        if (routes.size() == 2){
                            map.removeRoute(routes.get(0));
                            map.removeRoute(routes.get(1));
                        }
                        else {
                            map.removeRoute(selectedRoute);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                   "You do not have enough TRAIN CARDS to claim this Route",
                   "Invalid", JOptionPane.ERROR_MESSAGE);
                    }                    
                }
            }
            else { // it's player 2's turn
                //check if they can claim the route and then claim it
                if (map.contains(selectedRoute)){
                    int[] cards = whichCards(playerTwo, selectedRoute);
                    if (playerTwo.claimRoute
                    (selectedRoute,selectedRoute.getColor(),cards)){
                        //Buttons for meeples
                        Route rt = selectedRoute;
                        int meeplesSize1 = 
                        meeples.getArray(rt.getVertex1()).size();
                        int meeplesSize2 = 
                        meeples.getArray(rt.getVertex2()).size();
                        String[] meepleButtons1 = 
                        new String[meeplesSize1];
                        String[] meepleButtons2 = 
                        new String[meeplesSize2];
                        ArrayList<MeeplesColor> arr1 = 
                        meeples.getArray(rt.getVertex1());
                        ArrayList<MeeplesColor> arr2 = 
                        meeples.getArray(rt.getVertex2());
                        for (int i = 0; i < meeplesSize1; i++){
                            meepleButtons1[i] = arr1.get(i).toString();
                        }
                        for (int i = 0; i < meeplesSize2; i++){
                            meepleButtons2[i] = arr2.get(i).toString();
                        }
                        if (meepleButtons1.length > 0){
                            int response1 = 
                            JOptionPane.showOptionDialog(null, 
                        "Which Meeple would you like from "+                           
                        rt.getVertex1().toString() + "?", "Choose Meeple",
                                    0, JOptionPane.QUESTION_MESSAGE,
                                    null, meepleButtons1, meepleButtons1[0]);
                            playerTwo.addMeeple(arr1.get(response1));
                          meeples.remove(rt.getVertex1(),arr1.get(response1));
                           
                        }
                        if (meepleButtons2.length > 0){
                            int response2 = 
                            JOptionPane.showOptionDialog(null, 
                          "Which Meeple would you like from "+ 
                         rt.getVertex2().toString() + "?", "Choose Meeple",
                                    0, JOptionPane.QUESTION_MESSAGE, null,
                                    meepleButtons2, meepleButtons2[0]);
                            playerTwo.addMeeple(arr2.get(response2));
                          meeples.remove(rt.getVertex2(),arr2.get(response2));
                        }
                        changeTurn();
                        if (routes.size() == 2){
                            map.removeRoute(routes.get(0));
                            map.removeRoute(routes.get(1));
                        }
                        else {
                            map.removeRoute(selectedRoute);
                        }
                    }
                }
            }
        }

        return selectedRoute; //if a valid route is not selected
    }

    /**
     * Checks for what cards players want to use for claiming a route.
     * 
     * @param p the current player.
     * @param r the route.
     * 
     * 
     */
    public int[] whichCards(Player p, Route r){
        int[] cards = new int[2]; //int[0] = color cards, int[1] = 
        //loco cards
        int numLoco = 0;
        int remaining = 0;
        if (r.getColor() != TrainCardsColor.GRAY){
            do{
                if (p.getNumTrainCard(TrainCardsColor.LOCOMOTIVE) >= 0){
                    //ask how many loco cards you want to use, check answer
                    numLoco = 
                    Integer.parseInt( JOptionPane.showInputDialog
   ("Please enter in the number of locomotive cards you would like to use"));       
                    cards[1] = numLoco;
                    int numTrains = r.getNumTrains();
                    remaining = numTrains - numLoco;
                    cards[0] = remaining;
                }
            }while (numLoco > p.getNumTrainCard
            (TrainCardsColor.LOCOMOTIVE) && 
            p.getNumTrainCard(r.getColor()) >= remaining);
        }
        else{ //gray route is selected
            do{
                if (p.getNumTrainCard
                (TrainCardsColor.LOCOMOTIVE) >= 0){
                    //ask how many loco cards you want to use, check answer
                    numLoco = Integer.parseInt
                    ( JOptionPane.showInputDialog
   ("Please enter in the number of locomotive cards you would like to use"));
                    cards[1] = numLoco;
                    int numTrains = r.getNumTrains();
                    remaining = numTrains - numLoco;
                    cards[0] = remaining;
                }
            }while (numLoco > 
            p.getNumTrainCard(TrainCardsColor.LOCOMOTIVE));
        }
        return cards;
    }

    /**
     * Gets the city by x and y coordinate.
     * 
     * @param x The Xcoordinaten for city.
     * @param y The Ycoordinate for city.
     * 
     * @return return the vertices based 
     * off of x and y coordinates 
     */
    public Vertices getCity(int x,int y){
        if (x>=114-OFF&&x<=144+OFF&&y>=209-OFF&&y<=209+OFF){ 
            //Emden
            return Vertices.EMDEN;
        }
        else if (x>=245-OFF&&
        x<=245+OFF&&y>=242-OFF&&y<=242+OFF){
            //Bremen
            return Vertices.BREMEN;
        }
        else if (x>=239-OFF&&
        x<=239+OFF&&y>=193-OFF&&y<=193+OFF){
            //Bremerhaven
            return Vertices.BREMERHAVEN;
        }
        else if (x>=350-OFF&&
        x<=350+OFF&&y>=112-OFF&&y<=112+OFF){
            //Kiel
            return Vertices.KIEL;
        }
        else if (x>=155-OFF&&
        x<=155+OFF&&y>=351-OFF&&y<=351+OFF){
            //Munster
            return Vertices.MUNSTER;
        }
        else if (x>=140-OFF&&
        x<=140+OFF&&y>=407-OFF&&y<=407+OFF){
            //Dortmund
            return Vertices.DORTMUND;
        }
        else if (x>=79-OFF&&
        x<=79+OFF&&y>=427-OFF&&y<=427+OFF){
            //Dusseldorf
            return Vertices.DUSSELDORF;
        }
        else if (x>=76-OFF&&
        x<=76+OFF&&y>=485-OFF&&y<=485+OFF){
            //Koln
            return Vertices.KOLN;
        }
        else if (x>=91-OFF&&
        x<=91+OFF&&y>=543-OFF&&y<=543+OFF){
            //Koble
            return Vertices.KOBLENZ;
        }
        else if (x>=178-OFF&&
        x<=178+OFF&&y>=591-OFF&&y<=591+OFF){
            //Mainz
            return Vertices.MAINZ;
        }
        else if (x>=63-OFF&&
        x<=63+OFF&&y>=653-OFF&&y<=653+OFF){
            //Saarbrucken
            return Vertices.SAARBRUCKEN;
        }
        else if (x>=202-OFF&&
        x<=202+OFF&&y>=693-OFF&&y<=693+OFF){
            //Karlrsuhe
            return Vertices.KARLSRUHE;
        }
        else if (x>=206-OFF&&
        x<=206+OFF&&y>=640-OFF&&y<=640+OFF){
            //Mannheim
            return Vertices.MANNHEIM;
        }
        else if (x>=235-OFF&&
        x<=235+OFF&&y>=557-OFF&&y<=557+OFF){
            //Frankfurt
            return Vertices.FRAKFURT;
        }
        else if (x>=336-OFF&&
        x<=336+OFF&&y>=591-OFF&&y<=591+OFF){
            //Wurzburg
            return Vertices.WURZBURG;
        }
        else if (x>=269-OFF&&
        x<=269+OFF&&y>=705-OFF&&y<=705+OFF){
            //Stuttgart
            return Vertices.STUTTGART;
        }
        else if (x>=266-OFF&&
        x<=266+OFF&&y>=824-OFF&&y<=824+OFF){
            //Konstanz
            return Vertices.KONSTANZ;
        }
        else if (x>=327-OFF&&
        x<=327+OFF&&y>=832-OFF&&y<=832+OFF){
            //Lindau
            return Vertices.LINDAU;
        }
        else if (x>=356-OFF&&
        x<=356+OFF&&y>=748-OFF&&y<=748+OFF){
            //Ulm
            return Vertices.ULM;
        }
        else if (x>=422-OFF&&
        x<=422+OFF&&y>=755-OFF&&y<=755+OFF){
            //Augsburg
            return Vertices.AUGSBURG;
        }
        else if (x>=524-OFF&&
        x<=524+OFF&&y>=774-OFF&&y<=774+OFF){
            //Munchen
            return Vertices.MUNCHEN;
        }
        else if (x>=572-OFF&&
        x<=572+OFF&&y>=677-OFF&&y<=677+OFF){
            //Regensburg
            return Vertices.REGENSBURG;
        }
        else if (x>=439-OFF&&
        x<=439+OFF&&y>=615-OFF&&y<=615+OFF){
            //Nurnberg
            return Vertices.NURNBERG;
        }
        else if (x>=682-OFF&&
        x<=682+OFF&&y>=463-OFF&&y<=463+OFF){
            //Dresden
            return Vertices.DRESDEN;
        }
        else if (x>=619-OFF&&
        x<=619+OFF&&y>=487-OFF&&y<=487+OFF){
            //Chemnitz
            return Vertices.CHEMNITZ;
        }
        else if (x>=547-OFF&&
        x<=547+OFF&&y>=424-OFF&&y<=424+OFF){
            //Leipzig
            return Vertices.LEIPZIG;
        }
        else if (x>=631-OFF&&
        x<=631+OFF&&y>=297-OFF&&y<=297+OFF){
            //Berlin
            return Vertices.BERLIN;
        }
        else if (x>=531-OFF&&
        x<=531+OFF&&y>=113-OFF&&y<=113+OFF){
            //Rostock
            return Vertices.ROSTOCK;
        }
        else if (x>=468-OFF&&
        x<=468+OFF&&y>=184-OFF&&y<=184+OFF){
            //Schwerin
            return Vertices.SCHWERIN;
        }
        else if (x>=325-OFF&&
        x<=325+OFF&&y>=329-OFF&&y<=329+OFF){
            //Hannover
            return Vertices.HANNOVER;
        }
        else if (x>=371-OFF&&
        x<=371+OFF&&y>=192-OFF&&y<=192+OFF){
            //Hamburg
            return Vertices.HAMBURG;
        }
        else if (x>=507-OFF&&
        x<=507+OFF&&y>=350-OFF&&y<=350+OFF){
            //Madgeburg
            return Vertices.MAGDEBURG;
        }
        else if (x>=436-OFF&&
        x<=436+OFF&&y>=476-OFF&&y<=476+OFF){
            //Erfurt
            return Vertices.ERFURT;
        }
        else if (x>=311-OFF&&
        x<=311+OFF&&y>=438-OFF&&y<=438+OFF){
            //Kassel
            return Vertices.KASSEL;
        }
        else if (x>=162-OFF&&
        x<=162+OFF&&y>=798-OFF&&y<=798+OFF){
            //Freiburg
            return Vertices.FREIBURG;
        }
        else if (x>=21&&
        x<=116&&y>=696&&y<=791){
            //FRANKREICH
            return Vertices.FRANKREICH;
        }
        else if (x>=157&&
        x<=241&&y>=829&&y<=880){
            //SCHWEIZ
            return Vertices.SCHWEIZ;
        }
        else if ( (x>=412&&x<=483&&y>=835&&y<=879)
        || (x>=597&&x<=699&&y>=779&&y<=879)){
            //OSTERREICH
            return Vertices.OSTERREICH;
        }
        else if (x>=276&&x<=348&&y>=31&&y<=78){
            //DANEMARK
            return Vertices.DANEMARK;
        }
        else if (x>=23&&x<=95&&y>=261&&y<=333){
            //NIEDERLANDE
            return Vertices.NIEDERLANDE;
        }
        return null;
    }

    /**
     * Prompts the user for short or long tickets and 
     * draws them from the deck to display
     * 
     * @param name The String name of the current
     * player
     */
    private void picTickets(String name)
    {
        temp.clear();
        ticDeck.pick.clear();
        Object[] options = {"SHORT" , "LONG"};
        int num = -1;
        int count = 0;
        for(int i =0 ; i < 4; i++)
        {
            num = 
            JOptionPane.showOptionDialog
            (null, "" + name.toUpperCase() 
            +" please pick the ticket type (" + (i+1) + "/4 )" 
            , "Pick a choice",JOptionPane.YES_NO_OPTION,
             JOptionPane.QUESTION_MESSAGE,null,options,null );
            if( num == JOptionPane.YES_OPTION)
            {
                ticDeck.pick.add(ticDeck.drawShortTicket());
            }
            else
            {
                ticDeck.pick.add(ticDeck.drawLongTicket());
            }
        }
        repaint();
    }

    /**
     * Changes the current player
     * 
     */
    private void changeTurn()
    {
        if (player1Turn)
        {
            drawn =0;
            player1Turn = false;
            if(lastTurn ==1)
            {
                counter++;
                x++;
            }

        }
        else
        {
            drawn =0;
            player1Turn = true;
            if(lastTurn ==1)
            {
                counter++;
                x++;
            }
        }

        picked = false;
        picked2 = false;
        picked3 = false;
        picked4 = false;
    }
    
    /**
     * Runs the Ticket to Ride Game by calling 
     * createAndShowGUI()
     * 
     * @param args Doesn't use args
     */
    private static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }

    /**
     * Creates the frame for the Ticket to Ride Game and 
     * begins to play music.
     * 
     */
    protected static void createAndShowGUI() {
        JFrame frame = new JFrame("Applet Viewer: Display.class");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board test = new Board();

        try {
            AudioInputStream audioInputStream = 
            AudioSystem.getAudioInputStream(
                    new File
             ("." + "\\PicturesLayout\\ttrwav.wav").getAbsoluteFile());       
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e){
            System.err.println("Error");
            e.printStackTrace();
        }

        frame.getContentPane().add(test);

        frame.pack();
        frame.setVisible(true);
    }
}
