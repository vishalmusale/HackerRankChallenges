import java.util.HashMap;
import java.util.Scanner;

public class firstRepeatedWord {
    public static void main(String args[]){

        // Input
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();

        //  Initialization
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String[] ipWords = ip.split("\\s\\.,:;-]+");

        //  Checking and inserting into hashmap
        for(int i=0; i<ipWords.length; i++)
        {
            if(hm.containsKey(ipWords[i])){
                System.out.println(ipWords[i]);
            }
            else{
                hm.put(ipWords[i], 0);
            }
        }
    }
}
