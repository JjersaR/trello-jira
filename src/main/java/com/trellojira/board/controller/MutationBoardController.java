package com.trellojira.board.controller;

import org.springframework.stereotype.Controller;

import com.trellojira.board.service.BoardService;
import com.trellojira.dto.mapper.ModelMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MutationBoardController {

  private final BoardService service;
  private final ModelMapper mapper;

}
