package com.perscholas.krishna.saveaccess;

import com.perscholas.krishna.saveaccess.repos.MyuserRepository;
import com.perscholas.krishna.saveaccess.services.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class MyCommandLineRunner implements CommandLineRunner {
 MyUserService myUserService;
 MyuserRepository myuserRepository;
@Autowired
    public MyCommandLineRunner(MyUserService myUserService, MyuserRepository myuserRepository) {
        this.myUserService = myUserService;
        this.myuserRepository = myuserRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    myUserService.addUser(1, "tikakuikel@gmail.com","kuikel", "tika","password");
    myUserService.addUser(2, "kevin@gmail.com","bacon", "kevin","password");
    myUserService.addUser(3, "jonsnow@gmail.com","snow", "john","password");
    }
}
