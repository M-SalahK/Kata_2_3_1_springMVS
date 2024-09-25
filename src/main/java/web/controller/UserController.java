package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;
import web.model.User;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/index")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "index";
    }

    @GetMapping(value = "/save")
    public String save(Model model) {
        model.addAttribute("user", new User());
        return "save";
    }

    @PostMapping
    public String save(@ModelAttribute(value = "user") User user) {
        userService.saveUser(user);
        return "redirect:/index";
    }

    @PostMapping("/update/")
    public String updateUser(@RequestParam int id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/index";
    }

    @PostMapping("/delete/")
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/index";
    }

    @GetMapping("/update/")
    public String showUpdateForm(@RequestParam("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update";
    }

}
