package com.perscholas.krishna.saveaccess.repos;

import com.perscholas.krishna.saveaccess.models.Thought;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ThoughtRepository extends JpaRepository<Thought, Integer> {
}