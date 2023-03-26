import java.util.HashSet;
import java.util.Set;
import java.io.*;
import java.util.*;

public class User {
    private int Id;
    private String name;
    private int age;
    private String hometown;
    private String workplace;
    private BinaryTree friends;
    private User left;
    private User right;
    private String password;


    public User(int ID ,String name, int age, String hometown, String workplace) {
        this.Id = Id;
        this.name = name;
        this.age = age;
        this.hometown = hometown;
        this.workplace = workplace;
        this.friends = new BinaryTree();
    }

    public int getId() {
        return Id;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHometown() {
        return hometown;
    }

    public String getWorkplace() {
        return workplace;
    }
    
    public String getPassword() {
        return name;
    }
    
    //Friend sections- Not yet fully implimented

    public void addFriend(Friend friend) {
        friends.insert(friend);
    }

    public void removeFriend(Friend friend) {
        friends.delete(friend);
    }

    public boolean hasFriend(Friend friend) {
        return friends.contains(friend);
    }

    public Set<Friend> getFriends() {
        Set<Friend> friendsSet = new HashSet<>();
        friends.inOrderTraversal().forEach(friendsSet::add);
        return friendsSet;
    }
    
    public User getLeft() {
        return left;
    }

    public void setLeft(User left) {
        this.left = left;
    }

    public User getRight() {
        return right;
    }

    public void setRight(User right) {
        this.right = right;
    }

    // other methods for filtering, friend recommendations, etc.
}