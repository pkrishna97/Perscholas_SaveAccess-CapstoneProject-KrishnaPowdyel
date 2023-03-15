package com.perscholas.krishna.saveaccess.controllers;
import com.perscholas.krishna.saveaccess.dao.TodoAddRequest;
import com.perscholas.krishna.saveaccess.models.Myuser;
import com.perscholas.krishna.saveaccess.models.TodoItem;
import com.perscholas.krishna.saveaccess.repos.MyuserRepository;
import com.perscholas.krishna.saveaccess.repos.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class TodoItemController {
    @Autowired
    TodoItemRepository todoItemRepository;

    @Autowired
    MyuserRepository myuserRepository;

    @PostMapping("/todos/add")
    public String addTodoItem(@RequestParam(name="id") int id,@RequestParam(name="text")String text,
                                @RequestParam(name="userId")int userId, Model model) {
        Myuser myuser = myuserRepository.findById(userId).get();

        TodoItem todoItem = new TodoItem(text, myuser);

        TodoItem savedTodoItem = todoItemRepository.save(todoItem);

        List<TodoItem> todoitems = todoItemRepository.findAll();

        model.addAttribute("todos", todoitems);
        return "todospage";
    }

    @GetMapping("/todos")
    public String getAllTodos(Model model){
        List<TodoItem> todoitems = todoItemRepository.findAll();

        model.addAttribute("todos", todoitems);

        return "todospage";
    }

    @GetMapping("/todos/add")
    public String addTodoPage(Model model){
        return "todosadd";
    }

}
