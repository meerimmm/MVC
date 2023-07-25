package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
    private  final UserServiceImpl userService;
    @Autowired
    public UserController( UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping("/find_all")
    public String findAll( Model model){
        model.addAttribute("users" ,userService.findAll());
        return "users";
    }
}
