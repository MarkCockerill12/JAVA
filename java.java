import java.io.*;
import java.util.*;

class User {
    private String id;
    private String name;
    private String workplace;
    private String hometown;
    private List<User> friends;

    public User(String id, String name, String workplace, String hometown) {
        this.id = id;
        this.name = name;
        this.workplace = workplace;
        this.hometown = hometown;
        this.friends = new ArrayList<User>();
    }

    // Getters and setters for user properties

    public void addFriend(User friend) {
        this.friends.add(friend);
    }

    public void removeFriend(User friend) {
        this.friends.remove(friend);
    }

    public List<User> getFriends() {
        return this.friends;
    }
}

class SocialMediaNetwork {
    private List<User> users;

    public SocialMediaNetwork() {
        this.users = new ArrayList<User>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public List<User> getUsers() {
        return this.users;
    }

    public User findUserById(String id) {
        for (User user : this.users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void loadFromFile(String filename) {
        // Load the social media network from a file on disk
    }

    public void saveToFile(String filename) {
        // Save the social media network to a file on disk
    }

    public List<User> getFriendsOfUser(User user) {
        return user.getFriends();
    }

    public List<User> getFriendsInCommon(User user1, User user2) {
        List<User> friends1 = user1.getFriends();
        List<User> friends2 = user2.getFriends();
        List<User> commonFriends = new ArrayList<User>();
        for (User friend1 : friends1) {
            if (friends2.contains(friend1)) {
                commonFriends.add(friend1);
            }
        }
        return commonFriends;
    }

    public void addFriendship(User user1, User user2) {
        user1.addFriend(user2);
        user2.addFriend(user1);
    }

    public void removeFriendship(User user1, User user2) {
        user1.removeFriend(user2);
        user2.removeFriend(user1);
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        // Initialize the social media network
        SocialMediaNetwork network = new SocialMediaNetwork();

        // Load the social media network from a file
        network.loadFromFile("network.dat");

        // View/edit user profile
        User user = network.findUserById("123");
        user.setName("New Name");

        // Add a friend
        User friend = network.findUserById("456");
        network.addFriendship(user, friend);

        // Remove a friend
        network.removeFriendship(user, friend);

        // Save the social media network to a file
        network.saveToFile("network.dat");

        // Query the social media network
        List<User> myFriends = network.getFriendsOfUser(user);
        User friendOfFriend = myFriends.get(0).getFriends().get(0);
        List<User> commonFriends = network.getFriendsInCommon(user, friendOfFriend);
    }
}

