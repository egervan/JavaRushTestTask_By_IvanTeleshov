package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nz on 19.05.16.
 */
@Controller
public class LinkController {

    @RequestMapping(value="/")
    public ModelAndView mainPage() {
        return new ModelAndView("home");
    }

    @RequestMapping(value="/hello")
    public ModelAndView printWelcome(String name) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        mav.addObject("message", "Hello, " + ((name != null) ? name : "World!"));
        return mav;
    }

    @RequestMapping(value="/index")
    public ModelAndView indexPage() {
        return new ModelAndView("home");
    }

}
