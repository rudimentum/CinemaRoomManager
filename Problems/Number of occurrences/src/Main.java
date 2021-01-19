import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String main = scanner.nextLine();
        String sub = scanner.nextLine();
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder(main);
        while (true) {
            int index = stringBuilder.indexOf(sub);
            if (index != -1) {
                stringBuilder.delete(index, index + sub.length());
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}