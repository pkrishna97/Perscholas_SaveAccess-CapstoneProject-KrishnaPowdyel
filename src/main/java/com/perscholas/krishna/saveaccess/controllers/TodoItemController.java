package com.perscholas.krishna.saveaccess.controllers;

import com.perscholas.krishna.saveaccess.dao.TodoAddRequest;
import com.perscholas.krishna.saveaccess.models.Myuser;
import com.perscholas.krishna.saveaccess.models.Todoitem;
import com.perscholas.krishna.saveaccess.repos.MyuserRepository;
import com.perscholas.krishna.saveaccess.repos.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class TodoItemController {

    @Autowired
    TodoItemRepository todoItemRepository;

    @Autowired
    MyuserRepository myuserRepository;

    @PostMapping("/todos")
    public String addTodoItem(@RequestParam(name="userId")int userId, @RequestParam(name="text")String text, Model model) {
        Myuser myuser = myuserRepository.findById(userId).get();

        Todoitem todoitem = new Todoitem(text, myuser);
        List<Todoitem> todoitems = todoItemRepository.findAll();
        model.addAttribute("todos",todoitems);
        todoItemRepository.save(todoitem);
        return "todopage";
    }

    @GetMapping("/todos")
    public String getAllTodos(Model model){
        List<Todoitem> todoitems = todoItemRepository.findAll();

        model.addAttribute("todos", todoitems);

        return "todopage";
    }
}
