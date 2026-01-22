package com.trellojira.column.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.trellojira.column.service.ColumnService;
import com.trellojira.dto.request.ColumnRequest;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MutationColumnController {

  private final ColumnService service;

  @MutationMapping(name = "createColumn")
  public String save(@Argument ColumnRequest column) {
    service.save(column);
    return "Columna creada";
  }

  @MutationMapping(name = "updateColumn")
  public String update(@Argument ColumnRequest column, @Argument Integer id) {
    service.update(column, Long.parseLong(id.toString()));
    return "Columna actualizada";
  }

  @MutationMapping(name = "deleteColumn")
  public String delete(@Argument Integer id) {
    service.delete(Long.parseLong(id.toString()));
    return "Columna borrada";
  }

}
