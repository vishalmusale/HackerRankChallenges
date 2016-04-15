import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class decNumComplement {

	public static void main(String[] args) throws IOException, ParseException {
        int number;
        int[] binString;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a positive integer");
        number = in.nextInt();

        binString=decToBinAndComplement(number);

        System.out.println(binToDec(binString));
    }

    private static int[] decToBinAndComplement(int number) {
        int i = 0, cur_i = 0;
        int[] binString;
        while (Math.pow(2, i) <= number) {
            cur_i = i;
            i++;
        }
        number -= Math.pow(2, cur_i);

        binString = new int[cur_i + 1];
        binString[cur_i] = 1;
        binString = covertBin(number, cur_i - 1, binString);

        for (i = 0; i < binString.length; i++) {
            if (binString[i] == 1)
                binString[i] = 0;
            else
                binString[i] = 1;
        }

        return binString;
    }

    private static int[] covertBin(int num, int power, int[] binString) {

        if(num==0)
            return binString;
        else{
            while(power>=0){
                if(num==0)
                    return binString;
                if(Math.pow(2,power)<=num){
                    binString[power]=1;
                    num-=Math.pow(2,power);
                    power--;
                }
                else
                    power--;
            }
        }
        return binString;
    }

    private static int binToDec(int[] binString) {
        int num=0;

        for (int i = 0; i < binString.length; i++) {
            if (binString[i] == 1)
                num+=Math.pow(2,i);
        }
        return num;
    }
}