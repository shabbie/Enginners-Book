package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.AnswerModel;
import com.gtu.EngBook.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<AnswerModel, Long > {

    public List<AnswerModel> findAllByDoubtId(Long DoubtId, org.springframework.data.domain.Pageable pageable);

    public AnswerModel findByAnswerId(Long answer_id);

    public List<AnswerModel> findAllByUserModel(UserModel userModel);
}

