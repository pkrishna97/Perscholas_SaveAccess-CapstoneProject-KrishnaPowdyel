package com.perscholas.krishna.saveaccess.repos;

import com.perscholas.krishna.saveaccess.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TodoItemRepository extends JpaRepository<TodoItem, Integer> {
}