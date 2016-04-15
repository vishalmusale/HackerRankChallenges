import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Stack;

public class parenthesisMatch {

	public static void main(String[] args) throws IOException, ParseException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no. of inputs:");
        int n=in.nextInt();

        String[] ipStrings = new String[n];
        String[] ans;
        for(int i=0; i<n; i++){
            ipStrings[i] = in.next();
        }

        ans = braces(ipStrings);

        printFunction(ans);
    }

    private static void printFunction(String[] ans) {
        for(int i =0 ; i<ans.length; i++) {
            System.out.print(ans[i]);
        }
    }

    private static String[] braces(String[] ipStrings) {
        String[] ans = new String[ipStrings.length];

        for(int i =0 ; i<ipStrings.length; i++){
            ans[i]=checkBraces(ipStrings[i]);
        }
        return ans;
    }

    private static String checkBraces(String ip) {
        if(ip.length() ==0)
            return "YESSS";

        Stack<Character> stk = new Stack<>();

        for(int i =0 ; i<ip.length(); i++){
            char c=ip.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stk.push(c);
            }

            if(c==')' || c=='}' || c==']'){

                if(stk.isEmpty())
                    return "NO";

                char tp = stk.peek();
                if(c==')' && tp == '(' || c=='}' && tp == '{' || c==']' && tp == '[')
                    stk.pop();
                else
                    return "NO";
            }
        }
        if(stk.isEmpty())
            return "YES";
        else
            return "NO";
    }
}