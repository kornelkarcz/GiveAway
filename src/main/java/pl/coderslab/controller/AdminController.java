package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String getAdminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String getAllOrdinaryUsers(Model model) {
        model.addAttribute("users", userService.findAllOrdinaryUsers());
        return "admin/users";
    }


}
