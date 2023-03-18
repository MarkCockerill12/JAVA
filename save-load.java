import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SocialMediaNetwork {

    // ...

    public static void main(String[] args) {
        // ...

        // load the social media network from a file
        loadFromFile("social_media_network.txt");

        // ...

        // save the social media network to a file
        saveToFile("social_media_network.txt");
    }

    // save the social media network to a file
    public static void saveToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);

            // write each user's profile information
            for (User user : users) {
                writer.write("user," + user.getID() + "," + user.getName() + "," + user.getWorkplace() + "," + user.getHometown() + "\n");
            }

            // write each user's friends
            for (User user : users) {
                for (User friend : user.getFriends()) {
                    writer.write("friend," + user.getID() + "," + friend.getID() + "\n");
                }
            }

            writer.close();
            System.out.println("Social media network saved to " + filename);
        } catch (IOException e) {
            System.out.println("Failed to save social media network to " + filename);
            e.printStackTrace();
        }
    }

    // load the social media network from a file
    public static void loadFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            // clear the existing users and connections
            users.clear();

            // read each line from the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // split the line into fields
                String[] fields = line.split(",");

                if (fields[0].equals("user")) {
                    // create a new user and add them to the list of users
                    User user = new User(fields[1], fields[2], fields[3], fields[4]);
                    users.add(user);
                } else if (fields[0].equals("friend")) {
                    // find the user and friend based on their IDs
                    User user = getUserByID(fields[1]);
                    User friend = getUserByID(fields[2]);

                    // add the friend to the user's friend list
                    user.addFriend(friend);
                }
            }

            scanner.close();
            System.out.println("Social media network loaded from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load social media network from " + filename);
            e.printStackTrace();
        }
    }

    // ...
}
