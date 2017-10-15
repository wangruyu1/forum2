package com.leisure.forum.user;

import com.leisure.forum.entity.User;
import com.leisure.forum.user.servie.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangruyu
 * @since 2017/10/15-12:30
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addUser(@RequestParam("user") User user) {
       return userService.add(user);
    }
}
