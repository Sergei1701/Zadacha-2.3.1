package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> userAll = userService.getUsers();
        model.addAttribute("allUsers", userAll);
        return "table";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("newAddUser", user);
        return "newUser";
    }

    @PostMapping("/safeUser")
    public String safeUser(@ModelAttribute("newAddUser") User user) {
        userService.safeUser(user);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("userId") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("newAddUser", user);
        return "newUser";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
