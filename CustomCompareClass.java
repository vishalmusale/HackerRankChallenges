import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Comparator comp =  new Comparator();

        try{
            int T= Integer.parseInt(br.readLine().trim());
            while (T-->0){
                int ch = Integer.parseInt(br.readLine().trim());
                if(ch==1)
                {
                    String s1=br.readLine().trim();
                    String s2=br.readLine().trim();
                    if(comp.compare(s1,s2))
                    {
                        System.out.println("Same");
                    }
                    else
                    {
                        System.out.println("Different");
                    }
                }
                else if(ch==2)
                {
                    int num1=Integer.parseInt(br.readLine().trim());
                    int num2=Integer.parseInt(br.readLine().trim());
                    if(comp.compare(num1,num2))
                    {
                        System.out.println("Same");
                    }
                    else
                    {
                        System.out.println("Different");
                    }
                }
                else if(ch==3)
                {
                    String len = br.readLine().trim();
                    String s1=br.readLine().trim();
                    String s2=br.readLine().trim();
                    StringTokenizer st = new StringTokenizer(len);
                    StringTokenizer st1 = new StringTokenizer(s1);
                    StringTokenizer st2 = new StringTokenizer(s2);
                    int len1 = Integer.parseInt(st.nextToken());
                    int len2 = Integer.parseInt(st.nextToken());

                    int arr1[]= new int[len1];
                    int arr2[]= new int[len2];
                    for(int i=0; i<len1;i++)
                    {
                        arr1[i] = Integer.parseInt(st1.nextToken());
                    }
                    for(int i=0; i<len2;i++)
                    {
                        arr2[i] = Integer.parseInt(st2.nextToken());
                    }

                    if(comp.compare(arr1,arr2))
                    {
                        System.out.println("Same");
                    }
                    else
                    {
                        System.out.println("Different");
                    }
                }
            }
        }catch (NumberFormatException | IOException e){
            e.printStackTrace();
        }
    }
}

class Comparator{
    //  String Compare 
    //  Using actual comparison instead of using String equals function
    public boolean compare(String a, String b){
        if(a.length() == b.length()){
            for(int i=0; i<a.length(); i++){
                if(a.charAt(i) != b.charAt(i))
                    return false;
            }
            return true;
        }
        else
            return false;
    }

    //  Integer Compare
    public boolean compare(int a, int b){
        if(a==b)
            return true;
        else
            return false;
    }

    //  Array Compare
    public boolean compare(int[] a, int[] b){
        if(a.length == b.length){
            for(int i=0; i<a.length; i++){
                if(a[i] != b[i])
                    return false;
            }
            return true;
        }
        else
            return false;
    }
}