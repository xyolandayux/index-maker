/*
*This class creates and organizes a list of words found in the imputed text file and return them in an alphabetical order. 
*Gets rid of any excess punctuation or blank spaces to make it just an index for words and numbers.
*Created by: Yolanda Yu
*Last modified: April 13th, 2017
*/


import java.util.ArrayList;

public class DocumentIndex extends ArrayList<IndexEntry>
{

  //Constructor of DocumentIndex
  public DocumentIndex()
  {
    super();   //calling constructor from superclass
  }
  
  //Constructor of DocumentIndex with a set capacity 
  public DocumentIndex(int capacity)
  {
    super(capacity);  //calling constructor from superclass
  }

  //Organizes all the words found in an alphabetical order
  private int foundOrInserted(String word)
  { 
    //Compare all the words already in the ArrayList to the new found word, then after comparing, insert the word in the right location based on alphabetical order
    for (int i = 0; i < size(); i++)
    {
      //Compare the word at location i to the new word
      int location = (get(i).getWord()).compareToIgnoreCase(word);
      //if the word is already there, then don’t do anything, just return the location 
      if (location == 0)
      {
        return i;
      }
      //If the new word is bigger than the one in the list at location i, then add the new word to location i, pushing all the words below that down 1 and return i
      else if (location > 0)
      {
        add(i, new IndexEntry(word));
        return i;
      }
    }
    //add the new word to the end of the list and return size()-1 as the location 
    add(new IndexEntry(word));
    return size() - 1;
  }

  //Connect the word and the line number it appears on together into one row
  public void addWord(String word, int num)
  {
    get(foundOrInserted(word)).add(num);
  }

 //Get rid of empty spaces and punctuation of the text file, returning only words
  public void addAllWords(String line, int num)
  {
    String[] str = line.split("\\W+");   //split method separates the texts, with parameter (\\W+) gets rid of everything that is not a letter or number
  //for all of the new word-only string
      for (String updated : str)
    {
      if (!updated.equals("")).   //if it does not equal to blank or empty spaces
        addWord(updated, num); //update the new list of words/texts need to be processed
    }
  }
}  

           
