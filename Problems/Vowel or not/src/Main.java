import java.util.Scanner;


public class Main {

    public static boolean isVowel(char ch) {
        // write your code here
        char[] vowels = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'};
        boolean isVowel = false;
        for (int i : vowels) {
            isVowel = i == ch ? true : false;
            if (isVowel)
                break;
        }
        return isVowel;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}
