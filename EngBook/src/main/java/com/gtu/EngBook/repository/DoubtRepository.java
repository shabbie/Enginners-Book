package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.DoubtModel;
import com.gtu.EngBook.model.TempModels.DoubtsAnswersModel;
import com.gtu.EngBook.model.UserModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoubtRepository extends JpaRepository<DoubtModel, Long> {

    public List<DoubtModel> findAllByUserModelNotAndDeptId(UserModel userModel, long dept_id, Pageable pageable);

    public List<DoubtModel> findAllByUserModel(UserModel userModel, Pageable pageable);

    /*@Query(value = "SELECT * from doubts where user_id!=:user_id and dept_id=:dept_id and heading like '%:heading%'", nativeQuery = true)
    public List<DoubtModel> findAllByUserModelNotAndDeptIdAndHeading(@Param("user_id")long user_id, @Param("dept_id")long dept_id, @Param("heading")String heading, Pageable pageable);*/


    public List<DoubtModel> findAllByUserModelNotAndDeptIdAndHeadingContaining(UserModel userModel, long dept_id, String heading, Pageable pageable);

    public DoubtModel findByDoubtId(Long doubt_id );

    public List<DoubtModel> findAllByUserModel(UserModel userModel);

    @Query(value = "SELECT count(answer_id) as c FROM answers WHERE doubt_id = :doubt_id", nativeQuery = true)
    public Integer findCountByDoubtId(@Param("doubt_id") long doubt_id);

}
