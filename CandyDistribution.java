package com.HackerRank.VishalMusale;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import static java.lang.Integer.*;

/**
 * Created by vishal on 2/24/2016.
 *
 * https://www.hackerrank.com/challenges/candies
 *
 */
public class CandyDistribution {
    public static void main(String[] args) throws IOException, ParseException {

        //  Input
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] a = new int[size];

        for(int i=0; i<size; i++){
            a[i]= in.nextInt();  //  Converting String into int
        }

        System.out.println(distributeCandy(a));
    }

    static int distributeCandy(int[] score) {

        int[] candyArray = new int[score.length];

        for(int i=0; i<score.length; i++){
            candyArray[i] = 1;      //   Initialize the array with 1
        }

        //  from left to right
        for(int i=1; i<score.length; i++){
            if (score[i] > score[i-1]){
                candyArray[i] = candyArray[i-1] + 1;
            }
        }

        //  from right to left
        for(int i=score.length-2; i>=0; i--){
            if (score[i] > score[i+1]){
                candyArray[i] = Math.max(candyArray[i], candyArray[i+1] + 1);
            }
        }

        //  calculating total number of candies
        int sum=0;
        for (int i: candyArray
                ) {
            sum+=i;
        }

        return sum;
    }
}
