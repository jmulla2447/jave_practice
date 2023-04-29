package core.java.practice.leet.code;

import java.util.HashMap;

public class IsoMorphicString {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("abb", "exg"));
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<String, String > charMap = new HashMap();
        charMap.put(s.substring(0,1),t.substring(0,1));
        for(int i= 1 ; i < t.length();i++){
            String presentChar = charMap.get(s.substring(i,i+1));
            if(presentChar!= null){
                if(!presentChar.equals(t.substring(i,i+1))){
                    return false;
                }
            }else{
                charMap.put(s.substring(i,i+1),t.substring(i,i+1));
            }
        }
        return true;
    }
}
