package com.trellojira.user.controller;

import org.springframework.stereotype.Controller;

import com.trellojira.dto.mapper.ModelMapper;
import com.trellojira.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QueryController {

  private final UserService service;
  private final ModelMapper mapper;

}
