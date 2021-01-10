package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seats = scanner.nextInt();
        System.out.printf("Total income: $%d", calculateProfit(rows, seats));
    }

    public static int calculateProfit(int rows, int seats) {
        int total = rows * seats;
        int price;
        if (total <= 60) {
            price = total * 10;
        } else {
            int part = Math.round(rows/2);
            price = (part * seats * 10) + ((rows - part) * seats * 8);
        }
        return price;
    }
}