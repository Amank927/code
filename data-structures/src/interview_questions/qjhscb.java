package interview_questions;

import java.util.Scanner;

public class qjhscb
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        int num = Integer.parseInt(str);
        System.out.println(num);
        StringBuilder res = new StringBuilder();
        res.reverse().toString();
        String[] lines = res.toString().split("~n");
    }
}
