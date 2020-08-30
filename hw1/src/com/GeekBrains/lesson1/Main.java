package com.GeekBrains.lesson1;

import java.util.Scanner;

//STEP1
public class Main {
    public static void main(String[] args) {
	// STEP2, let's initialize variables

        byte var1= 1;
        int var2=5;
        short var3;
        long var4=11000000000l;
        float var5= 1.234f;
        double var6;

        // STEP3 initial var for superCalc
        int a =3;
        int b=2;
        int c=5;
        int d=-8;
        int result_c =  superCalc(a,b,c,d);

        //Output result and input for all steps
        System.out.println("Step 3 a="+a);
        System.out.println("Step 3 b="+b);
        System.out.println("Step 3 c="+c);
        System.out.println("Step 3 d="+d);
        System.out.println("Step 3 Use this formula to calc result: a * (b + (c / d)): ");
        System.out.println("RESULT:" +result_c);
        System.out.println("");
        System.out.println("RESULT: Is it correct that sum of this numbers between 10 and 20?: "+isEqual());
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.println("Step 5, please enter the positive or negative number");
        var2 = input.nextInt();
        isNumberNegative2(var2);
        System.out.println("");
        Scanner input2 = new Scanner(System.in);
        System.out.println("Step 6, please enter the positive or negative number");
        var2 = input2.nextInt();
        System.out.println("RESULT: Statement that this number negative is "+isNumberNegative(var2));
        System.out.println("");
        System.out.println("Step 7, Enter your name, please: ");
        Scanner sc = new Scanner(System.in);
        String str1= sc.nextLine();
        greeting(str1);
        System.out.println("");
        Scanner input3 = new Scanner(System.in);
        System.out.println("Step 8, please enter the year:");
        var2 = input3.nextInt();
        leapYearChecker(var2);
        System.out.println("");
    }
    // step3, let's make dummy calc method
    static int superCalc (int a, int b, int c, int d)
    {
        int result = 0;
        result=a * (b + (c / d));
        return result;
    }

    // step 4, compare result sum of two arguments
    static boolean isEqual ()
    {
       int num1;
       int num2;
       boolean compare_result=false;
       Scanner input = new Scanner(System.in);
       System.out.println("Step 4, please enter the first number");
       num1 = input.nextInt();
       System.out.println("Step 4, please enter the second number");
       num2 = input.nextInt();
       //check that sum of this number between 10 and 20
       if (10<num1+num2 && num1+num2<=20)
    {
           compare_result=true;
    }
       return compare_result;
    }
    // step 6, check negative or positive number entry
    static boolean isNumberNegative(int var2)
    {
        boolean checker_result=false;
        if (var2<0)
       {
           checker_result=true;
       }
    return checker_result;
    }

    // step5, print result after check number
    static void isNumberNegative2(int var10)
    {
       if (var10<0)
       {
           System.out.println("RESULT: This number is negative");
       }
       else
       {
           System.out.println("RESULT: This number is not negative, try again...");
       }
    }
    // step7, print greeting
    static void greeting(String var20)
    {
        System.out.println("RESULT: Ohayo Gozaimas "+var20+"!");
    }
    //step 8, check leap year

    static void leapYearChecker(int year_n)
    {

        if ((year_n % 4 == 0) && year_n % 100 != 0)
        {
            System.out.println("RESULT: "+year_n + " is a leap year.");
        }
        else if ((year_n % 4 == 0) && (year_n % 100 == 0) && (year_n % 400 == 0))
        {
            System.out.println("RESULT: "+year_n + " is a leap year.");
        }
        else
        {
            System.out.println("RESULT: "+year_n + " is not a leap year.");
        }
    }

}
