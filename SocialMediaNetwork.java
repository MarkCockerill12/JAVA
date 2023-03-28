import java.util.ArrayList;
import java.util.List;

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

    public User findUserById(int id) {
    for (User user : this.users) {
        if (user.getId() == id) {
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
    
    public User PasswordCheck(int id, String password) {
    for (User user : users) {
        if (user.getId() == id && user.getPassword().equals(password)) {
            return user;
        }
    }
    return null;
}


    public boolean addFriendship(User user1, User user2) {
    if (user1.getFriends().contains(user2)) {
        // Users are already friends
        return false;
    }
    user1.addFriend(user2);
    user2.addFriend(user1);
    return true;
}

    public boolean removeFriendship(User user1, User user2) {
    if (user1.getFriends().contains(user2)) {
        user1.removeFriend(user2);
        user2.removeFriend(user1);
    }
    return false;
}


}