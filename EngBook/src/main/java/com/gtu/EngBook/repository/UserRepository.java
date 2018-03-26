package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.ArticlesModel;
import com.gtu.EngBook.model.DepartmentModel;
import com.gtu.EngBook.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String > {

    public UserModel findOneByEmail(String email);
    public UserModel findByUserId(Long user_id);
}
