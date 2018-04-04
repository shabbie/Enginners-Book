package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentModel, Long > {

    public List<CommentModel> findAllByArticleId(Long artticleId, org.springframework.data.domain.Pageable pageable);

    @Query(value = "SELECT count(comment_id) FROM comments WHERE article_id= :article_id", nativeQuery = true)
    public int findByArticleId(@Param("article_id") long article_id);
}
