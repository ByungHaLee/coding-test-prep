import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


//https://leetcode.com/problems/regular-expression-matching/

class Solution2 {
    public boolean isMatch(String s, String p) {
        if( s.equals(p))
            return true;

        List<Integer> starIndexes = new ArrayList<>();
        for(int i=0; i<p.lastIndexOf("*");) {
            i = p.indexOf("*", i+1);
            starIndexes.add(i);
        }

        List<String> staticStringList = new ArrayList<>();
        for(int i=0; i<starIndexes.size(); i++) {
            if(i == 0 && starIndexes.get(i)>1){
                staticStringList.add(p.substring(0, starIndexes.get(i)-1));
            }
//            if(starIndexes.get(i+1) - starIndexes.get(i))
        }

        String sString = s;
        for(int i=0; i<=starIndexes.size(); i++) {
            if(i == starIndexes.size()) {
                Integer starIndex = starIndexes.get(i - 1);
                break;
            }
            Integer prevStarIndex = i==-1?0:starIndexes.get(i);
            Integer nextStarIndex = starIndexes.get(i);
            if(nextStarIndex - prevStarIndex > 2) {
                String staticString = p.substring(prevStarIndex + 1, nextStarIndex - 1);
                if(!sString.startsWith(staticString))
                    return false;
                sString = sString.substring(staticString.length());
            }
            String matchChar = p.substring(nextStarIndex - 1, nextStarIndex);
        }

        return true;
    }

    @Test
    public void tt() {
//        assertEquals(false, isMatch("aa", "p"));
//        assertEquals(true, isMatch("aa", "a*"));
//        assertEquals(true, isMatch("ab", ".*"));
        assertEquals(true, isMatch("aaaaaaa", "aa.*"));
        assertEquals(true, isMatch("aaaabbbbbcccc", "a*b*c*"));
        assertEquals(true, isMatch("aaaabbbbbcccc", "a*.*c*"));
        assertEquals(true, isMatch("aaaabbbbbcccc", "a*/aab/b*/c*"));
    }

    @Test
    public void t1t() {

        // constant * constant
        //  a*b*c*
    }
}