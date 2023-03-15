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
public class MyUserController {
    @Autowired
    private MyuserRepository myuserRepository;
    @Autowired
    private MyUserService myUserService;

    @GetMapping("/users")
    public String registerUser(Model model) {
        List<Myuser> myuserList = myUserService.getusers();
        model.addAttribute("users", myuserList);
        log.warn(myuserList.toString());

        return "userspage";
    }
//Mapping for userspage after adding users//
    @GetMapping("/users/add")
    public String addUsersPage() {
        return "usersadd";
    }
// post mapping for adding users//
    @PostMapping("/users/add")
    public String registerUserAccount(@RequestParam(name = "id") int userId, @RequestParam(name = "email") String userEmail,
                                      @RequestParam(name = "firstname") String userfirstname, @RequestParam(name = "lastname") String userlastname,
                                      @RequestParam(name = "email") String userPassword, Model model) {
        log.warn(userId + " " + userEmail + " " + userfirstname + " " + userlastname + " " + userPassword);

        myUserService.addUser(userId, userEmail, userfirstname, userlastname, userPassword);
        List<Myuser> myuserList = myUserService.getusers();
        model.addAttribute("users", myuserList);
        return "userspage";
    }
    //Mapping for editing userspage and edit method handler//
    @GetMapping("/users/edit/{id}")
    public String editUsersForm(@PathVariable int id, Model model) {
        log.warn("editUsersForm");
        model.addAttribute("user", myUserService.getuser(id));
        return "usersupdate";
    }
//Mapping for users and update method handler//
    @PostMapping("/user/{id}")
    public String updateUsers(@PathVariable int id,
                              @ModelAttribute("Myuser") Myuser myuser,
                              Model model) {
        log.warn("updateUsers");

        // get student from database by id
        Myuser existingUser = myUserService.getuser(id);
        existingUser.setId(id);
        existingUser.setFirstname(myuser.getFirstname());
        existingUser.setLastname(myuser.getLastname());
        existingUser.setEmail(myuser.getEmail());
        existingUser.setPassword(myuser.getPassword());
        List<Myuser> myuserList = myUserService.getusers();
        model.addAttribute("users", myuserList);
        // save updated student object
        myUserService.updateusers(existingUser);
        return "userspage";
    }
// handler method for deleting my users//
//@PostMapping ("/users/{id}")
@GetMapping(value = "users/{id}")
    public String deleteUsers(@PathVariable int id,
                              @ModelAttribute("Myuser") Myuser myuser,
                              Model model) {
    log.warn("deleteUsers");
    model.addAttribute("user", myUserService.getuser(id));
        myUserService.deleteuser(id);
//        List<Myuser> myuserList = myUserService.getusers();
//        model.addAttribute("users", myuserList);
        // get student from database by id
        return "index";
    }



}



