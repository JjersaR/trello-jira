package com.trellojira.board.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.trellojira.board.service.BoardService;
import com.trellojira.dto.response.BoardResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QueryBoardController {

  private final BoardService service;

  @QueryMapping(name = "findByOwner")
  public List<BoardResponse> byOwner(@Argument Integer id) {
    return service.getByOwnerId(Long.parseLong(id.toString()));
  }
}
