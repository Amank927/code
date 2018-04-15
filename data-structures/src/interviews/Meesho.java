package interviews;

import java.util.Scanner;

public class Meesho
{

    static void printMinMaxDispatchDates(String dispatchString, String orderDateString, String holidaysString) {
        System.out.println(dispatchString);

        int minDays=1,maxDays=0 ;
        if (dispatchString.contains("-")) {
            minDays = Integer.valueOf(dispatchString.substring(13 , dispatchString.indexOf('-') -1 ));
            maxDays = Integer.valueOf(dispatchString.substring(dispatchString.indexOf('-')), dispatchString.lastIndexOf(' '));
        } else if (dispatchString.contains("on")) {
        } else {
            minDays = Integer.valueOf(dispatchString.substring(13, dispatchString.lastIndexOf(' ')));
            maxDays = minDays;
        }
        System.out.println(minDays +"   " + maxDays);
    }


    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        String dispatchString;
        try {
            dispatchString = in.nextLine();
        } catch (Exception e) {
            dispatchString = null;
        }

        String orderDateString;
        try {
            orderDateString = in.nextLine();
        } catch (Exception e) {
            orderDateString = null;
        }

        String holidaysString;
        try {
            holidaysString = in.nextLine();
        } catch (Exception e) {
            holidaysString = null;
        }

        printMinMaxDispatchDates(dispatchString, orderDateString, holidaysString);

    }
}

