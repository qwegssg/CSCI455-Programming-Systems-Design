// Name: Yutao Ren
// USC NetID: yutaoren
// CS 455 PA4
// Fall 2017

import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/**
 * A dictionary of all anagram sets. 
 * Note: the processing is case-sensitive; so if the dictionary has all lower
 * case words, you will likely want any string you test to have all lower case
 * letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
    
    private HashMap<String, ArrayList<String>> anagramDict;
    

   /**
    * Create an anagram dictionary from the list of words given in the file
    * indicated by fileName.  
    * PRE: The strings in the file are unique.
    * 
    * @param fileName  the name of the file to read from
    * @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
         
       Scanner in = new Scanner(new File(fileName));
       anagramDict = getAnagramDict(in);          

   }
   

   /**
    * Get all anagrams of the given string. This method is case-sensitive.
    * E.g. "CARE" and "race" would not be recognized as anagrams.
    * 
    * @param s string to process
    * @return a list of the anagrams of s
    * 
    */
   public ArrayList<String> getAnagramsOf(String s) {
       
       String canon = getCanon(s);
       
       if(anagramDict.containsKey(canon)) {
           
           //avoid side effect
           return new ArrayList<String>(anagramDict.get(canon));
           
       }
       else {
           return new ArrayList<String>();
       }
   }
   
   
   /**
    * Get the canonical form of given string, that is, a sorted version 
    * of the characters in the word.
    * 
    * @param s    given string needed to be sorted
    * @return   canonical form of given string 
    */
   private String getCanon(String s) {
       
       //convert string into an array of characters so that we can sort the string
       char[] charOfString = s.toCharArray();
       Arrays.sort(charOfString);
       return String.valueOf(charOfString);
       
   }
   
   
   /**
    * Get the Dictionary of anagrams. Use HashMap to represent dictionary. 
    * use the canonical form of given string as key, use ArrayList, which 
    * stores the anagrams of the string.
    * convert string into the canonical form of key. If key already exists in map, 
    * then add the string to the corresponding ArrayList; If key doesn't exist,
    * creates a new ArrayList with the string.  
    * 
    * @param in  input of word list
    * @return  map of anagram dictionary
    */
   private HashMap<String, ArrayList<String>> getAnagramDict(Scanner in) {
       
       HashMap<String, ArrayList<String>> dict = new HashMap<>(); 
       String tempString = "";
       String tempCanon = "";
       
       while(in.hasNext()) {
     
           tempString = in.next();
           
           //get the key (canonical form) of map
           tempCanon = getCanon(tempString);
           
           ArrayList<String> tempList = new ArrayList<String>();

           if(!dict.containsKey(tempCanon)) {              
               tempList.add(tempString);
               dict.put(tempCanon, tempList);              
           }
           else {
               //get the value (list of anagrams) towards the key
               tempList = dict.get(tempCanon);
               tempList.add(tempString);
               dict.put(tempCanon, tempList);
           }          
       }

       return dict;
   }  
}
