// Name: Yutao Ren
// USC NetID: yutaoren
// CS 455 PA4
// Fall 2017


/**
 * A table about Scrabble scores for scrabble letters and words.
 * Letters that occur more often in the English language are worth less
 * and letters that occur less often are worth more. upper and lower 
 * case versions of the letters will have the same value.
 */

public class ScoreTable {
    
    private int[] score;
    
    public ScoreTable() {
        
        score = new int[26];
        
        for(int i = 0; i < 26; i++) {
            
            //1 point: A, E, I, O, U, L, N, S, T, R 
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20 || 
               i == 11 || i == 13 || i == 18 || i == 19 || i == 17) {
                score[i] = 1;
            }
            //2 points: D, G
            else if(i == 3 || i == 6) {
                score[i] = 2;
            }
            //3 points:B, C, M, P
            else if(i == 1 || i == 2 || i == 12 || i == 15) {
                score[i] = 3;
            }
            //4 points: F, H, V, W, Y
            else if(i == 5 || i == 7 || i == 21 || i == 22 || i == 24) {
                score[i] = 4;
            }
            //5 points: K
            else if(i == 10) {
                score[i] = 5;
            }
            //8 points: J, X
            else if(i == 9 || i== 23) {
                score[i] = 8;
            }
            //10 points: Q, Z
            else if(i == 16 || i == 25) {
                score[i] = 10;
            }
            
        }
    }
    
    
    /**
     * Get the total score of word according to the value of specific letters.
     * Upper and lower case versions of the letters will have the same value.
     * 
     * @param words  word that needed to get scores
     * @return  the score of word
     */
    public int getScore(String words) {
        
        String lowerCaseWords = words.toLowerCase();
        int score = 0;
        
        for(int i = 0; i < lowerCaseWords.length(); i++) {
            score += this.score[lowerCaseWords.charAt(i) - 'a'];
        }
        
        return score;
    }  
}
