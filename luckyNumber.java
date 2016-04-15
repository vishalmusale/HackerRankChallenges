import java.util.Scanner;

public class luckyNumber {

	public static void main(String[] args) throws IOException, ParseException{
		int size = in.nextInt();
        int[] ip = new int[size];
        int[] temp = new int[size];

        //  Input
        for(int i=0; i<size; i++){
            ip[i]=in.nextInt();
            temp[i] = divisor(ip[i]);   //  To find the divisors
        }

        //  Print Array
        printArray(temp);
    }
	
	private static int divisor(int x) {
        int count=0;
        //  to check from 3 to num/2
        for(int i=3; i<x/2 + 1; i++){
            if(x%i==0){
                if(checkLucky(Integer.toString(i)))
                    count++;
            }
        }
        
        //  to check the number itself
        if(checkLucky(Integer.toString(x)))
            count++;

        return count;
    }

    private static boolean checkLucky(String x) {
        for(int i=0; i<x.length(); i++){
            if(x.charAt(i)=='5'||x.charAt(i)=='3')
                return true;
        }
        return false;
    }

    private static void printArray(int[] arr) {
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
