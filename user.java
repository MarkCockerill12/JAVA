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
    private List<User> friends;
    private User left;
    private User right;
    private String password;

 //Constructor!! We like these
    public User(int Id ,String name, int age, String hometown, String workplace, String password) {
        this.Id = Id;
        this.name = name;
        this.age = age;
        this.hometown = hometown;
        this.workplace = workplace;
        this.friends = new ArrayList<User>();    
        this.password = password;
    }

    
    //Getter Methods
    public int getId() {
        return Id;
    }
    
    public void setName(String newName) {
    this.name = newName;
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
        return password;
    }
    
    //Setter methods
    public void setPassword(String password) {
        this.password = password;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //Friend sections- Not yet fully implimented

    public void addFriend(User friend) {
    friends.add(friend);
}

public void removeFriend(User friend) {
    friends.remove(friend);
}

public boolean hasFriend(User friend) {
    return friends.contains(friend);
}

public List<User> getFriends() {
    return friends;
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