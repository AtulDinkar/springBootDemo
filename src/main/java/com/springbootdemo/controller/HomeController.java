package com.springbootdemo.controller;

import com.springbootdemo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello Atul";
    }

    //    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public User getUserInfo() {
        User user = new User();
        user.setId(1L);
        user.setName("Atul D");
        user.setEmilId("atul@gmail.com");

        return user;
    }

    @GetMapping("/{id}")
    public String pathVariable(@PathVariable String id) {
        return "the path variable is : " + id;
    }

    @GetMapping("/requestParam")
    public String requestParameter(@RequestParam String name) {
        return "your name is :: " + name;
    }
}
