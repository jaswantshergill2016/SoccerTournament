package Test;

import java.util.Scanner;

class MySchedule {
    final int MAXSIZE = 32;
    int A[][]; //reference variable
    int max; //number of integers in A, <= MAXSIZE
    int row = 1; //keeps track of rows during recursion, row 0 set during user input

    //constructor
    MySchedule() {
        A = new int[MAXSIZE] [MAXSIZE];
        max = 0;
    }

    /*
    if teams = 4, then movements per row are: 2^0, 2^1, 2^0
    if teams = 8: 2^0, 2^1, 2^0, 2^2, 2^0, 2^1, 2^0
    (n/2) gives us the correct power to calculate movements
    for each value of n, we move n places in either direction
    for loop iterates ever 2*n
    outer loop is for each iteration
    inner loops are each number of movements for each iteration
    */
    void schedule(int n) {
        if (n >= 1) {
            schedule(n/2);
            //start at column 0 for each row
            int col = 0;
            for (int i = 0; i < max; i += (2*n)) {
                //current position uses value from previous n rows/columns.
                for (int j = 0; j < n; j++)
                    A[row][col+j] = A[row-n][col+j+n];
                for (int j = n; j < n*2; j++)
                    A[row][col+j] = A[row-n][col+j-n];
                col += 2*n;
            }
            row++;
            if (n > 1)
                schedule(n/2);
        }
    }

    void printA() {
        //print header, then print team schedule
        System.out.printf("%4s", "day");
        System.out.printf("%12s", "teams");
        System.out.println();
        printA(max-1);
    }

    void printA(int n) {
        if (n >= 0) {
            printA(n-1);
            //n=0 is the row to list the teams.  
            //Following rows indicate which team they play on which day
            if (n == 0)
                System.out.printf("%4s", "");
            if (n >= 1)
                System.out.printf("%4s", "D"+n);
            for (int c = 0; c < max; c++)
                System.out.printf("%3d", (A[n][c]));
            System.out.println();
        }
    }
}

public class Hw10 {
    //determine if n is a 2's power
    static boolean isPow(int n) {
        while (n > 1) {
            if (n%2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int teams;

        //prompt user input for teams and print schedule
        do {
            System.out.print("How many teams (0 to exit): ");
            teams = in.nextInt();
            //check to make sure user input is a power of 2.
            do {
                if (isPow(teams) == false) {
                    System.out.println("Invalid input, must be a power of 2.");
                    System.out.print("How many teams (0 to exit): ");
                    teams = in.nextInt();
                }
            } while (isPow(teams) == false);

            //initialize array to avoid out of bounds errors on repeat tries
            MySchedule sched = new MySchedule();

            //initialize first row of array with number of teams
            for (int i = 0; i < teams; i++)
                sched.A[0][i] = i+1;
            sched.max = teams;

            sched.schedule(teams/2);
            sched.printA();
            System.out.println();
        } while (teams > 0);
    }
}