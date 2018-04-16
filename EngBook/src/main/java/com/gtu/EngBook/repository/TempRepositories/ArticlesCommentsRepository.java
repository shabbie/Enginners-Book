package com.gtu.EngBook.repository.TempRepositories;

import com.gtu.EngBook.model.TempModels.ArticlesCommentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticlesCommentsRepository extends JpaRepository<ArticlesCommentsModel, Long > {
    @Query(value = "SELECT article_id,count(comment_id) as c FROM comments WHERE article_id= :article_id", nativeQuery = true)
    public ArticlesCommentsModel findByArticleId(@Param("article_id") long article_id);
}
