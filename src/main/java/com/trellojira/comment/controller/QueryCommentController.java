package com.trellojira.comment.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.trellojira.comment.service.CommentService;
import com.trellojira.dto.response.CommentResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QueryCommentController {

  private final CommentService service;

  @QueryMapping(name = "findByCard")
  public List<CommentResponse> findByCard(@Argument Integer id) {
    return service.getByCardId(Long.parseLong(id.toString()));
  }
}
