package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.ArticlesModel;
import com.gtu.EngBook.model.TempModels.ArticlesCommentsModel;
import com.gtu.EngBook.model.UserModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticlesModel, Long > {

   public List<ArticlesModel> findAllByUserModelNotAndDeptId(UserModel userModel, long dept_id, Pageable pageable);

   public List<ArticlesModel> findAllByUserModel(UserModel userModel, Pageable pageable);

   public List<ArticlesModel> findAllByUserModel(UserModel userModel);

   public ArticlesModel findByArticleId(Long article_id );
}
