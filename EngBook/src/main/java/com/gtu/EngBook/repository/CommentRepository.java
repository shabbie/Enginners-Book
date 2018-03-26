package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentModel, Long > {

    public List<CommentModel> findAllByArticleId(Long artticleId, org.springframework.data.domain.Pageable pageable);
}
