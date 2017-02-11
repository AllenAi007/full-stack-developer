package org.ai.controller;

import org.ai.model.PagingResult;
import org.ai.model.User;
import org.ai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by hua.ai on 2016/11/21.
 */
@Controller
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("user/index");
    }

    @ResponseBody
    @RequestMapping("api/getUsers")
    public PagingResult<User> getUsers() {
        List<User> users = userService.getUsers();
        PagingResult<User> pagingResult = new PagingResult<>(users);
        pagingResult.setTotal(users.size());
        return pagingResult;
    }

    @ResponseBody
    @RequestMapping("api/getUserByLoginName")
    public User getUserByLoginName(@RequestParam String username) {
        return userService.getUserByLoginName(username);
    }

    @ResponseBody
    @RequestMapping("api/delete")
    public String delete(@RequestParam String username) {
        userService.delete(username);
        return username;
    }

    @ResponseBody
    @RequestMapping("api/update")
    public User update(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        userService.update(user);
        return user;
    }


}
