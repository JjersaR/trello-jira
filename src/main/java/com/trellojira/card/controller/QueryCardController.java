package com.trellojira.card.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.trellojira.card.service.CardService;
import com.trellojira.dto.response.CardResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QueryCardController {

  private final CardService service;

  @QueryMapping(name = "findByColumn")
  public List<CardResponse> getByColumnId(@Argument Integer id) {
    return service.getByColumnId(Long.parseLong(id.toString()));
  }

  @QueryMapping(name = "findByAssignedTo")
  public List<CardResponse> getByAssignedToId(@Argument Integer id) {
    return service.getByAssignedToId(Long.parseLong(id.toString()));
  }

  @QueryMapping(name = "findByColumnOrder")
  public List<CardResponse> getByColumnIdOrder(@Argument Integer id) {
    return service.getByColumnIdOrder(Long.parseLong(id.toString()));
  }

}
