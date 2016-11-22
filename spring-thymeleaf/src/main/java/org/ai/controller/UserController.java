package org.ai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hua.ai on 2016/11/21.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("user/index");
    }
}
