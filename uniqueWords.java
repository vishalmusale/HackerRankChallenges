import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class Testing {
    public static void main(String[] args){
        Set<String> uniqueWords = new HashSet<String>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        uniqueWords.addAll(permutation("", "abba", uniqueWords));

        TreeSet sortedwords = new TreeSet();
        sortedwords.addAll(uniqueWords);

        int j=0;
        Iterator<String> itr=sortedwords.iterator();
        while(itr.hasNext()) {
            String s = itr.next();
            hm.put(s, j);
            j++;
        }

        Set set = hm.entrySet();
        Iterator i = set.iterator();

        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        System.out.print(hm.get("abba"));
        double a= Math.pow(10,9);
        System.out.print(a);
    }

    public static Set<String> permutation(String prefix, String str, Set<String> words) {
        int n = str.length();
        if (n == 0){
            words.add(prefix);
            return words;
        }
        else {
            for (int i = 0; i < n; i++)
                words.addAll(permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), words));
        }
        return words;
    }
}