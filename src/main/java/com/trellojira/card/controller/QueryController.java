package com.trellojira.card.controller;

import org.springframework.stereotype.Controller;

import com.trellojira.card.service.CardService;
import com.trellojira.dto.mapper.ModelMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QueryController {

  private final CardService service;
  private final ModelMapper mapper;

}
