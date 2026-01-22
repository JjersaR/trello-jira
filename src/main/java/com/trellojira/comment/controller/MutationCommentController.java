package com.trellojira.comment.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.trellojira.comment.service.CommentService;
import com.trellojira.dto.request.CommentRequest;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MutationCommentController {

  private final CommentService service;

  @MutationMapping(name = "saveComment")
  public String save(@Argument CommentRequest comment) {
    service.save(comment);
    return "Comment saved";
  }

  @MutationMapping(name = "deleteComment")
  public String delete(@Argument Long id) {
    service.delete(id);
    return "Comment deleted";
  }
}
