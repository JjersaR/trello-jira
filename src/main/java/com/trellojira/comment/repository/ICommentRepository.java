package com.trellojira.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trellojira.comment.entity.Comment;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {

  List<Comment> findByCardId(Long id);
}
