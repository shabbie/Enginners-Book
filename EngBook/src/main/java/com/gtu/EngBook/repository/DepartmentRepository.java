package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long>
{
    int findByDeptName(String deptName);

    // public DepartmentModel findByUserType(String userType);
}
