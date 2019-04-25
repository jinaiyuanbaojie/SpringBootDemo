package com.jinaiyuan.web.controller;

import com.jinaiyuan.web.dao.User;
import com.jinaiyuan.web.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    static final String SUCCESS_CODE = "success";
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    public int addUser() {
        userService.create("a", 10);
        return hashCode();
    }

    @RequestMapping(value = "clear")
    public String clearAllUsers() {
        userService.deleteAllUsers();
        return SUCCESS_CODE;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<>(users.values());
        return r;
    }

    // /users/id=102&name=andrew
    @ApiOperation(value = "create a new user", notes = "hi swagger2")
    @ApiImplicitParam(name = "user", value = "User bean", required = true, dataType = "User")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return SUCCESS_CODE;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        return SUCCESS_CODE;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return SUCCESS_CODE;
    }
}
