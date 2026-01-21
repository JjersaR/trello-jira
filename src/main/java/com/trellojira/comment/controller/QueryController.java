package com.trellojira.comment.controller;

import org.springframework.stereotype.Controller;

import com.trellojira.comment.service.CommentService;
import com.trellojira.dto.mapper.ModelMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QueryController {

  private final CommentService service;
  private final ModelMapper mapper;

}
