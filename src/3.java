import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution3 {
    char[][] mapping = new char[][]{
            {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y','z'} };
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return new ArrayList<>();
        List<String> results = new ArrayList<>();
        char[] chars = digits.toCharArray();
        addChar(chars, 0, "", results);
        return results;
    }

    void addChar(char[] chars, int i, String current, List<String> results) {
        if(i == chars.length) {
            results.add(current);
            return;
        }
        char[] chars1 = mapping[chars[i] - '2'];
        for(int j = 0; j< chars1.length; j++) {
            addChar(chars, i+1, current + chars1[j], results);
        }
    }

    @Test
    public void tt() {
        assertTrue(letterCombinations("23").containsAll(List.of("ad","ae","af","bd","be","bf","cd","ce","cf")));
        assertEquals(0, letterCombinations("").size());
    }

}