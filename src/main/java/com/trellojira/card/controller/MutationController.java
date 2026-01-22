package com.trellojira.card.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.trellojira.card.service.CardService;
import com.trellojira.dto.request.CardRequest;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MutationController {

  private final CardService service;

  @MutationMapping(name = "createCard")
  public String save(@Argument CardRequest card) {
    service.save(card);
    return "Tarjeta creada";
  }

  @MutationMapping(name = "deleteCard")
  public String delete(@Argument Long id) {
    service.delete(id);
    return "Tarjeta borrada";
  }
}
