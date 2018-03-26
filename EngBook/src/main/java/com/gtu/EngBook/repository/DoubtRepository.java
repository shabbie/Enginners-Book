package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.DoubtModel;
import com.gtu.EngBook.model.UserModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoubtRepository extends JpaRepository<DoubtModel, Long> {

    public List<DoubtModel> findAllByUserModelNotAndDeptId(UserModel userModel, long dept_id, Pageable pageable);

    public DoubtModel findByDoubtId(Long doubt_id );

    public List<DoubtModel> findAllByUserModel(UserModel userModel);

}
