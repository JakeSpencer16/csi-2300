
import java.util.Scanner;

public class stringreverse {
    @SuppressWarnings("resource") //so vscode would not complain about the scanner
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the string you want to have reversed. ");
        String originalString =  scan.nextLine(); //takes the input
        String reversedString = new StringBuilder(originalString).reverse().toString(); //and reverses it
        System.out.print("Your reversed string is: "+reversedString);
    }
}
