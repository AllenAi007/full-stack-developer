package org.ai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hua.ai on 2016/11/19.
 */
@RestController
@ConfigurationProperties(prefix = "spring")
public class HomeController {

    private final static Logger LOG = LoggerFactory.getLogger(HomeController.class);

    private String greeting;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index", "message", greeting);
    }

    @RequestMapping("/page1")
    public ModelAndView page1() {
        return new ModelAndView("page1", "message", "Page1");
    }


    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

}
