import java.io.*;
import java.util.*;

public class jerryAI
{
    //Forms the sets to compare for wincons
    private static void formSets()
    {
        for(int i=0;i<9;i++)
        {
            playerSet.add(playerMoves[i]);
            AISet.add(selectedSpots[i]);
            winSet.add(winCheck[i]);
        }
    }
//Checks to see if spot is already occupied
private boolean emptySpot()
{
    for(int i=0;i<=spots.length();i++)
    {
        if(selectedSpot==selectedSpots[i]|| selectedSpot==playerMoves[i])
        {
            return false;
            break;
        }
         else return true;
    }
}
//uses sets to check if a wincon is a subset of player arrays
private boolean winCons(Set<T> setA, Set<T> setB)
{
    return setB.containsAll(setA);
}
//checks if wincon is done, if it is game ends
private boolean playing()
{
    //remember to check for wincons each runthrough
    if (moveCount<9 && winCons==false) return true;
    else return false;
}
//These two are to check to make sure it's the AI's turn
private static boolean isTurnFirst()
{
    if(selectedSpots.size()==playerMoves.size()) return true;
    else return false;
}
private static boolean isTurnSecond()
{
    if(selectedSpots.size()<playerMoves.size()) return true;
    else return false;
}
public static void AI()
{
    int [] spots=new int [] {1,2,3,4,5,6,7,8,9};
    int selectedSpot=0;
    ArrayList <Integer> selectedSpots=new ArrayList <Integer>();
    ArrayList <Integer> playerMoves=new ArrayList <Integer>();
    int moveCount=0;
    boolean playing=true;
    boolean emptySpot=true;
    int [] winCheck= new int []{{1,2,3},{1,4,8},{1,5,9},{2,4,7},{2,6,9},{3,5,7},{3,6,9},{4,5,6},{7,8,9}};
    //Makes sets to check for subsets as wincons, compares them, true is a win, false is a continue
    Set<Integer> playerSet = new TreeSet<Integer>();
    Set<Integer> AISet = new TreeSet<Integer>();
    Set<Integer> winSet = new TreeSet<Integer>();
    while(playing)
    {
         //Checks to see if player wins before AI makes move
         winCons(playerSet,winSet);
         if(winCons(playerSet,winSet)==true) System.out.println("Congratulations, you win!");
    for(int spaces=9;spaces>0;spaces--)
        {
        if(((isTurnFirst()==true)&&(isTurnSecond()==false))||((isTurnFirst()==false)&&isTurnSecond()==true))
            {
             selectedSpot=1+(spots.length*rand());
             while(emptySpot==false) selectedSpot=1+(spots.length*rand());
            }
        selectedSpots.add(selectedSpot);
        
        //Calls function to refresh size and values of arraylists after each addition of a new spot
        formSets(); 
        }
         //Checks to see if AI's new move is a winner
         winCons(AISet,winSet);
         if(winCons(AISet,winSet)==true)  System.out.println("You lose :(");
        moveCount++;
       if(moveCount==9) System.out.println("Drraawwwwwwww");
    }
}
}