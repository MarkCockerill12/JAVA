import java.util.List;

public class SocialMediaApp {
    public static void main(String[] args) {
        // Initialize the social media network
        SocialMediaNetwork network = new SocialMediaNetwork();

        // Add users to the network
        User user1 = new User(1, "Alice", 25, "New York", "Google");
        User user2 = new User(2, "Bob", 30, "San Francisco", "Apple");
        User user3 = new User(3, "Charlie", 35, "London", "Facebook");

        network.addUser(user1);
        network.addUser(user2);
        network.addUser(user3);

        // Add friendships to the network
        network.addFriendship(user1, user2);
        network.addFriendship(user2, user3);

        // Remove a user from the network
        network.removeUser(user1);

        // Find a user by ID
        User foundUser = network.findUserById(2);

        // Print the user's name
        if (foundUser != null) {
            System.out.println("Found user: " + foundUser.getName());
        } else {
            System.out.println("User not found");
        }

        // Get a user's friends
        List<User> friends = network.getFriendsOfUser(foundUser);
        System.out.println("Friends of " + foundUser.getName() + ":");
        for (User friend : friends) {
            System.out.println("- " + friend.getName());
        }

        // Get friends in common between two users
        User user4 = new User(4, "David", 40, "Sydney", "Amazon");
        network.addUser(user4);
        network.addFriendship(user1, user4);
        network.addFriendship(user4, user3);
        List<User> commonFriends = network.getFriendsInCommon(user1, user3);
        System.out.println("Friends in common between " + user1.getName() + " and " + user3.getName() + ":");
        for (User friend : commonFriends) {
            System.out.println("- " + friend.getName());
        }
    }
}
