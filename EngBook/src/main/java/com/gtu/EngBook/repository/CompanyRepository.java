package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<CompanyModel, Long > {

    public CompanyModel findBycompId(Long comp_id);

    @Query(value = "SELECT comp_name FROM company", nativeQuery = true)
    public String findString();
}
