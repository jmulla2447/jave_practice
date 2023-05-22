package core.java.practice.leet.code;

public class PalindromeCheck {

    public boolean isPalindrome(int no) {
        // first condition  -121 -> 121- this not palindrom
        // 0 then it is palindrom but 120 is not 2nd condition check this
        if (no < 0 || (no % 10 == 0 && no != 0)) return false;
        int reverseNo = 0;

        while (no > reverseNo) { //121>0    12> 1
            reverseNo = reverseNo * 1 + no % 10; //0+1   1+20=21
            no = no / 10; //12    1
        }
        return reverseNo == no || no == reverseNo / 10;
    }

    public boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) { // madam  i = m  j = m  i =a j = a
            if(chars[i] != chars[j]) return false;
        }
        return  true;

    }
}
