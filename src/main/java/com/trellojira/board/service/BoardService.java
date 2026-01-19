package com.trellojira.board.service;

import org.springframework.stereotype.Service;

import com.trellojira.board.repository.IBoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final IBoardRepository repository;
}
