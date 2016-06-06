package controllers;

import objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

/**
 * Created by nz on 19.05.16.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomePage() {
        return "redirect:/home";
    }

    //Этот контроллер открывает главную страницу - home, на которой отображаются все пользователи
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "WEB-INF/jsp/home.jsp";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getUsersByName(@RequestParam("requestName") String requestName, Model model)
    {
        model.addAttribute("users", userService.getUsersByName(requestName));

        return "WEB-INF/jsp/search.jsp";
    }


    //Этот контроллер удаляет выбранную запись и показывает обновлённый список пользователей
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(Integer.parseInt(id));
        return "redirect:/home";
    }
    //Этот контроллер открывает страницу добавления нового пользователя
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "WEB-INF/jsp/add.jsp";
    }

    //Этот контроллер вызвается при сохранении нового пользователя
    @RequestMapping(value = "/addAction", method = {RequestMethod.POST, RequestMethod.GET})
    public String addAction(@ModelAttribute("user") User user) {
        this.userService.addUser(user);
        return "redirect:/home";
    }

    //Этот контроллер запрашивает запись пользователя из БД и отправляет её для редактирования в контроллер updatePage
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, Model model) {
        model.addAttribute("user", userService.getUserById(Integer.parseInt(id)));
        //Не понятно пока почему, но если отсюда переходить на "WEB-INF/jsp/update.jsp" вываливается ошибка, т.к. к адресу впереди добавляется update/"WEB-INF/jsp/update.jsp"
        return "/updatePage";
    }

    //Этот контроллер открывает страницу редактирования записи пользователя
    @RequestMapping(value = "/updatePage", method = RequestMethod.GET)
    public String updatePage(Model model) {
        return "WEB-INF/jsp/update.jsp";
    }

    //Этот контроллер вызывается при сохранении изменений в записи пользователя
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateAction(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/home";

    }
}

