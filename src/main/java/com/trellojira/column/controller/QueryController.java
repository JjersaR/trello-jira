package com.trellojira.column.controller;

import org.springframework.stereotype.Controller;

import com.trellojira.column.service.ColumnService;
import com.trellojira.dto.mapper.ModelMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QueryController {

  private final ColumnService service;
  private final ModelMapper mapper;

}
