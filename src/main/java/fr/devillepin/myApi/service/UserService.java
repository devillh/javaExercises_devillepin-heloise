package fr.devillepin.myApi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.devillepin.myApi.model.User;

@Service
public class UserService {
    private ArrayList<User> users;

    public UserService() {
        this.users = new ArrayList<User>();

        this.users.add(new User(0, "Georges", 41));
        this.users.add(new User(1, "Lina", 8));
        this.users.add(new User(2, "Gontran", 27));
    }

    public User getUser(int id) {
        for (User user : this.users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
