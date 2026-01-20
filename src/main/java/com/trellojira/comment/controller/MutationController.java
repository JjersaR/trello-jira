package com.trellojira.comment.controller;

import org.springframework.stereotype.Controller;

import com.trellojira.comment.service.CommentService;
import com.trellojira.dto.mapper.ModelMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MutationController {

  private final CommentService service;
  private final ModelMapper mapper;

}
