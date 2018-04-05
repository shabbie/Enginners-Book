package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.CollegeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CollegeRepository extends JpaRepository<CollegeModel, Long> {
    
    @Query(value = "select colg_id from college where colg_name=:colg_name",nativeQuery = true)
    int findByColgName(@Param("colg_name")String colg_name);
}
