package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.dto.UserDto;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
@SessionAttributes({"logged", "check"})
public class LogRegController {

    private final UserService userService;

    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register/register";
    }

    @PostMapping("register")
    public ModelAndView registerUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result) {

        User registeredUser = new User();
        if (!result.hasErrors()){
            userDto.setEnabled(false);
            userDto.setIsAdmin(false);
            System.out.println(userDto.toString());
            registeredUser = createUserAccount(userDto);
            System.out.println(registeredUser.toString());
        }

        if (registeredUser == null) {
            result.rejectValue("email", "message.regError");
        }

        if (result.hasErrors()) {
            return new ModelAndView("register/register", "user", userDto);
        } else {
            return new ModelAndView("register/successRegister", "user", userDto);
        }

    }

    private User createUserAccount(UserDto userDto) {
        User registered = null;
        try {
            registered = userService.registerUser(userDto);
        } catch (Exception e) {
            return null;
        }
        return registered;
    }

    @GetMapping("login")
    public String loginUser(Model model) {
        return "login/login";
    }

//    @PostMapping("login")
//    public String loginUser(@ModelAttribute FakeUser fakeUser, Model model, RedirectAttributes redirectAttributes) {
//        List<User> users = userService.findAllUsers();
//        User logged = new User();
//        for (User tempUser : users) {
//            if (fakeUser.getEmail().equals(tempUser.getEmail())) {
//                if (BCrypt.checkpw(fakeUser.getPassword(), tempUser.getPassword())) {
//                    logged = tempUser;
//                    break;
//                } else {
//                    return "redirect:/login";
//                }
//            }
//        }
//
//        boolean check = logged.isAdmin();
//        redirectAttributes.addFlashAttribute(check);
//        model.addAttribute("logged", logged);
//        model.addAttribute("check", check);
//        System.out.println(check);
//
//        return "redirect:/";
//    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login/logout";
    }

}
