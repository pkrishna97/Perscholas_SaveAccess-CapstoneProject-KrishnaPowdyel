package com.perscholas.krishna.saveaccess.repos;

import com.perscholas.krishna.saveaccess.models.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepository extends JpaRepository<Documents, Integer> {
}