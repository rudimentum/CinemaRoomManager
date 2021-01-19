import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        // write your code with StringBuilder here
        StringBuilder sb = new StringBuilder();
        StringBuilder[] sbArray = new StringBuilder[strings.length];
        for (int i = 0; i < sbArray.length; i++) {
            sbArray[i] = new StringBuilder(strings[i]);
            for (int j = 0; j < sbArray[i].length(); ) {
                if (Character.isDigit(sbArray[i].charAt(j))) {
                    sbArray[i].deleteCharAt(j);
                } else {
                    j++;
                }
            }
            sb.append(sbArray[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}
