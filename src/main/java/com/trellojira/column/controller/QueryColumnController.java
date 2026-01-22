package com.trellojira.column.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.trellojira.column.service.ColumnService;
import com.trellojira.dto.response.ColumnResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QueryColumnController {

  private final ColumnService service;

  @QueryMapping(name = "findByBoardId")
  public List<ColumnResponse> getByBoardId(@Argument Integer id) {
    return service.getByBoardId(Long.parseLong(id.toString()));
  }

  @QueryMapping(name = "findByBoardIdOrder")
  public List<ColumnResponse> getByBoardIdOrder(@Argument Integer id) {
    return service.getByBoardIdOrder(Long.parseLong(id.toString()));
  }
}
