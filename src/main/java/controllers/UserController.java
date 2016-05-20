package controllers;

import objects.User;
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
    private UserService userService;

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "WEB-INF/jsp/home.jsp";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") String id){
        userService.deleteUser(Integer.parseInt(id));
        return "/home";
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add() {
        return "WEB-INF/jsp/add.jsp";
    }

    //For add and update user both
    @RequestMapping(value= "/addAction", method = RequestMethod.POST)
    public String addAction(@ModelAttribute("user") User user)
    {


        if(user.getId() == 0){
            //new user, add it
            this.userService.addUser(user);
        }else{
            //existing user, call update
            this.userService.updateUser(user);
        }

        return "/home";

    }

    @RequestMapping("/update/{id}")
    public ModelAndView updateUser(@PathVariable("id") int id, Model model){
        ModelAndView modelAndView = new ModelAndView("update-user");
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.getAllUsers());
        return modelAndView;
    }

}

