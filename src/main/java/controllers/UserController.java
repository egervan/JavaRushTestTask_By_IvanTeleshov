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

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by nz on 19.05.16.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //Этот контроллер открывает главную страницу - home, на которой отображаются все пользователи
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "WEB-INF/jsp/home.jsp";
    }
    //Этот контроллер удаляет выбранную запись и показывает обновлённый список пользователей
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(Integer.parseInt(id));
        return "/home";
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
        return "/home";
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

        //Из-за проблем с сохранением руссих имён (user.name) сделал такую фичу:
        try
        {
            user.setName(new String(user.getName().getBytes("ISO8859_1"), "UTF8"));
        }
        catch (UnsupportedEncodingException e)
        {
        }
        finally {
            userService.updateUser(user);
        }
        return "/home";
    }
}

