package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentModel, Long > {

    @Query(value = "SELECT college.colg_name,year_of_passing,count(student.user_id) FROM student,college where student.comp_id= :comp_id and student.colg_id=college.colg_id group by year_of_passing,student.colg_id", nativeQuery = true)
    public Object findByCompId(@Param("comp_id") long comp_id);
}
