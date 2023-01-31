package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String addingNewUser(Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping("/addUser")
    public String savingUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/editUser/{userId}")
    public String editingUser(@PathVariable("userId") int id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }

    @PatchMapping(value="/editUser/{getId}")
    public String saveEditedUser(@PathVariable int getId, @ModelAttribute("user") User user){
        user.setId(getId);
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("deleteUser/{getId}")
    public String deleteUser(@PathVariable int getId) {
        userService.deleteUser(getId);
        return "redirect:/";
    }
}
