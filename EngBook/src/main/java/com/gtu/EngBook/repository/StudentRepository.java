package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.StudentModel;
import com.gtu.EngBook.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentModel, Long > {

    @Query(value = "SELECT college.colg_name,department.dept_name,year_of_passing,count(student.user_id) FROM student,college,department where student.comp_id= :comp_id and student.colg_id=college.colg_id and student.dept_id=department.dept_id group by year_of_passing,student.colg_id,student.dept_id", nativeQuery = true)
    public List<Object[]> findByDeptCompId(@Param("comp_id") long comp_id);

    @Query(value = "SELECT department.dept_name,user.user_id,user.fname,user.lname,user.profile_pic FROM student JOIN college JOIN user JOIN department where student.comp_id= :comp_id and student.year_of_passing= :year_of_passing and student.colg_id= :colg_id and student.colg_id=college.colg_id and student.dept_id=department.dept_id and student.user_id=user.user_id", nativeQuery = true)
    public List<Object[]> findByStudentCompId(@Param("comp_id") long comp_id,@Param("year_of_passing") int yop,@Param("colg_id") long colg_id);

    @Query(value = "SELECT user.user_id,user.fname,user.lname,user.profile_pic,student.enroll_no FROM student,college,user,department where student.comp_id= :comp_id and student.year_of_passing= :year_of_passing and student.colg_id= :colg_id and student.dept_id= :dept_id and student.colg_id=college.colg_id and student.dept_id=department.dept_id and student.user_id=user.user_id", nativeQuery = true)
    public List<Object[]> findByStudentCompIdDept(@Param("comp_id") long comp_id,@Param("year_of_passing") int yop,@Param("colg_id") long colg_id,@Param("dept_id") long dept_id);

    public StudentModel findByUserModel(UserModel userModel);
}