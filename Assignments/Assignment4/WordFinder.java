// Name: Yutao Ren
// USC NetID: yutaoren
// CS 455 PA4
// Fall 2017

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * WordFinder Class
 * 
 * Give some letters to comprise a Scrabble rack, creates a list of all legal words that 
 * can be formed from the letters on that rack.Display all such words, with the corresponding 
 * Scrabble score for each word, in decreasing order by score.For words with the same scrabble score, 
 * the words appear in alphabetical order.
 */

public class WordFinder {

    public static void main(String[] args) {

        String fileName = "sowpods.txt";
        
        if (args.length > 0) {
            fileName = args[0];
        }
        
        try {
            AnagramDictionary ad = new AnagramDictionary(fileName);
            findWords(ad);
        }
        catch(FileNotFoundException e) {
            System.out.println("Could not open input file: " + fileName);
        }
    }
    

    /**
     * Get the canonical form of given string, that is, a sorted version 
     * of the characters in the word.
     * 
     * @param s    given string needed to be sorted
     * @return   canonical form of given string 
     */
    private static String getCanon(String s) {
        
        //convert string into an array of characters so that we can sort the string
        char[] charOfString = s.toCharArray();
        Arrays.sort(charOfString);
        return String.valueOf(charOfString);
        
    }

    
    /**
     * Find and display all the words that be formed from the letters on the rack , 
     * with the corresponding Scrabble score for each word, in decreasing order by score.
     * For words with the same scrabble score, the words appear in alphabetical order.
     * 
     * @param ad  dictionary of anagrams
     */
    private static void findWords(AnagramDictionary ad) {
        
        System.out.println("Type . to quit.");        
        System.out.print("Rack? ");
        
        Scanner in = new Scanner(System.in);       

        while(in.hasNext()) {

            String input = in.next();
            
            if(input.equals(".")) {
                System.exit(0);
            }
            
            Rack rack = new Rack(input);
            
            ArrayList<String> subsetsList = rack.getAllSubsets();           
            ArrayList<String> anagramsList = new ArrayList<>();
            
            for(String string : subsetsList) {
                anagramsList.addAll(ad.getAnagramsOf(string));
            }

            ArrayList<Map.Entry<String, Integer>> entryList = getWordsAndScores(anagramsList);

            System.out.println("We can make " + entryList.size() + " words from \"" + getCanon(input) + "\"");
            
            if(entryList.size() != 0) {
                System.out.println("All of the words with their scores (sorted by score): ");
            } 
            
            for (Map.Entry<String, Integer> curr : entryList) {
                System.out.println(curr.getValue() + ": " + curr.getKey());
            }
            
            System.out.print("Rack? ");
        }
    }
    
    
    /**
     * Use TreeMap to represent all the words and scores. 
     * Use words as key, scores as value. Sort the entries in 
     * decreasing order by score.
     * 
     * @param anagramsList  
     * @return  sorted entry list
     */
    private static ArrayList<Map.Entry<String, Integer>> getWordsAndScores(ArrayList<String> anagramsList) {
      
        TreeMap<String, Integer> anagramsMap = new TreeMap<>();
        
        ScoreTable score = new ScoreTable();
        
        for(String string : anagramsList) {
            anagramsMap.put(string, score.getScore(string));
        }
        
        ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>();
        
        entryList.addAll(anagramsMap.entrySet());
        
        Collections.sort(entryList, new ScoreComparator());
        
        return entryList;
    }
}


/**
 * Implement Comparator Interface. 
 * Compare the value of entry so as to sort the entry in decreasing order of scores.
 */
class ScoreComparator implements Comparator<Map.Entry<String, Integer>> {   
    
    public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){
        return b.getValue() - a.getValue();
    }
}
