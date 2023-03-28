import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.List;
import java.io.PrintWriter;
import java.util.HashSet;


public class Menu {
    private SocialMediaNetwork network;
    private Scanner scanner;

    public Menu() {
        this.network = new SocialMediaNetwork();
        this.scanner = new Scanner(System.in);
    }
    
    public void Login(){
     loadFromFile();

        System.out.println("Welcome to the Social Media Network!");
        System.out.println("");

        boolean running = true;
        boolean loggedIn = false;
        User currentUser = null;

          while (running) {
            System.out.println("1. Log In");
            System.out.println("2. Sign up");
            System.out.println("0. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    while (!loggedIn){
                    System.out.println("Please enter your id:");
            int UserId = scanner.nextInt();

            System.out.println("Please enter your password:");
            String password = scanner.nextLine();

            currentUser = network.PasswordCheck(UserId, password);
            if (currentUser != null) {
                loggedIn = true;
                System.out.println("Logged in successfully.");
                run(UserId);
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }


            case 2:
             int UserId = SignUp();
             run(UserId);

            case 0:
             running = false;
             break;


        }
    }
}



    
    
    
    
    public void run(int UserId) {
        System.out.println("Welcome to the Social Media Network!");
        System.out.println("");
        
        boolean running = true;
        while (running) {
           
            System.out.println("1. Add a new user");
            System.out.println("2. Remove a user");
            System.out.println("3. Search user ID");
            System.out.println("4. Add a friend");
            System.out.println("5. Unfriend");
            System.out.println("6. View friends of a user");
            System.out.println("7. Recomended Friends");
            System.out.println("8. View profile");   
            System.out.println("9. Load social media network from file");
            System.out.println("10. Save social media network to file");
            System.out.println("11. Add a friendship between two users");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    SearchUser(UserId);
                    break;
                case 4:
                    addFriendship(UserId);
                    break;
                case 5:
                    removeFriendship(UserId);
                    break;
                case 6:
                    getFriendsOfUser(UserId);
                    break;
                case 7:
                    reccommendFriends(UserId);
                    break;
                case 8:
                    viewProfile(UserId);
                break;
                    //These are for testing and will not be in final version
                case 9:
                    loadFromFile();
                    break;
                case 10:
                    saveToFile();
                    break;
                case 11:
                    addFriendships();
                    break;
            
                
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
        
    private int SignUp() {
        System.out.println("Please enter the user's ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the user's name:");
        String name = scanner.nextLine();

        System.out.println("Please enter the user's age:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the user's hometown:");
        String hometown = scanner.nextLine();

        System.out.println("Please enter the user's workplace:");
        String workplace = scanner.nextLine();
        
        System.out.println("Please enter the user's password:");
        String password = scanner.nextLine();


        User user = new User(id, name, age, hometown, workplace, password);
        network.addUser(user);
        System.out.println("User added successfully.");
        
        return id;
    }
    
        private void addUser() {
        System.out.println("Please enter the user's ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the user's name:");
        String name = scanner.nextLine();

        System.out.println("Please enter the user's age:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the user's hometown:");
        String hometown = scanner.nextLine();

        System.out.println("Please enter the user's workplace:");
        String workplace = scanner.nextLine();
        
        System.out.println("Please enter the user's password:");
        String password = scanner.nextLine();


        User user = new User(id, name, age, hometown, workplace, password);
        network.addUser(user);
        System.out.println("User added successfully.");
    }
    
     private boolean login(List<User> users) {
        System.out.println("Please enter your username:");
    String enteredUsername = scanner.nextLine();

    System.out.println("Please enter your password:");
    String enteredPassword = scanner.nextLine();

    for (User user : users) {
        if (user.getName().equals(enteredUsername) && user.getPassword().equals(enteredPassword)) {
            return true;
        }
    }

    return false;
    }

    private void deleteUser() {
        System.out.println("Please enter the ID of the user to delete:");
        int id = scanner.nextInt();
        scanner.nextLine();

        User user = network.findUserById(id);
        if (user == null) {
            System.out.println("User was not found.");
        } else {
            network.removeUser(user);
            System.out.println("User removed successfully.");
        }
    }
    
    private void SearchUser(int UserId) {
        System.out.println("Please enter the ID of the user to find:");
        int SearchId = scanner.nextInt();
        scanner.nextLine();

        User user = network.findUserById(SearchId);
        if (user == null) {
            System.out.println("User not found.");
        } else {
            boolean running = true;
            
            System.out.println("UserName: " + user.getName() + "#" + user.getId());
            System.out.println("Age: " + user.getAge());
            System.out.println("Workplace : " + user.getWorkplace());
            System.out.println("Hometown : " + user.getHometown());
            System.out.println("");
            System.out.println("Would you like to friend this user?");
            System.out.println("1. Yes.");
            System.out.println("2. No.");
            int choice = scanner.nextInt();
            
            while (running)
            
            switch(choice){
            case 1:
            User user1 = network.findUserById(UserId);
            User user2 = network.findUserById(SearchId);
            
            
            network.addFriendship(user1, user2);
            System.out.println(user.getName() + user.getId() + " Is now your friend!");
            System.out.println(" ");
            running = false;
            break;
            
            case 2:
            running = false;
            break;
            
            
        default:
            System.out.println("Invalid choice. Please try again.");
            break;
        }
    }
    }
    
     private void addFriendship(int UserId) {  


        User user1 = network.findUserById(UserId);
        if (user1 == null) {
        System.out.println("An error has occured");
        System.out.println("");
        return;
    }
    
    
    System.out.println("Please enter the ID of person you would like to friend.");
    int FriendId = scanner.nextInt();
    scanner.nextLine();
  
    User user2 = network.findUserById(FriendId);
    if (user2 == null) {
        System.out.println("User not found.");
        System.out.println("");
        return;
    }

    boolean added = network.addFriendship(user1, user2);
    if (added) {
        System.out.println(user1.getName() + " and " + user2.getName() + " are now friends.");
        System.out.println("");
    } else {
        System.out.println(user1.getName() + " and " + user2.getName() + " are already friends.");
    }
}

private void addFriendships() {  
    //This method is for testing
    
    System.out.println("Please enter the second ID of person friend.");
    System.out.println("");
    int Id1 = scanner.nextInt();
    scanner.nextLine();
    
    User user1 = network.findUserById(Id1);
        if (user1 == null) {
        System.out.println("An error has occured");
        System.out.println("");
        return;
    }
    
    
    System.out.println("Please enter the second ID of person friend.");
    int FriendId = scanner.nextInt();
    scanner.nextLine();
  
    User user2 = network.findUserById(FriendId);
    if (user2 == null) {
        System.out.println("User not found.");
        return;
    }

    boolean added = network.addFriendship(user1, user2);
    if (added) {
        System.out.println(user1.getName() + " and " + user2.getName() + " are now friends.");
    } else {
        System.out.println(user1.getName() + " and " + user2.getName() + " are already friends.");
    }
}

private void removeFriendship(int UserId) {
    User user1 = network.findUserById(UserId);
        if (user1 == null) {
        System.out.println("An error has occured");
        System.out.println("");
        return;
    }

    //So sad:(
    
    System.out.println("Please enter the ID of the person you would like to unfriend:");
    System.out.println("");
    int unFriendId = scanner.nextInt();
    scanner.nextLine();

    User user2 = network.findUserById(unFriendId);
    if (user2 == null) {
        System.out.println("User not found.");
        System.out.println("");
        return;
    }

    boolean removed = network.removeFriendship(user1, user2);
    if (removed) {
        System.out.println(user1.getName() + " and " + user2.getName() + " are no longer friends.");
        System.out.println("");
    } else {
        System.out.println(user1.getName() + " and " + user2.getName() + " were not friends to begin with.");
        System.out.println("");
    }
}

private void getFriendsOfUser(int UserId) {
    System.out.println("Please enter the ID of the user:");
    System.out.println("");
    int FriendId = scanner.nextInt();
    scanner.nextLine();

    User user = network.findUserById(FriendId);
    if (user == null) {
        System.out.println("User not found.");
        System.out.println("");
        return;
    }

    List<User> friends = network.getFriendsOfUser(user); // change Set<User> to List<User>
    if (friends.isEmpty()) {
        System.out.println(user.getName() + " has no friends.");
        System.out.println("");
    } else {
        mutualFriends(UserId,FriendId);
        
        System.out.println("Friends of " + user.getName() + ":");
        System.out.println("");
        for (User friend : friends) {
            System.out.println("- " + friend.getName() + "#" + friend.getId());
            System.out.println("Age" + friend.getAge());
            System.out.println("Hometown" + friend.getHometown());
            System.out.println("Workplace" + friend.getWorkplace());
            System.out.println("");
        }
    }
}


private void mutualFriends(int UserId, int FriendId) {
    User user1 = network.findUserById(UserId);
        if (user1 == null) {
        System.out.println("An error has occured.");
        System.out.println("");
        return;
    }

    User user2 = network.findUserById(FriendId);
    if (user2 == null) {
        System.out.println("An error has occured.");
        System.out.println("");
        return;
    }

    List<User> mutuals = network.getFriendsInCommon(user1, user2); 
    if (mutuals.isEmpty()) {
        System.out.println("");
    } else {
        System.out.println("You have mutal friends!:");
        for (User friend : mutuals) {
            System.out.println("-" + friend.getName() + "#" + friend.getId());
        
        }
    }
}

private void viewProfile(int UserId) {
    User user = network.findUserById(UserId);
    boolean running = true;
    
    System.out.println("Your profile is, as follows:");
    System.out.println("UserName: " + user.getName() + "#" + user.getId());
    System.out.println("Age: " + user.getAge());
    System.out.println("Workplace : " + user.getWorkplace());
    System.out.println("Hometown : " + user.getHometown());
    
    
    System.out.println("What would you like to edit?");
    System.out.println("1. Name");
    System.out.println("2. Age");
    System.out.println("3. Hometown");
    System.out.println("4. Workplace");
    System.out.println("5. Password");
    System.out.println("0. Exit");

    int choice = scanner.nextInt();
    scanner.nextLine();
    
    while(running)

    switch (choice) {
        case 1:
            System.out.println("Please enter your new name:");
            String newName = scanner.nextLine();
            user.setName(newName);
            System.out.println("Name updated successfully.");
            break;
        case 2:
            System.out.println("Please enter your new age:");
            int newAge = scanner.nextInt();
            scanner.nextLine();
            user.setAge(newAge);
            System.out.println("Age updated successfully.");
            break;
        case 3:
            System.out.println("Please enter your new hometown:");
            String newHometown = scanner.nextLine();
            user.setHometown(newHometown);
            System.out.println("Hometown updated successfully.");
            break;
        case 4:
            System.out.println("Please enter your new workplace:");
            String newWorkplace = scanner.nextLine();
            user.setWorkplace(newWorkplace);
            System.out.println("Workplace updated successfully.");
            break;
        case 5:
            System.out.println("Please enter your new password:");
            String newPassword = scanner.nextLine();
            user.setPassword(newPassword);
            System.out.println("Password updated successfully.");
            break;
        case 0:
            running = false;
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
            break;
    }
}

public void reccommendFriends(int userId) {
    int Id = userId;
    User currentUser = network.findUserById(Id);
    if (currentUser == null) {
        System.out.println("User not found.");
        return;
    }
    
    System.out.println("User found:");
    System.out.println("ID: " + currentUser.getId());
    System.out.println("Name: " + currentUser.getName());
    System.out.println("Workplace: " + currentUser.getWorkplace());
    System.out.println("Hometown: " + currentUser.getHometown());

    List<User> friends = network.getFriendsOfUser(currentUser);

    Set<User> friendOfFriends = new HashSet<>();
    for (User friend : friends) {
        friendOfFriends.addAll(network.getFriendsOfUser(friend));
    }
    friendOfFriends.remove(currentUser);

    Set<User> result = new HashSet<>();
    for (User friendOfFriend : friendOfFriends) {
        if (friendOfFriend.getHometown().equals(currentUser.getHometown()) ||
                friendOfFriend.getWorkplace().equals(currentUser.getWorkplace())) {
            result.add(friendOfFriend);
        }
    }

    if (result.isEmpty()) {
        System.out.println("No users found.");
    } else {
        System.out.println("You have a reccomended friend!:");
        for (User user : result) {
            System.out.println("UserName: " + user.getName() + "#" + user.getId() + ", Workplace: " + user.getWorkplace() + ", Hometown: " + user.getHometown());
        }
    }
}


private void loadFromFile() {
    //You got this mark!!!!
}

private void saveToFile() {
    //Your turn mark :O
}

    }


