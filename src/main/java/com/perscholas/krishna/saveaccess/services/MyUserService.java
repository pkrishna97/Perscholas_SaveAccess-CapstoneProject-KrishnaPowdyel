package com.perscholas.krishna.saveaccess.services;

import com.perscholas.krishna.saveaccess.models.Myuser;
import com.perscholas.krishna.saveaccess.repos.MyuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserService {
    @Autowired
    private MyuserRepository myuserRepository;
    public void addUser(int id, String email, String lastname, String firstname, String password){
        Myuser myuser = new Myuser(id, email,lastname, firstname, password);
        myuserRepository.saveAndFlush(myuser);
    }
    public List<Myuser> getusers(){
        List<Myuser> myuserList= myuserRepository.findAll();
        return myuserList;

    }

}
