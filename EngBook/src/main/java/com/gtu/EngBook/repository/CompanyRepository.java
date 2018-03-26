package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyModel, Long > {

    public CompanyModel findBycompId(Long comp_id);
}
