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
@RestController
public class TodoItemController {

    TodoItemRepository todoItemRepository;

    MyuserRepository myuserRepository;

    @PostMapping("/todos")
    public TodoItem addTodoItem(@RequestBody TodoAddRequest todoAddRequest) {
        Myuser myuser = myuserRepository.findById(todoAddRequest.getUserId()).get();

        TodoItem todoItem = new TodoItem(todoAddRequest.getText(), myuser);

        TodoItem savedTodoItem = todoItemRepository.save(todoItem);
        return savedTodoItem;
    }

    @GetMapping("/todos")
    public List<TodoItem> getAllTodos(){
        List<TodoItem> todoitems = todoItemRepository.findAll();

        return todoitems;
    }

    @GetMapping("/todos/{id}")
    public TodoItem getOneTodoItem(@PathVariable int id){
        TodoItem todoItem = todoItemRepository.findById(id).get();

        if(todoItem == null){
            return null;
        }

        return todoItem;
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodoItem(@PathVariable int id){
        TodoItem todoItem = todoItemRepository.findById(id).get();

        if(todoItem == null){
            return null;
        }

        todoItemRepository.deleteById(id);

        return "Successfully deleted Todo Item with id" + todoItem.getId();
    }
}
