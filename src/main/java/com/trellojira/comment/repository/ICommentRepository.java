package com.trellojira.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trellojira.comment.entity.Comment;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {

}
