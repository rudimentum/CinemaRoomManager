package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoomMaker roomMaker = new RoomMaker();
        roomMaker.setSizes(RoomManager.enterSize());
        String[][] room = roomMaker.getRoom();
        while (true) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit\n");
            int choice = scanner.nextByte();
            switch (choice) {
                case 1:
                    RoomManager.printRoom(room);
                    break;
                case 2:
                    RoomManager.buyTicket(room);
                    break;
                case 3:
                    RoomManager.printStatistics(room);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }
}
