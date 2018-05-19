// Name: Yutao Ren
// USC NetID: yutaoren
// CS 455 PA4
// Fall 2017

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * A Rack of Scrabble tiles
 */

public class Rack {
   
    private String unique;
    private int[] mult;


    public Rack(String s) {      
        
        unique = "";
        getUnique(s);       
    }
    
    
    /**
     * Get all subsets of rack
     * 
     * @return  list of all subsets of rack
     */
    public ArrayList<String> getAllSubsets() {
        
        //make copy of ArrayList to avoid side effect.
        return new ArrayList<>(allSubsets(unique, mult, 0));
        
    }
    
    
   /**
    * Finds all subsets of the multiset starting at position k in unique and mult.
    * unique and mult describe a multiset such that mult[i] is the multiplicity of the char
    *      unique.charAt(i).
    * PRE: mult.length must be at least as big as unique.length()
    *      0 <= k <= unique.length()
    *      
    * @param unique a string of unique letters
    * @param mult the multiplicity of each letter from unique.  
    * @param k the smallest index of unique and mult to consider.
    * @return all subsets of the indicated multiset
    * @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }
   
   
   /**
    * Get string of unique letters for rack and multiplicity of each letter from string.
    * Use treeMap to compute the multiplicity of letter.use unique letter as key, 
    * use multiplicity of each letter as value. Iterate the entry set of map, get value
    * of multiplicity and store the value in array.
    * 
    * PRE: mult.length must be at least as big as unique.length()
    * 
    * @param s  given rack
    */
   private void getUnique(String s) {
       
       //convert string into an array of characters so that we can sort the string
       char[] charOfString = s.toCharArray();
       Arrays.sort(charOfString);
       
       //use map to compute the multiplicity of letter 
       //use unique letter as key, use multiplicity of each letter as value 
       TreeMap<Character, Integer> map = new TreeMap<>();
       
       for(char character : charOfString) {
           Integer num = map.get(character);
           map.put(character, num == null ? 1 : num + 1);
       }

       Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
       
       mult = new int[map.size()];
       
       for(int i = 0; i < mult.length; i++) {
           
           Map.Entry<Character, Integer> entry = iter.next();
           
           mult[i] = entry.getValue();
           
           //use toString to Return a String object representing the Character's value
           unique += Character.toString(entry.getKey());
      
       }
   }
}
