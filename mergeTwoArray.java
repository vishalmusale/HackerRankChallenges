import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException, ParseException{
		//  Input
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] a = new int[size];
        int[] b = new int[size];

        for(int i=0; i<size; i++){
            a[i]= in.nextInt();  //  Converting String into int
        }
        for(int i=0; i<size; i++){
            b[i]= in.nextInt();  //  Converting String into int
        }


        merge(a,b);
	}

    private static void merge(int[] a, int[] b) {
        int[] tempArr = new int[a.length *2];
        int i=0, j=0, k=0;

        for(; i<a.length && j<b.length;k++){
            if (a[i] < b[j]) {
                tempArr[k] = a[i];
                i++;
            }
            else {
                tempArr[k] = b[j];
                j++;
            }
        }

        while(i<a.length){
            tempArr[k] = a[i];
            k++;
            i++;
        }
        while(j<b.length){
            tempArr[k] = b[j];
            k++;
            j++;
        }


        printFuniction(tempArr);
    }

    public static void printFuniction(int[] x){
        for(int i=0; i<x.length; i++){
            System.out.println(x[i]);
        }
    }
}