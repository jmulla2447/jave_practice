package core.java.practice.leet.code2;

public class LongestPlindormString {
    private String palindorm;
    private int maxLen = 1;

    public String fetchMaxPlindrom(String str) {
        findPivotal(0, str.length() - 1, str);
        if (maxLen == 1) palindorm = str.substring(0, 1);
        return palindorm;
    }

    private void findPivotal(int i, int j, String str) {
        if (i >= j) return;
        if (str.length() <= 3) {
            if (str.charAt(i) == str.charAt(j) && maxLen < (j - i)) {
                maxLen = (j - i);
                palindorm = str;
            } else {
                return;
            }
        }
        int pivotal = (i + j) / 2;
        if (str.charAt(pivotal - 1) == str.charAt(pivotal + 1)) {
            fetchPalindrom(pivotal - 1, pivotal + 1, str);
        } else if (str.charAt(pivotal - 1) == str.charAt(pivotal)) {
            fetchPalindrom(pivotal - 1, pivotal, str);
        } else if (str.charAt(pivotal) == str.charAt(pivotal + 1)) {
            fetchPalindrom(pivotal, pivotal + 1, str);
        }

        checkStartingStringPalidnrom(str.substring(i, pivotal - 2));
        checkStartingStringPalidnrom(str.substring(pivotal + 2, j));
    }

    private void checkStartingStringPalidnrom(String str) {
        if ((str.length()) > 3) {
            findPivotal(0, str.length() - 1, str);
        }
    }

    private void fetchPalindrom(int start, int end, String str) {
        int strLen = str.length();
        for (int i = start, j = end; (i >= 0 && j < strLen); i--, j++) {
            if (str.charAt(i) != str.charAt(j)) {
                if (maxLen < (j - i - 1)) {
                    maxLen = (j - i - 1);
                    palindorm = str.substring(i + 1, j);
                }
                checkStartingStringPalidnrom(str.substring(0, j));
                checkStartingStringPalidnrom(str.substring(j, strLen));
            }
        }
    }
}
