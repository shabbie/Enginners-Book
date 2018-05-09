package com.gtu.EngBook.repository.TempRepositories;

import com.gtu.EngBook.model.TempModels.UserInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoModel, String > {
    @Query(value = "SELECT user_id,fname,lname,profile_pic FROM user WHERE user_id= :user_id", nativeQuery = true)
    public UserInfoModel findByUserId(@Param("user_id") long user_id);

    @Query(value = "SELECT user.user_id,fname,lname,profile_pic FROM user join student WHERE user.user_id!=:user_id and dept_id=:dept_id and user.user_id=student.user_id ", nativeQuery = true)
    public List<UserInfoModel> findStudentByUserIdAndDeptId(@Param("user_id") long user_id, @Param("dept_id") long dept_id);

    @Query(value = "SELECT user.user_id,fname,lname,profile_pic FROM user join faculty WHERE user.user_id!=:user_id and dept_id=:dept_id and user.user_id=faculty.user_id", nativeQuery = true)
    public List<UserInfoModel> findFacultyByUserIdAndDeptId(@Param("user_id") long user_id,@Param("dept_id") long dept_id);
}
