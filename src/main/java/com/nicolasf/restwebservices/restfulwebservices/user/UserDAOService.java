package com.nicolasf.restwebservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//DAO stands for Data Access Object
@Component
public class UserDAOService {
    //JPA / Hibernate -> Database
    //UserDAOService -> Static list
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(10)));
        users.add(new User(++usersCount, "Jack", LocalDate.now().minusYears(45)));
        users.add(new User(++usersCount, "Chloe", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Nico", LocalDate.now().minusYears(25)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
