package core.java.practice.leet.code;

public class CharacterReplacement {
    public int longesSubstringReplacement(String s, int k) {
        char[] tokens = s.toCharArray();
        int i = 0;
        int j = i + 1;
        int longestString = 0;
        int tempK = k;
        boolean isComputed = false;
        while (j <= tokens.length - 1) {
            if (tempK != 0 || tokens[i] == tokens[j]) {
                if (tokens[i] != tokens[j]) {
                    tempK--;
                }
                j++;
                isComputed = false;
            } else {
                isComputed = true;
                longestString = Math.max(longestString, j - i);
                if (longestString > (tokens.length) - j) break;
                i = tempK==0 ? j: j + 1;
                j = i + 1;
            }
        }
        return isComputed ? longestString : j-i;
    }

}
