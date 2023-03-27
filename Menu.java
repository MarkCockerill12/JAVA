import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.List;



public class Menu {
    private SocialMediaNetwork network;
    private Scanner scanner;

    public Menu() {
        this.network = new SocialMediaNetwork();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the Social Media Network!");
            System.out.println("What would you like to do?");
            System.out.println("1. Add a new user");
            System.out.println("2. Remove a user");
            System.out.println("3. Find a user by ID");
            System.out.println("4. Add a friendship between two users");
            System.out.println("5. Remove a friendship between two users");
            System.out.println("6. Get friends of a user");
            System.out.println("7. Get friends in common between two users");
            System.out.println("8. Load social media network from file");
            System.out.println("9. Save social media network to file");
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
                    findUserById();
                    break;
                case 4:
                    addFriendship();
                    break;
                case 5:
                    removeFriendship();
                    break;
                case 6:
                    getFriendsOfUser();
                    break;
                case 7:
                    getFriendsInCommon();
                    break;
                case 8:
                    loadFromFile();
                    break;
                case 9:
                    saveToFile();
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

        User user = new User(id, name, age, hometown, workplace);
        network.addUser(user);
        System.out.println("User added successfully.");
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
    
    private void findUserById() {
        System.out.println("Please enter the ID of the user to find:");
        int id = scanner.nextInt();
        scanner.nextLine();

        User user = network.findUserById(id);
        if (user == null) {
            System.out.println("User not found.");
        } else {
            System.out.println(user.getName() + " found.");
        }
    }
    
     private void addFriendship() {
        System.out.println("Please enter the ID of the first user:");
        int id1 = scanner.nextInt();
        scanner.nextLine();

        User user1 = network.findUserById(id1);
        if (user1 == null) {
        System.out.println("User not found.");
        return;
    }

    System.out.println("Please enter the ID of the second user:");
    int id2 = scanner.nextInt();
    scanner.nextLine();

    User user2 = network.findUserById(id2);
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

private void removeFriendship() {
    System.out.println("Please enter the ID of the first user:");
    int id1 = scanner.nextInt();
    scanner.nextLine();

    User user1 = network.findUserById(id1);
    if (user1 == null) {
        System.out.println("User not found.");
        return;
    }

    System.out.println("Please enter the ID of the second user:");
    int id2 = scanner.nextInt();
    scanner.nextLine();

    User user2 = network.findUserById(id2);
    if (user2 == null) {
        System.out.println("User not found.");
        return;
    }

    boolean removed = network.removeFriendship(user1, user2);
    if (removed) {
        System.out.println(user1.getName() + " and " + user2.getName() + " are no longer friends.");
    } else {
        System.out.println(user1.getName() + " and " + user2.getName() + " were not friends to begin with.");
    }
}

private void getFriendsOfUser() {
    System.out.println("Please enter the ID of the user:");
    int id = scanner.nextInt();
    scanner.nextLine();

    User user = network.findUserById(id);
    if (user == null) {
        System.out.println("User not found.");
        return;
    }

    List<User> friends = network.getFriendsOfUser(user); // change Set<User> to List<User>
    if (friends.isEmpty()) {
        System.out.println(user.getName() + " has no friends.");
    } else {
        System.out.println("Friends of " + user.getName() + ":");
        for (User friend : friends) {
            System.out.println("- " + friend.getName());
        }
    }
}


private void getFriendsInCommon() {
    System.out.println("Please enter the ID of the first user:");
    int id1 = scanner.nextInt();
    scanner.nextLine();

    User user1 = network.findUserById(id1);
    if (user1 == null) {
        System.out.println("User not found.");
        return;
    }

    System.out.println("Please enter the ID of the second user:");
    int id2 = scanner.nextInt();
    scanner.nextLine();

    User user2 = network.findUserById(id2);
    if (user2 == null) {
        System.out.println("User not found.");
        return;
    }

    List<User> friendsInCommon = network.getFriendsInCommon(user1, user2); // change Set<User> to List<User>
    if (friendsInCommon.isEmpty()) {
        System.out.println(user1.getName() + " and " + user2.getName() + " have no friends in common.");
    } else {
        System.out.println("Friends in common between " + user1.getName() + " and " + user2.getName() + ":");
        for (User friend : friendsInCommon) {
            System.out.println("- " + friend.getName());
        }
    }
}

private void loadFromFile() {
    System.out.println("Please enter the name of the file to load from:");
    String fileName = scanner.nextLine();

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
        this.network = (SocialMediaNetwork) ois.readObject();
        System.out.println("Social media network loaded successfully from file.");
    } catch (FileNotFoundException e) {
        System.out.println("File not found.");
    } catch (IOException e) {
        System.out.println("Error reading from file.");
    } catch (ClassNotFoundException e) {
        System.out.println("Error loading social media network from file.");
    }
}

private void saveToFile() {
    System.out.println("Please enter the name of the file to save to:");
    String fileName = scanner.nextLine();

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
        oos.writeObject(this.network);
        System.out.println("Social media network saved successfully to file.");
    } catch (IOException e) {
        System.out.println("Error writing to file.");
    }
}

    }


