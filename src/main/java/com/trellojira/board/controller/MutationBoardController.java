package com.trellojira.board.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.trellojira.board.service.BoardService;
import com.trellojira.dto.request.BoardRequest;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MutationBoardController {

  private final BoardService service;

  @MutationMapping(name = "createBoard")
  public String save(@Argument(name = "board") BoardRequest request) {
    service.save(request);
    return "Board creado";
  }

  @MutationMapping(name = "updateBoard")
  public String update(@Argument(name = "board") BoardRequest request, @Argument Integer id) {
    service.update(request, Long.parseLong(id.toString()));
    return "Board actualizado";
  }

  @MutationMapping(name = "deleteBoard")
  public String delete(@Argument Integer id) {
    service.delete(Long.parseLong(id.toString()));
    return "Board borrado";
  }

}
