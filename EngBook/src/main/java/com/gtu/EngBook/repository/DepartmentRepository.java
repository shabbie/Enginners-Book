package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long>
{
    @Query(value = "select dept_id from department where dept_name=:dept_name",nativeQuery = true)
    long findByDeptName(@Param("dept_name")String dept_name);

    // public DepartmentModel findByUserType(String userType);
}
