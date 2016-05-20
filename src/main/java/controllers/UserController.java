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
    @RequestMapping(value= "/addAction", method = {RequestMethod.POST, RequestMethod.GET})
    public String addAction(@ModelAttribute("user") User user)
    {
        if(user.getId() == 0){
            //new user, add it
            this.userService.addUser(user);
        }
        else{
            //existing user, call update
            this.userService.updateUser(user);
        }
        return "/home";
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, Model model){
        model.addAttribute("user", userService.getUserById(Integer.parseInt(id)));
        //Не понятно пока почему, но если отсюда переходить на "WEB-INF/jsp/update.jsp" вываливается ошибка, т.к. к адресу впереди добавляется update/"WEB-INF/jsp/update.jsp"
        return "/updatePage";
    }

    @RequestMapping(value="/updatePage", method = RequestMethod.GET)
    public String updatePage(Model model){
        return  "WEB-INF/jsp/update.jsp";
    }

    @RequestMapping(value="/update", method = RequestMethod.GET)
    public String updateAction(@ModelAttribute("user") User user)
    {
        userService.updateUser(user);
        return "/home";
    }



   /*
    @RequestMapping("/update/{id}")
    public ModelAndView updateUser(@PathVariable("id") int id, Model model){
        ModelAndView modelAndView = new ModelAndView("update-user");
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.getAllUsers());
        return modelAndView;
    }
  */
}



    /*//For add and update user both
    Рабочий метод добавления пользователей
    @RequestMapping(value= "/addAction", method = {RequestMethod.POST, RequestMethod.GET})
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

    }*/