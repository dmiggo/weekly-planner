package com.example.planner.controller;

import com.example.planner.model.User;
import com.example.planner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // GET все пользователи
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET пользователя по ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // ✅ POST - Создайте пользователя (НОВЫЙ МЕТОД!)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // PUT - Обновить пользователя
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            return userRepository.save(user);
        }
        return null;
    }

    // DELETE - Удалить пользователя
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
