import java.util.Scanner;
/**
 * Write a description of class Meny here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    // instance variables - replace the example below with your own
    private User user;
    private Scanner scanner;

    /**
     * Constructor for objects of class Meny
     */
    public Menu()
    {
        user = new User();
        scanner = new Scanner(System.in);
    }

   public void display() {
        int choice = -1; //validation
        
        //Add in login method here
    
        while (choice != 0) {
            //List Options
            System.out.println("Welcome to the Social Network.");
            System.out.println("==================================");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Search User");
            System.out.println("4. Remove User");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character
            
            //For Each choice one to 5 and exit

            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    //Validation else
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
}
