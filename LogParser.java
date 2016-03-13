package com.HackerRank.VishalMusale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Vishal Musale on 2/23/2016.
 *
 * HackerRank
 *
 * Log Parser
 *
 * Write a program that will read a log file and calculate the percent of time a player had network connectivity.
 Details
 We have several games that involve connecting to our servers via the network. Mobile network conditions can be very
 different between devices, providers, and so on. For diagnostic reasons it's important to know what portion of the time
 a given player spends actually connected to the network.
 We keep console logs of various game subsystems for each play session. The first line of the log file will be the
 number of lines in the file (for purposes of this test}. Each log message has the following format:
 (MM/dd/yyyy-hh:mm:ss) :: <Message>

 (11/12/2015-02:34:56) :: START
 (01/02/1990-13:10:00) :: DISCONNECTED
 (01/02/1990-15:40:00) :: SHUTDOWN


 */
public class LogParser {

    public static void main(String[] args) throws IOException, ParseException {

        Scanner in = new Scanner(System.in);
        int i=0,no = in.nextInt();
        String[] str = new String[no];
        String res;

        while(i<no){
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                str[i]=reader.readLine();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            i++;
        }

        res = parseLine(str);     // Funtion Call
        System.out.println(res);
    }

    private static long parseLine(String[] lines){


        // Initialization

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
        Date[] dtTm = new Date[lines.length];
        String[] Event = new String[lines.length];

        // Assigning value to Date, Time, Event
        for(int i =0 ; i< lines.length; i++)
        {
            lines[i] = lines[i].replaceAll("\\(","");  // To remove parenthesis
            lines[i] = lines[i].replaceAll("\\)","");  // To remove parenthesis
            lines[i] = lines[i].replaceAll("::","");  // To remove ':'

            String[] dtTmStr = lines[i].split("  ");
            Event[i] = dtTmStr[1];  // Assign Event Name
            try {
                dtTm[i] = format.parse(dtTmStr[0]);     // To get date and time seperate string "MM/dd/yyyy-hh:mm:ss" format
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        //  Internmediate Diff
        long internmediate = internmediateTime(dtTm, Event);
        return Long.parseLong(String.valueOf(internmediate/(timeDiff(dtTm[0], dtTm[dtTm.length-1])) *100));
    }

    private static long internmediateTime(Date[] dtTm, String[] Event){
        long inter = 0;
        if(Event.length>2){
            for(int i=1; i<Event.length; i++){
                if(Event[i]=="Connection"){
                    for(int j=i+1; j<Event.length; j++){
                        if(Event[j]=="DISCONNECT" || Event[j]=="SHUTDOWN"){
                            inter += timeDiff(dtTm[i],dtTm[j]);
                            i=j;
                        }

                    }
                }
            }
            return inter;
        }
        else
            return timeDiff(dtTm[0], dtTm[1]);
    }

    private static long timeDiff(Date d1, Date d2){
        try {
            long diff = (d1.getTime() - d2.getTime()) / 1000;

            return diff;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
