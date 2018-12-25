package com.pcidata.renrenstudy.controller;

import com.pcidata.renrenstudy.service.UserService;
import com.pcidata.renrenstudy.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: dzy
 * @Date: 2018/12/25 16:35
 * @Describe: TODO
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public User save(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        User user = new User(username, password);
        System.out.println("user:" + user);
        User save = userService.save(user);
        return save;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public User update(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        User user = new User(username, password);
        System.out.println("user:" + user);
        User update = userService.update(user);
        return update;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "username") String username) {
        System.out.println("username:" + username);
        String delete = userService.delete(username);
        return delete;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public User select(@RequestParam(value = "username") String username) {
        System.out.println("username:" + username);
        User select = userService.select(username);
        return select;
    }

}
