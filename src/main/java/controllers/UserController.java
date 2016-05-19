package controllers;

import objects.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import java.util.Map;

/**
 * Created by nz on 19.05.16.
 */
@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUsers(Model model) {
        ModelAndView modelAndView = new ModelAndView("all-users");
        modelAndView.addObject("users", userService.getAllUsers());
        return modelAndView;
    }

    //For add and update user both
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user)
    {
        ModelAndView modelAndView = new ModelAndView("add-user-form ");
        String message = String.format("User with %d and name %s id successfully  added.", user.getId(), user.getName());
        modelAndView.addObject("message", message);

        if(user.getId() == 0){
            //new user, add it
            this.userService.addUser(user);
        }else{
            //existing user, call update
            this.userService.updateUser(user);
        }

        return modelAndView;

    }

    @RequestMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("home");
        userService.deleteUser(id);
        String message = String.format("User %d was successfully deleted.", id);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping("/update/{id}")
    public ModelAndView updateUser(@PathVariable("id") int id, Model model){
        ModelAndView modelAndView = new ModelAndView("update-user");
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.getAllUsers());
        return modelAndView;
    }

}

