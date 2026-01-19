package com.trellojira.card.service;

import org.springframework.stereotype.Service;

import com.trellojira.card.repository.ICardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardService {

  private final ICardRepository repository;
}
