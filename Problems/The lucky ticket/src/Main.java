import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] ticket = new int[6];
        for (int i = 0; i < ticket.length; i++) {
            ticket[i] = Character.getNumericValue(s.charAt(i));
        }
    
        int firstSum = ticket[0] + ticket[1] + ticket[2];
        int secondSum = ticket[3] + ticket[4] + ticket[5];
        String result = firstSum == secondSum ? "Lucky" : "Regular";
        System.out.print(result);
    }
}
