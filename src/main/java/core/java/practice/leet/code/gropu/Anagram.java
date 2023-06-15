package core.java.practice.leet.code.gropu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {
    Map<Map<String, Integer>, List<String>> mapOfAnagrms = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
       int i = 0 , j = 1;
       while(j < strs.length){
           isAnagrams(strs[i], strs[j]);
           i = j+1;
           j = i+1;
       }
       return mapOfAnagrms.entrySet().stream().map(a -> a.getValue()).collect(Collectors.toList());
    }
    public Map<Map<String, Integer>, List<String>> isAnagrams(String str1, String str2) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> newMap = null;
        boolean duplicateFlag = false;
        int len = str1.length();
        int count = 1;
        for (int i = 0; i < len; i++) {

            String ch = str1.substring(i , i+1);
            if (!str2.contains(ch) && !duplicateFlag) {
                newMap = new HashMap<>(map);
                duplicateFlag = true;
            }

            createUpdateMap(map, ch, count);
            if (duplicateFlag) createUpdateMap(newMap, str2.substring(i , i+1), count);
        }
        createUpdateMap( mapOfAnagrms, map, str1);
        if (newMap != null) {
            createUpdateMap(mapOfAnagrms, newMap, str2);
        } else {
            createUpdateMap(mapOfAnagrms, map, str2);
        }
        return mapOfAnagrms;
    }

    public Map createUpdateMap( Map<Map<String, Integer>, List<String>> mapOfAnagrms , Map<String, Integer> map, String str) {
        if (mapOfAnagrms.containsKey(map)) {
            List<String> list = new ArrayList<>(mapOfAnagrms.get(map));
            list.add(str);
            mapOfAnagrms.put(map, list);
        } else {
            mapOfAnagrms.put(map, List.of(str));
        }
        return mapOfAnagrms;
    }

    public Map createUpdateMap(Map<String, Integer> map, String ch, int count) {
        if (map.containsKey(ch)) {
            count = map.get(ch);
            map.put(ch, ++count);
        } else {
            map.put(ch, count);
        }
        return map;
    }
}
