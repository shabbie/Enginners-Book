package com.gtu.EngBook.repository.TempRepositories;

import com.gtu.EngBook.model.TempModels.DoubtsAnswersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoubtsAnswersRepository extends JpaRepository<DoubtsAnswersModel, Long > {

    @Query(value = "SELECT doubt_id,count(answer_id) as c FROM answers WHERE doubt_id = :doubt_id", nativeQuery = true)
    public DoubtsAnswersModel findByDoubtId(@Param("doubt_id") long doubt_id);
}
