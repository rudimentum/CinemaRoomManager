package cinema;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        RoomMaker roomMaker = new RoomMaker(enterSize());
        String [][] room = roomMaker.createRoom();
        while (true) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit\n");
            int choice = scanner.nextByte();
            switch (choice) {
                case 1:
                    printRoom(room);
                    break;
                case 2:
                    buyTicket(room);
                    break;
                case 3:
                    printStatistics(room);
                    break;
                case 0:
                    return;
            }
        }
    }
    /*
    if the total number of seats is not more than 60, then the price is 10 dollars
    in larger rooms the tickets are 10 dollars for the front half of the rows
    and 8 dollars for the back half
     */
    public static int calculateTicketPrice(int rows, int seats, int currentRow) {
        int total = rows * seats;
        int price;
        if (total <= 60) {
            price = 10;
        } else {
            int part = Math.round(rows/2);
            price = currentRow <= part ? 10 : 8;
        }
        return price;
    }
    public static int[] enterSize() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number of rows: ");
            int rows = scanner.nextInt();
            System.out.println("Enter the number of seats in each row: ");
            int seats = scanner.nextInt();
            return new int[]{rows,seats};
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Use integers!");
            return enterSize();
        }
    }

    public static String[][] buyTicket(String [][] room) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter a row number: ");
                int row = scanner.nextInt();
                System.out.println("Enter a seat number in that row: ");
                int seat = scanner.nextInt();
                int rows = room.length - 1;
                int seats = room[rows].length - 1;
                if (row > rows || seat > seats) {
                    System.out.printf("Wrong input!");
                } else if ("B ".equals(room[row][seat])) {
                    System.out.println("That ticket has already been purchased!");
                } else {
                    room[row][seat] = "B ";
                    System.out.println("Ticket price: $" + calculateTicketPrice(rows, seats, row));
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input! Use integers!");
        } finally {
           return room;
        }
    }

    public static void printRoom(String [][] room) {
        System.out.println("Cinema:");
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                System.out.print(room[i][j]);
            }
            System.out.println();
        }
    }

    public static int calculateIncome(String[][] room, int amount) {
        int rows = room.length - 1;
        int seats = room[rows].length - 1;
        int total = rows * seats;
        int part = Math.round(rows / 2);
        int income = 0;
        if (amount == total) {
            if (amount <= 60) {
                income = amount * 10;
            } else {
                income = (part * seats * 10) + ((rows - part) * seats * 8);
            }
        } else {
            for (int i = 0; i < room.length; i++) {
                for (int j = 0; j < room[i].length; j++) {
                    if ("B ".equals(room[i][j])) {
                        income = i <= part ? income + 10 : income + 8;
                    }
                }
            }
        }
        return income;
    }

    public static int getPurchased(String[][] room) {
        int purchased = 0;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                purchased = "B ".equals(room[i][j]) ? ++purchased : purchased;
            }
        }
        return purchased;
    }

    public static void printStatistics(String[][] room) {
        int rows = room.length - 1;
        int seats = room[rows].length - 1;
        int total = rows * seats;
        int purchased = getPurchased(room);
        System.out.printf("Number of purchased tickets: %d%n", purchased);
        float percentageOccupancy = (float) purchased / total * 100;
        System.out.printf("Percentage: %.2f%%%n", percentageOccupancy);
        System.out.printf("Current income: $%d%n", calculateIncome(room, purchased));
        System.out.printf("Total income: $%d%n", calculateIncome(room, total));
    }
}
