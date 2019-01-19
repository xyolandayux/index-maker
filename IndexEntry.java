
/*
*This class creates and organizes an ArrayList containing all the lines a certain word has appeared on 
*and make them print out as a string in numerical order next to the word that’s being searched for.
*Created by: Yolanda Yu
*Last modified: April 13th, 2017
*/
import java.util.ArrayList;

public class IndexEntry
{
  //fields of IndexEntry
  private String word;
  private ArrayList<Integer> numsList;


 //constructor of IndexEntry
  public IndexEntry(String w)
  {
    numsList = new ArrayList<Integer>();   //creates a new ArrayList with the type Interger and default capacity with size 0
    word = w.toUpperCase();  //turn all the words into upper case
  }

//Add the line number to the end if the list doesn't already have the number
  public void add(int num)
  {
    if (!numsList.contains(num))  //Does not contain the number
      numsList.add(num);   //Add the number to the list
  }

  //Return the string word
  public String getWord()
  {
    return word;
  }

  //Convert the ArrayList into String and return the word followed by it’s respective list of line numbers (now a String) 
  public String toString()
  {
    String list = numsList.toString();  //convert numsList into a string
    list = list.substring(1, list.length() - 1);  //Get rid of the brackets at each end, for that it’s displayed after being converted
    return word + " " + list;  //return the word followed by it’s line number list
  }
}

