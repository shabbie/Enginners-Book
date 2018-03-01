package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String > {


    public boolean findOneByEmail(String email,String Password);

}
