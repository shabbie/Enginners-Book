package com.gtu.EngBook.repository.TempRepositories;

import com.gtu.EngBook.model.TempModels.UserInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoModel, String > {
    @Query(value = "SELECT user_id,fname,lname,profile_pic FROM user WHERE user_id= :user_id", nativeQuery = true)
    public UserInfoModel findByUserId(@Param("user_id") long user_id);
}
