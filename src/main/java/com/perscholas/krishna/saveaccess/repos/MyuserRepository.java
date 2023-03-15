package com.perscholas.krishna.saveaccess.repos;
import com.perscholas.krishna.saveaccess.models.Myuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyuserRepository extends JpaRepository<Myuser, Integer> {
//    Myuser myuser deleteuser(Myuser myuser);
}