package com.perscholas.krishna.saveaccess.controllers;
import com.perscholas.krishna.saveaccess.models.Myuser;
import com.perscholas.krishna.saveaccess.repos.MyuserRepository;
import com.perscholas.krishna.saveaccess.services.MyUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@Slf4j
@RequestMapping("/users")
public class MyUserController {
    private MyUserService myUserService;
    private  MyuserRepository repository;

    @GetMapping("/myusers")
    public String registerUser( Model model) {

    List<Myuser> myuserList= myUserService.getusers();
    model.addAttribute("users",myuserList);
    log.warn(myuserList.toString());

        return "userspage";
    }
    @PostMapping("/myusers")
    public String  registerUserAccount(@RequestParam(name="id")int userId,@RequestParam(name="email")String userEmail,
                                      @RequestParam(name="firstname")String userfirstname,@RequestParam(name="lastname")String userlastname,
                                      @RequestParam(name="email")String userPassword, Model model) {
    log.warn(userId + " "+ userEmail+" "+ userfirstname +" "+userlastname+" "+userPassword);

    myUserService.addUser(userId, userEmail, userfirstname, userlastname, userPassword);
        List<Myuser> myuserList= myUserService.getusers();
        model.addAttribute("users",myuserList);
    return "userspage";
    }



}




