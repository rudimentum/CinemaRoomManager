package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        String [][] room = createRoom(enterSize());
        while (true) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "0. Exit\n");
            int choice = scanner.nextByte();
            switch (choice) {
                case 1:
                    printRoom(room);
                    break;
                case 2:
                    buyTicket(room);
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
        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seats = scanner.nextInt();
        return new int[]{rows,seats};
    }
    public static String [][] createRoom(int... sizes) {
        int rows = sizes[0];
        int seats = sizes[1];
        String [][] room = new String[++rows][++seats];
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (i == 0 && j == 0) {
                    room[i][j] = "  ";
                }
                else if (i == 0) {
                    room[i][j] = j + " ";
                } else if (j == 0){
                    room[i][j] = i + " ";
                } else {
                    room[i][j] = "S ";
                }
            }
        }
        return room;
    }

    public static String[][] buyTicket(String [][] room) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number: ");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row: ");
        int seat = scanner.nextInt();
        int rows = room.length - 1;
        int seats = room[rows].length - 1;
        if (room[row][seat].equals("B ")) {
            System.out.println("This seat is occupied! Choose another one!");
        } else {
            room[row][seat] = "B ";
            System.out.println("Ticket price: $" + calculateTicketPrice(rows, seats, row));
        }
        return room;
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
}
