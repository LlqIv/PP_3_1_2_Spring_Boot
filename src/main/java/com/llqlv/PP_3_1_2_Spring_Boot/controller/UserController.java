package com.llqlv.PP_3_1_2_Spring_Boot.controller;

import com.llqlv.PP_3_1_2_Spring_Boot.entity.User;
import com.llqlv.PP_3_1_2_Spring_Boot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(name = "/users")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.showAllUsers());
        return "show-page";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "create-page";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "edit-page";
    }

    @PatchMapping("/{id}")
    public String saveEditUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable(name = "id") Long id ){
        userService.delete(id);
        return "redirect:/users";
    }

}
