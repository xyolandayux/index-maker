/*
*This class contains the main method that runs the whole IndexMaker program. 
*It uses the scanner method to ask the user which file to read, after scanning through the document, 
*this class will output another text document containing a list of all the words capitalized 
*in alphabetical order that appeared in the file, along with a list of line numbers that word has appeared on. 
*Created by : Maria Litvin and Gary Litvin
*Modified by: Yolanda Yu
*Last Modified: April 13th, 2017
*/

//imports of IndexMaker
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class IndexMaker
{
  //Main method of this class, this method ultimately takes a file, reads it and process it with various different other methods to create an output file that display all the words and line(s) they appear on
  public static void main(String[] args) throws IOException
  {
    //Initialize and use a scanner to ask for user’s choice of imputed text file. As well as asking the name of their output file
    Scanner keyboard = new Scanner(System.in);
    String fileName;

    // Get the input text file 
    if (args.length > 0)
      fileName = args[0];
    else
    {
      System.out.print("\nEnter input file name: ");
      fileName = keyboard.nextLine().trim();
    }

    BufferedReader inputFile = new BufferedReader(new FileReader(fileName), 1024);

    //Get/create the output text file/location
    if (args.length > 1)
      fileName = args[1];
    else
    {
      System.out.print("\nEnter output file name: ");
      fileName = keyboard.nextLine().trim();
    }

    PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));

    //Create new a index from DocumentIndex
    DocumentIndex index = new DocumentIndex();

    //This setup the array list’s line number being incremented 
    String line;
    int lineNum = 0;
    while ((line = inputFile.readLine()) != null)
    {
      lineNum++;
      index.addAllWords(line, lineNum);
    }

    //Prints out everything in the index into the output file txt
    for (IndexEntry entry : index)
      outputFile.println(entry);

