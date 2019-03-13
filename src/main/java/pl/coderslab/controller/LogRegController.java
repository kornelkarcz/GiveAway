package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.FakeUser;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;
import pl.coderslab.utils.BCrypt;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes({"logged", "isAdmin"})
public class LogRegController {

    @Autowired
    private UserService userService;

    @GetMapping("register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "/register/register";
    }

    @PostMapping("register")
    public String registerUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.registerUser(user);
        return "redirect:/";
    }

    @GetMapping("login")
    public String loginUser(Model model) {
        model.addAttribute("fake", new FakeUser());
        return "login/login";
    }

    @PostMapping("login")
    public String loginUser(@ModelAttribute FakeUser fakeUser, Model model) {
        List<User> users = userService.findAllUsers();
        User logged = new User();
        for (User tempUser : users) {
            if (fakeUser.getEmail().equals(tempUser.getEmail())) {
                if (BCrypt.checkpw(fakeUser.getPassword(), tempUser.getPassword())) {
                    logged = tempUser;
                    break;
                } else {
                    return "redirect:/login";
                }
            }
        }
        model.addAttribute("logged", logged);
        model.addAttribute("isAdmin", logged.isAdmin());

        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login/logout";
    }

}
