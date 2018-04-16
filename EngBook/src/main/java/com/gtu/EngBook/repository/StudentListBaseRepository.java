package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.TempModels.StudentListBaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentListBaseRepository extends JpaRepository<StudentListBaseModel, Long > {
    @Query(value = "SELECT enroll_no,colg_id,year_of_passing,count(user_id) as c FROM student WHERE comp_id= :comp_id GROUP by year_of_passing,colg_id", nativeQuery = true)
    public List<StudentListBaseModel> findByCompId(@Param("comp_id") long comp_id);
}
