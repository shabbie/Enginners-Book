package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.UniversityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UniversityRepository extends JpaRepository<UniversityModel, Long> {

    @Query(value = "select uni_id from university where uni_name=:univ_name",nativeQuery = true)
    int findByUniName(@Param("univ_name")String univ_name);
}