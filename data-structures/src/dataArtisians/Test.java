package dataArtisians;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a grid of ‘grid_size’ * ’grid_size letters, find the set of words that can be formed by starting at any letter
 * in the grid and repeatedly moving one column or row at a time in any direction.
 *
 * So for the grid:
 *
 * C A Z
 * R T H
 * E F F
 *
 * The only valid word is CAT. Diagonal moves are not allowed, so RAT, ARC, CAR, ART, CART and TAR are not valid words.
 * Grid positions may not be used more than once in a word  (i.e. no doubling back).
 * Any length letter word
 * Dict of valid words {"CAT", "RAT"} is given
 */


public class Test
{
    private Set<String> result;
    private Set<String> validWords;
    private char[][] grid;
    private Integer size;


    public Test(Set<String> validWords, char[][] grid)
    {
        this.result = new HashSet<>();
        this.validWords = validWords;
        this.grid = grid;
        this.size = grid.length;
    }

    public Set<String> getResult()
    {
        return result;
    }

    public boolean isValidPos(int i, int j) {
        if(i >=0 && i < size && j >= 0 && j < size) {
            return true;
        } else {
            return false;
        }
    }
    public void findValidWords(int i, int j, StringBuilder currWord, boolean[][] visited) {
        if(isValidPos(i, j) && !visited[i][j]) {
            visited[i][j] = true;
            currWord.append(grid[i][j]);
            if(this.validWords.contains(currWord.toString())) {
                result.add(String.valueOf(currWord.toString()));
            }
        } else {
            return;
        }
        findValidWords(i+1, j, currWord,  visited);
        findValidWords(i-1, j, currWord,  visited);
        findValidWords(i, j+1, currWord, visited);
        findValidWords(i, j-1, currWord, visited);
        if(currWord.length() > 0) {
            currWord.deleteCharAt(currWord.length() -1);
        }
        visited[i][j] = false;
    }
    public static void main(String[] args)
    {
        System.out.println("Hello");
        char[][] grid = new char[][] {{'C', 'A', 'T'},
                                        {'R', 'T', 'T'},
                                        {'E', 'F', 'F'}};
        Set<String> valid = new HashSet<>();
        valid.add("CAT");
        valid.add("RAT");
        valid.add("TAT");
        Test test = new Test(valid, grid);
        for(int i=0; i< grid.length ;i++) {
            for(int j=0 ; j<grid.length;j++) {
                boolean[][] visited = new boolean[grid.length][grid.length];
                test.findValidWords(i, j, new StringBuilder(), visited);
            }
        }
        System.out.println(test.getResult());
    }
}
