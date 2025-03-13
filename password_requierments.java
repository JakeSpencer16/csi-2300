
import java.util.Scanner;

public class password_requierments {
    public static void main(String[] args){
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        String password = "";
        boolean x = true;

            while (x){  
                System.out.println("Please input a password");
                password = scan.nextLine();

                if (password.length() >= 8 && password.length() <= 16) {
                    if (password.matches(".*[a-z].*") && // lower case
                        password.matches(".*[A-Z].*") && // upercase
                        password.matches(".*\\d.*") && //numbers 0-9
                        password.matches(".*[!@#$%^&*()_+\\-={};':\"\\\\|,.<>/?].*")) // special charecters 
                        {
                            x = false;
                        }
                else {
                        System.out.println("Password does not meet all requirements. Please try again.");
                     }
            } else {
                System.out.println("Password length must be between 8 and 16 characters. Please try again.");
            }
        }
        System.out.print("Your password: " +password+ "is accepted");
    }
}